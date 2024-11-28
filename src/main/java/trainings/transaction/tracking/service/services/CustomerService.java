package trainings.transaction.tracking.service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import trainings.transaction.tracking.service.Repository.CustomersRepository;
import trainings.transaction.tracking.service.dtos.CustomersDto;
import trainings.transaction.tracking.service.dtos.TransactionDto;
import trainings.transaction.tracking.service.mappers.CustomersMapper;
import trainings.transaction.tracking.service.models.Customers;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerServiceImpl{
    private final CustomersRepository customersRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;


    @Override
    public CustomersDto saveCustomers(CustomersDto customersDto){
        Customers customers = CustomersMapper.dtoToModel(customersDto);
        customers = customersRepository.save(customers);
        return CustomersMapper.modelToDto(customers);
    }

    @Override
    public double fetchBalance(Long customerId){
        Customers customers = customersRepository.findById(customerId).
                orElseThrow(() -> new RuntimeException("Customer not found"));
        if(customers != null){
            return customers.getBalance();
        }
        return 0.0;
    }

    @Override
    public String performTransaction(TransactionDto dto){
        //confirm the sender exist on the database
        //confirm the recipient exist on the database

        Customers sender =  customersRepository.findCustomersByPhoneNumber(dto.getSenderPhoneNumber());


        //update sender balance
        if (dto.getTransactionAmount()> sender.getBalance())
            throw new RuntimeException("Amount not enough to be transferred");

        double senderBalance = sender.getBalance() - dto.getTransactionAmount();
        sender.setBalance(senderBalance);

        kafkaTemplate.send("transaction-sender-topic", sender);

        customersRepository.save(sender);

        //update recipient info
        Customers recipient =  customersRepository.findCustomersByPhoneNumber(dto.getRecipientPhoneNumber());
        double recipientBalance = recipient.getBalance() + dto.getTransactionAmount();
        recipient.setBalance(recipientBalance);
        kafkaTemplate.send("transaction-receiver-topic", recipient);
        customersRepository.save(recipient);


    return "Transaction Successful, " + dto +" has been transferred to" + recipient.getFullName();
    }


}

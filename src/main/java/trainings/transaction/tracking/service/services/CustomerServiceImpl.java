package trainings.transaction.tracking.service.services;

import trainings.transaction.tracking.service.dtos.CustomersDto;
import trainings.transaction.tracking.service.dtos.TransactionDto;

public interface CustomerServiceImpl {
    CustomersDto saveCustomers(CustomersDto customersDto);

    double fetchBalance(Long customerId);

    String performTransaction(TransactionDto dto);
}

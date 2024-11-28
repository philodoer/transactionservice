package trainings.transaction.tracking.service.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import trainings.transaction.tracking.service.dtos.CustomersDto;
import trainings.transaction.tracking.service.models.Customers;

public class CustomersMapper {
    private static final ObjectMapper objectMapper= new ObjectMapper();

    public static Customers dtoToModel(CustomersDto customersDto) {
        return objectMapper.convertValue(customersDto, Customers.class);
    }

    public static CustomersDto modelToDto(Customers customers) {
        return objectMapper.convertValue(customers, CustomersDto.class);
    }
}

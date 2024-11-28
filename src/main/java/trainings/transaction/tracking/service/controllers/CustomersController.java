package trainings.transaction.tracking.service.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trainings.transaction.tracking.service.dtos.CustomersDto;
import trainings.transaction.tracking.service.dtos.TransactionDto;
import trainings.transaction.tracking.service.services.CustomerService;
import trainings.transaction.tracking.service.services.CustomerServiceImpl;

/**
 * Endpoint projection class
 * @author philip
 * @version 1.01
 */

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Tag(name = "Transactions managament", description = "show all endpoints for transaction")
public class CustomersController {
    private final CustomerServiceImpl customerService;

    @PostMapping("/make-transaction")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionDto transactionDto) {
        return ResponseEntity.ok(customerService.performTransaction(transactionDto));
    }

    @PostMapping
    public ResponseEntity<CustomersDto> createCustomer(@RequestBody CustomersDto customersDto) {
        return ResponseEntity.ok(customerService.saveCustomers(customersDto));
    }

    @GetMapping("/fetch-balance/{id}")
    public ResponseEntity<Double> fetchBalance(@PathVariable @NotNull Long id) {
        return ResponseEntity.ok(customerService.fetchBalance(id));
    }
}

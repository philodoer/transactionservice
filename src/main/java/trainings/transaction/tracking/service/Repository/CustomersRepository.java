package trainings.transaction.tracking.service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trainings.transaction.tracking.service.models.Customers;


public interface CustomersRepository extends JpaRepository<Customers, Long> {

    Customers findCustomersByPhoneNumber(String phoneNumber);
}

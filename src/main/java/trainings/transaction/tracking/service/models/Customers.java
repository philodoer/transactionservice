package trainings.transaction.tracking.service.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Customer Dao
 * @author Philip nduati
 * @version 1.01
 */

@Entity
@Table(name = "CUSTOMERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column()
    private long id;

    @Column(name = "CUSTOMER_NAME")
    private String fullName;

    @Column(name = "CUSTOMER_EMAIL")
    private String emailAddress;

    @Column(name = "CUSTOMER_PHONE_NO")
    private String phoneNumber;

    @Column(name = "CUSTOMER_BAL")
    private double balance;

}

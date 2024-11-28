package trainings.transaction.tracking.service.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Data Transfer Object
 * @author Philip
 * @version 1.01
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Customer details", description = "show details needed to persist customer transactions")
public class CustomersDto {

    @ApiModelProperty(name = "unique identifier", notes = "Code used to uniquely identify a client")
    private long id;

    @NotNull
    private String fullName;


    @Email
    private String emailAddress;

    @NotNull
    private String phoneNumber;

    @ApiModelProperty(name = "Customer balance", notes = "total account balance")
    private double balance;
}

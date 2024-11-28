package trainings.transaction.tracking.service.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "transaction details", description = "Give details of transaction performed")
public class TransactionDto {

    @ApiModelProperty(name = "sender", notes = "code of the customer who initiated the transaction")
    private String senderPhoneNumber;

    @ApiModelProperty(name = "sender", notes = "code of the customer who the money is transferred to")
    private String recipientPhoneNumber;

    @ApiModelProperty(name = "sender", notes = "name of the customer who initiated the transaction")
    private String senderName;

    @ApiModelProperty(name = "sender", notes = "name of the customer who the money is transferred to")
    private String recipientName;

    @ApiModelProperty(name = "amount", notes = "Amount to be transferred")
    private Double transactionAmount;


}

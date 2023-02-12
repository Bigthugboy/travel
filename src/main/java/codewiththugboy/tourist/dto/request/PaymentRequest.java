package codewiththugboy.tourist.dto.request;

import codewiththugboy.tourist.data.model.Currency;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    private String Email;
    private String Amount;
    @JsonProperty("subAccount")
    private String SubAccount;
    private Currency currency;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;
}

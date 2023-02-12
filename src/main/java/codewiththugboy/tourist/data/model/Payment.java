package codewiththugboy.tourist.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document("payment")
public class Payment {
    private String Email;
    private String Amount;
    @JsonProperty("subAccount")
    private String SubAccount;
    private Currency currency;
    private String FirstName;
    private String LastName;
    private String PhoneNumber;

}

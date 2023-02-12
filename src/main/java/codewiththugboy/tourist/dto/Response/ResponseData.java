package codewiththugboy.tourist.dto.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseData {
    @JsonProperty("authorization_url")
    private String authorizationUrl;
    @JsonProperty("access_code")
    private String accessCode;
    private String reference;
}

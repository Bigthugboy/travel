package codewiththugboy.tourist.dto.Response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentResponse {
    private boolean status;
    private String message;
    private ResponseData data;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String amount;
}
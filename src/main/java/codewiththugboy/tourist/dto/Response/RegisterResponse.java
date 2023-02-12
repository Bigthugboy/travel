package codewiththugboy.tourist.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterResponse {
    private String email;
    private String firstName;
    private String lastName;
    private String PhoneNumber;
    private String Token;
    private String message;
}

package codewiththugboy.tourist.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String checkPassword;
    private String phoneNumber;
    private String location;
}

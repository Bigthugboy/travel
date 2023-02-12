package codewiththugboy.tourist.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document("Tourist")
public class Tourist {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String checkPassword;
    private String phoneNumber;
    private String bookedTour;
    private String RequestTour;
    private String TaggedTourist;
    private String location;
    private String token;
    private String newToken;
    private LocalDateTime createdAt;
    private LocalDateTime UpdateAt;
}

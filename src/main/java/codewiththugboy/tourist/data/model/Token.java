package codewiththugboy.tourist.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Document("Confirmation Token")
@AllArgsConstructor
public class Token {
    @Id
    private String id;
    private String token;
//    @Column(nullable = false)
    private LocalDateTime createdAt;
//    @Column(nullable = false)
    private LocalDateTime expirdAt;
    //    @Column(nullable = false)
    private LocalDateTime confirmedAt;

    public Token(String token, LocalDateTime createdAt, LocalDateTime expirdAt) {
        this.token = token;
        this.createdAt = createdAt;
        this.expirdAt = expirdAt;


    }


}

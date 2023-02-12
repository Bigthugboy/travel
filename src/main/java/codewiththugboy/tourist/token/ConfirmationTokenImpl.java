package codewiththugboy.tourist.token;

import codewiththugboy.tourist.data.model.Token;
import codewiththugboy.tourist.data.repository.TokenRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ConfirmationTokenImpl implements ConfirmationToken{

    private  final TokenRepository repository;

    public void saveConfirmationToken(Token token) {
        repository.save(token);
    }

    public Optional<Token> getToken(String token) {return repository.findByToken(token);
    }

    public boolean setConfirmedAt(String token) {
        Optional<Token> confirmationToken = getToken(token);
        confirmationToken.ifPresent(value -> value.setConfirmedAt(LocalDateTime.now()));
        repository.save(confirmationToken.get());
        return true;
    }
}

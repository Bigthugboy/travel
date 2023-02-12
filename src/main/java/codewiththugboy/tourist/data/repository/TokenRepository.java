package codewiththugboy.tourist.data.repository;

import codewiththugboy.tourist.data.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenRepository extends MongoRepository<Token,String> {
    Optional<Token> findByToken(String token);
}

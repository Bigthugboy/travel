package codewiththugboy.tourist.data.repository;

import codewiththugboy.tourist.data.model.Token;
import codewiththugboy.tourist.data.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TouristRepository extends MongoRepository<Tourist,String> {

    Optional<Tourist> findByEmail(String email);

}

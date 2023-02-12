package codewiththugboy.tourist.data.repository;

import codewiththugboy.tourist.data.model.Tourist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Tourist,String> {
}

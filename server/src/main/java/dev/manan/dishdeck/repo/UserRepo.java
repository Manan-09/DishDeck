package dev.manan.dishdeck.repo;

import dev.manan.dishdeck.data.entity.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(String userId);

    boolean existsByUserId(String userId);

}
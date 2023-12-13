package dev.manan.dishdeck.repo;

import dev.manan.dishdeck.data.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String> {

}

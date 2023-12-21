package dev.manan.dishdeck.repo;

import dev.manan.dishdeck.data.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends MongoRepository<Category, String> {

    void deleteById(String categoryId);

    List<Category> findByRestaurantID(String restaurantId);

}

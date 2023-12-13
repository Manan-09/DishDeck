package dev.manan.dishdeck.repo;

import dev.manan.dishdeck.data.entity.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends MongoRepository<Restaurant, String> {

}

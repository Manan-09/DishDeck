package dev.manan.dishdeck.repo;

import dev.manan.dishdeck.data.entity.Category;
import dev.manan.dishdeck.data.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends MongoRepository<Item, String> {

}

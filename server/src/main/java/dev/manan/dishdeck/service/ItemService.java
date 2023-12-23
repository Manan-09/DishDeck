package dev.manan.dishdeck.service;

import dev.manan.dishdeck.data.dto.ItemRequestDTO;
import dev.manan.dishdeck.data.entity.Item;
import dev.manan.dishdeck.repo.ItemRepo;
import dev.manan.dishdeck.transformer.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import static dev.manan.dishdeck.service.AuthorisationHelper.validateOwnership;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;
    private final StorageService storageService;
    private final MongoTemplate mongoTemplate;

    public Item fetchItemById(String itemId) {
        return itemRepo.findById(itemId).orElseThrow();
    }

    public List<Item> fetchItemByCategoryId(String restaurantId) {
        return itemRepo.findByCategoryID(restaurantId);
    }

    public List<Item> fetchItemByRestaurantId(String restaurantId, String text) {
        Criteria criteria = Criteria.where("restaurantID").is(restaurantId);
        if(nonNull(text) && text.length() > 0) {
            String regexPattern = ".*" + text + ".*";
            criteria.and("name").regex(regexPattern, "i");
        }
        Query query = new Query(criteria);
        return mongoTemplate.find(query, Item.class);
    }

    public Item createItem(ItemRequestDTO itemRequestDTO) {
        Item item = ItemMapper.INSTANCE.updateItemFromRequest(itemRequestDTO, new Item());
        item.audit();
        return  itemRepo.insert(item);
    }

    public void deleteItemById(String itemId) {
        Item item = fetchItemById(itemId);
        validateOwnership(item);
        item.setDeleted(true);
        itemRepo.save(item);
    }

    public Item updateItem(ItemRequestDTO itemRequestDTO, String itemId) {
        Item existingItem = fetchItemById(itemId);
        validateOwnership(existingItem);
        existingItem = ItemMapper.INSTANCE.updateItemFromRequest(itemRequestDTO, existingItem);
        existingItem.audit();
        return  itemRepo.save(existingItem);
    }

    public Item uploadImage(String itemID, MultipartFile file) throws Exception {
        final String key = UUID.randomUUID().toString();
        Item item = fetchItemById(itemID);
        validateOwnership(item);
        final String oldImageKey = item.getImage();
        storageService.uploadImage(key, file);
        item.setImage(key);
        storageService.deleteObject(oldImageKey);
        return itemRepo.save(item);
    }
}
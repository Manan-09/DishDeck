package dev.manan.dishdeck.service;

import dev.manan.dishdeck.data.dto.ItemRequestDTO;
import dev.manan.dishdeck.data.entity.Item;
import dev.manan.dishdeck.repo.ItemRepo;
import dev.manan.dishdeck.transformer.ItemMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.manan.dishdeck.service.AuthorisationHelper.validateOwnership;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepo itemRepo;

    public Item fetchItemById(String itemId) {
        return itemRepo.findById(itemId).orElseThrow();
    }

    public List<Item> fetchItemByCategoryId(String restaurantId) {
        return itemRepo.findByCategoryID(restaurantId);
    }

    public List<Item> fetchItemByRestaurantId(String restaurantId) {
        return itemRepo.findByRestaurantID(restaurantId);
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
}
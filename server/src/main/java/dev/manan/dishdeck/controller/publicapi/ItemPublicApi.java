package dev.manan.dishdeck.controller.publicapi;

import dev.manan.dishdeck.data.entity.Item;
import dev.manan.dishdeck.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/v1/items")
public class ItemPublicApi {

    private final ItemService categoryService;

    @GetMapping("/{item}")
    public ResponseEntity<Item> fetchItemById(@PathVariable String item) {
        return ResponseEntity.ok(categoryService.fetchItemById(item));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Item>> fetchItemsForRestaurant(@PathVariable String restaurantId) {
        return ResponseEntity.ok(categoryService.fetchItemByRestaurantId(restaurantId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Item>> fetchItemsForCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(categoryService.fetchItemByCategoryId(categoryId));
    }
}
package dev.manan.dishdeck.controller.publicapi;

import dev.manan.dishdeck.data.entity.Item;
import dev.manan.dishdeck.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/v1/items")
public class ItemPublicApi {

    private final ItemService categoryService;

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Item>> fetchItemsForRestaurant(@PathVariable String restaurantId, @RequestParam(required = false) String text) {
        return ResponseEntity.ok(categoryService.fetchItemByRestaurantId(restaurantId, text));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Item>> fetchItemsForCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(categoryService.fetchItemByCategoryId(categoryId));
    }

    @GetMapping("/{item}")
    public ResponseEntity<Item> fetchItemById(@PathVariable String item) {
        return ResponseEntity.ok(categoryService.fetchItemById(item));
    }
}
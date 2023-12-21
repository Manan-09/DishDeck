package dev.manan.dishdeck.controller.restrictedapi;

import dev.manan.dishdeck.data.dto.ItemRequestDTO;
import dev.manan.dishdeck.data.entity.Item;
import dev.manan.dishdeck.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restricted/v1/items")
public class ItemRestrictedApi {

    private final ItemService restaurantService;

    @PostMapping()
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDTO requestDTO) {
        return ResponseEntity.ok(restaurantService.createItem(requestDTO));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItemById(@PathVariable String itemId) {
        restaurantService.deleteItemById(itemId);
        return ResponseEntity.ok("SUCCESS");
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemRequestDTO requestDTO, @PathVariable String itemId) {
        return ResponseEntity.ok(restaurantService.updateItem(requestDTO, itemId));
    }
}
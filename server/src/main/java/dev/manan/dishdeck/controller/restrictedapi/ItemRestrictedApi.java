package dev.manan.dishdeck.controller.restrictedapi;

import dev.manan.dishdeck.data.dto.ItemRequestDTO;
import dev.manan.dishdeck.data.entity.Item;
import dev.manan.dishdeck.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restricted/v1/items")
public class ItemRestrictedApi {

    private final ItemService itemService;

    @PostMapping()
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDTO requestDTO) {
        return ResponseEntity.ok(itemService.createItem(requestDTO));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItemById(@PathVariable String itemId) {
        itemService.deleteItemById(itemId);
        return ResponseEntity.ok("SUCCESS");
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@RequestBody ItemRequestDTO requestDTO, @PathVariable String itemId) {
        return ResponseEntity.ok(itemService.updateItem(requestDTO, itemId));
    }

    @PostMapping("/{itemId}/upload/image")
    public ResponseEntity<Item> uploadMoviePosterImage(@PathVariable String itemId, @RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(itemService.uploadImage(itemId, file));
    }

}
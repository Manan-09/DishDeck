package dev.manan.dishdeck.controller.restrictedapi;

import dev.manan.dishdeck.data.dto.RestaurantRequestDTO;
import dev.manan.dishdeck.data.entity.Item;
import dev.manan.dishdeck.data.entity.Restaurant;
import dev.manan.dishdeck.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restricted/v1/restaurants")
public class RestaurantRestrictedApi {

    private final RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody RestaurantRequestDTO requestDTO) {
        return ResponseEntity.ok(restaurantService.createRestaurant(requestDTO));
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<String> deleteRestaurantById(@PathVariable String restaurantId) {
        restaurantService.deleteRestaurantById(restaurantId);
        return ResponseEntity.ok("SUCCESS");
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantRequestDTO requestDTO, @PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(requestDTO, restaurantId));
    }

    @PostMapping("/{restaurantId}/upload/image")
    public ResponseEntity<Restaurant> uploadMoviePosterImage(@PathVariable String restaurantId, @RequestParam("file") MultipartFile file) throws Exception {
        return ResponseEntity.ok(restaurantService.uploadImage(restaurantId, file));
    }
}

package dev.manan.dishdeck.controller;

import dev.manan.dishdeck.data.dto.RestaurantRequestDTO;
import dev.manan.dishdeck.data.entity.Restaurant;
import dev.manan.dishdeck.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restricted/v1/restaurants")
public class RestaurantRestrictedController {

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
}

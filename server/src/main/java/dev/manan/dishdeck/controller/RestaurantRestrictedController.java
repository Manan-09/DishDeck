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

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> deleteRestaurantById(@PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.fetchRestaurantById(restaurantId));
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody RestaurantRequestDTO requestDTO, @PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.createRestaurant(requestDTO));
    }
}

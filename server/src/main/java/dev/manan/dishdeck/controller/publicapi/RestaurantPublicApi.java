package dev.manan.dishdeck.controller.publicapi;

import dev.manan.dishdeck.data.entity.Restaurant;
import dev.manan.dishdeck.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/v1/restaurants")
public class RestaurantPublicApi {

    private final RestaurantService restaurantService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> fetchRestaurantById(@PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.fetchRestaurantById(restaurantId));
    }
}

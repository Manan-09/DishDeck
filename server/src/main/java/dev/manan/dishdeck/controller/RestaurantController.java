package dev.manan.dishdeck.controller;

import dev.manan.dishdeck.data.dto.RestaurantRequestDTO;
import dev.manan.dishdeck.data.entity.Restaurant;
import dev.manan.dishdeck.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Restaurant> fetchMovieById(@PathVariable String restaurantId) {
        return ResponseEntity.ok(restaurantService.fetchRestaurantById(restaurantId));
    }

    @PostMapping()
    public ResponseEntity<Restaurant> createMovie(@RequestBody RestaurantRequestDTO requestDTO) {
        return ResponseEntity.ok(restaurantService.createRestaurant(requestDTO));
    }
}

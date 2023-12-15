package dev.manan.dishdeck.service;

import dev.manan.dishdeck.data.dto.RestaurantRequestDTO;
import dev.manan.dishdeck.data.entity.Restaurant;
import dev.manan.dishdeck.repo.RestaurantRepo;
import dev.manan.dishdeck.transformer.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public Restaurant fetchRestaurantById(String restaurantId) {
        return  restaurantRepo.findById(restaurantId).orElseThrow();
    }

    public Restaurant createRestaurant(RestaurantRequestDTO restaurantRequestDTO) {
        return  restaurantRepo.insert(RestaurantMapper.INSTANCE.updateRestaurantFromRequest(restaurantRequestDTO, new Restaurant()));
    }

    public void deleteRestaurantById(String restaurantId) {
        restaurantRepo.deleteById(restaurantId);
    }

    public Restaurant updateRestaurant(RestaurantRequestDTO restaurantRequestDTO, String restaurantId) {
        Restaurant existingRestaurant = fetchRestaurantById(restaurantId);
        return  restaurantRepo.save(RestaurantMapper.INSTANCE.updateRestaurantFromRequest(restaurantRequestDTO, existingRestaurant));
    }
}

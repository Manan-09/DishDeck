package dev.manan.dishdeck.service;

import dev.manan.dishdeck.data.dto.RestaurantRequestDTO;
import dev.manan.dishdeck.data.entity.Restaurant;
import dev.manan.dishdeck.repo.RestaurantRepo;
import dev.manan.dishdeck.transformer.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static dev.manan.dishdeck.service.AuthorisationHelper.validateOwnership;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepo restaurantRepo;

    public Restaurant fetchRestaurantById(String restaurantId) {
        return  restaurantRepo.findById(restaurantId).orElseThrow();
    }

    public Restaurant createRestaurant(RestaurantRequestDTO restaurantRequestDTO) {
        Restaurant restaurant = RestaurantMapper.INSTANCE.updateRestaurantFromRequest(restaurantRequestDTO, new Restaurant());
        restaurant.audit();
        return  restaurantRepo.insert(restaurant);
    }

    public void deleteRestaurantById(String restaurantId) {
        Restaurant restaurant = fetchRestaurantById(restaurantId);
        validateOwnership(restaurant);
        restaurant.setDeleted(true);
        restaurantRepo.save(restaurant);
    }

    public Restaurant updateRestaurant(RestaurantRequestDTO restaurantRequestDTO, String restaurantId) {
        Restaurant existingRestaurant = fetchRestaurantById(restaurantId);
        validateOwnership(existingRestaurant);
        existingRestaurant = RestaurantMapper.INSTANCE.updateRestaurantFromRequest(restaurantRequestDTO, existingRestaurant);
        existingRestaurant.audit();
        return  restaurantRepo.save(existingRestaurant);
    }
}

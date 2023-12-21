package dev.manan.dishdeck.data.dto;

import dev.manan.dishdeck.data.enums.FoodType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemRequestDTO {
    private String categoryID;
    private String restaurantID;
    private String name;
    private String description;
    private double price;
    private String foodType;
}
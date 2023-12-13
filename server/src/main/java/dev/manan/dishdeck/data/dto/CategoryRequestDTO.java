package dev.manan.dishdeck.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryRequestDTO {
    private String restaurantID;
    private String name;
}
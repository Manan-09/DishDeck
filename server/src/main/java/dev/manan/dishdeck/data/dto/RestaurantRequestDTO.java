package dev.manan.dishdeck.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantRequestDTO {
    private String name;
    private String location;
    private String contact;
}
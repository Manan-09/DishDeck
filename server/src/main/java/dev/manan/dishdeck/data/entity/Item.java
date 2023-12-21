package dev.manan.dishdeck.data.entity;

import dev.manan.dishdeck.data.enums.FoodType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
@NoArgsConstructor
public class Item extends AuditableBean{

    @Id
    private String itemID; // Primary Key
    @Indexed
    private String categoryID;// Foreign Key
    @Indexed
    private String restaurantID;// Foreign Key
    private String name;
    private String description;
    private double price;
    private FoodType foodType;

    public Item(String itemID, String categoryID, String restaurantID, String name, String description, double price, FoodType foodType) {
        this.itemID = UUID.randomUUID().toString();
        this.categoryID = categoryID;
        this.restaurantID = restaurantID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.foodType = foodType;
        this.audit();
    }
}

package dev.manan.dishdeck.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

import static dev.manan.dishdeck.util.AlphanumericGenerator.generateAlphanumeric;

@Document
@Data
@NoArgsConstructor
public class Category extends AuditableBean{

    @Id
    private String categoryID; // Primary Key
    @Indexed
    private String restaurantID;
    private String name;

    public Category(String restaurantID, String name) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.categoryID = UUID.randomUUID().toString();
        this.audit();
    }
}
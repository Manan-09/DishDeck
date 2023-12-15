package dev.manan.dishdeck.data.entity;

import dev.manan.dishdeck.configuration.RequestContext;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import static dev.manan.dishdeck.util.AlphanumericGenerator.generateAlphanumeric;

@Document
@Data
public class Restaurant {

    @Id
    private String restaurantID; // Primary Key
    private String name;
    private String location;
    private String contact;

    public Restaurant(String name, String location, String contact) {
        this.restaurantID = generateAlphanumeric(8);
        this.name = name;
        this.location = location;
        this.contact = contact;
    }

    public Restaurant() {
        this.restaurantID = RequestContext.getCurrentUserId()+"_"+generateAlphanumeric(4);
    }
}

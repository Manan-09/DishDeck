package dev.manan.dishdeck.data.entity;

import dev.manan.dishdeck.configuration.RequestContext;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

import static dev.manan.dishdeck.util.AlphanumericGenerator.generateAlphanumeric;

@Document
@Data
public class Restaurant extends AuditableBean{

    @Id
    private String restaurantID; // Primary Key
    private String name;
    private String location;
    private String contact;

    public Restaurant(String name, String location, String contact) {
        this.restaurantID = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.audit();
    }

    public Restaurant() {
        this.restaurantID = UUID.randomUUID().toString();
        this.audit();
    }
}

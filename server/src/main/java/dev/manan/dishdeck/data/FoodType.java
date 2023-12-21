package dev.manan.dishdeck.data;

public enum FoodType {
    VEG("Vegetarian"),
    CONTAINS_EGG("Contains Egg"),
    NON_VEG("Non-Vegetarian");

    private final String description;

    FoodType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

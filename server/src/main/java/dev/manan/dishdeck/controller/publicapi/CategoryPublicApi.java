package dev.manan.dishdeck.controller.publicapi;

import dev.manan.dishdeck.data.entity.Category;
import dev.manan.dishdeck.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/public/v1/categories")
public class CategoryPublicApi {

    private final CategoryService categoryService;

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> fetchCategoryById(@PathVariable String categoryId) {
        return ResponseEntity.ok(categoryService.fetchCategoryById(categoryId));
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Category>> fetchCategoriesForRestaurant(@PathVariable String restaurantId) {
        return ResponseEntity.ok(categoryService.fetchCategoryByRestaurantId(restaurantId));
    }
}
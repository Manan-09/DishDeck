package dev.manan.dishdeck.controller.restrictedapi;

import dev.manan.dishdeck.data.dto.CategoryRequestDTO;
import dev.manan.dishdeck.data.entity.Category;
import dev.manan.dishdeck.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restricted/v1/categories")
public class CategoryRestrictedApi {

    private final CategoryService restaurantService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequestDTO requestDTO) {
        return ResponseEntity.ok(restaurantService.createCategory(requestDTO));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable String categoryId) {
        restaurantService.deleteCategoryById(categoryId);
        return ResponseEntity.ok("SUCCESS");
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryRequestDTO requestDTO, @PathVariable String categoryId) {
        return ResponseEntity.ok(restaurantService.updateCategory(requestDTO, categoryId));
    }
}

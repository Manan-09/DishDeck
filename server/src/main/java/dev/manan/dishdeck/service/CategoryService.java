package dev.manan.dishdeck.service;

import dev.manan.dishdeck.data.dto.CategoryRequestDTO;
import dev.manan.dishdeck.data.entity.Category;
import dev.manan.dishdeck.repo.CategoryRepo;
import dev.manan.dishdeck.transformer.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static dev.manan.dishdeck.service.AuthorisationHelper.validateOwnership;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public Category fetchCategoryById(String categoryId) {
        return categoryRepo.findById(categoryId).orElseThrow();
    }

    public List<Category> fetchCategoryByRestaurantId(String restaurantId) {
        return categoryRepo.findByRestaurantID(restaurantId);
    }

    public Category createCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = CategoryMapper.INSTANCE.updateCategoryFromRequest(categoryRequestDTO, new Category());
        category.audit();
        return  categoryRepo.insert(category);
    }

    public void deleteCategoryById(String categoryId) {
        Category category = fetchCategoryById(categoryId);
        validateOwnership(category);
        category.setDeleted(true);
        categoryRepo.save(category);
    }

    public Category updateCategory(CategoryRequestDTO categoryRequestDTO, String categoryId) {
        Category existingCategory = fetchCategoryById(categoryId);
        validateOwnership(existingCategory);
        existingCategory = CategoryMapper.INSTANCE.updateCategoryFromRequest(categoryRequestDTO, existingCategory);
        existingCategory.audit();
        return  categoryRepo.save(existingCategory);
    }
}

package dev.manan.dishdeck.transformer;

import dev.manan.dishdeck.data.dto.CategoryRequestDTO;
import dev.manan.dishdeck.data.dto.RestaurantRequestDTO;
import dev.manan.dishdeck.data.entity.Category;
import dev.manan.dishdeck.data.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category updateCategoryFromRequest(CategoryRequestDTO request, @MappingTarget Category entity);
}

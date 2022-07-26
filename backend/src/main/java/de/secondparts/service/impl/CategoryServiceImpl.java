package de.secondparts.service.impl;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.dtos.CategoryViewDTO;
import de.secondparts.model.enums.CategoryEnum;
import de.secondparts.repository.CategoryRepository;
import de.secondparts.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initializeCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
                CategoryEntity category = new CategoryEntity();

                category.setName(categoryEnum);
                categoryRepository.save(category);
            });
        }
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<CategoryEntity> findByName(String name) {
        CategoryEnum categoryEnum = CategoryEnum.valueOf(name);

        return categoryRepository.findCategoryEntityByName(categoryEnum);

    }

    @Override
    public List<CategoryViewDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream().map(this::mapCategory)
                .collect(Collectors.toList());
    }

    private CategoryViewDTO mapCategory(CategoryEntity categoryEntity) {
        CategoryViewDTO category = new CategoryViewDTO();

        category.setName(categoryEntity.getName().name());
        category.setOrders(categoryEntity.getOrders());

        return category;
    }


}

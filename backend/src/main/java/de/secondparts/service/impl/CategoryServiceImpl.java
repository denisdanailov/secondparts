package de.secondparts.service.impl;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.enums.CategoryEnum;
import de.secondparts.repository.CategoryRepository;
import de.secondparts.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

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


}

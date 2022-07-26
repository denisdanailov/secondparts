package de.secondparts.service;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.dtos.CategoryViewDTO;
import de.secondparts.model.enums.CategoryEnum;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    void initializeCategories();

    Optional<CategoryEntity> findById(Long id);

    Optional<CategoryEntity> findByName(String name);

    List<CategoryViewDTO> getAllCategories();
}

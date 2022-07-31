package de.secondparts.service;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.dtos.CategoryViewDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<CategoryEntity> findById(Long id);

    Optional<CategoryEntity> findByName(String name);

    List<CategoryViewDTO> getAllCategories();
}

package de.secondparts.service.impl;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.dtos.CategoryViewDTO;
import de.secondparts.repository.CategoryRepository;
import de.secondparts.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<CategoryEntity> findByName(String name) {

        return categoryRepository.findCategoryEntityByName(name);

    }

    @Override
    public List<CategoryViewDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream().map(this::mapCategory)
                .collect(Collectors.toList());
    }

    private CategoryViewDTO mapCategory(CategoryEntity categoryEntity) {
        CategoryViewDTO category = modelMapper.map(categoryEntity, CategoryViewDTO.class);

        return category;
    }


}

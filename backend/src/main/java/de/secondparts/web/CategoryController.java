package de.secondparts.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.secondparts.model.entity.dtos.CategoryViewDTO;
import de.secondparts.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryViewDTO>> getAllCategories() {

        return ResponseEntity.ok(categoryService.getAllCategories());
    }

}

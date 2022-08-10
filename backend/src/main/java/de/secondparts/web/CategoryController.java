package de.secondparts.web;


import de.secondparts.model.entity.dtos.CategoryViewDTO;
import de.secondparts.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryViewDTO>> getAllCategories() {

        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryViewDTO> getCategoryById(@PathVariable("id") Long id) {
        Optional<CategoryViewDTO> category = categoryService.findById(id).map(categoryEntity -> {
            CategoryViewDTO categoryViewDTO = modelMapper.map(categoryEntity, CategoryViewDTO.class);

            return categoryViewDTO;
        });

        return category.map(categoryViewDTO
                -> new ResponseEntity<>(categoryViewDTO, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}

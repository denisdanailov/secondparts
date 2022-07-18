package de.secondparts.init;

import de.secondparts.service.BrandService;
import de.secondparts.service.CategoryService;
import de.secondparts.service.ModelService;
import de.secondparts.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ModelService modelService;

    public DataInit(UserService userService, BrandService brandService, CategoryService categoryService, ModelService modelService) {
        this.userService = userService;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.modelService = modelService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.initializeRoles();
        brandService.initializeBrands();
        categoryService.initializeCategories();
        modelService.initializeModels();
    }
}

package de.secondparts.init;

import de.secondparts.service.BrandService;
import de.secondparts.service.CategoryService;
import de.secondparts.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public DataInit(UserService userService, BrandService brandService, CategoryService categoryService) {
        this.userService = userService;
        this.brandService = brandService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.initializeRoles();
        brandService.initializeBrands();
        categoryService.initializeCategories();
    }
}

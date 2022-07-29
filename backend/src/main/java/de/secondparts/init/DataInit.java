package de.secondparts.init;

import de.secondparts.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final UserService userService;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ModelService modelService;
    private final AdminService adminService;

    public DataInit(UserService userService, BrandService brandService, CategoryService categoryService, ModelService modelService, AdminService adminService) {
        this.userService = userService;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.modelService = modelService;
        this.adminService = adminService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.initializeRoles();
        adminService.initializeAdmin();
//        brandService.initializeBrands();
        categoryService.initializeCategories();
//        modelService.initializeModels();
    }
}

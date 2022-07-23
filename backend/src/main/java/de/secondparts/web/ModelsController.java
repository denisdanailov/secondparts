package de.secondparts.web;

import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.dtos.ModelViewDTO;
import de.secondparts.service.BrandService;
import de.secondparts.service.CategoryService;
import de.secondparts.service.ModelService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/models")
public class ModelsController {

    private static final long VW_BRAND_ID = 1L;
    private static final long MERCEDES_BRAND_ID = 2L;
    private static final long BMW_BRAND_ID = 3L;
    private static final long AUDI_BRAND_ID = 4L;
    private static final long OPEL_BRAND_ID = 5L;
    private static final long PORSCHE_BRAND_ID = 6L;

    private final ModelService modelService;
    private final CategoryService categoryService;
    private final BrandService brandService;

    public ModelsController(ModelService modelService, CategoryService categoryService, BrandService brandService) {
        this.modelService = modelService;
        this.categoryService = categoryService;
        this.brandService = brandService;
    }

    @GetMapping("/vw")
    public List<ModelViewDTO> getAllModelsFromBrandVw() {

        return modelService.getAllModelsByBrandId(VW_BRAND_ID);
    }

    @GetMapping("/mercedes-benz")
    public List<ModelViewDTO> getAllModelsFromBrandMercedesBenz() {

        return modelService.getAllModelsByBrandId(MERCEDES_BRAND_ID);
    }

    @GetMapping("/bmw")
    public List<ModelViewDTO> getAllModelsFromBrandBmw() {

        return modelService.getAllModelsByBrandId(BMW_BRAND_ID);
    }

    @GetMapping("/audi")
    public List<ModelViewDTO> getAllModelsFromBrandAudi() {

        return modelService.getAllModelsByBrandId(AUDI_BRAND_ID);
    }

    @GetMapping("/opel")
    public List<ModelViewDTO> getAllModelsFromBrandOpel() {

        return modelService.getAllModelsByBrandId(OPEL_BRAND_ID);
    }

    @GetMapping("/porsche")
    public List<ModelViewDTO> getAllModelsFromBrandPorsche() {

        return modelService.getAllModelsByBrandId(PORSCHE_BRAND_ID);
    }

//    @GetMapping("/all")
//    public List<ModelViewDTO> getAllBrandsVw() {
//        return brandService.findById(2L).getModels();
//    }


}

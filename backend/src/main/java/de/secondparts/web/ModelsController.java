package de.secondparts.web;

import de.secondparts.model.entity.ModelEntity;
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

    private final ModelService modelService;


    public ModelsController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/mercedes-benz")
    public List<ModelEntity> getModelsFromBrandMercedesBenz(Long id) {

        return modelService.getAllModels(2L);
    }
}

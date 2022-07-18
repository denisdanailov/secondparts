package de.secondparts.service.impl;

import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.enums.ModelsAudiEnum;
import de.secondparts.repository.ModelRepository;
import de.secondparts.service.BrandService;
import de.secondparts.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
    }

    @Override
    public List<ModelEntity> getAllModelsByBrandId(Long id) {
        return modelRepository.findAllModelsByBrandId(id);
    }

    @Override
    public void initializeModels() {
//        if (modelRepository.count() == 0) {
//
//            Arrays.stream(ModelsAudiEnum.values()).forEach(modelsAudiEnum -> {
//                ModelEntity model = new ModelEntity();
////                TODO: only for example
////                Brand id 4 is Brand "Audi"
//                BrandEntity brand = brandService.findById(4L);
//
//                model.setName(modelsAudiEnum.name());
//                model.setStartYear(2000L);
//                model.setEndYear(2022L);
//                model.setBrand(brand);
//                brand.getModels().add(model);
//
//                modelRepository.save(model);
//            });
//
//        }
    }
}

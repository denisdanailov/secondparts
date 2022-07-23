package de.secondparts.service.impl;


import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.dtos.ModelViewDTO;
import de.secondparts.repository.ModelRepository;
import de.secondparts.service.BrandService;
import de.secondparts.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public ModelServiceImpl(ModelRepository modelRepository, BrandService brandService, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModelViewDTO> getAllModelsByBrandId(Long id) {
        return modelRepository.findAllModelsByBrandId(id).stream().map(this::mapModel).collect(Collectors.toList());
    }

    private ModelViewDTO mapModel (ModelEntity modelEntity) {
        ModelViewDTO modelViewDTO = this.modelMapper.map(modelEntity, ModelViewDTO.class);

        return modelViewDTO;
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

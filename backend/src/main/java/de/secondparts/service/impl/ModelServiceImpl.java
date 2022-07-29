package de.secondparts.service.impl;


import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.BrandViewDTO;
import de.secondparts.model.entity.dtos.ModelViewDTO;
import de.secondparts.model.entity.dtos.userDTOs.UserViewDTO;
import de.secondparts.model.enums.BrandEnum;
import de.secondparts.model.enums.modelsEnums.PorscheEnum;
import de.secondparts.repository.ModelRepository;
import de.secondparts.service.BrandService;
import de.secondparts.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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

    private ModelViewDTO mapModel(ModelEntity modelEntity) {
        ModelViewDTO modelViewDTO = this.modelMapper.map(modelEntity, ModelViewDTO.class);

        return modelViewDTO;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {
// TODO: impl logic..to init models

        }
    }

    private BrandEntity mapBrand(BrandViewDTO brandViewDTO) {
        BrandEntity brandEntity = this.modelMapper.map(brandViewDTO, BrandEntity.class);

        return brandEntity;
    }

    @Override
    public Optional<ModelEntity> findByName(String name) {
        return modelRepository.findByName(name);
    }
}

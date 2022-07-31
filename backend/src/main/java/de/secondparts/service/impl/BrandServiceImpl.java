package de.secondparts.service.impl;

import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.dtos.BrandViewDTO;
import de.secondparts.model.entity.dtos.ModelViewDTO;
import de.secondparts.repository.BrandRepository;
import de.secondparts.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewDTO> getAllBrands() {
        return brandRepository.
                findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BrandViewDTO> findById(Long id) {
        return brandRepository
                .findById(id)
                .map(this::mapBrand);
    }

    private BrandViewDTO  mapBrand(BrandEntity brandEntity) {
        List<ModelViewDTO> models = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel)
                .collect(Collectors.toList());

        return new BrandViewDTO()
                .setModels(models)
                .setName(brandEntity.getName());
    }

    private ModelViewDTO mapModel(ModelEntity modelEntity) {
        return  new ModelViewDTO()
                .setName(modelEntity.getName())
                .setId(modelEntity.getId())
                .setBrand(modelEntity.getBrand());
    }
}


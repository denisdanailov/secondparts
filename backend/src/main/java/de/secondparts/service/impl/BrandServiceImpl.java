package de.secondparts.service.impl;

import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.BrandViewDTO;
import de.secondparts.model.entity.dtos.UserViewDTO;
import de.secondparts.model.enums.BrandEnum;
import de.secondparts.repository.BrandRepository;
import de.secondparts.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
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
    public void initializeBrands() {
        if (brandRepository.count() == 0) {

            Arrays.stream(BrandEnum.values()).forEach(brandEnum -> {
                BrandEntity brand = new BrandEntity();

                brand.setName(brandEnum);
                brandRepository.save(brand);
            });
        }
    }

    @Override
    public List<BrandViewDTO> getAllBrands() {
        return brandRepository.findAll().stream().map(this::mapBrand).collect(Collectors.toList());
    }

    private BrandViewDTO  mapBrand(BrandEntity brandEntity) {
       BrandViewDTO brandViewDto = this.modelMapper.map(brandEntity, BrandViewDTO.class);

        return brandViewDto;
    }

    @Override
    public BrandEntity findById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }
}


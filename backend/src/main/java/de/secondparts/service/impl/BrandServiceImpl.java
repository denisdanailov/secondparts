package de.secondparts.service.impl;

import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.enums.BrandEnum;
import de.secondparts.repository.BrandRepository;
import de.secondparts.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
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
}


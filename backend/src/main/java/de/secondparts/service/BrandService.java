package de.secondparts.service;

import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.dtos.BrandViewDTO;

import java.util.List;

public interface BrandService {

    void initializeBrands();

    List<BrandViewDTO> getAllBrands();

    BrandEntity findById(Long id);
}

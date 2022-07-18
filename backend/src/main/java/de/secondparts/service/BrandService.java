package de.secondparts.service;

import de.secondparts.model.entity.BrandEntity;

import java.util.List;


public interface BrandService {

    void initializeBrands();

    List<BrandEntity> getAllBrands();

    BrandEntity findById(Long id);
}

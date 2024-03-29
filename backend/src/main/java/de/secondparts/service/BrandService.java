package de.secondparts.service;

import de.secondparts.model.entity.dtos.BrandViewDTO;

import java.util.List;
import java.util.Optional;

public interface BrandService {

    List<BrandViewDTO> getAllBrands();

    Optional<BrandViewDTO> findById(Long id);
}

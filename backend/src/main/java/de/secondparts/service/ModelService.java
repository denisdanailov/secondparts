package de.secondparts.service;

import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.dtos.ModelViewDTO;

import java.util.List;
import java.util.Optional;

public interface ModelService {
   List<ModelViewDTO> getAllModelsByBrandId(Long id);

    void initializeModels();

    Optional<ModelEntity> findByName(String name);
}

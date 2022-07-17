package de.secondparts.service;

import de.secondparts.model.entity.ModelEntity;

import java.util.List;

public interface ModelService {
   List<ModelEntity> getAllModels(Long id);
}

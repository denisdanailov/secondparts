package de.secondparts.service.impl;

import de.secondparts.model.entity.ModelEntity;
import de.secondparts.repository.ModelRepository;
import de.secondparts.service.ModelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<ModelEntity> getAllModels(Long id) {
        return modelRepository.findAllByBrandId(id);
    }
}

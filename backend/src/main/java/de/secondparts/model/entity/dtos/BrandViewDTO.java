package de.secondparts.model.entity.dtos;

import de.secondparts.model.enums.BrandEnum;

import java.util.ArrayList;
import java.util.List;


public class BrandViewDTO {

    private BrandEnum name;

    private List<ModelViewDTO> models = new ArrayList<>();


    public BrandEnum getName() {
        return name;
    }

    public BrandViewDTO setName(BrandEnum name) {
        this.name = name;
        return this;
    }

    public List<ModelViewDTO> getModels() {
        return models;
    }

    public BrandViewDTO setModels(List<ModelViewDTO> models) {
        this.models = models;
        return this;
    }
}

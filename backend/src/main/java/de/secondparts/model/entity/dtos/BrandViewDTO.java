package de.secondparts.model.entity.dtos;

import java.util.ArrayList;
import java.util.List;


public class BrandViewDTO {

    private String name;

    private List<ModelViewDTO> models = new ArrayList<>();

    public String getName() {
        return name;
    }

    public BrandViewDTO setName(String name) {
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

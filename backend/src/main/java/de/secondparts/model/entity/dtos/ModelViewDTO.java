package de.secondparts.model.entity.dtos;

import de.secondparts.model.entity.BrandEntity;

public class ModelViewDTO {

    private String name;

    private BrandEntity brand;

    private Long startYear;

    private Long endYear;

    private String imageUrl;

    public String getName() {
        return name;
    }

    public ModelViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelViewDTO setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    public Long getStartYear() {
        return startYear;
    }

    public ModelViewDTO setStartYear(Long startYear) {
        this.startYear = startYear;
        return this;
    }

    public Long getEndYear() {
        return endYear;
    }

    public ModelViewDTO setEndYear(Long endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}

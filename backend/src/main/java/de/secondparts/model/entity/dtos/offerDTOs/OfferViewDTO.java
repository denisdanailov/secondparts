package de.secondparts.model.entity.dtos.offerDTOs;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;


import java.math.BigDecimal;

public class OfferViewDTO {

    private Long id;

    private String title;

    private BigDecimal price;

    private EngineEnum engine;

    private TransmissionEnum transmission;

    private String vehicleIdentificationNumber;

    private Integer year;

    private Integer kilometers;

    private String imageUrl;

    private String description;

    private CategoryEntity category;

    private boolean isActive;

    private ModelEntity model;

    private UserEntity seller;

    public Long getId() {
        return id;
    }

    public OfferViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OfferViewDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferViewDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferViewDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public OfferViewDTO setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferViewDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public OfferViewDTO setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public OfferViewDTO setActive(boolean active) {
        isActive = active;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OfferViewDTO setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferViewDTO setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferViewDTO setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }
}

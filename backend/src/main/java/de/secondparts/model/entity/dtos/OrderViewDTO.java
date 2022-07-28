package de.secondparts.model.entity.dtos;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;


import java.math.BigDecimal;

public class OrderViewDTO {

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


    private ModelEntity model;


    private UserEntity seller;

    public Long getId() {
        return id;
    }

    public OrderViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OrderViewDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderViewDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OrderViewDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OrderViewDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public OrderViewDTO setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OrderViewDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public OrderViewDTO setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OrderViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderViewDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public OrderViewDTO setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OrderViewDTO setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OrderViewDTO setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }
}

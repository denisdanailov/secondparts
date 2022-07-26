package de.secondparts.model.entity.dtos;


import de.secondparts.model.enums.CategoryEnum;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;

import java.math.BigDecimal;

public class OrderCreateDTO {

    private String title;


    private BigDecimal price;


    private EngineEnum engine;


    private TransmissionEnum transmission;


    private String vehicleIdentificationNumber;


    private Integer year;

    private Integer kilometers;

    private String imageUrl;


    private String description;


    private String category;


    private String model;


    private Long sellerId;

    public String getTitle() {
        return title;
    }

    public OrderCreateDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderCreateDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OrderCreateDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OrderCreateDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public OrderCreateDTO setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OrderCreateDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public OrderCreateDTO setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OrderCreateDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public OrderCreateDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OrderCreateDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public OrderCreateDTO setSellerId(Long sellerId) {
        this.sellerId = sellerId;
        return this;
    }

    @Override
    public String toString() {
        return "OrderCreateDTO{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", engine=" + engine +
                ", transmission='" + transmission + '\'' +
                ", vehicleIdentificationNumber='" + vehicleIdentificationNumber + '\'' +
                ", year=" + year +
                ", kilometers=" + kilometers +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", model='" + model + '\'' +
                ", sellerId=" + sellerId +
                '}';
    }
}

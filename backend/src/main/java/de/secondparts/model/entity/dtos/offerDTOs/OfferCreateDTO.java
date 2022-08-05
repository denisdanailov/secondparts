package de.secondparts.model.entity.dtos.offerDTOs;


import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferCreateDTO {

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private EngineEnum engine;

    @NotBlank
    private TransmissionEnum transmission;

    @NotBlank
    @Size(max = 50)
    private String vehicleIdentificationNumber;

    @NotBlank
    private Integer year;

    private Integer kilometers;

    private String imageUrl;

    private String description;

    @NotBlank
    private String category;

    @NotBlank
    private String model;

    private Long sellerId;

    public String getTitle() {
        return title;
    }

    public OfferCreateDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferCreateDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferCreateDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferCreateDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public OfferCreateDTO setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferCreateDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public OfferCreateDTO setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferCreateDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public OfferCreateDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferCreateDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public OfferCreateDTO setSellerId(Long sellerId) {
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

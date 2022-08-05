package de.secondparts.model.entity.dtos.offerDTOs;

import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferEditDTO {

    private Long id;

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

    public Long getId() {
        return id;
    }

    public OfferEditDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OfferEditDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEditDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEditDTO setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEditDTO setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public OfferEditDTO setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferEditDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public OfferEditDTO setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEditDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEditDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public OfferEditDTO setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferEditDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public OfferEditDTO setSellerId(Long sellerId) {
        this.sellerId = sellerId;
        return this;
    }
}

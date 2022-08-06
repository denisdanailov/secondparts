package de.secondparts.model.entity.dtos.offerDTOs;


import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferCreateDTO {

    @NotNull
    @Size(max = 50)
    private String title;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private EngineEnum engine;

    @NotNull
    private TransmissionEnum transmission;

    @NotNull
    @Size(max = 50)
    private String vehicleIdentificationNumber;

    @NotNull
    @Positive
    private Integer year;

    @Positive
    private Integer kilometers;

    private String imageUrl;

    private String description;

    @NotNull
    private String category;

    @NotNull
    private String model;

    @NotNull
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

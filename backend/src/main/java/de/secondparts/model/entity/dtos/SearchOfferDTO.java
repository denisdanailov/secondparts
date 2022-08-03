package de.secondparts.model.entity.dtos;

public class SearchOfferDTO {

    private String model;

    private String vehicleIdentificationNumber;

    public String getModel() {
        return model;
    }

    public SearchOfferDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public SearchOfferDTO setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        return this;
    }

    @Override
    public String toString() {
        return "SearchOfferDTO{" +
                "model='" + model + '\'' +
                ", vehicleIdentificationNumber='" + vehicleIdentificationNumber + '\'' +
                '}';
    }
}

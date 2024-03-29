package de.secondparts.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private BrandEntity brand;

    @Column(nullable = false)
    private Long startYear;

    @Column(nullable = false)
    private Long endYear;

    private String imageUrl;

    public ModelEntity() {
    }

    public ModelEntity(String name, BrandEntity brand, Long startYear, Long endYear, String imageUrl) {
        this.name = name;
        this.brand = brand;
        this.startYear = startYear;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    public Long getStartYear() {
        return startYear;
    }

    public ModelEntity setStartYear(Long startYear) {
        this.startYear = startYear;
        return this;
    }

    public Long getEndYear() {
        return endYear;
    }

    public ModelEntity setEndYear(Long endYear) {
        this.endYear = endYear;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", brand=" + brand +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}

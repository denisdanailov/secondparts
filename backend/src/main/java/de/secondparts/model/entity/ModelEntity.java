package de.secondparts.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private BrandEntity brand;

    @Column(nullable = false)
    private Long year;


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

    public Long getYear() {
        return year;
    }

    public ModelEntity setYear(Long year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", brand=" + brand +
                ", year=" + year +
                '}';
    }
}

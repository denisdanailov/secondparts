package de.secondparts.model.entity;

import de.secondparts.model.enums.BrandEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private BrandEnum name;

    @OneToMany(
            mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<ModelEntity> models = new ArrayList<>();

    public BrandEntity() {
    }

    public BrandEnum getName() {
        return name;
    }

    public BrandEntity setName(BrandEnum name) {
        this.name = name;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }

    @Override
    public String toString() {
        return "BrandEntity{" +
                "name=" + name +
                ", models=" + models +
                '}';
    }
}

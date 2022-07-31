package de.secondparts.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    private String name;

    private String imageUrl;

    @OneToMany( mappedBy = "category",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<OfferEntity> offers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public CategoryEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CategoryEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public CategoryEntity setOffers(List<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }
}

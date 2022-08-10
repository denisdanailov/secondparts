package de.secondparts.model.entity.dtos;

import de.secondparts.model.entity.OfferEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewDTO {

    private Long id;

    private String name;

    private String imageUrl;

    private List<OfferEntity> offers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public CategoryViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CategoryViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CategoryViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public CategoryViewDTO setOffers(List<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }
}

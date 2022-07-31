package de.secondparts.model.entity.dtos;

public class CategoryViewDTO {

    private String name;

    private String imageUrl;

    public String getName() {
        return name;
    }

    public CategoryViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CategoryViewDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}

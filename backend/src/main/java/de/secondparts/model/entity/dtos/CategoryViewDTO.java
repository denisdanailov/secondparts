package de.secondparts.model.entity.dtos;

import de.secondparts.model.entity.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryViewDTO {

    private String name;

    private List<OrderEntity> orders = new ArrayList<>();

    public String getName() {
        return name;
    }

    public CategoryViewDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public CategoryViewDTO setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}

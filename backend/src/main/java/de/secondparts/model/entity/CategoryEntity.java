package de.secondparts.model.entity;

import de.secondparts.model.enums.CategoryEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @OneToMany( mappedBy = "category",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<OrderEntity> orders = new ArrayList<>();

    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public CategoryEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }


}

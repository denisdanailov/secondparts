package de.secondparts.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    private String title;

    private Integer year;

    private Integer kilometers;

    private String description;


}

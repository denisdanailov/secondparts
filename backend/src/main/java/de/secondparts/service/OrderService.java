package de.secondparts.service;

import de.secondparts.model.entity.dtos.OrderCreateDTO;

public interface OrderService {

    void orderCreate(OrderCreateDTO orderCreateDTO) throws Exception;
}

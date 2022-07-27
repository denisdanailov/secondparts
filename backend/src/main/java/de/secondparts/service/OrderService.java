package de.secondparts.service;

import de.secondparts.model.entity.dtos.OrderCreateDTO;
import de.secondparts.model.entity.dtos.OrderViewDTO;

import java.util.List;

public interface OrderService {

    void orderCreate(OrderCreateDTO orderCreateDTO) throws Exception;

    List<OrderViewDTO> getAllOrders();
}

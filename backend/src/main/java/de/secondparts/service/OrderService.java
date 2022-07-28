package de.secondparts.service;

import de.secondparts.model.entity.OrderEntity;
import de.secondparts.model.entity.dtos.OrderCreateDTO;
import de.secondparts.model.entity.dtos.OrderViewDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void orderCreate(OrderCreateDTO orderCreateDTO) throws Exception;

    List<OrderViewDTO> getAllOrders();

    void deleteOrder(Long id);

    Optional<OrderEntity> findById(Long id);
}

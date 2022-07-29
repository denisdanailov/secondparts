package de.secondparts.service;

import de.secondparts.model.entity.OrderEntity;
import de.secondparts.model.entity.dtos.OrderCreateDTO;
import de.secondparts.model.entity.dtos.OrderEditDTO;
import de.secondparts.model.entity.dtos.OrderViewDTO;
import de.secondparts.model.entity.dtos.UserEditDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderViewDTO> getAllOrders();

    Optional<OrderEntity> findById(Long id);

    void orderCreate(OrderCreateDTO orderCreateDTO);

    void editOrder(Long id, OrderEditDTO orderEditDTO);

    void deleteOrder(Long id);



}

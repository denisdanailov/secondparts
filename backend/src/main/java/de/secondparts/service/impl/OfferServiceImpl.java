package de.secondparts.service.impl;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.OrderEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.OrderCreateDTO;
import de.secondparts.model.entity.dtos.OrderEditDTO;
import de.secondparts.model.entity.dtos.OrderViewDTO;
import de.secondparts.model.entity.dtos.UserViewDTO;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.repository.OrderRepository;
import de.secondparts.service.CategoryService;
import de.secondparts.service.ModelService;
import de.secondparts.service.OrderService;
import de.secondparts.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.PreRemove;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ModelService modelService;
    private final CategoryService categoryService;
    private final OrderRepository orderRepository;


    public OrderServiceImpl(UserService userService, ModelMapper modelMapper, ModelService modelService, CategoryService categoryService, OrderRepository orderRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.categoryService = categoryService;
        this.orderRepository = orderRepository;
    }

    @Override
    public void orderCreate(OrderCreateDTO orderCreateDTO) {
        OrderEntity newOrder = new OrderEntity();
        Optional<ModelEntity> model = modelService.findByName(orderCreateDTO.getModel());
        Optional<UserEntity> seller = userService.findById(orderCreateDTO.getSellerId());
        Optional<EngineEnum> engine = Arrays.stream(EngineEnum.values())
                .filter(engineEnum -> engineEnum.equals(orderCreateDTO.getEngine())).findFirst();

        Optional<TransmissionEnum> transmission = Arrays.stream(TransmissionEnum.values())
                .filter(transmissionEnum -> transmissionEnum.equals(orderCreateDTO.getTransmission())).findFirst();

        Optional<CategoryEntity> category = categoryService.findByName(orderCreateDTO.getCategory());

        newOrder.setTitle(orderCreateDTO.getTitle())
                .setPrice(orderCreateDTO.getPrice())
                .setYear(orderCreateDTO.getYear())
                .setImageUrl(orderCreateDTO.getImageUrl())
                .setKilometers(orderCreateDTO.getKilometers())
                .setVehicleIdentificationNumber(orderCreateDTO.getVehicleIdentificationNumber())
                .setDescription(orderCreateDTO.getDescription())
                .setModel(model.get())
                .setCategory(category.get())
                .setEngine(engine.get())
                .setTransmission(transmission.get())
                .setSeller(seller.get());

// TODO: Check Optional isPresent->


        orderRepository.save(newOrder);

    }

    @Override
    public void editOrder(Long id, OrderEditDTO orderEditDTO) {

        OrderEntity order = orderRepository.findById(id).orElse(null);

        Optional<ModelEntity> model = modelService.findByName(orderEditDTO.getModel());
        Optional<EngineEnum> engine = Arrays.stream(EngineEnum.values())
                .filter(engineEnum -> engineEnum.equals(orderEditDTO.getEngine())).findFirst();

        Optional<TransmissionEnum> transmission = Arrays.stream(TransmissionEnum.values())
                .filter(transmissionEnum -> transmissionEnum.equals(orderEditDTO.getTransmission())).findFirst();

        Optional<CategoryEntity> category = categoryService.findByName(orderEditDTO.getCategory());


        if (order != null
                && model.isPresent()
                && engine.isPresent()
                && transmission.isPresent()
                && category.isPresent()) {


            order.setTitle(orderEditDTO.getTitle())
                    .setPrice(orderEditDTO.getPrice())
                    .setYear(orderEditDTO.getYear())
                    .setImageUrl(orderEditDTO.getImageUrl())
                    .setKilometers(orderEditDTO.getKilometers())
                    .setVehicleIdentificationNumber(orderEditDTO.getVehicleIdentificationNumber())
                    .setDescription(orderEditDTO.getDescription())
                    .setModel(model.get())
                    .setCategory(category.get())
                    .setEngine(engine.get())
                    .setTransmission(transmission.get());

            orderRepository.save(order);
            }


    }

    @Override
    public List<OrderViewDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(this::mapOrder).collect(Collectors.toList());
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.findById(id).ifPresent(orderRepository::delete);
    }

    @Override
    public Optional<OrderEntity> findById(Long id) {
        return orderRepository.findById(id);
    }

    private OrderViewDTO mapOrder(OrderEntity orderEntity) {
        OrderViewDTO orderViewDTO = this.modelMapper.map(orderEntity, OrderViewDTO.class);

        return orderViewDTO;
    }

    private UserEntity mapUser(UserViewDTO userViewDTO) {
        UserEntity userEntity = this.modelMapper.map(userViewDTO, UserEntity.class);

        return userEntity;
    }
}

package de.secondparts.service.impl;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.OrderEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.OrderCreateDTO;
import de.secondparts.model.entity.dtos.UserViewDTO;
import de.secondparts.model.enums.CategoryEnum;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.repository.OrderRepository;
import de.secondparts.service.CategoryService;
import de.secondparts.service.ModelService;
import de.secondparts.service.OrderService;
import de.secondparts.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

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
    public void orderCreate(OrderCreateDTO orderCreateDTO) throws Exception {
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



//        if (model.isPresent()) {
//            newOrder.setModel(model.get());
//        } else if (seller.isPresent()) {
//           newOrder.setSeller(seller.get());
//        } else if (transmission.isPresent()) {
//            newOrder.setTransmission(transmission.get());
//        } else if (engine.isPresent()) {
//            newOrder.setEngine(engine.get());
////        } else if (category.isPresent()) {
////            newOrder.setCategory(category);
//        }
//        else {
//            throw new Exception("not found");
//        }


        orderRepository.save(newOrder);

    }

    private UserEntity mapUser(UserViewDTO userViewDTO) {
        UserEntity userEntity = this.modelMapper.map(userViewDTO, UserEntity.class);

        return userEntity;
    }
}

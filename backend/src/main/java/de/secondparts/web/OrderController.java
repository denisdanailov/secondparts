package de.secondparts.web;

import de.secondparts.model.entity.OrderEntity;
import de.secondparts.model.entity.dtos.BrandViewDTO;
import de.secondparts.model.entity.dtos.OrderCreateDTO;
import de.secondparts.model.entity.dtos.OrderViewDTO;
import de.secondparts.model.enums.CategoryEnum;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.payment.response.MessageResponse;
import de.secondparts.service.BrandService;
import de.secondparts.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, BrandService brandService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderViewDTO>> getAllOrders() {

       return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderViewDTO> getOrderById(@PathVariable("id") Long id) {
        Optional<OrderViewDTO> order = orderService.findById(id).map(orderEntity -> {
            OrderViewDTO orderViewDTO = modelMapper.map(orderEntity, OrderViewDTO.class);

            return orderViewDTO;
        });

        return order.map(orderViewDTO
                -> new ResponseEntity<>(orderViewDTO, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderViewDTO> deleteOrder(@PathVariable("id") Long id) {
        try {
            orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> createUser(@Valid @RequestBody OrderCreateDTO orderCreateDTO) throws Exception {


        try {
            System.out.println(orderCreateDTO);
            orderService.orderCreate(orderCreateDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//   TODO:  types for Create Form. Create a Types Controller for them->

    @GetMapping("/transmissions")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public TransmissionEnum[] getTransmissionItems() {
        return TransmissionEnum.values();
    }

    @GetMapping("/engines")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public EngineEnum[] getEngines() {
        return EngineEnum.values();
    }

    @GetMapping("/categories")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public CategoryEnum[] getCategories() {
        return CategoryEnum.values();
    }

    @GetMapping("/brands")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<BrandViewDTO> getAllBrands() {
        return brandService.getAllBrands();
    }

}

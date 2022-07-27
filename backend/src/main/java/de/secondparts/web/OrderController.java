package de.secondparts.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import de.secondparts.model.entity.dtos.BrandViewDTO;
import de.secondparts.model.entity.dtos.OrderCreateDTO;
import de.secondparts.model.entity.dtos.OrderViewDTO;
import de.secondparts.model.enums.CategoryEnum;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.payment.response.MessageResponse;
import de.secondparts.service.BrandService;
import de.secondparts.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final BrandService brandService;

    public OrderController(OrderService orderService, BrandService brandService) {
        this.orderService = orderService;
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderViewDTO>> getAllOrders() {

       return ResponseEntity.ok(orderService.getAllOrders());
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

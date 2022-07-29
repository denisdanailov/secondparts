package de.secondparts.web;

import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.dtos.*;
import de.secondparts.model.entity.dtos.offerDTOs.OfferCreateDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferEditDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferViewDTO;
import de.secondparts.model.enums.CategoryEnum;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.payment.response.MessageResponse;
import de.secondparts.service.BrandService;
import de.secondparts.service.OfferService;
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

    private final OfferService offerService;
    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public OrderController(OfferService offerService, BrandService brandService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OfferViewDTO>> getAllOrders() {

        return ResponseEntity.ok(offerService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferViewDTO> getOrderById(@PathVariable("id") Long id) {
        Optional<OfferViewDTO> order = offerService.findById(id).map(orderEntity -> {
            OfferViewDTO offerViewDTO = modelMapper.map(orderEntity, OfferViewDTO.class);

            return offerViewDTO;
        });

        return order.map(offerViewDTO
                -> new ResponseEntity<>(offerViewDTO, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OfferViewDTO> deleteOrder(@PathVariable("id") Long id) {
        try {
            offerService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<OfferEditDTO> editOrder(@Valid @PathVariable("id") Long id, @RequestBody OfferEditDTO offerEditDTO) {

        OfferEntity orderToEdit = offerService.findById(id).orElse(null);

        if (orderToEdit != null) {

            offerService.editOrder(id, offerEditDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> createUser(@Valid @RequestBody OfferCreateDTO offerCreateDTO) {

        try {
            offerService.orderCreate(offerCreateDTO);
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

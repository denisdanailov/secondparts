package de.secondparts.web;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.dtos.*;
import de.secondparts.model.entity.dtos.offerDTOs.OfferCreateDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferEditDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferViewDTO;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.payment.response.MessageResponse;
import de.secondparts.service.BrandService;
import de.secondparts.service.CategoryService;
import de.secondparts.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public OfferController(OfferService offerService, BrandService brandService, CategoryService categoryService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OfferViewDTO>> getAllActiveOffers() {

        return ResponseEntity.ok(offerService.getAllActiveOffers());
    }

    @PostMapping("/search")
    public ResponseEntity<List<OfferViewDTO>> searchOffer(@Valid @RequestBody SearchOfferDTO searchOfferDTO) {

        System.out.println(searchOfferDTO);

        return ResponseEntity.ok(offerService.searchOffer(searchOfferDTO));
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getOffersCount() {

        return ResponseEntity.ok(offerService.getOffersCount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferViewDTO> getOfferById(@PathVariable("id") Long id) {
        Optional<OfferViewDTO> order = offerService.findById(id).map(orderEntity -> {
            OfferViewDTO offerViewDTO = modelMapper.map(orderEntity, OfferViewDTO.class);

            return offerViewDTO;
        });

        return order.map(offerViewDTO
                -> new ResponseEntity<>(offerViewDTO, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("@offerServiceImpl.isOwnerOrAdmin(#principal.name, #id)")
    public ResponseEntity<OfferViewDTO> deactivateOffer(Principal principal, @PathVariable("id") Long id) {
        try {
            offerService.deactivateOffer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("{id}")
    @PreAuthorize("@offerServiceImpl.isOwnerOrAdmin(#principal.name, #id)")
    public ResponseEntity<OfferEditDTO> editOffer(@Valid Principal principal,
                                                  @PathVariable("id") Long id,
                                                  @RequestBody OfferEditDTO offerEditDTO) {

        OfferEntity orderToEdit = offerService.findById(id).orElse(null);

        if (orderToEdit != null) {

            offerService.editOffer(id, offerEditDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/create")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> createOffer(@Valid @RequestBody OfferCreateDTO offerCreateDTO) {

        System.out.println(offerCreateDTO);

        try {
            offerService.createOffer(offerCreateDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
    public List<CategoryViewDTO> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/brands")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<BrandViewDTO> getAllBrands() {
        return brandService.getAllBrands();
    }

}

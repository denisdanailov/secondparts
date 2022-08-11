package de.secondparts.web;


import de.secondparts.model.entity.ShoppingCardEntity;
import de.secondparts.model.entity.dtos.offerDTOs.OfferViewDTO;
import de.secondparts.payment.response.MessageResponse;
import de.secondparts.service.ShoppingCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/shopping-card")
public class ShoppingCardController {

    private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<ShoppingCardEntity> getAllOffersByBuyerId(@PathVariable("id") Long id) {

                  return shoppingCardService.getAllActiveOfferByBuyerId(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> addOffer(@Valid @RequestBody ShoppingCardEntity shoppingCardEntity) {

        try {
            shoppingCardService.addOffer(shoppingCardEntity);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/checkout")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> checkout() {
        try {
            shoppingCardService.setOffersToSold();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

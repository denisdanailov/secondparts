package de.secondparts.service;

import de.secondparts.model.entity.ShoppingCardEntity;

import java.util.List;

public interface ShoppingCardService {

    void addOffer(ShoppingCardEntity shoppingCardEntity);

    List<ShoppingCardEntity> getAllActiveOfferFromCard();

    List<ShoppingCardEntity> getAllActiveOfferByBuyerId(Long id);

    void setOffersToSold();
}

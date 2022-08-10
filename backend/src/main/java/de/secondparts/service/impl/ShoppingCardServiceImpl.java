package de.secondparts.service.impl;

import de.secondparts.model.entity.ShoppingCardEntity;
import de.secondparts.repository.ShoppingCardRepository;
import de.secondparts.service.ShoppingCardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCardServiceImpl implements ShoppingCardService {

    private final ShoppingCardRepository shoppingCardRepository;

    public ShoppingCardServiceImpl(ShoppingCardRepository shoppingCardRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
    }

    @Override
    public void addOffer(ShoppingCardEntity shoppingCardEntity) {
        ShoppingCardEntity card = new ShoppingCardEntity();

        card.setOfferId(shoppingCardEntity.getOfferId())
                .setBuyerId(shoppingCardEntity.getBuyerId())
                .setOfferTitle(shoppingCardEntity.getOfferTitle())
                .setOfferPrice(shoppingCardEntity.getOfferPrice())
                .setIsSold(false);

        shoppingCardRepository.save(card);

    }

    @Override
    public List<ShoppingCardEntity> getAllActiveOfferFromCard() {
        return shoppingCardRepository
                .findAll()
                .stream()
                .filter(shoppingCardEntity -> !shoppingCardEntity.isSold())
                .collect(Collectors.toList());
    }

    @Override
    public void setOffersToSold() {
        List<ShoppingCardEntity> soldOffers =
                shoppingCardRepository.findAll().stream().map(shoppingCardEntity -> {
                    return shoppingCardEntity.setIsSold(true);

                }).collect(Collectors.toList());

        shoppingCardRepository.saveAll(soldOffers);
    }
}

package de.secondparts.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "shopping_cards")
public class ShoppingCardEntity extends BaseEntity{

    private Long buyerId;

    private Long offerId;

    private String offerTitle;

    private BigDecimal offerPrice;

    boolean isSold;

    public Long getBuyerId() {
        return buyerId;
    }

    public ShoppingCardEntity setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
        return this;
    }

    public Long getOfferId() {
        return offerId;
    }

    public ShoppingCardEntity setOfferId(Long offerId) {
        this.offerId = offerId;
        return this;
    }

    public String getOfferTitle() {
        return offerTitle;
    }

    public ShoppingCardEntity setOfferTitle(String offerTitle) {
        this.offerTitle = offerTitle;
        return this;
    }

    public BigDecimal getOfferPrice() {
        return offerPrice;
    }

    public ShoppingCardEntity setOfferPrice(BigDecimal offerPrice) {
        this.offerPrice = offerPrice;
        return this;
    }

    public boolean isSold() {
        return isSold;
    }

    public ShoppingCardEntity setIsSold(boolean sold) {
        isSold = sold;
        return this;
    }
}

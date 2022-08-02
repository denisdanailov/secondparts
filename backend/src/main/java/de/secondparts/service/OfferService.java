package de.secondparts.service;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.dtos.SearchOfferDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferCreateDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferEditDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferViewDTO;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    List<OfferViewDTO> getAllActiveOffers();

    List<OfferViewDTO> getAllByCategory(CategoryEntity category);

    List<OfferViewDTO> searchOffer(SearchOfferDTO searchOfferDTO);

    Integer getOffersCount();

    Optional<OfferEntity> findById(Long id);

    void createOffer(OfferCreateDTO offerCreateDTO);

    void editOffer(Long id, OfferEditDTO offerEditDTO);

    void deactivateOffer(Long id);

    boolean isOwnerOrAdmin(String userName, Long offerId);



}

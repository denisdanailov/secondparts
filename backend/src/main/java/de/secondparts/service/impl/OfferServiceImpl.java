package de.secondparts.service.impl;

import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.SearchOfferDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferCreateDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferEditDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferViewDTO;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.repository.OfferRepository;
import de.secondparts.repository.OfferSpecification;
import de.secondparts.service.CategoryService;
import de.secondparts.service.ModelService;
import de.secondparts.service.OfferService;
import de.secondparts.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ModelService modelService;
    private final CategoryService categoryService;
    private final OfferRepository offerRepository;

    public OfferServiceImpl(UserService userService, ModelMapper modelMapper, ModelService modelService, CategoryService categoryService, OfferRepository offerRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.modelService = modelService;
        this.categoryService = categoryService;
        this.offerRepository = offerRepository;
    }

    @Override
    public void createOffer(OfferCreateDTO offerCreateDTO) {
        OfferEntity newOffer = new OfferEntity();
        Optional<ModelEntity> model = modelService.findByName(offerCreateDTO.getModel());
        Optional<UserEntity> seller = userService.findById(offerCreateDTO.getSellerId());
        Optional<EngineEnum> engine = getEngine(offerCreateDTO.getEngine());
        Optional<TransmissionEnum> transmission = getTransmission(offerCreateDTO.getTransmission());
        Optional<CategoryEntity> category = categoryService.findByName(offerCreateDTO.getCategory());

        if (model.isPresent()
                && engine.isPresent()
                && transmission.isPresent()
                && category.isPresent()
                && seller.isPresent()) {

            newOffer.setTitle(offerCreateDTO.getTitle())
                    .setPrice(offerCreateDTO.getPrice())
                    .setYear(offerCreateDTO.getYear())
                    .setImageUrl(offerCreateDTO.getImageUrl())
                    .setKilometers(offerCreateDTO.getKilometers())
                    .setVehicleIdentificationNumber(offerCreateDTO.getVehicleIdentificationNumber())
                    .setDescription(offerCreateDTO.getDescription())
                    .setModel(model.get())
                    .setCategory(category.get())
                    .setEngine(engine.get())
                    .setTransmission(transmission.get())
                    .setSeller(seller.get())
                    .setActive(true);

            offerRepository.save(newOffer);
        }
    }

    @Override
    public void editOffer(Long id, OfferEditDTO offerEditDTO) {

        OfferEntity offer = offerRepository.findById(id).orElse(null);

        Optional<ModelEntity> model = modelService.findByName(offerEditDTO.getModel());
        Optional<EngineEnum> engine = getEngine(offerEditDTO.getEngine());
        Optional<TransmissionEnum> transmission = getTransmission(offerEditDTO.getTransmission());
        Optional<CategoryEntity> category = categoryService.findByName(offerEditDTO.getCategory());

        if (offer != null
                && model.isPresent()
                && engine.isPresent()
                && transmission.isPresent()
                && category.isPresent()) {

            offer.setTitle(offerEditDTO.getTitle())
                    .setPrice(offerEditDTO.getPrice())
                    .setYear(offerEditDTO.getYear())
                    .setImageUrl(offerEditDTO.getImageUrl())
                    .setKilometers(offerEditDTO.getKilometers())
                    .setVehicleIdentificationNumber(offerEditDTO.getVehicleIdentificationNumber())
                    .setDescription(offerEditDTO.getDescription())
                    .setModel(model.get())
                    .setCategory(category.get())
                    .setEngine(engine.get())
                    .setTransmission(transmission.get());

            offerRepository.save(offer);
        }
    }

    @Override
    public List<OfferViewDTO> getAllActiveOffers() {
        return offerRepository.findAll().stream().map(this::mapOffer)
                .filter(OfferViewDTO::isActive).collect(Collectors.toList());
    }

    @Override
    public List<OfferViewDTO> getAllByCategory(CategoryEntity category) {
        return offerRepository.findAllByCategory(category)
                .stream().map(this::mapOffer).collect(Collectors.toList());
    }

    @Override
    public List<OfferViewDTO> searchOffer(SearchOfferDTO searchOfferDTO) {
        return offerRepository.findAll(new OfferSpecification(searchOfferDTO))
                .stream().map(offerEntity -> {
                    OfferViewDTO offerViewDTO = modelMapper.map(offerEntity, OfferViewDTO.class);

                    return offerViewDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public Integer getOffersCount() {
        return getAllActiveOffers().size();
    }

    @Override
    public void deactivateOffer(Long id) {
        //   We deactivate the offer, then a Scheduling functionality delete a deactivated offers.
        Optional<OfferEntity> offerToDeactivated = offerRepository.findById(id);

        if (offerToDeactivated.isPresent()) {
            offerToDeactivated.get().setActive(false);

            offerRepository.save(offerToDeactivated.get());
        }
    }

    @Override
    public void clearRemovedOffers() {
        offerRepository.clearRemovedOffers();
    }

    @Override
    public boolean isOwnerOrAdmin(String username, Long offerId) {

        boolean isOwner = offerRepository
                .findById(offerId)
                .filter(offerEntity -> offerEntity.getSeller().getUsername().equals(username))
                .isPresent();

        if (isOwner) {
            return true;
        }

        return userService.findByUsername(username).filter(this::isAdmin).isPresent();
    }

    private boolean isAdmin(UserEntity user) {
        return user.getRoles()
                .stream()
                .anyMatch(userRole -> userRole.getName() == UserRoleEnum.ROLE_ADMIN);
    }

    @Override
    public Optional<OfferEntity> findById(Long id) {
        return offerRepository.findById(id);
    }

    private OfferViewDTO mapOffer(OfferEntity offerEntity) {
        OfferViewDTO offerViewDTO = this.modelMapper.map(offerEntity, OfferViewDTO.class);

        return offerViewDTO;
    }

    private Optional<EngineEnum> getEngine(EngineEnum engine2) {
        return Arrays.stream(EngineEnum.values())
                .filter(engineEnum -> engineEnum.equals(engine2)).findFirst();
    }

    private Optional<TransmissionEnum> getTransmission(TransmissionEnum transmission2) {
        return Arrays.stream(TransmissionEnum.values())
                .filter(transmissionEnum -> transmissionEnum.equals(transmission2)).findFirst();
    }
}

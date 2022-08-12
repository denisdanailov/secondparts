package de.secondparts.service;

import de.secondparts.model.entity.*;
import de.secondparts.model.entity.dtos.SearchOfferDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferCreateDTO;
import de.secondparts.model.entity.dtos.offerDTOs.OfferViewDTO;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.repository.OfferRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OfferServiceTest {

    @Mock
    private OfferService offerService;

    @Mock
    private OfferRepository offerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAllActivesOffer() throws Exception {
        OfferEntity offer = new OfferEntity();
        CategoryEntity category = new CategoryEntity();
        UserEntity seller = new UserEntity();
        ModelEntity modelEntity = new ModelEntity();
        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setName("Opel");

        modelEntity.setName("astra");
        modelEntity.setEndYear(2019L)
                        .setStartYear(2020L)
                                .setBrand(brandEntity);

        seller.setEmail("test@test.de")
                .setFirstName("testName")
                .setLastName("setTestName")
                .setPassword("topSecreet")
                .setUsername("imfortesthere");

        category.setName("Brake");

        offer.setActive(true)
                .setImageUrl("img")
                .setEngine(EngineEnum.GASOLINE)
                .setTransmission(TransmissionEnum.MANUAL)
                .setCategory(category)
                .setPrice(BigDecimal.TEN)
                .setYear(2019)
                .setSeller(seller)
                .setModel(modelEntity)
                .setTitle("Offertafortest");

        OfferViewDTO offerViewDTO = this.modelMapper.map(offer, OfferViewDTO.class);

        List<OfferViewDTO> offersDTOs = new ArrayList<>();
        List<OfferEntity> offers = new ArrayList<>();
        offers.add(offer);

        offersDTOs.add(offerViewDTO);

        offerRepository.save(offer);

        when(offerService.getAllActiveOffers()).thenReturn(offersDTOs);
        when(offerRepository.findAll()).thenReturn(offers);
//        find by id
        when(offerService.findById(1L)).thenReturn(Optional.of(offer));



    }

    @Test
    void testIsOwnerOrAdmin() {

        when(offerService.isOwnerOrAdmin("imfortesthere",1L)).thenReturn(true);
    }

    @Test
    void testGetAllByCategory() {
        CategoryEntity category = new CategoryEntity();
        category.setName("Brakes");

        List<OfferViewDTO> offersDTOs = new ArrayList<>();
        when(offerService.getAllByCategory(category)).thenReturn(offersDTOs);
    }

    @Test
    void testGetOffersCount() throws Exception {
        List<OfferEntity> offers = new ArrayList<>();
        when(offerService.getOffersCount()).thenReturn(offers.size());
    }

    @Test
    void testSearchOffer() {
        OfferEntity offer = new OfferEntity();
        CategoryEntity category = new CategoryEntity();
        UserEntity seller = new UserEntity();
        ModelEntity modelEntity = new ModelEntity();
        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setName("Opel");

        modelEntity.setName("astra");
        modelEntity.setEndYear(2019L)
                .setStartYear(2020L)
                .setBrand(brandEntity);

        seller.setEmail("test@test.de")
                .setFirstName("testName")
                .setLastName("setTestName")
                .setPassword("topSecreet")
                .setUsername("imfortesthere");

        category.setName("Brake");

        offer.setActive(true)
                .setImageUrl("img")
                .setEngine(EngineEnum.GASOLINE)
                .setTransmission(TransmissionEnum.MANUAL)
                .setCategory(category)
                .setPrice(BigDecimal.TEN)
                .setYear(2019)
                .setSeller(seller)
                .setModel(modelEntity)
                .setTitle("Offertafortest");

        SearchOfferDTO searchOfferDTO = this.modelMapper.map(offer, SearchOfferDTO.class);
        OfferViewDTO offerViewDTO = this.modelMapper.map(offer, OfferViewDTO.class);

        when(offerService.searchOffer(searchOfferDTO)).thenReturn(List.of(offerViewDTO));

    }


}

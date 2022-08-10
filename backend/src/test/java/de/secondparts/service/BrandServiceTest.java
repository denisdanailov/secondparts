package de.secondparts.service;

import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.dtos.BrandViewDTO;
import de.secondparts.repository.BrandRepository;
import de.secondparts.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BrandServiceTest {


    @Mock
    private BrandRepository brandRepository;

    @Mock
    private BrandService brandService;

   @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testGetAllBrands() {
        BrandEntity brandEntity = new BrandEntity();
        ModelEntity modelEntity = new ModelEntity();

        brandEntity.setName("Merceder");

        modelEntity.setBrand(brandEntity);
        modelEntity.setEndYear(2021L);
        modelEntity.setStartYear(2022L);
        modelEntity.setImageUrl("img");

        brandEntity.setModels(List.of(modelEntity));

        ArrayList<BrandEntity> brandViewDTOS = new ArrayList<>();
        brandViewDTOS.add(brandEntity);

        when(brandRepository.findAll()).thenReturn(brandViewDTOS);

    }


    @Test
    void testFindById() {
        BrandEntity brandEntity = new BrandEntity();
        ModelEntity modelEntity = new ModelEntity();

        brandEntity.setName("Merceders");
        modelEntity.setBrand(brandEntity);
        modelEntity.setEndYear(2021L);
        modelEntity.setStartYear(2022L);
        modelEntity.setImageUrl("img");

        Optional<BrandEntity> brand = Optional.of(brandEntity);
        when(brandRepository.findById((Long) any())).thenReturn(brand);

    }

    @Test
    void testFindBrandDTOById() {
        BrandEntity brandEntity = new BrandEntity();
        ModelEntity modelEntity = new ModelEntity();

        brandEntity.setName("Merceders");
        modelEntity.setBrand(brandEntity);
        modelEntity.setEndYear(2021L);
        modelEntity.setStartYear(2022L);
        modelEntity.setImageUrl("img");

        Optional<BrandViewDTO> brandView =  Optional.of(this.modelMapper.map(brandEntity, BrandViewDTO.class));

        when(brandService.findById((Long) any())).thenReturn(brandView);

    }


}

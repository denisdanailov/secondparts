package de.secondparts.service;


import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.ModelEntity;
import de.secondparts.model.entity.dtos.ModelViewDTO;
import de.secondparts.repository.BrandRepository;
import de.secondparts.repository.ModelRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ModelServiceTest {

    @Mock
    private ModelService modelService;

    @Mock
    private ModelRepository modelRepository;

    @Mock
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testFindByName() {
        ModelEntity modelEntity = new ModelEntity();
        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setName("Opel");
        brandEntity.setModels(List.of(modelEntity));

        modelEntity.setName("Astra");
        modelEntity.setBrand(brandEntity);
        modelEntity.setImageUrl("img");
        modelEntity.setStartYear(1232L);
        modelEntity.setEndYear(3432L);

        when(modelService.findByName((String) any())).thenReturn(Optional.of(modelEntity));


    }

    @Test
    void testFindByBrandId() {
        ModelEntity modelEntity = new ModelEntity();
        BrandEntity brandEntity = new BrandEntity();

        brandEntity.setName("Opel");
        brandEntity.setModels(List.of(modelEntity));

        modelEntity.setName("Astra");
        modelEntity.setBrand(brandEntity);
        modelEntity.setImageUrl("img");
        modelEntity.setStartYear(1232L);
        modelEntity.setEndYear(3432L);

        ModelViewDTO modelViewDTO = this.modelMapper.map(modelEntity, ModelViewDTO.class);
        List<ModelViewDTO> models = new ArrayList<>();
        models.add(modelViewDTO);

        when(modelService.getAllModelsByBrandId((Long) any())).thenReturn(models);
    }
}

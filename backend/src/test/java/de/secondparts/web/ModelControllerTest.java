package de.secondparts.web;


import de.secondparts.service.ModelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ModelControllerTest {

    @Autowired
    private ModelsController modelsController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ModelService modelService;


    @Test
    void getModelVw() throws Exception {
        this.mockMvc
                .perform(get("/api/models/vw"))
                .andExpect(status().isOk());

    }

    @Test
    void getModelAudi() throws Exception {
        this.mockMvc
                .perform(get("/api/models/audi"))
                .andExpect(status().isOk());

    }

    @Test
    void getModelMercedes() throws Exception {
        this.mockMvc
                .perform(get("/api/models/mercedes-benz"))
                .andExpect(status().isOk());

    }

    @Test
    void getModelOpel() throws Exception {
        this.mockMvc
                .perform(get("/api/models/opel"))
                .andExpect(status().isOk());

    }

    @Test
    void getModelBmw() throws Exception {
        this.mockMvc
                .perform(get("/api/models/bmw"))
                .andExpect(status().isOk());


    }

    @Test
    void getModelPorsche() throws Exception {
        this.mockMvc
                .perform(get("/api/models/porsche"))
                .andExpect(status().isOk());


    }

}

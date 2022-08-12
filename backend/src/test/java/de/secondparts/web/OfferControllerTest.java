package de.secondparts.web;


import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateOfferWithoutAuthenticate() throws Exception {


        mockMvc.perform(post("/api/offers/create").
                        param("modelId", "1").
                        param("price", "11200").
                        param("engine", "GASOLINE").
                param("category","Brake").
                        param("year", "1979").
                        param("mileage", "1000").
                        param("description", "test").
                        param("transmission", "MANUAL").
                        param("imageUrl", "image://test.png").
                        with(csrf())
                ).
                andExpect(status().is4xxClientError());

        }

    @Test
    void testGetBrands_Forbidden() throws Exception {
        mockMvc.perform(get("/api/offers/brands").
                        with(csrf())
                ).
                andExpect(status().is4xxClientError());
    }

    @Test
    void testGetCategories_Forbidden() throws Exception {
        mockMvc.perform(get("/api/offers/categories").
                        with(csrf())
                ).
                andExpect(status().is4xxClientError());
    }

    @Test
    void testGetEngines_Forbidden() throws Exception {
        mockMvc.perform(get("/api/offers/engines").
                        with(csrf())
                ).
                andExpect(status().is4xxClientError());
    }

    @Test
    void testGetTransmission_Forbidden() throws Exception {
        mockMvc.perform(get("/api/offers/transmissions").
                        with(csrf())
                ).
                andExpect(status().is4xxClientError());
    }

}

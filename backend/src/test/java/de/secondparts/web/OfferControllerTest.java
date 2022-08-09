package de.secondparts.web;


import de.secondparts.model.entity.CategoryEntity;
import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.repository.UserRepository;
import de.secondparts.repository.UserRoleRepository;
import de.secondparts.service.BrandService;
import de.secondparts.service.CategoryService;
import de.secondparts.service.OfferService;
import de.secondparts.util.TestDataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OfferControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private TestDataUtils testDataUtils;

    private UserEntity testUser;

    private OfferEntity testOffer;

    private CategoryEntity testCategory;

    @BeforeEach
    void setUp() {

//        testUser = testDataUtils.createTestUser("adminaa");
//        testAdmin = testDataUtils.createTestAdmin("admin@example.com");
//        var testModel =
//                testDataUtils.createTestModel(testDataUtils.createTestBrand());
//
//        testOffer = testDataUtils.createTestOffer(testUser, testModel);
//        testAdminOffer = testDataUtils.createTestOffer(testAdmin, testModel);


    }

    @Test
    void testCreateOffer() throws Exception {
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
                andExpect(status().isOk());

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

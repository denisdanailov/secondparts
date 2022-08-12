package de.secondparts.web;

import de.secondparts.model.entity.dtos.CategoryViewDTO;
import de.secondparts.service.CategoryService;
import de.secondparts.service.ModelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryService categoryService;


    @Test
    void getAllCategories() throws Exception {
        this.mockMvc
                .perform(get("/api/category/all"))
                .andExpect(status().isOk());

    }

}

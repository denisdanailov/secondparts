package de.secondparts.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.secondparts.model.entity.dtos.userDTOs.UserRegistrationDTO;
import de.secondparts.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Mock
    private AuthController authController;

    @Mock
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testUserExistsByEmail() throws Exception {
        when(userService.existsByEmail((String) any())).thenReturn(true);

    }

    @Test
    public void shouldNotAllowAccessToUnauthenticatedUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/auth/signin"))
                .andExpect(status().isMethodNotAllowed());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/auth/signup"))
                .andExpect(status().isMethodNotAllowed());
    }


}

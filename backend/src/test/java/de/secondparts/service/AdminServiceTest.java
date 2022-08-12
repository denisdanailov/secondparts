package de.secondparts.service;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.userDTOs.UserEditDTO;
import de.secondparts.repository.UserRepository;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminServiceTest {

    @Mock
    private AdminService adminService;

    @Mock
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testDeactivateUser() {
        UserEntity user = new UserEntity();
        user.setEmail("test@test.de")
                .setFirstName("testName")
                .setLastName("setTestName")
                .setPassword("topSecreet")
                .setUsername("imfortesthere");

            adminService.deactivateUser(user.getId());
            verify(adminService).deactivateUser(user.getId());
        }




}

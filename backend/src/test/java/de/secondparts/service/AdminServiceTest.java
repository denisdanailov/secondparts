package de.secondparts.service;

import de.secondparts.model.entity.BrandEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.userDTOs.UserEditDTO;
import de.secondparts.repository.BrandRepository;
import de.secondparts.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
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
    void testUserEdit() {
        UserEditDTO userEditDTO = new UserEditDTO();
        userEditDTO.setEmail("test@test.de")
                .setFirstName("testName")
                .setLastName("setTestName")
                .setPassword("topSecreet")
                .setUsername("imfortesthere");

//        TODO: impl logic..
    }
}

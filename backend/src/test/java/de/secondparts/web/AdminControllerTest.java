package de.secondparts.web;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.entity.dtos.userDTOs.UserViewDTO;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.repository.UserRepository;
import de.secondparts.repository.UserRoleRepository;
import de.secondparts.service.AdminService;
import de.secondparts.service.UserService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    public static final Long TEST_ADMIN_ID= 13L;
    public static final String TEST_ADMIN_EMAIL="admin@admina.com";
    private static final String TEST_ADMIN_PASSWORD = "123456";
    private static final String TEST_ADMIN_FIRST_NAME = "Test";
    private static final String TEST_ADMIN_LAST_NAME = "Test";
    private static final String TEST_ADMIN_USERNAME = "imadmin";

    @Autowired
    private AdminPanelController adminPanelController;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;



    @Test
    @WithMockUser(value = TEST_ADMIN_USERNAME)
    void testGetAllUsers() throws Exception {

        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/users/all");
    }


    @Test
    @WithMockUser(value = TEST_ADMIN_USERNAME)
    void testGetUsersDetails() throws Exception {

//        Not authorizated..

        Long id = 13L;
        this.mockMvc
                .perform(get("/api/users/"+id))
                .andExpect(status().is4xxClientError());
    }


    @Test
    void testCreateUser() throws Exception {

//        Not authorizated..

        this.mockMvc
                .perform(post("/api/users/create"))
                .andExpect(status().is4xxClientError());

    }


    private UserEntity getTestAdmin() {

        UserRoleEntity roleUser = this.roleRepository.save(new UserRoleEntity().setName(UserRoleEnum.ROLE_ADMIN));

        UserEntity testUser =  new UserEntity()
                .setFirstName(TEST_ADMIN_FIRST_NAME)
                .setLastName(TEST_ADMIN_LAST_NAME)
                .setUsername(TEST_ADMIN_USERNAME)
                .setRoles(Set.of(roleUser))
                .setEmail(TEST_ADMIN_EMAIL)
                .setPassword(passwordEncoder.encode(TEST_ADMIN_PASSWORD));
        UserEntity savedUser = this.userRepository.save(testUser);
        return savedUser;
    }


}



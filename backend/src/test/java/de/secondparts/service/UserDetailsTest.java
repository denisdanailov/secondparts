package de.secondparts.service;


import de.secondparts.service.impl.UserDetailsImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserDetailsTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserDetailsImpl userDetails;


    @Test
    void testReturnId() {
        when(userDetails.getId()).thenReturn(1L);
    }

    @Test
    void testReturnEmail() {
        when(userDetails.getEmail()).thenReturn("example@gmx.de");
    }

    @Test
    void testReturnUsername() {
        when(userDetails.getUsername()).thenReturn("username");
    }

    @Test
    void testReturnPassword() {
        when(userDetails.getPassword()).thenReturn("topsecreet");
    }


}

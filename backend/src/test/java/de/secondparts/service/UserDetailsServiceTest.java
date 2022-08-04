package de.secondparts.service;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.repository.UserRepository;
import de.secondparts.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDetailsServiceTest {

    private UserDetailsService toTest;

    @Mock
    private UserRepository mockUserRepo;

    @BeforeEach
    void setUp() {
        toTest = new UserDetailsServiceImpl(mockUserRepo);
    }

    @Test
    void  loadUserByUsername_UserExists() {
        UserEntity testUserEntity =
                new UserEntity()
                        .setUsername("userTest")
                        .setFirstName("Peter")
                        .setLastName("Petrov")
                        .setEmail("test@test.de")
                        .setImageUrl("http://test.png")
                        .setRoles(
                                Set.of(
                                        new UserRoleEntity().setName(UserRoleEnum.ROLE_ADMIN),
                                        new UserRoleEntity().setName(UserRoleEnum.ROLE_USER)

                                ))
                        .setPassword("topsecreet")
                        .setActive(true);

            when(mockUserRepo.findByUsername(testUserEntity.getUsername())).thenReturn(Optional.of(testUserEntity));
//            act
            UserDetails userDetails =
            toTest.loadUserByUsername(testUserEntity.getUsername());

//            assert
        Assertions.assertEquals(testUserEntity.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getPassword(), userDetails.getPassword());
        Assertions.assertTrue(userDetails.isAccountNonExpired());
        Assertions.assertTrue(userDetails.isAccountNonLocked());
        Assertions.assertTrue(userDetails.isCredentialsNonExpired());
        Assertions.assertTrue(userDetails.isEnabled());

    }

    @Test
    void loadUserByUsername_UserDoesNotExist() {

        Assertions.assertThrows(UsernameNotFoundException.class, () -> toTest.loadUserByUsername("not-exist"));

    }
}

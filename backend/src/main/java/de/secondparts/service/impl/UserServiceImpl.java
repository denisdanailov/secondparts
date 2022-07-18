package de.secondparts.service.impl;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.model.entity.dtos.UserRegistrationDTO;
import de.secondparts.repository.UserRepository;
import de.secondparts.repository.UserRoleRepository;
import de.secondparts.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository roleRepository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void register(UserRegistrationDTO userRegistrationDTO) {

        // Create new user's account
        UserEntity user = new UserEntity(userRegistrationDTO.getUsername(),
                userRegistrationDTO.getEmail(),
                encoder.encode(userRegistrationDTO.getPassword()));

        user
                .setFirstName(userRegistrationDTO.getFirstName())
                .setLastName(userRegistrationDTO.getLastName());

        Set<UserRoleEntity> roles = new HashSet<>();
        UserRoleEntity userRole = roleRepository.findByName(UserRoleEnum.ROLE_USER);
        UserRoleEntity adminRole = roleRepository.findByName(UserRoleEnum.ROLE_ADMIN);

//      First registered user is admin
        if (userRepository.count() == 0) {
            roles.add(userRole);
            roles.add(adminRole);
            user.setRoles(roles);
            userRepository.save(user);
        }

        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);


    }

    @Override
    public void initializeRoles() {
        if (roleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setName(UserRoleEnum.ROLE_ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setName(UserRoleEnum.ROLE_USER);

            roleRepository.saveAll(List.of(adminRole, userRole));
        }
    }
}

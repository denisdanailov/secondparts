package de.secondparts.service.impl;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.entity.dtos.UserEditDTO;
import de.secondparts.model.entity.dtos.UserViewDTO;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.model.entity.dtos.UserRegistrationDTO;
import de.secondparts.repository.UserRepository;
import de.secondparts.repository.UserRoleRepository;
import de.secondparts.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository roleRepository, PasswordEncoder encoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserViewDTO> getAll() {
        return userRepository.findAll().stream().map(this::mapUser).collect(Collectors.toList());
    }

    @Override
    public void register(UserRegistrationDTO userRegistrationDTO) {

        // Create new user's account
        UserEntity user = new UserEntity(userRegistrationDTO.getUsername(),
                userRegistrationDTO.getEmail(),
                encoder.encode(userRegistrationDTO.getPassword()));

        user
                .setFirstName(userRegistrationDTO.getFirstName())
                .setLastName(userRegistrationDTO.getLastName())
                .setImageUrl(userRegistrationDTO.getImageUrl());

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

    @Override
    public Optional<UserViewDTO> findById(Long id) {
        return userRepository.findById(id).map(userEntity -> {
            UserViewDTO user = modelMapper.map(userEntity, UserViewDTO.class);

            return user;
        });
    }

    @Override
    public Optional<UserViewDTO> findByUsername(String username) {
        Optional<UserViewDTO> userByUsername = userRepository.findByUsername(username).map(this::mapUser);

        return userByUsername;
    }

    @Override
    public Optional<UserViewDTO> findByEmail(String email) {
        Optional<UserViewDTO> userByEmail = userRepository.findByEmail(email).map(this::mapUser);

        return userByEmail;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }

    @Override
    public void editUser(Long id, UserEditDTO userEditDTO) {
//        TODO: Check return type void, UserEditDTO, or Boolean ?

        UserEntity user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setFirstName(userEditDTO.getFirstName());
            user.setLastName(userEditDTO.getLastName());
            user.setUsername(userEditDTO.getUsername());
            user.setEmail(userEditDTO.getEmail());
            user.setPassword(user.getPassword());
            user.setImageUrl(userEditDTO.getImageUrl());

        }
        userRepository.save(user);
    }

    @Override
    public UserEntity findUserToEdit(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    private UserViewDTO mapUser(UserEntity userEntity) {
        UserViewDTO userViewDTO = this.modelMapper.map(userEntity, UserViewDTO.class);

        return userViewDTO;
    }
}

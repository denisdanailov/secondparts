package de.secondparts.service;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.userDTOs.UserRegistrationDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void initializeRoles();

    void register(UserRegistrationDTO userRegistrationDTO);

    List<UserEntity> getAllActiveUsers();

    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

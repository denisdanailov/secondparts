package de.secondparts.service;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.UserEditDTO;
import de.secondparts.model.entity.dtos.UserRegistrationDTO;
import de.secondparts.model.entity.dtos.UserViewDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void initializeRoles();

    void register(UserRegistrationDTO userRegistrationDTO);

    List<UserViewDTO> getAll();

    Optional<UserViewDTO> findById(Long id);

    Optional<UserViewDTO> findByUsername(String username);

    Optional<UserViewDTO> findByEmail(String email);

    void deleteUser(Long id);

    void editUser(Long id, UserEditDTO userEditDTO);

    UserEntity findUserToEdit(Long id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

package de.secondparts.service;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.UserRegistrationDTO;
import de.secondparts.model.entity.dtos.UserViewDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserViewDTO> getAll();

    void register(UserRegistrationDTO userRegistrationDTO);

    void initializeRoles();

    Optional<UserViewDTO> findById(Long id);

    void deleteUser(Long id);

    void editUser(Long id);
}

package de.secondparts.service;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.UserRegistrationDTO;
import de.secondparts.model.entity.dtos.UserViewDTO;

import java.util.List;

public interface UserService {

    List<UserViewDTO> getAll();

    void register(UserRegistrationDTO userRegistrationDTO);

    void initializeRoles();
}

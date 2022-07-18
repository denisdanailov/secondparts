package de.secondparts.service;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.UserRegistrationDTO;

import java.util.List;

public interface UserService {

    List<UserEntity> getAll();

    void register(UserRegistrationDTO userRegistrationDTO);

    void initializeRoles();
}

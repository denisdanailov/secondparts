package de.secondparts.service;

import de.secondparts.model.entity.dtos.userDTOs.UserEditDTO;



public interface AdminService {

    void initializeAdmin();

    void deactivateUser(Long id);

    void editUser(Long id, UserEditDTO userEditDTO);
}

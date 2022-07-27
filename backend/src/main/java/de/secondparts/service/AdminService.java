package de.secondparts.service;

import de.secondparts.model.entity.dtos.UserEditDTO;



public interface AdminService {

    void deleteUser(Long id);

    void editUser(Long id, UserEditDTO userEditDTO);
}

package de.secondparts.service.impl;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.UserEditDTO;
import de.secondparts.repository.UserRepository;
import de.secondparts.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}

package de.secondparts.service.impl;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.repository.UserRepository;
import de.secondparts.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}

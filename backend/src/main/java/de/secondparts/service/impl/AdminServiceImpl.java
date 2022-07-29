package de.secondparts.service.impl;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.entity.dtos.userDTOs.UserEditDTO;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.repository.UserRepository;
import de.secondparts.repository.UserRoleRepository;
import de.secondparts.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    public AdminServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void initializeAdmin() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            UserEntity admin = new UserEntity();
            UserRoleEntity adminRole = userRoleRepository.findByName(UserRoleEnum.ROLE_ADMIN);
            UserRoleEntity userRole = userRoleRepository.findByName(UserRoleEnum.ROLE_USER);

            admin
                    .setUsername("admin")
                    .setEmail("admin@admin.de")
                    .setFirstName("Admin")
                    .setLastName("Adminov")
                    .setPassword("$2a$10$uuZr1X5A/xwnDqGfVn0wS.TYek3EIGnLQnHoWGTvsJp8AEe/YSoQS")
                    .setActive(true)
                    .setRoles(Set.of(adminRole, userRole));

            userRepository.save(admin);
        }
    }

    @Override
    public void deactivateUser(Long id) {
//   We deactivate the user, then a Scheduling functionality delete a deactivated users.
        Optional<UserEntity> userToDelete = userRepository.findById(id);

        if (userToDelete.isPresent()) {
            userToDelete.get().setActive(false);

            userRepository.save(userToDelete.get());
        }
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

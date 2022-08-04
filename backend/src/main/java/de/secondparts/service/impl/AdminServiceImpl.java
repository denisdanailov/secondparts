package de.secondparts.service.impl;

import de.secondparts.model.entity.OfferEntity;
import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.UserRoleEntity;
import de.secondparts.model.entity.dtos.userDTOs.UserEditDTO;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.repository.OfferRepository;
import de.secondparts.repository.UserRepository;
import de.secondparts.repository.UserRoleRepository;
import de.secondparts.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final OfferRepository offerRepository;

    public AdminServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, OfferRepository offerRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.offerRepository = offerRepository;
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

            List<OfferEntity> userOffers = offerRepository.findAllBySeller(userToDelete.get());

            if (userOffers.size() > 0) {
                List<OfferEntity> deactivateOffers = userOffers.stream().map(offerEntity -> {
                    return offerEntity.setActive(false);

                }).collect(Collectors.toList());

                offerRepository.saveAll(deactivateOffers);

                userRepository.save(userToDelete.get());
            }

//            offerRepository.clearRemovedOffers();
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

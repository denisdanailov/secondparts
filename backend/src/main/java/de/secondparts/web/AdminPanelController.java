package de.secondparts.web;

import de.secondparts.model.entity.UserEntity;
import de.secondparts.model.entity.dtos.userDTOs.UserEditDTO;
import de.secondparts.model.entity.dtos.userDTOs.UserRegistrationDTO;
import de.secondparts.model.entity.dtos.userDTOs.UserViewDTO;
import de.secondparts.payment.response.MessageResponse;
import de.secondparts.service.AdminService;
import de.secondparts.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class AdminPanelController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final AdminService adminService;

    public AdminPanelController(UserService userService, ModelMapper modelMapper, AdminService adminService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.adminService = adminService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<UserViewDTO>> getAllActiveUsers() {

        try {
            List<UserViewDTO> users = userService.getAllActiveUsers().stream().map(userEntity -> {
                UserViewDTO userDTO = modelMapper.map(userEntity, UserViewDTO.class);
                return userDTO;
            }).collect(Collectors.toList());

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserViewDTO> getUserDetails(@PathVariable("id") Long id ) {

        Optional<UserViewDTO> user = userService.findById(id).map(userEntity -> {

            UserViewDTO userDTO = modelMapper.map(userEntity, UserViewDTO.class);
            return userDTO;
        });

        return user.map(userViewDTO
                -> new ResponseEntity<>(userViewDTO, HttpStatus.OK)).orElseGet(()
                -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<MessageResponse> createUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {

        if (userService.existsByUsername(userRegistrationDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(userRegistrationDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        userService.register(userRegistrationDTO);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserViewDTO> deactivateUser(@PathVariable("id") Long id) {

        try {
            adminService.deactivateUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserViewDTO> editUser(@Valid @PathVariable("id") Long id, @RequestBody UserViewDTO userViewDTO ) {

        UserEntity userToEdit = userService.findById(id).orElse(null);
        UserEditDTO editedUser = new UserEditDTO();

        if (userToEdit != null) {
            editedUser.setFirstName(userViewDTO.getFirstName());
            editedUser.setLastName(userViewDTO.getLastName());

//          Check if Username is not exists in DataBase, because usernames is unique.
            if (!userToEdit.getUsername().equals(userViewDTO.getUsername())) {
                Optional<UserViewDTO> byUsername = userService.findByUsername(userViewDTO.getUsername()).map(userEntity -> {
                    return this.modelMapper.map(userEntity, UserViewDTO.class);
                });

                if (byUsername.isPresent()) {
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }
            }
            editedUser.setUsername(userViewDTO.getUsername());

//          Check if Email is not exists in DataBase, because Email is unique.
            if (!userToEdit.getEmail().equals(userViewDTO.getEmail())) {
                Optional<UserViewDTO> byEmail = userService.findByEmail(userViewDTO.getEmail()).map(userEntity -> {
                    return this.modelMapper.map(userEntity, UserViewDTO.class);
                });

                if (byEmail.isPresent()) {
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
                }
            }
            editedUser.setEmail(userViewDTO.getEmail());

//          set Password by Default, because Admin cannot edit a users passwords.
            editedUser.setPassword(userViewDTO.getPassword());

            editedUser.setImageUrl(userViewDTO.getImageUrl());
        }
        adminService.editUser(id, editedUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}

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
    public ResponseEntity<MessageResponse> editUser(@Valid @PathVariable("id") Long id, @RequestBody UserEditDTO userEditDTO ) {

        UserEntity userToEdit = userService.findById(id).orElse(null);
        UserEditDTO editedUser = new UserEditDTO();

        System.out.println(userEditDTO);

        if (userToEdit != null) {
            editedUser.setFirstName(userEditDTO.getFirstName());
            editedUser.setLastName(userEditDTO.getLastName());

//          Check if Username is not exists in DataBase, because usernames is unique.
            if (userService.existsByUsername(userEditDTO.getUsername()) &&
                    !userToEdit.getUsername().equals(userEditDTO.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }
            editedUser.setUsername(userEditDTO.getUsername());

//          Check if Email is not exists in DataBase, because Email is unique.
            if (userService.existsByEmail(userEditDTO.getEmail()) &&
                    !userToEdit.getEmail().equals(userEditDTO.getEmail())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Email is already in use!"));
            }
            editedUser.setEmail(userEditDTO.getEmail());

//          set Password by Default, because Admin cannot edit a users passwords.
            editedUser.setPassword(userEditDTO.getPassword());

            editedUser.setImageUrl(userEditDTO.getImageUrl());
        } else {
            return ResponseEntity.ok(new MessageResponse("User not exists!"));
        }

        adminService.editUser(id, editedUser);
        return ResponseEntity.ok(new MessageResponse("User edited successfully!"));
    }


}

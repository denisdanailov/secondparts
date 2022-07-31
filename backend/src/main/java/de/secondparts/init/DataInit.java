package de.secondparts.init;

import de.secondparts.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {

    private final UserService userService;
    private final AdminService adminService;

    public DataInit(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.initializeRoles();
        adminService.initializeAdmin();
    }
}

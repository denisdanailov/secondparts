package de.secondparts.util;

import de.secondparts.model.entity.*;
import de.secondparts.model.enums.EngineEnum;
import de.secondparts.model.enums.TransmissionEnum;
import de.secondparts.model.enums.UserRoleEnum;
import de.secondparts.repository.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Component
public class TestDataUtils {

    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    private OfferRepository offerRepository;

    private ModelRepository modelRepository;

    private CategoryRepository categoryRepository;

    private BrandRepository brandRepository;

    public TestDataUtils(UserRepository userRepository, UserRoleRepository userRoleRepository, OfferRepository offerRepository, ModelRepository modelRepository, CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            UserRoleEntity adminRole = new UserRoleEntity();
            adminRole.setName(UserRoleEnum.ROLE_ADMIN);

            UserRoleEntity userRole = new UserRoleEntity();
            userRole.setName(UserRoleEnum.ROLE_USER);

            userRoleRepository.saveAllAndFlush(List.of(adminRole, userRole));
        }
    }

    public UserEntity createTestAdmin(String username) {

        initRoles();

        UserRoleEntity adminRole = new UserRoleEntity().setName(UserRoleEnum.ROLE_ADMIN);
        UserRoleEntity userRole = new UserRoleEntity().setName(UserRoleEnum.ROLE_USER);



        var admin = new UserEntity()
                .setUsername(username)
                .setPassword("asdasd")
                .setFirstName("Adminkov")
                .setLastName("Petrov")
                .setEmail("admina@admina.de")
                .setActive(true)
                .setRoles(Set.of(adminRole, userRole));

        return userRepository.save(admin);
    }


    public UserEntity createTestUser(String username) {
//
//
//        initRoles();
//        UserRoleEntity userRole = new UserRoleEntity().setName(UserRoleEnum.ROLE_USER);

        var user = new UserEntity()
                .setUsername(username)
                .setFirstName("Userkov")
                .setLastName("Petrov")
                .setPassword("asdasd")
                .setEmail("admina@admina.de")
                .setActive(true);

        return userRepository.save(user);
    }

    public OfferEntity createTestOffer(UserEntity seller, ModelEntity model, CategoryEntity category) {
        initRoles();

        var offer = new OfferEntity()
                .setActive(true)
                .setEngine(EngineEnum.GASOLINE)
                .setPrice(BigDecimal.TEN)
                .setTransmission(TransmissionEnum.MANUAL)
                .setKilometers(123123)
                .setSeller(seller)
                .setModel(model)
                .setCategory(category)
                .setVehicleIdentificationNumber("12313212")
                .setYear(2019)
                .setDescription("13123121");


            return offerRepository.save(offer);
    }

    public CategoryEntity createTestCategory() {

        initRoles();
        CategoryEntity category = new CategoryEntity().setName("brakesystem").setImageUrl("img");

        return categoryRepository.save(category);
    }

    public BrandEntity createTestBrand() {
        var brandEntity = new BrandEntity().setName("Ford");

      return   brandRepository.save(brandEntity);
    }


    public ModelEntity createTestModel(BrandEntity brandEntity) {
        initRoles();
        ModelEntity model = new ModelEntity()
                .setName("Fiesta")
                .setBrand(brandEntity)
                .setStartYear(2019L)
                .setEndYear(2020L);

        return modelRepository.save(model);
    }


    public void cleanUpDatabase() {
        offerRepository.deleteAll();
        userRepository.deleteAll();
        userRoleRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();


    }
}

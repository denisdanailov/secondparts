package de.secondparts.chedules;

import de.secondparts.service.OfferService;
import de.secondparts.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CronDatabaseCleanup {

    private static final Logger LOGGER = LoggerFactory.getLogger(CronDatabaseCleanup.class);

    private final OfferService offerService;
    private final UserService userService;

    public CronDatabaseCleanup(OfferService offerService, UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @Scheduled(fixedDelay = 5000, initialDelay = 10000)
    public void showTimeWithCron() {

//        offerService.clearRemovedOffers();
//        userService.clearRemovedUsers();

        LOGGER.info("Database cleared successfully at {}", LocalDateTime.now());
    }
}

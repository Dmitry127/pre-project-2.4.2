package ru.dmitrys.web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.dmitrys.web.model.User;
import ru.dmitrys.web.service.UserService;

@Component
public class PopulateDb {

    private final UserService userService;

    @Autowired
    public PopulateDb(UserService userService) {
        this.userService = userService;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent() {
        boolean isDone = false;
        if (!isDone) {
            User admin = new User("admin", "admin", "admin",
                    "admin", "admin@mail.ru", null);
            userService.saveUser(admin, "ADMIN");

            User user = new User("user", "user", "user",
                    "user", "user@mail.ru", null);
            userService.saveUser(user, "USER");
            isDone = true;
        }
    }
}
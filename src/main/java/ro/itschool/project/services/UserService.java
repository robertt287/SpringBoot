package ro.itschool.project.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.User;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final EmailService emailService;
    private final Map<Long, User> users = new HashMap<>();

    public User createUser(User user) {

        long userId = users.size() + 1L;
        user.setId(userId);

        users.put(user.getId(), user);

        emailService.sendAccountCreationConfirmation(user);

        log.info("User with id {} has been created.", userId);

        return user;
    }
}

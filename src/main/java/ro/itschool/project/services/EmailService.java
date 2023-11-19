package ro.itschool.project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.User;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendAccountCreationConfirmation(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmailAddress());
        mailMessage.setSubject("Account created successfully");
        mailMessage.setText(String.format(new StringBuilder().append("Hello %s,\n")
                .append("\n")
                .append("Your account has been created successfully.\n")
                .append("\n")
                .append("Thank you,\n")
                .append("User App Team").toString(), user.getFirstName()));

        javaMailSender.send(mailMessage);
    }
}

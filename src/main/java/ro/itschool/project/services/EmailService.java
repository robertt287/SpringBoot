package ro.itschool.project.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.entities.Client;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    public void sendAccountCreationConfirmation(Client client) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(client.getEmailAddress());
        mailMessage.setSubject("Account created successfully");
        mailMessage.setText(String.format(new StringBuilder().append("Hello %s,\n")
                .append("\n")
                .append("Your account has been created successfully.\n")
                .append("\n")
                .append("Thank you,\n")
                .append("User App Team").toString(), client.getFirstName()));

        javaMailSender.send(mailMessage);
    }
}

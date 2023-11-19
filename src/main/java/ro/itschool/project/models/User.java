package ro.itschool.project.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.ZoneOffset.UTC;

@Data
public class User {
    private long id;
    @NotNull(message = "First name must not be null.")
    @Size(min = 2, message = "First name must be at least 2 characters long.")
    private String firstName;
    @NotNull(message = "Last name must not be null.")
    @Size(min = 2, message = "Last name must be at least 2 characters long.")
    private String lastName;
    @NotNull(message = "Email address must not be null.")
    @Pattern(regexp = ".+@.+\\..+", message = "Email address must be valid.")
    private String emailAddress;
    private LocalDateTime creationDate = LocalDateTime.now(ZoneId.of(UTC.getId()));

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress.trim();
    }
}

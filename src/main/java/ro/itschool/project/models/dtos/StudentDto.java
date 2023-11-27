package ro.itschool.project.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private Long id;
    @NotNull(message = "First name must not be null.")
    @Size(min = 2, message = "First name must be at least 2 characters long.")
    private String firstName;
    @NotNull(message = "Last name must not be null.")
    @Size(min = 2, message = "Last name must be at least 2 characters long.")
    private String lastName;
    @NotNull(message = "Email address must not be null.")
    @Pattern(regexp = ".+@.+\\..+", message = "Email address must be valid.")
    private String email;
}

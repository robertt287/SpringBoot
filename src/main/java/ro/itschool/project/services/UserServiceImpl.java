package ro.itschool.project.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.dtos.UserDTO;
import ro.itschool.project.models.entities.User;
import ro.itschool.project.repositories.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //validate DTO
        //convert DTO to entity
        //save entity to database
        //convert entity to DTO

        //validation
        if (userDTO.getFirstName().length() < 3) {
            throw new IllegalArgumentException("Invalid first name.");
        }

        //conversion to entity
        User userEntity = new User();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userEntity.getEmail());

        //save entity to database
        User savedUser = userRepository.save(userEntity);
        log.info("user {} was saved.", savedUser.getFirstName());

        //conversion to DTO
        UserDTO userResponseDTO = new UserDTO();
        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setFirstName(savedUser.getFirstName());
        userResponseDTO.setLastName(savedUser.getLastName());
        userResponseDTO.setEmail(savedUser.getEmail());

        return userResponseDTO;
    }
}

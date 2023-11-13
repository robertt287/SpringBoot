package ro.itschool.project.services;

import org.springframework.stereotype.Service;

@Service
public interface WeatherValidatorService {

    void validateCity(String city);
}

package ro.itschool.project.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.itschool.project.models.dtos.StudentDto;
import ro.itschool.project.models.entities.Student;
import ro.itschool.project.repositories.StudentRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    private static StudentDto entityToDto(Student entity) {
        return StudentDto.builder().email(entity.getEmail()).firstName(entity.getFirstName()).id(entity.getId()).lastName(entity.getLastName()).build();
    }

    private static Student dtoToEntity(StudentDto dto) {
        return Student.builder().firstName(dto.getFirstName()).lastName(dto.getLastName()).email(dto.getEmail()).build();
    }

    public StudentDto create(StudentDto dto) {

        Student entity = dtoToEntity(dto);

        entity = repository.save(entity);
        log.info("Student {} was saved", entity.getFirstName());

        return entityToDto(entity);
    }

    public StudentDto read(Long id) {
        return entityToDto(repository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public StudentDto update(StudentDto dto) {

        Student entity = repository.findById(dto.getId()).orElseThrow(EntityNotFoundException::new);

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setId(dto.getId());

        entity = repository.save(entity);
        log.info("Student {} was saved", entity.getFirstName());

        return entityToDto(entity);
    }


    public void delete (Long id){
        repository.deleteById(id);
    }
}

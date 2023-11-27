package ro.itschool.project.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.project.models.dtos.StudentDto;
import ro.itschool.project.services.StudentService;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(studentService.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> read(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.read(id));
    }

    @PutMapping
    public ResponseEntity<StudentDto> update(@RequestBody StudentDto dto) {
        return ResponseEntity.ok(studentService.update(dto));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        studentService.delete(id);
        return "Deleted successfully.";
    }
}

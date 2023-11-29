package ro.itschool.project.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "student_room")
public class StudentRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
    @Column(name = "description")
    private String description;
    @Column(name = "bed_number")
    private Integer bedNumber;

    @OneToMany(mappedBy = "studentRoom", fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();
}

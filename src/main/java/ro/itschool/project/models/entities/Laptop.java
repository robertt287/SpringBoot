package ro.itschool.project.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "hard_drive_capacity")
    private String hardDriveCapacity;
    @Column(name = "display")
    private Double display;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}

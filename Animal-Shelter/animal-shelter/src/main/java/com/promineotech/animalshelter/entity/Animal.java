package com.promineotech.animalshelter.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animalId;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Species is required")
    private String species;

    private String breed;

    @Positive(message = "Age must be a positive number")
    private Integer age;

    private String gender;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private AnimalStatus status;

    @NotNull(message = "Intake date is required")
    private LocalDate intakeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Adoption> adoptions;

    public enum AnimalStatus {
        AVAILABLE, ADOPTED, PENDING, UNDER_TREATMENT
    }
}

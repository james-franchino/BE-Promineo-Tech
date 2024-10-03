package com.promineotech.animalshelter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Entity representing an Animal in the shelter system.
 */
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

    /**
     * Represents the shelter where the animal is housed.
     * Many animals can belong to one shelter.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    @JsonBackReference
    private Shelter shelter;

    /**
     * Represents the adoptions associated with this animal.
     * One animal can have multiple adoption records.
     */
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Adoption> adoptions;

    /**
     * Enum representing the possible statuses of an animal.
     */
    public enum AnimalStatus {
        AVAILABLE, ADOPTED, PENDING, UNDER_TREATMENT
    }
}

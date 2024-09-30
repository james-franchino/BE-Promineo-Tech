package com.promineotech.animalshelter.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adoptions")
public class Adoption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adoptionId;

    @NotNull(message = "Adopter is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adopter_id", nullable = false)
    @JsonBackReference
    private Adopter adopter;

    @NotNull(message = "Animal is required")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id", nullable = false)
    @JsonBackReference
    private Animal animal;

    @NotNull(message = "Adoption date is required")
    @Column(name = "adoption_date")
    private LocalDate adoptionDate;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private AdoptionStatus status;

    public enum AdoptionStatus {
        PENDING, COMPLETED, CANCELLED
    }
}
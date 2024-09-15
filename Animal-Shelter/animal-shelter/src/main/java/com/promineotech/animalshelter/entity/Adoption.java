package com.promineotech.animalshelter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

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

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adopter_id")
    private Adopter adopter;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @NotNull
    @Column(name = "adoption_date")
    private LocalDate adoptionDate;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AdoptionStatus status;

    public enum AdoptionStatus {
        PENDING, COMPLETED, CANCELLED
    }
}
package com.promineotech.animalshelter.entity;

import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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

    @NotNull
    private String name;

    private String species;
    private String breed;
    private Integer age;
    private String gender;

    @Enumerated(EnumType.STRING)
    private AnimalStatus status;

    @Column(name = "intake_date")
    private LocalDate intakeDate;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adoption> adoptions;

    public enum AnimalStatus {
        AVAILABLE, ADOPTED, PENDING, UNDER_TREATMENT
    }
}

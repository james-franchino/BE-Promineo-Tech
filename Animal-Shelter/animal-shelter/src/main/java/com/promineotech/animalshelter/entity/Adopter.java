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
@Table(name = "adopters")
public class Adopter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adopterId;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "adopter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adoption> adoptions;
}

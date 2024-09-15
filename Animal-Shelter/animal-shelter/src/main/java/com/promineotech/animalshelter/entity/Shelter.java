package com.promineotech.animalshelter.entity;

import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shelters")
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shelterId;

    @NotNull
    @Column(name = "shelter_name")
    private String shelterName;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String email;

    private Integer capacity;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animals;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Staff> staff;
}

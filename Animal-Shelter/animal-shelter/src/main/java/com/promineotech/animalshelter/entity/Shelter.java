package com.promineotech.animalshelter.entity;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
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

    @ToString.Exclude
    @OneToMany(mappedBy = "shelter")
    private List<Animal> animals;

    @ToString.Exclude
    @OneToMany(mappedBy = "shelter")
    private List<Staff> staff;
}

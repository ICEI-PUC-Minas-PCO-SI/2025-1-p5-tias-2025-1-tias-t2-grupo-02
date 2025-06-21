package com.tias.back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private UUID patientId;

    private String name;
    
    @Column(unique = true)
    private String cpf;
    
    private LocalDate birthdate;

    private String address;

    private String condition;

    private boolean isActive;
}

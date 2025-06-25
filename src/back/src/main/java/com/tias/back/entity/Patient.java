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
    
    @Column(unique = true)
    private String rg;

    private LocalDate birthdate;

    private String cep;

    private String bloodType;

    private String plano;

    private String carteirinha;
    
    private String conditions;

    private String contactName;

    private String contactEmail;

    private String contactPhone;

    private String contactRelation;

    private boolean isActive;

    private LocalDate addedAt;
}

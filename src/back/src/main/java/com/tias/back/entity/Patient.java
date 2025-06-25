package com.tias.back.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String bloodType;

    private String plano;

    private String carteirinha;

    private String conditions;

    private boolean isActive;

    private LocalDate addedAt;
}

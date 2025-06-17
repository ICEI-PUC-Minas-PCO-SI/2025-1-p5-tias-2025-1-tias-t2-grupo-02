package com.tias.back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private Integer cpf;
    
    private LocalDate birthday;

    private String address;

    private String condition;

    private LocalDateTime createdAt;

    private LocalDateTime editedAt;

    private LocalDateTime deactivatedAt;
}

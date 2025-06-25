package com.tias.back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "documentation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documentation {

    @Id
    @GeneratedValue
    private UUID id;

    private String description;

    private String location;

    private LocalDateTime addedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", referencedColumnName = "patientId", nullable = false)
    private Patient patient;
}

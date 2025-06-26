package com.tias.back.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import com.tias.back.entity.MedicationStatus;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MedicationResponseDTO {
    private UUID id;
    private UUID patientId;
    private String description;
    private String dosage;
    private Long quantity;
    private LocalDate expirationDate;
    private MedicationStatus status;
    private String addedAt;
}

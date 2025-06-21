package com.tias.back.dto;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MedicationResponseDTO {
    private UUID id;
    private UUID patientId;
    private String description;
    private String dosage;
    private String addedAt;
}

package com.tias.back.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicationDTO {
    private UUID id;
    private UUID patientId;
    private String description;
    private String posologia;
    private LocalDateTime addedAt;
}

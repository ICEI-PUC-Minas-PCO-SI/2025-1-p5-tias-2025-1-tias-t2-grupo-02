package com.tias.back.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MedicationRequestDTO {
    @NotNull(message = "PatientId é obrigatório")
    private java.util.UUID patientId;

    @NotBlank(message = "Description é obrigatório")
    private String description;

    @NotBlank(message = "Dosage é obrigatório")
    private String dosage;
}

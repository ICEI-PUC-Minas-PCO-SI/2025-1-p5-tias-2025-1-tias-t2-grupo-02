package com.tias.back.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class MedicationRequestDTO {
    @NotNull(message = "PatientId é obrigatório")
    private java.util.UUID patientId;

    @NotBlank(message = "Descrição é obrigatório")
    private String description;

    @NotBlank(message = "Posologia é obrigatório")
    private String dosage;

    @NotBlank(message = "Quantidade é obrigatório")
    private Long quantity;

    @NotBlank(message = "Validade é obrigatório")
    private LocalDate expirationDate;

    
}

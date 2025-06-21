package com.tias.back.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class DocumentationRequestDTO {
    @NotNull(message = "PatientId é obrigatório")
    private java.util.UUID patientId;

    @NotBlank(message = "Description é obrigatório")
    private String description;

    @NotBlank(message = "Location é obrigatório")
    private String location;
}

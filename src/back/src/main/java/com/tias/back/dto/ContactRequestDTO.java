package com.tias.back.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ContactRequestDTO {
    @NotNull(message = "PatientId é obrigatório")
    private java.util.UUID patientId;

    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ú ]+$", message = "Nome deve conter apenas letras e espaços")
    private String name;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;

    @NotBlank(message = "Phone é obrigatório")
    @Pattern(regexp = "^\\d{10,11}$", message = "Phone deve conter 10 ou 11 dígitos numéricos")
    private String phone;

    @NotBlank(message = "Relation é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ú ]+$", message = "Relation deve conter apenas letras e espaços")
    private String relation;
}

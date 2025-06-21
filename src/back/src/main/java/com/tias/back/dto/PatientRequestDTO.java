package com.tias.back.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class PatientRequestDTO {
    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ú ]+$", message = "Nome deve conter apenas letras e espaços")
    private String name;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "^\\d{11}$", message = "CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;

    @NotBlank(message = "Birthdate é obrigatório")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Birthdate deve usar o formato YYYY-MM-DD")
    private LocalDate birthdate;

    @NotBlank(message = "Endereço é obrigatório")
    private String address;

    @NotBlank(message = "Condição é obrigatória")
    private String condition;
}

package com.tias.back.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class PatientRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ú ]+$",
             message = "Nome deve conter apenas letras e espaços")
    private String name;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "^\\d{11}$",
             message = "CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;

    @NotBlank(message = "RG é obrigatório")
    @Pattern(regexp = "^\\d{7,14}$",
             message = "RG deve conter apenas dígitos (7 a 14 caracteres)")
    private String rg;

    @NotNull(message = "Birthdate é obrigatório")
    @PastOrPresent(message = "Birthdate não pode ser uma data futura")
    private LocalDate birthdate;

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$",
             message = "CEP inválido: use XXXXX-XXX ou XXXXXXXX")
    private String cep;

    @NotBlank(message = "Endereço é obrigatório")
    private String address;

    @NotBlank(message = "Blood type é obrigatório")
    @Pattern(regexp = "^(A|B|AB|O)[+-]$",
             message = "bloodType inválido: use A+, A-, B+, B-, AB+, AB-, O+ ou O-")
    private String bloodType;

    @NotBlank(message = "Plano é obrigatório")
    private String plano;

    @NotBlank(message = "Carteirinha é obrigatória")
    private String carteirinha;

    @NotBlank(message = "Conditions é obrigatório")
    private String conditions;
}

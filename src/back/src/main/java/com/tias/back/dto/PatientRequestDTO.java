package com.tias.back.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotBlank(message = "Nome do contato de emergência é obrigatório")
    private String contatoEmergenciaNome;

    @NotBlank(message = "Parentesco é obrigatório")
    private String contatoEmergenciaParentesco;

    @NotBlank(message = "Telefone do contato de emergência é obrigatório")
    private String contatoEmergenciaTelefone;

    private String contatoEmergenciaEmail;

    private String photoBase64;

}


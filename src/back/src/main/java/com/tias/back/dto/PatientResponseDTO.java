package com.tias.back.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class PatientResponseDTO {
    private UUID patientId;
    private String name;
    private String cpf;
    private String rg;
    private LocalDate birthdate;
    private String cep;
    private String bloodType;
    private String plano;
    private String carteirinha;
    private String conditions;
    private String contactName;
    private String contactEmail;
    private String contactPhone;
    private String contactRelation;
    private boolean isActive;
    private LocalDate addedAt;
}

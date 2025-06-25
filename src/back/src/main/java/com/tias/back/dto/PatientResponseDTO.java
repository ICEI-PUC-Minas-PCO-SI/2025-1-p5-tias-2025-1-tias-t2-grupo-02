package com.tias.back.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

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

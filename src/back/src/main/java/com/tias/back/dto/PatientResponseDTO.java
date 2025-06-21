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
    private LocalDate birthdate;
    private String address;
    private String condition;
    private boolean isActive;
}

package com.tias.back.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientDTO {
    private UUID patientId;
    private String name;
    private Integer cpf;
    private LocalDate birthday;
    private String address;
    private String condition;
    private LocalDateTime createdAt;
    private LocalDateTime editedAt;
    private LocalDateTime deactivatedAt;
}

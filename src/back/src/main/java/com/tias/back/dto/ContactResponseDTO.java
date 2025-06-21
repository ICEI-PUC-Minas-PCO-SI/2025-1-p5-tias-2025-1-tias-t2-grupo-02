package com.tias.back.dto;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class ContactResponseDTO {
    private UUID id;
    private UUID patientId;
    private String name;
    private String email;
    private String phone;
    private String relation;
}

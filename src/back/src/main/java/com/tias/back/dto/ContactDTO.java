package com.tias.back.dto;

import java.util.UUID;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactDTO {
    private UUID id;
    private UUID patientId;
    private String name;
    private String phone;
    private String relation;
}

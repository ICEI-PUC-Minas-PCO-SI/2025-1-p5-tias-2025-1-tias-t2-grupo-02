package com.tias.back.dto;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class DocumentationResponseDTO {
    private UUID id;
    private UUID patientId;
    private String description;
    private String location;
    private String addedAt;
}

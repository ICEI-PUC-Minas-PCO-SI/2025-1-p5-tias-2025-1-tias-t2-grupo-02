package com.tias.back.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private UUID userId;
    private String name;
    private String cpf;
    private String email;
    private boolean isActive;
}
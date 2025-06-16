package com.tias.back.dto;

import java.util.UUID;
import lombok.*;

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

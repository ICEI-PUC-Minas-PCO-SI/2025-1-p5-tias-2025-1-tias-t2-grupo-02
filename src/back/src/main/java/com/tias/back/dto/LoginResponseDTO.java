package com.tias.back.dto;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LoginResponseDTO {
    private UUID loginId;
    private UUID userId;
    private String perfil;
    private boolean isActive;
}

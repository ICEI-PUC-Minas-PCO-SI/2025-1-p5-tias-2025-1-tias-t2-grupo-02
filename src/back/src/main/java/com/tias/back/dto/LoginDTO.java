package com.tias.back.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {
    private UUID id;
    private UUID userId;
    private String perfil;
    private String password;
    private LocalDateTime lastLogin;
}

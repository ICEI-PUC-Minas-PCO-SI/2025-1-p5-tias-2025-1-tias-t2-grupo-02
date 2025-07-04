package com.tias.back.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class LoginRequestDTO {

    @NotBlank(message = "Perfil é obrigatório")
    private String email;

    @NotBlank(message = "Password é obrigatório")
    private String password;
}

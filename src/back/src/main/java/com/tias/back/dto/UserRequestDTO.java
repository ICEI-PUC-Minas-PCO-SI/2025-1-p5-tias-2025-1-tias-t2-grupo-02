package com.tias.back.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Pattern(regexp = "^[A-Za-zÀ-ú ]+$", message = "Nome deve conter apenas letras e espaços")
    private String name;

    private String password;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "^[0-9]{11}$", message = "CPF deve conter exatamente 11 dígitos numéricos")
    private String cpf;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    private String email;
}
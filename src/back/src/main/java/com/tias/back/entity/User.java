package com.tias.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId", updatable = false, nullable = false)
    private UUID userId;

    private String name;

    private Integer cpf;

    @Email(message = "Email deve ser válido")
    private String email;

    private Integer activatedAt;

    private Integer deactivatedAt;
}

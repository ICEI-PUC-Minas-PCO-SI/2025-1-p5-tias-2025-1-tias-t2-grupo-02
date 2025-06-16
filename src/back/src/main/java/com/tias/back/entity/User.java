package com.tias.back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID userId;

    private String name;

    private String cpf;

    @Email(message = "Email deve ser válido")
    private String email;

    @Column(name = "is_active")
    public boolean isActive;

}

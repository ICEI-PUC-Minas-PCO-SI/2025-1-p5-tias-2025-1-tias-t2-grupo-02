package com.tias.back.repository;

import com.tias.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}
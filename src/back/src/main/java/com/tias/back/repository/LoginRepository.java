package com.tias.back.repository;

import com.tias.back.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<Login, UUID> {
    // Aqui você pode declarar métodos de busca customizados, por exemplo:
    // Optional<Login> findByEmail(String email);
}

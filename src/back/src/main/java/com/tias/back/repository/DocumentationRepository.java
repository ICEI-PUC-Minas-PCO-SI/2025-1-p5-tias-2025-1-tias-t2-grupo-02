package com.tias.back.repository;

import com.tias.back.entity.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentationRepository extends JpaRepository<Documentation, UUID> {
    // Aqui você pode declarar métodos de busca customizados, por exemplo:
    // Optional<Documentation> findByEmail(String email);
}

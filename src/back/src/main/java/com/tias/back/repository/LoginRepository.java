package com.tias.back.repository;

import com.tias.back.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<Login, UUID> {
    boolean existsByUser_UserId(UUID userId);
    Optional<Login> findByEmail(String email);
}

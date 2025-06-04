package com.tias.back.repository;

import com.tias.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    // Aqui você pode declarar métodos de busca customizados, por exemplo:
    // Optional<User> findByEmail(String email);
}

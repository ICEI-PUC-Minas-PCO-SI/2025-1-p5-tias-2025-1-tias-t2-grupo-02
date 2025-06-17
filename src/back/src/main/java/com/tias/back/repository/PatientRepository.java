package com.tias.back.repository;

import com.tias.back.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    // Aqui você pode declarar métodos de busca customizados, por exemplo:
    // Optional<Patient> findByEmail(String email);
}

package com.tias.back.repository;

import com.tias.back.entity.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, UUID> {
    // Aqui você pode declarar métodos de busca customizados, por exemplo:
    // Optional<Medication> findByEmail(String email);
}

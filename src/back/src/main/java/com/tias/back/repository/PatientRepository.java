// PatientRepository.java
package com.tias.back.repository;

import com.tias.back.entity.Patient;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository
    extends JpaRepository<Patient, UUID>,
            JpaSpecificationExecutor<Patient> {
    boolean existsByCpf(String cpf);
    boolean existsByRg(String rg);
    boolean existsByCarteirinha(String carteirinha);
}

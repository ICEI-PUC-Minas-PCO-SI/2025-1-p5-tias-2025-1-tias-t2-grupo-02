package com.tias.back.service;

import com.tias.back.dto.MedicationRequestDTO;
import com.tias.back.dto.MedicationResponseDTO;
import com.tias.back.entity.Medication;
import com.tias.back.repository.MedicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class MedicationService {

    private static final Logger logger = LoggerFactory.getLogger(MedicationService.class);
    private final MedicationRepository repository;

    public MedicationService(MedicationRepository repository) {
        this.repository = repository;
    }

    private void validateRequest(MedicationRequestDTO dto) {
        if (dto.getPatientId() == null) {
            logger.warn("Validação falhou em MedicationRequestDTO: PatientId obrigatório");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "PatientId é obrigatório");
        }
        if (dto.getDescription() == null || dto.getDescription().isBlank()) {
            logger.warn("Validação falhou em MedicationRequestDTO: Description vazia");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Description não pode ser vazio");
        }
        if (dto.getDosage() == null || dto.getDosage().isBlank()) {
            logger.warn("Validação falhou em MedicationRequestDTO: Dosage vazia");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Dosage não pode ser vazio");
        }
    }

    public MedicationResponseDTO create(MedicationRequestDTO dto) {
        validateRequest(dto);
        Medication m = Medication.builder()
            .patientId(dto.getPatientId())
            .description(dto.getDescription())
            .dosage(dto.getDosage())
            .addedAt(LocalDateTime.now())
            .build();
        Medication saved = repository.save(m);
        logger.info("Medication criada: {}", saved.getId());
        return toDto(saved);
    }

    public MedicationResponseDTO getById(UUID id) {
        Medication m = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Medication não encontrada: " + id));
        return toDto(m);
    }

    public List<MedicationResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public MedicationResponseDTO update(UUID id, MedicationRequestDTO dto) {
        validateRequest(dto);
        Medication m = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Medication não encontrada: " + id));
        m.setDescription(dto.getDescription());
        m.setDosage(dto.getDosage());
        Medication updated = repository.save(m);
        logger.info("Medication atualizada: {}", id);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
        logger.info("Medication deletada: {}", id);
    }

    private MedicationResponseDTO toDto(Medication m) {
        return MedicationResponseDTO.builder()
            .id(m.getId())
            .patientId(m.getPatientId())
            .description(m.getDescription())
            .dosage(m.getDosage())
            .addedAt(m.getAddedAt().toString())
            .build();
    }
}

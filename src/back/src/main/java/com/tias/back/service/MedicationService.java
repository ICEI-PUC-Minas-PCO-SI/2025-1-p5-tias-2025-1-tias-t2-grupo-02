package com.tias.back.service;

import com.tias.back.dto.MedicationDTO;
import com.tias.back.entity.Medication;
import com.tias.back.exception.ResourceNotFoundException;
import com.tias.back.repository.MedicationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MedicationService {

    private final MedicationRepository repository;

    public MedicationService(MedicationRepository repository) {
        this.repository = repository;
    }

    public MedicationDTO create(MedicationDTO dto) {
        Medication entity = toEntity(dto);
        Medication saved = repository.save(entity);
        return toDto(saved);
    }

    public MedicationDTO getById(UUID id) {
        Medication entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medication not found with id " + id));
        return toDto(entity);
    }

    public List<MedicationDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public MedicationDTO update(UUID id, MedicationDTO dto) {
        Medication entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Medication not found with id " + id));
        entity.setId(dto.getId());
        entity.setPatientId(dto.getPatientId());
        entity.setDescription(dto.getDescription());
        entity.setPosologia(dto.getPosologia());
        entity.setAddedAt(dto.getAddedAt());
        Medication updated = repository.save(entity);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private Medication toEntity(MedicationDTO dto) {
        Medication entity = new Medication();
        entity.setId(dto.getId());
        entity.setPatientId(dto.getPatientId());
        entity.setDescription(dto.getDescription());
        entity.setPosologia(dto.getPosologia());
        entity.setAddedAt(dto.getAddedAt());
        return entity;
    }

    private MedicationDTO toDto(Medication entity) {
        return MedicationDTO.builder()
                .id(entity.getId())
                .patientId(entity.getPatientId())
                .description(entity.getDescription())
                .posologia(entity.getPosologia())
                .addedAt(entity.getAddedAt())
                .build();
    }
}

package com.tias.back.service;

import com.tias.back.dto.PatientDTO;
import com.tias.back.entity.Patient;
import com.tias.back.exception.ResourceNotFoundException;
import com.tias.back.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public PatientDTO create(PatientDTO dto) {
        Patient entity = toEntity(dto);
        Patient saved = repository.save(entity);
        return toDto(saved);
    }

    public PatientDTO getById(UUID id) {
        Patient entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
        return toDto(entity);
    }

    public List<PatientDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PatientDTO update(UUID id, PatientDTO dto) {
        Patient entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id " + id));
        entity.setPatientId(dto.getPatientId());
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthday(dto.getBirthday());
        entity.setAddress(dto.getAddress());
        entity.setCondition(dto.getCondition());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setEditedAt(dto.getEditedAt());
        entity.setDeactivatedAt(dto.getDeactivatedAt());
        Patient updated = repository.save(entity);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private Patient toEntity(PatientDTO dto) {
        Patient entity = new Patient();
        entity.setPatientId(dto.getPatientId());
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setBirthday(dto.getBirthday());
        entity.setAddress(dto.getAddress());
        entity.setCondition(dto.getCondition());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setEditedAt(dto.getEditedAt());
        entity.setDeactivatedAt(dto.getDeactivatedAt());
        return entity;
    }

    private PatientDTO toDto(Patient entity) {
        return PatientDTO.builder()
                .patientId(entity.getPatientId())
                .name(entity.getName())
                .cpf(entity.getCpf())
                .birthday(entity.getBirthday())
                .address(entity.getAddress())
                .condition(entity.getCondition())
                .createdAt(entity.getCreatedAt())
                .editedAt(entity.getEditedAt())
                .deactivatedAt(entity.getDeactivatedAt())
                .build();
    }
}

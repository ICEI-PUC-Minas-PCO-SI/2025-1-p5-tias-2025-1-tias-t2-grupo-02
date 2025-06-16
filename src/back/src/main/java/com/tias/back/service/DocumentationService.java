package com.tias.back.service;

import com.tias.back.dto.DocumentationDTO;
import com.tias.back.entity.Documentation;
import com.tias.back.exception.ResourceNotFoundException;
import com.tias.back.repository.DocumentationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DocumentationService {

    private final DocumentationRepository repository;

    public DocumentationService(DocumentationRepository repository) {
        this.repository = repository;
    }

    public DocumentationDTO create(DocumentationDTO dto) {
        Documentation entity = toEntity(dto);
        Documentation saved = repository.save(entity);
        return toDto(saved);
    }

    public DocumentationDTO getById(UUID id) {
        Documentation entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documentation not found with id " + id));
        return toDto(entity);
    }

    public List<DocumentationDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public DocumentationDTO update(UUID id, DocumentationDTO dto) {
        Documentation entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Documentation not found with id " + id));
        entity.setId(dto.getId());
        entity.setPatientId(dto.getPatientId());
        entity.setDescription(dto.getDescription());
        entity.setLocation(dto.getLocation());
        entity.setAddedAt(dto.getAddedAt());
        Documentation updated = repository.save(entity);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private Documentation toEntity(DocumentationDTO dto) {
        Documentation entity = new Documentation();
        entity.setId(dto.getId());
        entity.setPatientId(dto.getPatientId());
        entity.setDescription(dto.getDescription());
        entity.setLocation(dto.getLocation());
        entity.setAddedAt(dto.getAddedAt());
        return entity;
    }

    private DocumentationDTO toDto(Documentation entity) {
        return DocumentationDTO.builder()
                .id(entity.getId())
                .patientId(entity.getPatientId())
                .description(entity.getDescription())
                .location(entity.getLocation())
                .addedAt(entity.getAddedAt())
                .build();
    }
}

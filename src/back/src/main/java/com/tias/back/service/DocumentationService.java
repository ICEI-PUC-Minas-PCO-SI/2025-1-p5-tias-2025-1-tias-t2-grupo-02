package com.tias.back.service;

import com.tias.back.dto.DocumentationRequestDTO;
import com.tias.back.dto.DocumentationResponseDTO;
import com.tias.back.entity.Documentation;
import com.tias.back.repository.DocumentationRepository;
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
public class DocumentationService {

    private static final Logger logger = LoggerFactory.getLogger(DocumentationService.class);
    private final DocumentationRepository repository;

    public DocumentationService(DocumentationRepository repository) {
        this.repository = repository;
    }

    private void validateRequest(DocumentationRequestDTO dto) {
        if (dto.getPatientId() == null) {
            logger.warn("Validação falhou em DocumentationRequestDTO: PatientId obrigatório");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "PatientId é obrigatório");
        }
        if (dto.getDescription() == null || dto.getDescription().isBlank()) {
            logger.warn("Validação falhou em DocumentationRequestDTO: Description vazia");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Description não pode ser vazio");
        }
        if (dto.getLocation() == null || dto.getLocation().isBlank()) {
            logger.warn("Validação falhou em DocumentationRequestDTO: Location vazia");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Location não pode ser vazio");
        }
    }

    public DocumentationResponseDTO create(DocumentationRequestDTO dto) {
        validateRequest(dto);
        Documentation d = Documentation.builder()
            .patientId(dto.getPatientId())
            .description(dto.getDescription())
            .location(dto.getLocation())
            .addedAt(LocalDateTime.now())
            .build();
        Documentation saved = repository.save(d);
        logger.info("Documentation criada: {}", saved.getId());
        return toDto(saved);
    }

    public DocumentationResponseDTO getById(UUID id) {
        Documentation d = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Documentation não encontrada: " + id));
        return toDto(d);
    }

    public List<DocumentationResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public DocumentationResponseDTO update(UUID id, DocumentationRequestDTO dto) {
        validateRequest(dto);
        Documentation d = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Documentation não encontrada: " + id));
        d.setDescription(dto.getDescription());
        d.setLocation(dto.getLocation());
        Documentation updated = repository.save(d);
        logger.info("Documentation atualizada: {}", id);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
        logger.info("Documentation deletada: {}", id);
    }

    private DocumentationResponseDTO toDto(Documentation d) {
        return DocumentationResponseDTO.builder()
            .id(d.getId())
            .patientId(d.getPatientId())
            .description(d.getDescription())
            .location(d.getLocation())
            .addedAt(d.getAddedAt().toString())
            .build();
    }
}

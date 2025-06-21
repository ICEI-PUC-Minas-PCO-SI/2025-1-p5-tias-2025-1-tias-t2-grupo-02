package com.tias.back.service;

import com.tias.back.dto.ContactRequestDTO;
import com.tias.back.dto.ContactResponseDTO;
import com.tias.back.entity.Contact;
import com.tias.back.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);
    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    private void validateRequest(ContactRequestDTO dto) {
        if (dto.getPatientId() == null) {
            logger.warn("Validação falhou em ContactRequestDTO: PatientId obrigatório");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "PatientId é obrigatório");
        }
        if (!(dto.getName() != null && dto.getName().matches("^[A-Za-zÀ-ú ]+$"))) {
            logger.warn("Validação falhou em ContactRequestDTO: Nome inválido");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Nome inválido: apenas letras e espaços");
        }
        if (!(dto.getEmail() != null && dto.getEmail().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$"))) {
            logger.warn("Validação falhou em ContactRequestDTO: Email inválido");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Email inválido");
        }
        if (!(dto.getPhone() != null && dto.getPhone().matches("\\d{10,11}"))) {
            logger.warn("Validação falhou em ContactRequestDTO: Phone inválido");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Phone inválido: 10 ou 11 dígitos");
        }
        if (!(dto.getRelation() != null && dto.getRelation().matches("^[A-Za-zÀ-ú ]+$"))) {
            logger.warn("Validação falhou em ContactRequestDTO: Relation inválido");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Relation inválido: apenas letras e espaços");
        }
    }

    public ContactResponseDTO create(ContactRequestDTO dto) {
        validateRequest(dto);
        Contact c = Contact.builder()
            .patientId(dto.getPatientId())
            .name(dto.getName())
            .email(dto.getEmail())
            .phone(dto.getPhone())
            .relation(dto.getRelation())
            .build();
        Contact saved = repository.save(c);
        logger.info("Contact criado: {}", saved.getId());
        return toDto(saved);
    }

    public ContactResponseDTO getById(UUID id) {
        Contact c = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Contact não encontrado: " + id));
        return toDto(c);
    }

    public List<ContactResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public ContactResponseDTO update(UUID id, ContactRequestDTO dto) {
        validateRequest(dto);
        Contact c = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Contact não encontrado: " + id));
        c.setPatientId(dto.getPatientId());
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        c.setPhone(dto.getPhone());
        c.setRelation(dto.getRelation());
        Contact updated = repository.save(c);
        logger.info("Contact atualizado: {}", id);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
        logger.info("Contact deletado: {}", id);
    }

    private ContactResponseDTO toDto(Contact c) {
        return ContactResponseDTO.builder()
            .id(c.getId())
            .patientId(c.getPatientId())
            .name(c.getName())
            .email(c.getEmail())
            .phone(c.getPhone())
            .relation(c.getRelation())
            .build();
    }
}

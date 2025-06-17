package com.tias.back.service;

import com.tias.back.dto.ContactDTO;
import com.tias.back.entity.Contact;
import com.tias.back.exception.ResourceNotFoundException;
import com.tias.back.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContactService {

    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public ContactDTO create(ContactDTO dto) {
        Contact entity = toEntity(dto);
        Contact saved = repository.save(entity);
        return toDto(saved);
    }

    public ContactDTO getById(UUID id) {
        Contact entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + id));
        return toDto(entity);
    }

    public List<ContactDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ContactDTO update(UUID id, ContactDTO dto) {
        Contact entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id " + id));
        entity.setId(dto.getId());
        entity.setPatientId(dto.getPatientId());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setRelation(dto.getRelation());
        Contact updated = repository.save(entity);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private Contact toEntity(ContactDTO dto) {
        Contact entity = new Contact();
        entity.setId(dto.getId());
        entity.setPatientId(dto.getPatientId());
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setRelation(dto.getRelation());
        return entity;
    }

    private ContactDTO toDto(Contact entity) {
        return ContactDTO.builder()
                .id(entity.getId())
                .patientId(entity.getPatientId())
                .name(entity.getName())
                .phone(entity.getPhone())
                .relation(entity.getRelation())
                .build();
    }
}

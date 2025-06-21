package com.tias.back.service;

import com.tias.back.dto.PatientRequestDTO;
import com.tias.back.dto.PatientResponseDTO;
import com.tias.back.entity.Patient;
import com.tias.back.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class PatientService {

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    private void validateRequest(PatientRequestDTO dto) {
        if (!(dto.getName() != null && dto.getName().matches("^[A-Za-zÀ-ú ]+$"))) {
            logger.warn("Validação falhou em PatientRequestDTO: Nome inválido");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Nome inválido: deve conter apenas letras e espaços");
        }
        if (!(dto.getCpf() != null && dto.getCpf().matches("\\d{11}"))) {
            logger.warn("Validação falhou em PatientRequestDTO: CPF inválido");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "CPF inválido: deve conter exatamente 11 dígitos numéricos");
        }
        if (dto.getBirthdate() == null) {
            logger.warn("Validação falhou em PatientRequestDTO: Birthdate obrigatório");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Birthdate é obrigatório");
        }
        if (dto.getBirthdate().isAfter(LocalDate.now())) {
            logger.warn("Validação falhou em PatientRequestDTO: Birthdate no futuro: {}", dto.getBirthdate());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Birthdate não pode ser uma data futura");
        }
        if (!(dto.getAddress() != null && !dto.getAddress().isBlank())) {
            logger.warn("Validação falhou em PatientRequestDTO: Endereço vazio");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Endereço não pode ser vazio");
        }
        if (!(dto.getCondition() != null && !dto.getCondition().isBlank())) {
            logger.warn("Validação falhou em PatientRequestDTO: Condição vazia");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Condição não pode ser vazia");
        }
    }

    public PatientResponseDTO create(PatientRequestDTO dto) {
        validateRequest(dto);
        if (repository.existsByCpf(dto.getCpf())) {
            logger.warn("Paciente com CPF duplicado: {}", dto.getCpf());
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                "Paciente com CPF '" + dto.getCpf() + "' já existe.");
        }
        Patient p = Patient.builder()
            .name(dto.getName())
            .cpf(dto.getCpf())
            .birthdate(dto.getBirthdate())
            .address(dto.getAddress())
            .condition(dto.getCondition())
            .isActive(true)
            .build();
        Patient saved = repository.save(p);
        logger.info("Paciente criado: {}", saved.getPatientId());
        return toDto(saved);
    }

    public PatientResponseDTO getById(UUID id) {
        Patient p = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Paciente não encontrado: " + id));
        return toDto(p);
    }

    public List<PatientResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public PatientResponseDTO update(UUID id, PatientRequestDTO dto) {
        validateRequest(dto);
        Patient p = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Paciente não encontrado: " + id));
        if (!p.getCpf().equals(dto.getCpf()) && repository.existsByCpf(dto.getCpf())) {
            logger.warn("Atualização com CPF duplicado: {}", dto.getCpf());
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                "CPF '" + dto.getCpf() + "' já está cadastrado.");
        }
        p.setName(dto.getName());
        p.setCpf(dto.getCpf());
        p.setBirthdate(dto.getBirthdate());
        p.setAddress(dto.getAddress());
        p.setCondition(dto.getCondition());
        Patient updated = repository.save(p);
        logger.info("Paciente atualizado: {}", id);
        return toDto(updated);
    }

    public PatientResponseDTO deactivate(UUID id) {
        Patient p = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Paciente não encontrado: " + id));
        if (!p.isActive()) {
            logger.warn("Paciente já inativo: {}", id);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Paciente '" + id + "' já está inativo.");
        }
        p.setActive(false);
        Patient saved = repository.save(p);
        logger.info("Paciente desativado: {}", id);
        return toDto(saved);
    }

    private PatientResponseDTO toDto(Patient p) {
        return PatientResponseDTO.builder()
            .patientId(p.getPatientId())
            .name(p.getName())
            .cpf(p.getCpf())
            .birthdate(p.getBirthdate())
            .address(p.getAddress())
            .condition(p.getCondition())
            .isActive(p.isActive())
            .build();
    }
}

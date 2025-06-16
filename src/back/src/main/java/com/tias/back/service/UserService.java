package com.tias.back.service;

import com.tias.back.dto.UserRequestDTO;
import com.tias.back.dto.UserResponseDTO;
import com.tias.back.entity.User;
import com.tias.back.repository.UserRepository;
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
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO create(UserRequestDTO dto) {
        if (repository.existsByCpf(dto.getCpf())) {
            logger.warn("CPF duplicado: {}", dto.getCpf());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado: " + dto.getCpf());
        }
        if (repository.existsByEmail(dto.getEmail())) {
            logger.warn("Email duplicado: {}", dto.getEmail());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado: " + dto.getEmail());
        }

        User entity = User.builder()
            .name(dto.getName())
            .cpf(dto.getCpf())
            .email(dto.getEmail())
            .isActive(true)
            .build();

        User saved = repository.save(entity);
        logger.info("Usuário criado: {}", saved.getUserId());
        return toResponse(saved);
    }

    public UserResponseDTO getById(UUID id) {
        User u = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado: " + id));
        return toResponse(u);
    }

    public List<UserResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public UserResponseDTO update(UUID id, UserRequestDTO dto) {
        User entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado: " + id));

        if (!entity.getCpf().equals(dto.getCpf()) && repository.existsByCpf(dto.getCpf())) {
            logger.warn("Atualização com CPF duplicado: {}", dto.getCpf());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado: " + dto.getCpf());
        }
        if (!entity.getEmail().equals(dto.getEmail()) && repository.existsByEmail(dto.getEmail())) {
            logger.warn("Atualização com email duplicado: {}", dto.getEmail());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado: " + dto.getEmail());
        }

        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        User updated = repository.save(entity);

        logger.info("Usuário atualizado: {}", id);
        return toResponse(updated);
    }

    public UserResponseDTO deactivate(UUID id) {
        User entity = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado: " + id));

        if (!entity.isActive()) {
            logger.warn("Usuário já inativo: {}", id);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já está inativo: " + id);
        }

        entity.setActive(false);
        User saved = repository.save(entity);
        logger.info("Usuário desativado: {}", id);
        return toResponse(saved);
    }

    private UserResponseDTO toResponse(User u) {
        return UserResponseDTO.builder()
            .userId(u.getUserId())
            .name(u.getName())
            .cpf(u.getCpf())
            .email(u.getEmail())
            .isActive(u.isActive())
            .build();
    }
}
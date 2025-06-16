package com.tias.back.service;

import com.tias.back.dto.*;
import com.tias.back.entity.User;
import com.tias.back.exception.ResourceNotFoundException;
import com.tias.back.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponseDTO create(UserRequestDTO dto) {
        User entity = User.builder()
            .name(dto.getName())
            .cpf(dto.getCpf())
            .email(dto.getEmail())
            .isActive(true)
            .build();
        User saved = repository.save(entity);
        return toResponse(saved);
    }

    public UserResponseDTO getById(UUID id) {
        User u = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        return toResponse(u);
    }

    public List<UserResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }

    public UserResponseDTO update(UUID id, UserRequestDTO dto) {
        User entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        User updated = repository.save(entity);
        return toResponse(updated);
    }

    public UserResponseDTO deactivate(UUID id) {
        User entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
        entity.setActive(false);
        User saved = repository.save(entity);
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

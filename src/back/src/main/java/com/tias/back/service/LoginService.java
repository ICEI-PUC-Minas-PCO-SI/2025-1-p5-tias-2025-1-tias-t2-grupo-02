package com.tias.back.service;

import com.tias.back.dto.LoginDTO;
import com.tias.back.entity.Login;
import com.tias.back.exception.ResourceNotFoundException;
import com.tias.back.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoginService {

    private final LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    public LoginDTO create(LoginDTO dto) {
        Login entity = toEntity(dto);
        Login saved = repository.save(entity);
        return toDto(saved);
    }

    public LoginDTO getById(UUID id) {
        Login entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Login not found with id " + id));
        return toDto(entity);
    }

    public List<LoginDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public LoginDTO update(UUID id, LoginDTO dto) {
        Login entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Login not found with id " + id));
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setPerfil(dto.getPerfil());
        entity.setPassword(dto.getPassword());
        entity.setLastLogin(dto.getLastLogin());
        Login updated = repository.save(entity);
        return toDto(updated);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    private Login toEntity(LoginDTO dto) {
        Login entity = new Login();
        entity.setId(dto.getId());
        entity.setUserId(dto.getUserId());
        entity.setPerfil(dto.getPerfil());
        entity.setPassword(dto.getPassword());
        entity.setLastLogin(dto.getLastLogin());
        return entity;
    }

    private LoginDTO toDto(Login entity) {
        return LoginDTO.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .perfil(entity.getPerfil())
                .password(entity.getPassword())
                .lastLogin(entity.getLastLogin())
                .build();
    }
}

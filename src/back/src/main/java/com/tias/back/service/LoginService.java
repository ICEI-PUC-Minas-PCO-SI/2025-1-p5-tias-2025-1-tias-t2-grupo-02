package com.tias.back.service;

import com.tias.back.dto.LoginRequestDTO;
import com.tias.back.dto.LoginResponseDTO;
import com.tias.back.entity.Login;
import com.tias.back.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
    private final LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    private void validateRequest(LoginRequestDTO dto) {
        if (dto.getUserId() == null) {
            logger.warn("Validação falhou em LoginRequestDTO: UserId obrigatório");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "UserId é obrigatório");
        }
        if (dto.getEmail() == null || dto.getEmail().isBlank()) {
            logger.warn("Validação falhou em LoginRequestDTO: email vazio");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Perfil não pode ser vazio");
        }
        if (dto.getPassword() == null || dto.getPassword().isBlank()) {
            logger.warn("Validação falhou em LoginRequestDTO: Password vazio");
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,
                "Password não pode ser vazio");
        }
    }

    public LoginResponseDTO getById(UUID id) {
        Login l = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Login não encontrado: " + id));
        return toDto(l);
    }

    public List<LoginResponseDTO> getAll() {
        return repository.findAll().stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }

    public LoginResponseDTO update(UUID id, LoginRequestDTO dto) {
        validateRequest(dto);
        Login l = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Login não encontrado: " + id));
        l.setEmail(dto.getEmail());
        l.setPassword(dto.getPassword());
        Login updated = repository.save(l);
        logger.info("Login atualizado: {}", id);
        return toDto(updated);
    }

    public LoginResponseDTO deactivate(UUID id) {
        Login l = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Login não encontrado: " + id));
        if (!l.getIsActive()) {
            logger.warn("Login já inativo: {}", id);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Login já está inativo: " + id);
        }
        l.setIsActive(false);
        Login saved = repository.save(l);
        logger.info("Login desativado: {}", id);
        return toDto(saved);
    }

    public ResponseEntity<String> authenticate(LoginRequestDTO dto) {
        validateRequest(dto);

        // Verificar se o email existe
        Login login = repository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Email não encontrado"));

        // Verificar se o login está ativo
        if (!login.getIsActive()) {
            logger.warn("Login inativo para o email: {}", dto.getEmail());
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,
                    "Login inativo para o email: " + dto.getEmail());
        }

        // Verificar se a senha está correta
        if (!login.getPassword().equals(dto.getPassword())) {
            logger.warn("Senha incorreta para o email: {}", dto.getEmail());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Senha incorreta");
        }

        // Se tudo estiver correto, retorna uma resposta positiva
        return ResponseEntity.ok("Login bem-sucedido");
    }

    private LoginResponseDTO toDto(Login l) {
        return LoginResponseDTO.builder()
            .loginId(l.getLoginId())
            .userId(l.getUser().getUserId())
            .email(l.getEmail())
            .isActive(l.getIsActive())
            .build();
    }
}

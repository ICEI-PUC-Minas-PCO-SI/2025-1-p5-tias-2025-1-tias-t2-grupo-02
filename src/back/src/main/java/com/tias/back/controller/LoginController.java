package com.tias.back.controller;

import com.tias.back.dto.LoginRequestDTO;
import com.tias.back.dto.LoginResponseDTO;
import com.tias.back.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/logins")
public class LoginController {

    private final LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> create(@RequestBody LoginRequestDTO dto) {
        LoginResponseDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public List<LoginResponseDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoginResponseDTO> update(
            @PathVariable UUID id,
            @RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LoginResponseDTO> deactivate(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deactivate(id));
    }
}

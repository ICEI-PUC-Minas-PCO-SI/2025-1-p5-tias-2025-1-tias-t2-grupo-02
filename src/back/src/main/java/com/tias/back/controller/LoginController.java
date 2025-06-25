package com.tias.back.controller;

import com.tias.back.dto.LoginRequestDTO;
import com.tias.back.dto.LoginResponseDTO;
import com.tias.back.service.LoginService;
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

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody LoginRequestDTO dto) {
        return service.authenticate(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public List<LoginResponseDTO> getAll() {
        return service.getAll();
    }
}

package com.tias.back.controller;

import com.tias.back.dto.LoginDTO;
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
    public ResponseEntity<LoginDTO> create(@RequestBody LoginDTO dto) {
        LoginDTO created = service.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoginDTO> getById(@PathVariable UUID id) {
        LoginDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<LoginDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public LoginDTO update(@PathVariable UUID id, @RequestBody LoginDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.tias.back.controller;

import com.tias.back.dto.PatientRequestDTO;
import com.tias.back.dto.PatientResponseDTO;
import com.tias.back.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientRequestDTO dto) {
        PatientResponseDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public List<PatientResponseDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> update(
            @PathVariable UUID id,
            @RequestBody PatientRequestDTO dto) {
        PatientResponseDTO updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> deactivate(@PathVariable UUID id) {
        PatientResponseDTO deactivated = service.deactivate(id);
        return ResponseEntity.ok(deactivated);
    }
}

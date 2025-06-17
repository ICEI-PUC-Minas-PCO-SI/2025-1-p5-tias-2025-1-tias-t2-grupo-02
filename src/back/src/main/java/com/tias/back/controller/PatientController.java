package com.tias.back.controller;

import com.tias.back.dto.PatientDTO;
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
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO dto) {
        PatientDTO created = service.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getById(@PathVariable UUID id) {
        PatientDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<PatientDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public PatientDTO update(@PathVariable UUID id, @RequestBody PatientDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

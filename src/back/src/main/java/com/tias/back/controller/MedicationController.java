package com.tias.back.controller;

import com.tias.back.dto.MedicationDTO;
import com.tias.back.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    private final MedicationService service;

    public MedicationController(MedicationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MedicationDTO> create(@RequestBody MedicationDTO dto) {
        MedicationDTO created = service.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDTO> getById(@PathVariable UUID id) {
        MedicationDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<MedicationDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public MedicationDTO update(@PathVariable UUID id, @RequestBody MedicationDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

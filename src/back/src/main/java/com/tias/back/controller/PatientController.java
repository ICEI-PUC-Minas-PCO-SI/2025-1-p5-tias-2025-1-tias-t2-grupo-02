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

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<PatientResponseDTO> create(@RequestBody PatientRequestDTO dto) {
        PatientResponseDTO created = patientService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(patientService.getById(id));
    }

    @GetMapping
    public List<PatientResponseDTO> getAll() {
        return patientService.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> update(
            @PathVariable UUID id,
            @RequestBody PatientRequestDTO dto) {
        PatientResponseDTO updated = patientService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<PatientResponseDTO> deactivate(@PathVariable UUID id) {
        PatientResponseDTO deactivated = patientService.deactivate(id);
        return ResponseEntity.ok(deactivated);
    }

    @PutMapping("/activate/{id}")
    public ResponseEntity<PatientResponseDTO> activate(@PathVariable UUID id) {
        PatientResponseDTO deactivated = patientService.activate(id);
        return ResponseEntity.ok(deactivated);
    }

    @DeleteMapping("/deactivate/{id}")
    public ResponseEntity<PatientResponseDTO> delete(@PathVariable UUID id) {
        PatientResponseDTO deactivated = patientService.deactivate(id);
        return ResponseEntity.ok(deactivated);
    }
}

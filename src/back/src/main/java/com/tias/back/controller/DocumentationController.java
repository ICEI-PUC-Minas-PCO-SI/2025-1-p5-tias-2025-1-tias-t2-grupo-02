package com.tias.back.controller;

import com.tias.back.dto.DocumentationRequestDTO;
import com.tias.back.dto.DocumentationResponseDTO;
import com.tias.back.service.DocumentationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/documentations")
public class DocumentationController {

    private final DocumentationService service;

    public DocumentationController(DocumentationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DocumentationResponseDTO> create(@RequestBody DocumentationRequestDTO dto) {
        DocumentationResponseDTO created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentationResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public List<DocumentationResponseDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentationResponseDTO> update(
            @PathVariable UUID id,
            @RequestBody DocumentationRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

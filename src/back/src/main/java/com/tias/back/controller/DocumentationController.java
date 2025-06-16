package com.tias.back.controller;

import com.tias.back.dto.DocumentationDTO;
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
    public ResponseEntity<DocumentationDTO> create(@RequestBody DocumentationDTO dto) {
        DocumentationDTO created = service.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentationDTO> getById(@PathVariable UUID id) {
        DocumentationDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<DocumentationDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public DocumentationDTO update(@PathVariable UUID id, @RequestBody DocumentationDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

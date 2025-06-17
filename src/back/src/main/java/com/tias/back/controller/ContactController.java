package com.tias.back.controller;

import com.tias.back.dto.ContactDTO;
import com.tias.back.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContactDTO> create(@RequestBody ContactDTO dto) {
        ContactDTO created = service.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getById(@PathVariable UUID id) {
        ContactDTO dto = service.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public List<ContactDTO> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public ContactDTO update(@PathVariable UUID id, @RequestBody ContactDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

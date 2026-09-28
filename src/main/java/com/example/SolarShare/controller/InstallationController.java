package com.example.SolarShare.controller;

import com.example.SolarShare.entity.Installation;
import com.example.SolarShare.service.InstallationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/installations")
public class InstallationController {

    private final InstallationService installationService;

    public InstallationController(
            InstallationService installationService) {

        this.installationService = installationService;
    }

    @PostMapping
    public ResponseEntity<Installation> create(
            @Valid @RequestBody Installation installation) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(installationService.create(installation));
    }

    @GetMapping
    public ResponseEntity<List<Installation>> getAll() {

        return ResponseEntity.ok(
                installationService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Installation> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                installationService.getById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Installation> update(
            @PathVariable Long id,
            @Valid @RequestBody Installation installation) {

        return ResponseEntity.ok(
                installationService.update(id, installation)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        installationService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
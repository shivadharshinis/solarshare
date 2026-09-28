package com.example.SolarShare.controller;

import com.example.SolarShare.entity.GenerationLog;
import com.example.SolarShare.service.GenerationLogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generation-logs")
public class GenerationLogController {

    private final GenerationLogService generationLogService;

    public GenerationLogController(
            GenerationLogService generationLogService) {

        this.generationLogService = generationLogService;
    }

    @PostMapping("/installation/{installationId}")
    public ResponseEntity<GenerationLog> create(
            @PathVariable Long installationId,
            @Valid @RequestBody GenerationLog generationLog) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        generationLogService.create(
                                installationId,
                                generationLog
                        )
                );
    }

    @GetMapping
    public ResponseEntity<List<GenerationLog>> getAll() {

        return ResponseEntity.ok(
                generationLogService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenerationLog> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                generationLogService.getById(id)
        );
    }

    @GetMapping("/installation/{installationId}")
    public ResponseEntity<List<GenerationLog>> getByInstallation(
            @PathVariable Long installationId) {

        return ResponseEntity.ok(
                generationLogService
                        .getByInstallation(installationId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenerationLog> update(
            @PathVariable Long id,
            @Valid @RequestBody GenerationLog generationLog) {

        return ResponseEntity.ok(
                generationLogService.update(
                        id,
                        generationLog
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        generationLogService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
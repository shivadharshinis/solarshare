package com.example.SolarShare.controller;

import com.example.SolarShare.entity.ConsumptionLog;
import com.example.SolarShare.service.ConsumptionLogService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consumption-logs")
public class ConsumptionLogController {

    private final ConsumptionLogService consumptionLogService;

    public ConsumptionLogController(
            ConsumptionLogService consumptionLogService) {

        this.consumptionLogService = consumptionLogService;
    }

    @PostMapping("/household/{householdId}")
    public ResponseEntity<ConsumptionLog> create(
            @PathVariable Long householdId,
            @Valid @RequestBody ConsumptionLog consumptionLog) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        consumptionLogService.create(
                                householdId,
                                consumptionLog
                        )
                );
    }

    @GetMapping
    public ResponseEntity<List<ConsumptionLog>> getAll() {

        return ResponseEntity.ok(
                consumptionLogService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsumptionLog> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                consumptionLogService.getById(id)
        );
    }

    @GetMapping("/household/{householdId}")
    public ResponseEntity<List<ConsumptionLog>> getByHousehold(
            @PathVariable Long householdId) {

        return ResponseEntity.ok(
                consumptionLogService
                        .getByHousehold(householdId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsumptionLog> update(
            @PathVariable Long id,
            @Valid @RequestBody ConsumptionLog consumptionLog) {

        return ResponseEntity.ok(
                consumptionLogService.update(
                        id,
                        consumptionLog
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        consumptionLogService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
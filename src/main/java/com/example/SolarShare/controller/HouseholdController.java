package com.example.SolarShare.controller;

import com.example.SolarShare.entity.Household;
import com.example.SolarShare.service.HouseholdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    private final HouseholdService householdService;

    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    @PostMapping("/installation/{installationId}")
    public ResponseEntity<Household> create(
            @PathVariable Long installationId,
            @Valid @RequestBody Household household) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        householdService.create(
                                installationId,
                                household
                        )
                );
    }

    @GetMapping
    public ResponseEntity<List<Household>> getAll() {

        return ResponseEntity.ok(
                householdService.getAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Household> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                householdService.getById(id)
        );
    }

    @GetMapping("/installation/{installationId}")
    public ResponseEntity<List<Household>> getByInstallation(
            @PathVariable Long installationId) {

        return ResponseEntity.ok(
                householdService.getByInstallation(installationId)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Household> update(
            @PathVariable Long id,
            @Valid @RequestBody Household household) {

        return ResponseEntity.ok(
                householdService.update(id, household)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        householdService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
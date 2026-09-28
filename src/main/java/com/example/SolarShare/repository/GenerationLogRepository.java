package com.example.SolarShare.repository;

import com.example.SolarShare.entity.GenerationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface GenerationLogRepository extends JpaRepository<GenerationLog, Long> {

    List<GenerationLog> findByInstallationId(Long installationId);

    Optional<GenerationLog> findByInstallationIdAndGenerationDate(
            Long installationId,
            LocalDate generationDate
    );
}
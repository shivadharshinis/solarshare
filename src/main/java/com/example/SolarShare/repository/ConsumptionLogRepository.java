package com.example.SolarShare.repository;

import com.example.SolarShare.entity.ConsumptionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsumptionLogRepository extends JpaRepository<ConsumptionLog, Long> {

    List<ConsumptionLog> findByHouseholdId(Long householdId);

    List<ConsumptionLog> findByHouseholdIdAndConsumptionDateBetween(
            Long householdId,
            LocalDate startDate,
            LocalDate endDate
    );
}
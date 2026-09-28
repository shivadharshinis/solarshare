package com.example.SolarShare.repository;

import com.example.SolarShare.entity.Installation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstallationRepository extends JpaRepository<Installation, Long> {
}
package com.example.SolarShare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class GenerationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate generationDate;

    @Column(nullable = false, precision = 12, scale = 4)
    private BigDecimal unitsGenerated;

    @ManyToOne
    @JoinColumn(name = "installation_id", nullable = false)
    @JsonIgnore
    private Installation installation;

    public GenerationLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(LocalDate generationDate) {
        this.generationDate = generationDate;
    }

    public BigDecimal getUnitsGenerated() {
        return unitsGenerated;
    }

    public void setUnitsGenerated(BigDecimal unitsGenerated) {
        this.unitsGenerated = unitsGenerated;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }
}
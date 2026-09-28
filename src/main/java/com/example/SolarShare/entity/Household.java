package com.example.SolarShare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String householdNumber;

    @Column(nullable = false)
    private String residentName;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal allocationRatio;

    @ManyToOne
    @JoinColumn(name = "installation_id", nullable = false)
    @JsonIgnore
    private Installation installation;

    @OneToMany(mappedBy = "household", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ConsumptionLog> consumptionLogs = new ArrayList<>();

    public Household() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHouseholdNumber() {
        return householdNumber;
    }

    public void setHouseholdNumber(String householdNumber) {
        this.householdNumber = householdNumber;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public BigDecimal getAllocationRatio() {
        return allocationRatio;
    }

    public void setAllocationRatio(BigDecimal allocationRatio) {
        this.allocationRatio = allocationRatio;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }

    public List<ConsumptionLog> getConsumptionLogs() {
        return consumptionLogs;
    }

    public void setConsumptionLogs(List<ConsumptionLog> consumptionLogs) {
        this.consumptionLogs = consumptionLogs;
    }
}
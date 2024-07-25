package com.example.mapper;

import com.example.model.HealthReport;
import java.util.List;

public interface HealthReportMapper {
    void addHealthReport(int animalId, String reportDate, String reportDetails);
    List<HealthReport> getHealthReportsByAnimal(int animalId);
}

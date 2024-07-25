package com.example.model;

import java.io.Serializable;
import java.sql.Date;

public class HealthReport implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;            // Il tipo Long è usato per l'ID generato automaticamente
    private Integer animalId;   // Tipo Integer per animal_id
    private Date reportDate;    // Tipo Date per report_date
    private String reportDetails; // Tipo String per report_details

    // Costruttore senza argomenti
    public HealthReport() {
    }

    // Costruttore con argomenti
    public HealthReport(Long id, Integer animalId, Date reportDate, String reportDetails) {
        this.id = id;
        this.animalId = animalId;
        this.reportDate = reportDate;
        this.reportDetails = reportDetails;
    }

    // Getter e Setter per id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter e Setter per animalId
    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    // Getter e Setter per reportDate
    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    // Getter e Setter per reportDetails
    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    @Override
    public String toString() {
        return "HealthReport [id=" + id + ", animalId=" + animalId + ", reportDate=" + reportDate + ", reportDetails=" + reportDetails + "]";
    }
}

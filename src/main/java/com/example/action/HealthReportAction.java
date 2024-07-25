package com.example.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.example.model.HealthReport;
import com.example.service.HealthReportService;
import com.example.service.KafkaProducerService;

import java.util.List;

public class HealthReportAction extends ActionSupport {
    private KafkaProducerService kafkaProducerService;
    private HealthReportService healthReportService;

    private int animalId;
    private String reportDate;
    private String reportDetails;
    private List<HealthReport> healthReports;
    private String jsonResponse;

    // Setter per KafkaProducerService
    public void setKafkaProducerService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    // Setter per HealthReportService
    public void setHealthReportService(HealthReportService healthReportService) {
        this.healthReportService = healthReportService;
    }

    // Metodo per aggiungere un report di salute
    public String addHealthReport() {
        // Aggiungi il report di salute nel database
        healthReportService.addHealthReport(animalId, reportDate, reportDetails);
    
        // Invia un messaggio a Kafka
        String message = String.format("New health report for animal %d", animalId);
        kafkaProducerService.sendMessage(String.valueOf(animalId), message);

        // Creazione della risposta JSON
        jsonResponse = "{ \"status\": \"success\", \"message\": \"Report added successfully\" }";
        return SUCCESS;       
    }

    // Metodo per ottenere i report di salute per un animale specifico
    public String getHealthReportsByAnimal() {
        healthReports = healthReportService.getHealthReportsByAnimal(animalId);

        // Creazione della risposta JSON
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonResponse = mapper.writeValueAsString(healthReports);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResponse = "{ \"status\": \"error\", \"message\": \"Error retrieving reports\" }";
        }
        return SUCCESS;
    }

    // Getter per JSON response
    public String getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    // Getters e setters per altri attributi
    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(String reportDetails) {
        this.reportDetails = reportDetails;
    }

    public List<HealthReport> getHealthReports() {
        return healthReports;
    }

    public void setHealthReports(List<HealthReport> healthReports) {
        this.healthReports = healthReports;
    }
}

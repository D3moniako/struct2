package com.example;

import org.apache.catalina.startup.Tomcat;


public class GatewayApplication {

    public static void main(String[] args) throws Exception {
        // Crea un'istanza di Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // Crea un connettore predefinito
        tomcat.getConnector();

        // Imposta il percorso corretto del file WAR
        String warFilePath = "C:/Users/soler/Desktop/StructsProgetti/animal-health/target/animal-health.war";
        
        // Usa una stringa vuota per il contesto radice
        tomcat.addWebapp("", new java.io.File(warFilePath).getAbsolutePath());


        // Avvia Tomcat
        tomcat.start();

        // Attende le richieste
        tomcat.getServer().await();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Construccion.Auditoria.Servicio;

/**
 *
 * @author pipe2
 */
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuditoriaService {
    private static AuditoriaService instance;

    private Map<String, Integer> errorCountMap = new HashMap<>();

    private AuditoriaService() {}

    public static AuditoriaService getInstance() {
        if (instance == null) {
            synchronized (AuditoriaService.class) {
                if (instance == null) {
                    instance = new AuditoriaService();
                }
            }
        }
        return instance;
    }

    public void registrarError(String action, String errorMessage) {
        int count = errorCountMap.getOrDefault(action, 0);
        errorCountMap.put(action, count + 1);
        
        if (count >= 2) {
            registrarEnArchivo(action, errorMessage);
        }
    }

    private void registrarEnArchivo(String action, String errorMessage) {
        LocalDateTime timestamp = LocalDateTime.now();
        String logMessage = timestamp + " - " + action + ": " + errorMessage + "\n";
        
        try (FileWriter writer = new FileWriter("error.log", true)) {
            writer.write(logMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Construccion.Auditoria.Servicio;

/**
 *
 * @author pipe2
 */
import com.example.Construccion.Auditoria.Repository.CambioPrecioHabitacionLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class AuditoriaService {

    private final CambioPrecioHabitacionLogRepository cambioPrecioHabitacionLogRepository;

    @Autowired
    public AuditoriaService(CambioPrecioHabitacionLogRepository cambioPrecioHabitacionLogRepository) {
        this.cambioPrecioHabitacionLogRepository = cambioPrecioHabitacionLogRepository;
    }

    public void registrarIntentoCambioPrecioHabitacion(double precioAnterior, double nuevoPrecio) {
        String mensaje = "Intento de cambio de precio de habitación. Precio anterior: " + precioAnterior +
                ", Nuevo precio: " + nuevoPrecio + ", Fecha y hora: " + LocalDateTime.now();
        
        // Registrar en archivo .txt localmente
        registrarEnArchivo(mensaje);

        // Generar excepción
        throw new RuntimeException("No se permite cambiar el precio de la habitación.");
    }

    private void registrarEnArchivo(String mensaje) {
        try {
            FileWriter fileWriter = new FileWriter("cambio_precio_habitacion_log.txt", true);
            fileWriter.write(mensaje + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Construccion.Auditoria.Controller;

/**
 *
 * @author pipe2
 */
import com.example.Construccion.Auditoria.Servicio.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

    private final AuditoriaService auditoriaService;

    @Autowired
    public AuditoriaController(AuditoriaService auditoriaService) {
        this.auditoriaService = auditoriaService;
    }

    @PostMapping("/cambio-precio-habitacion")
    public void registrarIntentoCambioPrecioHabitacion(@RequestParam double precioAnterior, @RequestParam double nuevoPrecio) {
        auditoriaService.registrarIntentoCambioPrecioHabitacion(precioAnterior, nuevoPrecio);
    }
}

package com.example.Construccion.Habitaciones.Controlador;

import com.example.Construccion.Habitaciones.Modelo.Habitacion;
import com.example.Construccion.Habitaciones.Servicios.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/v1/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PostMapping("/crear")
    public void crearHabitacion(@RequestParam String nombreHabitacion,
                                @RequestParam String descripcion,
                                @RequestParam String direccion,
                                @RequestParam String ciudad,
                                @RequestParam double precio,
                                @RequestParam int idPropietario,
                                @RequestParam int idEstado) {
        habitacionService.crearHabitacion(nombreHabitacion, descripcion, direccion, ciudad, precio, idPropietario, idEstado);
    }

        @DeleteMapping("/borrar/{idHabitacion}")
    public void borrarHabitacion(@PathVariable int idHabitacion) {
        habitacionService.borrarHabitacion(idHabitacion);
    }

    @PutMapping("/{idHabitacion}")
    public void actualizarHabitacion(@PathVariable int idHabitacion,
                                     @RequestParam String nombreHabitacion,
                                     @RequestParam String descripcion,
                                     @RequestParam String direccion,
                                     @RequestParam String ciudad,
                                     @RequestParam double precio,
                                     @RequestParam int idPropietario,
                                     @RequestParam int idEstado) {
        habitacionService.actualizarHabitacion(idHabitacion, nombreHabitacion, descripcion, direccion, ciudad, precio, idPropietario, idEstado);
    }

    @GetMapping("/{idHabitacion}")
    public Habitacion buscarHabitacionPorId(@PathVariable int idHabitacion) {
        return habitacionService.buscarHabitacionPorId(idHabitacion);
    }

    @GetMapping
    public List<Habitacion> findAll() {
        return habitacionService.findAll();
    }
    
    @PutMapping("/{id}/precio")
    public ResponseEntity<String> actualizarPrecioHabitacion(@PathVariable("id") int id, @RequestParam("precio") double nuevoPrecio) {
        Habitacion habitacion = habitacionService.buscarPorId(id);
        if (habitacion != null) {
            habitacion.setPrecio(nuevoPrecio);
            habitacionService.guardar(habitacion);
            return ResponseEntity.ok("Precio de la habitación actualizado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

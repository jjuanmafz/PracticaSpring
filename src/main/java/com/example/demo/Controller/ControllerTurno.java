package com.example.demo.Controller;

import com.example.demo.DAO.TurnoDAO;
import com.example.demo.Modelo.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class ControllerTurno {

    @Autowired
    private TurnoDAO turnoDAO;

    @GetMapping
    public List<Turno> listarTurnos() {
        return turnoDAO.listarTurnos();
    }

    @GetMapping("/{id}")
    public List<Turno> listaTurnoID(@PathVariable int id){
        return turnoDAO.listarTurnosXid(id);
    }

    @PostMapping("/guardar")
    public String guardarTurno(@RequestBody Turno turno) {
        try {
            turnoDAO.crearNuevoTurno(turno);
            return "Turno creado correctamente";
        } catch (Exception e) {
            return "Error al crear el turno: " + e.getMessage();
        }
    }
}
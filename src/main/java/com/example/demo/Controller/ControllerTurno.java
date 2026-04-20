package com.example.demo.Controller;

import com.example.demo.DAO.TurnoDAO;
import com.example.demo.Modelo.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
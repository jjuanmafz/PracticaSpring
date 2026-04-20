package com.example.demo.Controller;

import com.example.demo.DAO.MascotaDAO;
import com.example.demo.Modelo.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mascotas")
public class ControllerMascota {

    @Autowired
    private MascotaDAO mascotaDAO;

    @GetMapping
    public List<Mascota> listarMascotas() {
        return mascotaDAO.listarMascotas();
    }
}
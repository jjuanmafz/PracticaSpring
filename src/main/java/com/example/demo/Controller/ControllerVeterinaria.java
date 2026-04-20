package com.example.demo.Controller;


import com.example.demo.DAO.VeterinariaDAO;
import com.example.demo.Modelo.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/veterinarias")
public class ControllerVeterinaria {

    @Autowired
    private VeterinariaDAO veterinariaDAO;

    @GetMapping
    public List<Veterinaria> listarVeterinarias() {
        return veterinariaDAO.listarVeterinarias();
    }
}
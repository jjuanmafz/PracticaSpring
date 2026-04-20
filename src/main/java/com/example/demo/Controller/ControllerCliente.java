package com.example.demo.Controller;

import com.example.demo.DAO.ClienteDAO;
import com.example.demo.Modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ControllerCliente {

    @Autowired
    private ClienteDAO clienteDAO;


    @GetMapping
    public List<Cliente> listarClientes(){
        return clienteDAO.listarClientes();
    }
}

package com.example.demo.DAO;

import com.example.demo.Modelo.Veterinaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VeterinariaDAO {

    @Autowired
    private DataSource dataSource;

    // LISTAR TODOS LOS VETERINARIOS
    public List<Veterinaria> listarVeterinarias() {
        List<Veterinaria> lista = new ArrayList<>();

        String sql = "SELECT * FROM veterinaria";

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Veterinaria v = new Veterinaria();

                // Mapeo según tus atributos específicos
                v.setIdVeterinaria(rs.getInt("id_veterinaria"));
                v.setNombre(rs.getString("nombre"));
                v.setApellido(rs.getString("apellido"));
                v.setMatricula(rs.getInt("matricula"));
                v.setEspecialidad(rs.getString("especialidad"));
                v.setTelefono(rs.getLong("telefono"));
                v.setEmail(rs.getString("email"));

                lista.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
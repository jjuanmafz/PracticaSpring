package com.example.demo.DAO;

import com.example.demo.Modelo.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MascotaDAO {

    @Autowired
    private DataSource dataSource;

    // LISTAR TODAS LAS MASCOTAS
    public List<Mascota> listarMascotas() {
        List<Mascota> lista = new ArrayList<>();

        // Ajusta el nombre de la tabla según tu base de datos
        String sql = "SELECT * FROM mascota";

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Mascota m = new Mascota();

                m.setIdMascota(rs.getInt("id_mascota"));
                m.setNombre(rs.getString("nombre"));
                m.setEspecie(rs.getString("especie")); // Ej: Perro, Gato
                m.setRaza(rs.getString("raza"));
                m.setEdad(rs.getInt("edad"));
                m.setPeso(rs.getDouble("peso"));
                m.setIdCliente(rs.getInt("id_cliente"));

                lista.add(m);
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }

        return lista;
    }
}

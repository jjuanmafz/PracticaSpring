package com.example.demo.DAO;

import com.example.demo.Modelo.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TurnoDAO {

    @Autowired
    private DataSource dataSource;

    // LISTAR TODOS LOS TURNOS
    public List<Turno> listarTurnos() {
        List<Turno> lista = new ArrayList<>();

        String sql = "SELECT * FROM turno";

        try (Connection con = dataSource.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Turno t = new Turno();
                t.setIdTurno(rs.getInt("id_turno"));
                t.setFecha(rs.getObject("fecha", LocalDate.class));
                t.setHora(rs.getObject("hora", LocalTime.class));
                t.setMotivo(rs.getString("motivo"));
                t.setEstado(rs.getString("estado"));
                t.setIdCliente(rs.getInt("id_cliente"));
                t.setIdVeterinaria(rs.getInt("id_veterinaria"));
                t.setIdMascota(rs.getInt("id_mascota"));

                lista.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    public List<Turno> listarTurnosXid(@PathVariable int id) {
        List<Turno> lista = new ArrayList<>();

        String sql = "SELECT * FROM turno WHERE id_turno = ?";

        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Turno t = new Turno();
                t.setIdTurno(rs.getInt("id_turno"));
                t.setFecha(rs.getObject("fecha", LocalDate.class));
                t.setHora(rs.getObject("hora", LocalTime.class));
                t.setMotivo(rs.getString("motivo"));
                t.setEstado(rs.getString("estado"));
                t.setIdCliente(rs.getInt("id_cliente"));
                t.setIdVeterinaria(rs.getInt("id_veterinaria"));
                t.setIdMascota(rs.getInt("id_mascota"));

                lista.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void crearNuevoTurno  (Turno turno)
    {
        String sql= "INSERT INTO turno (fecha, hora, motivo, estado, id_cliente, id_veterinaria, id_mascota) " +
                "VALUES (?,?,?,?,?,?,?)";
        try(Connection con= dataSource.getConnection();
            PreparedStatement ps=con.prepareStatement(sql))  {
            ps.setObject(1, turno.getFecha());
            ps.setObject(2, turno.getHora());
            ps.setString(3, turno.getMotivo());
            ps.setString(4, turno.getEstado());
            ps.setInt(5, turno.getIdCliente());
            ps.setInt(6,turno.getIdVeterinaria());
            ps.setInt(7,turno.getIdMascota());

            ps.executeUpdate();

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
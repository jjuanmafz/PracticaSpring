package com.example.demo.Modelo;
import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    private int idTurno;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;
    private String estado;

    private int idCliente;
    private int idVeterinaria;
    private int idMascota;

    public Turno() {}

    public Turno(int idTurno, LocalDate fecha, LocalTime hora, String motivo,
                 String estado, int idCliente, int idVeterinaria, int idMascota) {
        this.idTurno = idTurno;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idVeterinaria = idVeterinaria;
        this.idMascota = idMascota;
    }

    public Turno(LocalDate fecha, LocalTime hora, String motivo, String estado, int idCliente, int idVeterinaria, int idMascota) {
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.idCliente = idCliente;
        this.idVeterinaria = idVeterinaria;
        this.idMascota = idMascota;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(int idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "idTurno=" + idTurno +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", motivo='" + motivo + '\'' +
                ", estado='" + estado + '\'' +
                ", idCliente=" + idCliente +
                ", idVeterinaria=" + idVeterinaria +
                ", idMascota=" + idMascota +
                '}';
    }
}
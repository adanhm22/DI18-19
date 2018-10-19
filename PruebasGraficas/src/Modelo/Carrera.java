/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author alumnop
 */
public class Carrera {

    private String nombre, direccion;
    private Date fechaCarrera;
    private int numeroParticipantes;
    private Map<String,Corredor> corredores;

    public Carrera(String nombre, String direccion, Date fechaCarrera, int numParticipantes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaCarrera = fechaCarrera;
        this.numeroParticipantes = numParticipantes;
        this.corredores = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaCarrera() {
        return fechaCarrera;
    }

    public void setFechaCarrera(Date fechaCarrera) {
        this.fechaCarrera = fechaCarrera;
    }

    public int getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(int numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public Corredor conseguirCorredores(String Dorsal) {
        return this.corredores.get(Dorsal);
    }

    public Corredor aniadirCorredoresDorsal(String dorsal, Corredor corredor) {

        
        return this.corredores.put(dorsal, corredor);
    }

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", direccion=" + direccion + ", fechaCarrera=" + fechaCarrera + ", numeroParticipantes=" + numeroParticipantes + ", carredores=" + corredores + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author alumnop
 */
public class Carrera {

    private String nombre, direccion;
    private Date fechaCarrera;

    public Carrera() {
    }

    public Carrera(String nombre, String direccion, Date fechaCarrera) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaCarrera = fechaCarrera;
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

    @Override
    public String toString() {
        return "Carrera{" + "nombre=" + nombre + ", direccion=" + direccion + ", fechaCarrera=" + fechaCarrera + '}';
    }

}

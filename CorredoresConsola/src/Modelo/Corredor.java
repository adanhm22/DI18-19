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
public class Corredor implements Comparable<Corredor>{

    private int telef;
    private String Nombre;
    private final String DNI;
    private Date fechaNac;

    public Corredor(String DNI) {
        this.DNI = DNI;
    }

    public Corredor(String Nombre, String DNI) {
        this.Nombre = Nombre;
        this.DNI = DNI;
    }

    public int getTelef() {
        return telef;
    }

    public void setTelef(int telef) {
        this.telef = telef;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDNI() {
        return DNI;
    }

    @Override
    public int compareTo(Corredor o) {
        return o.DNI.compareTo(this.DNI);
    }

    @Override
    public boolean equals(Object obj) {
        
        return DNI.equals(obj);
    }

    @Override
    public String toString() {
        return "Corredor{" + "telef=" + telef + ", Nombre=" + Nombre + ", DNI=" + DNI + ", fechaNac=" + fechaNac + '}';
    }
    
    
    
    

}

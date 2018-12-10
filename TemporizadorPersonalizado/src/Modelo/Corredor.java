/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author alumnop
 */
public class Corredor implements Comparable<Corredor>,Serializable {

    private int telef;
    private String Nombre, Direccion;
    private String DNI;
    private Date fechaNac;

    public Corredor(String DNI) {
        this.DNI = DNI;
    }

    public Corredor(String Nombre, String DNI) {
        this.Nombre = Nombre;
        this.DNI = DNI;
    }

    public Corredor( String DNI, String Nombre, String Direccion,int telef, Date fechaNac) {
        this.telef = telef;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.DNI = DNI;
        this.fechaNac = fechaNac;
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

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    @Override
    public int compareTo(Corredor o) {
        return o.DNI.compareTo(this.DNI);
    }

    @Override
    public String toString() {
            return this.DNI + " :: " + this.Nombre;
        
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==this)
            return true;
        if(obj instanceof Corredor)
            return this.DNI.equals(((Corredor) obj).DNI);
        return false;
            
    }
    
    

}

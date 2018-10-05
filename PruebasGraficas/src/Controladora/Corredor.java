/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.*;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author alumnop
 */
public class Corredor implements Comparable<Corredor>, Comparator<Corredor>{

    private int telef;
    private String Nombre,Direccion;
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
        return "Corredor{" + "telef=" + telef + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", DNI=" + DNI + ", fechaNac=" + fechaNac + '}';
    }

    

    @Override
    public int compare(Corredor o1, Corredor o2) {
        if(o1==o2){
            return 0;
        }
       return o1.DNI.compareTo(o2.DNI);
    }
    
    
    
    

}

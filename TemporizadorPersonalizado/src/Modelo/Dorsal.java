/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author alumnop
 */
public class Dorsal implements Serializable,Comparable<Dorsal> {
    private String dorsal;
    private Corredor corredor;
    private int horas,minutos,segundos;

  

    public Dorsal(String dorsal, Corredor corredor) {
        this.dorsal = dorsal;
        this.corredor = corredor;
    }

    public Dorsal(String dorsal, Corredor corredor, int horas, int minutos, int segundos) {
        this.dorsal = dorsal;
        this.corredor = corredor;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
      public String getDorsal() {
        return dorsal;
    }

    public void setDorsal(String dorsal) {
        this.dorsal = dorsal;
    }

    public Corredor getCorredor() {
        return corredor;
    }

    public void setCorredor(Corredor corredor) {
        this.corredor = corredor;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public int compareTo(Dorsal o) {
        return this.dorsal.compareTo(o.dorsal);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(obj instanceof Dorsal)
            return ((Dorsal) obj).getDorsal().equals(this.dorsal);
        return false;
    }

    @Override
    public String toString() {
        return dorsal + "= " + corredor;
    }
    
    
}

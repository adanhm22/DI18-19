/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alumnop
 */
public class Dorsal {
    private String dorsal;
    private Corredor corredor;

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

    public Dorsal(String dorsal, Corredor corredor) {
        this.dorsal = dorsal;
        this.corredor = corredor;
    }
    
    
}

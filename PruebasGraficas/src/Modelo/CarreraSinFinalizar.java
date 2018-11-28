/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alumnop
 */
public class CarreraSinFinalizar extends Carrera{
    
    private List<Dorsal> corredores;
    
    public CarreraSinFinalizar(String nombre, String direccion, Date fechaCarrera, int numParticipantes) {
        super(nombre, direccion, fechaCarrera, numParticipantes);
        this.corredores=new ArrayList<>();
    }

    public List<Dorsal> getCorredores() {
        return corredores;
    }

    public void setCorredores(List<Dorsal> corredores) {
        this.corredores = corredores;
    }
    
    
    
}

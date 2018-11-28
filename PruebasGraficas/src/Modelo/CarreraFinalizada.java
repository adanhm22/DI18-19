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
public class CarreraFinalizada extends Carrera{
    
    private String nombreGanador;
    
    public CarreraFinalizada(String nombre, String direccion, Date fechaCarrera, int numParticipantes) {
        super(nombre, direccion, fechaCarrera, numParticipantes);
    }

    public String getNombreGanador() {
        return nombreGanador;
    }
    
}

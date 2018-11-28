/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.CarreraFinalizada;
import Modelo.CarreraSinFinalizar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnop
 */
public class GestionCarreras {
    private List<CarreraSinFinalizar> carrerasSinFinalizar;
    private List<CarreraFinalizada> carrerasFinalizadas;

    public GestionCarreras() {
        this.carrerasFinalizadas=new ArrayList<>();
        this.carrerasSinFinalizar=new ArrayList<>();
    }

    public GestionCarreras(List<CarreraSinFinalizar> carrerasSinFinalizar, List<CarreraFinalizada> carrerasFinalizadas) {
        this.carrerasSinFinalizar = carrerasSinFinalizar;
        this.carrerasFinalizadas = carrerasFinalizadas;
    }

    public List<CarreraSinFinalizar> getCarrerasSinFinalizar() {
        return carrerasSinFinalizar;
    }

    public List<CarreraFinalizada> getCarrerasFinalizadas() {
        return carrerasFinalizadas;
    }
    
    
    
    
}

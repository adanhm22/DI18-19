/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Carrera;
import Modelo.CarreraFinalizada;
import Modelo.CarreraSinFinalizar;
import Modelo.Corredor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adan
 */
public class DataSource {
    
    public static List<Corredor> getCorredores(){
        return Controladora.getInstance().getGestionCorredores().getCorredores();
    }
    
    public static List<CarreraSinFinalizar> getCarrerasSinFinalizadar(){
        return Controladora.getInstance().getGestionCarreras().getCarrerasSinFinalizar();
    }
    
    public static List<CarreraFinalizada> getCarrerasFinalizadas(){
        return Controladora.getInstance().getGestionCarreras().getCarrerasFinalizadas();
    }
    
    public static List<Carrera> getCarreras(){
        GestionCarreras gestionCarreras = Controladora.getInstance().getGestionCarreras();
        List<Carrera> carreras = new ArrayList<>();
        carreras.addAll(gestionCarreras.getCarrerasFinalizadas());
        carreras.addAll(gestionCarreras.getCarrerasSinFinalizar());
        return carreras;
    }
    
}

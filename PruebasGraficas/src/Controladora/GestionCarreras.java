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
import Modelo.CorredorException;
import Modelo.Dorsal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alumnop
 */
public class GestionCarreras implements Serializable{
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

    public boolean nuevaCarrera(String nombre, String direccion, Date fecha, int participantes) {
        CarreraSinFinalizar nueva = new CarreraSinFinalizar(nombre, direccion, fecha, participantes);
        if(this.carrerasSinFinalizar.contains(nueva)||this.carrerasFinalizadas.contains(nueva)){
            return false;
        }
        return this.carrerasSinFinalizar.add(nueva);
    }
    
    /**
     * devuelve una lista de corredores que no estén en 
     * la carrera puesta por parametro
     * @param carrera
     * @return 
     */
    public List<Corredor> getCorredoresFueraCarrera(Carrera carrera){
        List<Dorsal> corredoresCarrera = new ArrayList<>(carrera.getCorredores());
        List<Corredor> corredoresLibre =
                new ArrayList<>(Controladora.getInstance()
                        .getGestionCorredores().getCorredores());
        for (Dorsal dorsal : corredoresCarrera) {
            corredoresLibre.remove(dorsal.getCorredor());
        }
      //  corredoresCarrera.forEach((Dorsal dorsal)->corredoresLibre.remove(dorsal.getCorredor()));
        
        return corredoresLibre;
    }

    public List<Carrera> getCarrerasFueraCorredor(Corredor corredor) {
        List<Carrera> carrerasSinCorredor = new ArrayList<>();
        for (CarreraSinFinalizar carrera : carrerasSinFinalizar) {
            boolean carreraValida=true;
            for (Dorsal dorsal : carrera.getCorredores()) {
                if(dorsal.getCorredor().equals(corredor)){
                    carreraValida=false;
                    break;
                }
            }
            if(carreraValida&&carrera.getNumeroParticipantes()>carrera.getCorredores().size()){
                    carrerasSinCorredor.add(carrera);
                }
        }
        return carrerasSinCorredor;
    }
    
}

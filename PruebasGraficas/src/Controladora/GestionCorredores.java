/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.CarreraSinFinalizar;
import Modelo.Corredor;
import Modelo.CorredorException;
import Modelo.Dorsal;
import static Modelo.Utiles.sdf;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adán
 */
public class GestionCorredores implements Serializable{

    private List<Corredor> corredores;

    public GestionCorredores() {
        this.corredores = new ArrayList<>();
    }
    
    public void borrarCorredor(String dni) throws CorredorException{
        Corredor c = new Corredor (dni);
        if(!corredores.contains(c)){
            throw new CorredorException("El corredor no existe");
        }else{
            GestionCarreras gestionCarreras=Controladora.getInstance().getGestionCarreras();
            for (CarreraSinFinalizar carreraSinFinalizar : gestionCarreras.getCarrerasSinFinalizar()) {
                for (Dorsal dorsal : carreraSinFinalizar.getCorredores()) {
                    if(dorsal.getCorredor().equals(c))
                        throw new CorredorException("el corredor está en la carrera '"
                                +carreraSinFinalizar.getNombre()+
                                "' no se puede borrar un corredor en una carrera");
                }
            }
            this.getCorredores().remove(c);
        }
    }

    /**
     * @return the Corredores
     */
    public List<Corredor> getCorredores() {
        return corredores;
    }

    void ordenar() {
        Collections.sort(this.corredores,new Comparator<Corredor>() {
            @Override
            public int compare(Corredor o1, Corredor o2) {
                return o1.getFechaNac().compareTo(o2.getFechaNac());
            }
        });
    }

    public boolean nuevoCorredor(String dni, String nombre, String direccion,
            int numTelefono, Date fechaNac) {
        Corredor nuevo = new Corredor(dni, nombre, direccion, numTelefono, fechaNac);
        if(this.corredores.contains(nuevo))
            return false;
        return this.corredores.add(nuevo);
        }
}

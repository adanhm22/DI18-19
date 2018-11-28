/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Corredor;
import Modelo.CorredorException;
import static Modelo.Utiles.sdf;
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
public class GestionCorredores {

    private List<Corredor> corredores;

    public GestionCorredores() {
        this.corredores = new ArrayList<>();
    }


    /**
     *
     * @param datos
     */
    public void nuevoCorredor(String[] datos) throws CorredorException {
        if(datos==null){
            throw new IllegalArgumentException("El parametro de entrada debe estar inicializado");
        }
        if (datos.length != 5) {
            throw new IllegalArgumentException("El parametro de entrada debe ser un array de 5");
        }
        if(datos[0].equals("")){
            throw new CorredorException("necesita el parametro \"dni\"");
        }
        
        Corredor c = new Corredor(datos[1], datos[0]);
        if (Collections.binarySearch(corredores, c) >= 0) {
            throw new CorredorException("ese corredor ya existe");
        }
        if (datos[2] != null) {
            try {
                c.setFechaNac(sdf.parse(datos[2]));
            } catch (ParseException ex) {
                c.setFechaNac(new Date());
            }
        } else {
            c.setFechaNac(new Date());
        }

        if (datos[3] != null) {
            try {
            c.setTelef(Integer.parseInt(datos[3]));
            }catch (NumberFormatException ex){
            }
        }
        if(datos[4] !=null){
            c.setDireccion(datos[4]);
        }

        this.corredores.add(c);
    }

    /**
     *
     * @param datos
     */
    public void modificarCorredor(String[] datos) throws CorredorException {
        if(datos==null){
            throw new IllegalArgumentException("El parametro de entrada debe estar inicializado");
        }
        if (datos.length != 5) {
            throw new IllegalArgumentException("El parametro de entrada debe ser un array de 5");
        }

        Corredor c = new Corredor(datos[0]);
        int indice = Collections.binarySearch(getCorredores(), c);
        if (indice >= 0) {
            if (datos[1] != null) {
                c.setNombre(datos[1]);
            }
            if (datos[2] != null) {
                try {
                    c.setFechaNac(sdf.parse(datos[2]));
                } catch (ParseException ex) {
                }
            } else {
                c.setFechaNac(new Date());
            }

            if (datos[3] != null) {
                c.setTelef(Integer.parseInt(datos[3]));
            }
              if(datos[4] !=null){
            c.setDireccion(datos[4]);
        }

        } else {
            throw new CorredorException("El corredor no existe");
        }
        this.getCorredores().remove(indice);
        this.getCorredores().add(c);
    }
    
    

    public void borrarCorredor(String dni) throws CorredorException{
        Corredor c = new Corredor (dni);
        int zona = Collections.binarySearch(getCorredores(), c);
        if(zona<0){
            throw new CorredorException("El corredor no existe");
        }else{
            this.getCorredores().remove(zona);
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
    
}

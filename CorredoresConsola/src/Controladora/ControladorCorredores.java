/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Corredor;
import static Modelo.Utiles.sdf;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adán
 */
public class ControladorCorredores {

    private List<Corredor> corredores;

    public ControladorCorredores() {
        this.corredores = new ArrayList<>();
    }


    /**
     *
     * @param datos
     * @return 1=ya existe, -1=fallo en la fecha, 0=ningun problema
     */
    public int nuevoCorredor(String[] datos) {
        if (datos.length != 4) {
            throw new IllegalArgumentException("El parametro de entrada debe ser un array de 4");
        }

        Corredor c = new Corredor(datos[1], datos[0]);
        if (Collections.binarySearch(getCorredores(), c) < 0) {
            return 1;
        }

        if (datos[2] != null) {
            try {
                c.setFechaNac(sdf.parse(datos[2]));
            } catch (ParseException ex) {
                return -1;
            }
        } else {
            c.setFechaNac(new Date());
        }

        if (datos[3] != null) {
            c.setTelef(Integer.parseInt(datos[3]));
        }

        this.corredores.add(c);
        return 0;
    }

    /**
     *
     * @param datos
     * @return 1= no existe corredor -1= error con la fecha 0= ningun fallo
     */
    public int modificarCorredor(String[] datos) {
        if (datos.length != 4) {
            throw new IllegalArgumentException("El parametro de entrada debe ser un array de 4");
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
                    return -1;
                }
            } else {
                c.setFechaNac(new Date());
            }

            if (datos[3] != null) {
                c.setTelef(Integer.parseInt(datos[3]));
            }

        } else {
            return 1;
        }
        this.getCorredores().remove(indice);
        this.getCorredores().add(c);
        return 0;
    }
    
    

    public int borrarCorredor(String dni){
        Corredor c = new Corredor (dni);
        int zona = Collections.binarySearch(getCorredores(), c);
        if(zona<0){
            return 1;
        }else{
            this.getCorredores().remove(zona);
            return 0;
        }
    }

    /**
     * @return the Corredores
     */
    public List<Corredor> getCorredores() {
        return corredores;
    }
    
}

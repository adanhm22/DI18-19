/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Corredor;
import Modelo.GestionFicheros;
import Modelo.Utiles;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Adán
 */
public class ControladoraFicheros extends GestionFicheros {

    public void grabarCorredores(List<Corredor> corredores) throws IOException {
        super.abrirFicheroEscritura("res/corredores.csv");
        for (Corredor corredor : corredores) {
            super.escribirLinea(corredor.getDNI() + "," + corredor.getDireccion()
                    + "," + corredor.getNombre() + "," + corredor.getFechaNac() + ","
                    + corredor.getTelef());
        }
        super.cerrarFicheroEscritura();
    }

    public List<Corredor> leerCorredores() throws IOException{
        super.abrirFicheroLectura("res/corredores.csv");

        List<Corredor> corredores = new ArrayList<>();
        String[] lista = super.leerFichero();
        for (String lista1 : lista) {
            String[] lista2 = lista1.split(",");
            Corredor c = new Corredor(lista2[2], lista2[0]);
            c.setDireccion(lista2[1]);
           /* SimpleDateFormat parser=new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            c.setFechaNac(parser.parse(lista2[3]));*/
            //c.setTelef(Integer.parseInt(lista2[4].trim()));
            System.out.println(c);
        }
        return corredores;
    }

}

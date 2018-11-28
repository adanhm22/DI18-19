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
import Modelo.Utiles;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author alumnop
 */
public class Controladora implements Serializable{

    private GestionCorredores gestionCorredores;
    private GestionCarreras gestionCarreras;
    
    private static Controladora CONTROLADORA;
    
    public static Controladora getInstance()
    {
        if(CONTROLADORA==null){
            File controlador = new File("./controladora.dat");
            if(controlador.exists()){
                ObjectInputStream ois = null;
                try {
                    FileInputStream fis = new FileInputStream(controlador);
                    ois = new ObjectInputStream(fis);
                    CONTROLADORA = (Controladora) ois.readObject();
                } catch (IOException ex) {
                        ex.printStackTrace();
                }   catch (ClassNotFoundException ex) {
                        Exceptions.printStackTrace(ex);
                    } finally {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }
            }else{
                CONTROLADORA=new Controladora();
            }
        }
        return CONTROLADORA;
    }

    private Controladora() {
        this.gestionCorredores = new GestionCorredores();
        this.gestionCarreras=new GestionCarreras();
    }

    private Controladora(GestionCorredores gestionCorredores, GestionCarreras gestionCarreras) {
        this.gestionCorredores = gestionCorredores;
        this.gestionCarreras = gestionCarreras;
    }

    public void borrarCorredor(String dni) throws CorredorException {
        this.gestionCorredores.borrarCorredor(dni);
    }

    public void mostrarCorredores() {
        List<Modelo.Corredor> corredores = gestionCorredores.getCorredores();
        for (Corredor corredore : corredores) {
            System.out.println(corredore);
        }
    }

    public GestionCorredores getGestionCorredores() {
        return gestionCorredores;
    }

    public GestionCarreras getGestionCarreras() {
        return gestionCarreras;
    }

    public void rellenarTablaCarreras(boolean terminada, JTable tabla) {
        
        if(terminada){
            List<CarreraFinalizada> carrerasFinalizadas = this.gestionCarreras.getCarrerasFinalizadas();
            String[] columnas = {"nombre", "lugar", "fecha","participantes","ganador"};
             DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
             String[] campos=new String[5];
             for (CarreraFinalizada carreras : carrerasFinalizadas) {
                campos[0]=carreras.getNombre();
                campos[1]=carreras.getDireccion();
                campos[2]=Utiles.sdf.format(carreras.getFechaCarrera());
                campos[3]=String.valueOf(carreras.getNumeroParticipantes());
                campos[4]=carreras.getNombreGanador();
                dtm.addRow(campos);
            }
             tabla.setModel(dtm);
        }
        else{
            List<CarreraSinFinalizar> carrerasSinFinalizar = this.gestionCarreras.getCarrerasSinFinalizar();
            String[] columnas = {"nombre", "lugar", "fecha","participantes"};
             DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
             String[] campos=new String[4];
             for (CarreraSinFinalizar carreras : carrerasSinFinalizar) {
                campos[0]=carreras.getNombre();
                campos[1]=carreras.getDireccion();
                campos[2]=Utiles.sdf.format(carreras.getFechaCarrera());
                campos[3]=String.valueOf(carreras.getNumeroParticipantes());
                dtm.addRow(campos);
            }
             tabla.setModel(dtm);
            
        }
            
    }

    public void rellenarTablaCorredores(JTable tabla) {
        String[] columnas = {"dni", "nombre", "direccion","telefono","nacimiento"};
             DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
             String[] campos=new String[5];
             for (Corredor corredor : this.gestionCorredores.getCorredores()) {
                 campos[0]=corredor.getDNI();
                 campos[1]=corredor.getNombre();
                 campos[2]=corredor.getDireccion();
                 campos[3]=String.valueOf(corredor.getTelef());
                 campos[4]=Utiles.sdf.format(corredor.getFechaNac());
                 dtm.addRow(campos);
             }
             tabla.setModel(dtm);
    }

    public void rellenarTablaCorredores(JTable tabla, Carrera carrera) {
        String[] columnas = {"dorsal","dni", "nombre", "direccion","telefono","nacimiento"};
             DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
             String[] campos=new String[6];
            for (Dorsal corredor : carrera.getCorredores()) {
                campos[0]=corredor.getDorsal();
                campos[1]=corredor.getCorredor().getDNI();
                campos[2]=corredor.getCorredor().getNombre();
                campos[3]=corredor.getCorredor().getDireccion();
                campos[4]=String.valueOf(corredor.getCorredor().getTelef());
                campos[5]=Utiles.sdf.format(corredor.getCorredor().getFechaNac());
                dtm.addRow(campos);
            }
            tabla.setModel(dtm);
    }
    

}

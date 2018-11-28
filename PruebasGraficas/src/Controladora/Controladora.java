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
import Modelo.Utiles;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumnop
 */
public class Controladora {

    private GestionCorredores gestionCorredores;
    private GestionCarreras gestionCarreras;
    
    private static Controladora CONTROLADORA;
    
    public static Controladora getInstance()
    {
        if(CONTROLADORA==null)
            CONTROLADORA=new Controladora();
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

    public void darAltaCorredor(String[] datos) throws CorredorException {
        gestionCorredores.nuevoCorredor(datos);
    }

    public void modificarCorredor(String[] datos) throws CorredorException {
            gestionCorredores.modificarCorredor(datos);
    }

    public void borrarCorredor(String dni) {
        
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
                campos[5]=carreras.getNombreGanador();
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
            }
             tabla.setModel(dtm);
            
        }
            
    }

    public void rellenarListaCorredores(JTable jTable1) {
        String[] columnas = {"nombre", "lugar", "fecha","participantes"};
             DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
             String[] campos=new String[4];
    }
    

}

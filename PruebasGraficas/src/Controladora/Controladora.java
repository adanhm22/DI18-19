/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Corredor;
import Modelo.CorredorException;
import Modelo.Utiles;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alumnop
 */
public class Controladora {

    private ControladorCorredores cc;
    private ControladoraFicheros cf;

    public Controladora() {
        this.cc = new ControladorCorredores();
        this.cf = new ControladoraFicheros();
    }

    public void darAlta(String[] datos) throws CorredorException {
            cc.nuevoCorredor(datos);
        
    }

    public void modificarCorredor(String[] datos) {
        try {
            cc.modificarCorredor(datos);
        } catch (IllegalArgumentException e) {
            System.out.println("Ha ocurrido un problema, " + e.getMessage());
        } catch (CorredorException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void borrarCorredor(String dni) {
        try {
            cc.borrarCorredor(dni);
        } catch (CorredorException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void mostrarCorredores() {
        List<Modelo.Corredor> corredores = cc.getCorredores();
        for (Corredor corredore : corredores) {
            System.out.println(corredore);
        }
    }

    public void ordenarPorFecha() {
        cc.ordenar();
        this.mostrarCorredores();
    }
    
    public List<Corredor> getCorredores() {
        return this.cc.getCorredores();
    }

    public void rellenarLista(JTable lista) {
       String[] columnas = {"DNI","Nombre","Fecha nac","telf","Direccion"};
       DefaultTableModel dtm = new DefaultTableModel(columnas,0);
        for (Corredor corredore : cc.getCorredores()) {
            String[] campos = new String[5];
            campos[0]=corredore.getDNI();
            campos[1]=corredore.getNombre();
            campos[2]=Utiles.sdf.format(corredore.getFechaNac());
            campos[3]=String.valueOf(corredore.getTelef());
            campos[4]=corredore.getDireccion();
            dtm.addRow(campos);
        }
        lista.setModel(dtm);
    }

}

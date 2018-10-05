/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Corredor;
import Modelo.CorredorException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

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

    public void rellenarLista(JList lista) {
        DefaultListModel dlm = new DefaultListModel();
        for (Corredor corredor: this.cc.getCorredores()){
            dlm.addElement(corredor);
        }
        lista.setModel(dlm);
    }

}

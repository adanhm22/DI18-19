/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.CorredorException;
import Vista.Menu;
import Vista.ObtenerDatos;
import java.io.IOException;

/**
 *
 * @author alumnop
 */
public class Controladora {

    private ControladorCorredores cc;
    private ObtenerDatos od;
    private ControladoraFicheros cf;

    public Controladora() {
        this.cc = new ControladorCorredores();
        this.od = new ObtenerDatos();
        this.cf = new ControladoraFicheros();
    }

    public void iniciar() throws IOException {
        cc.getCorredores().addAll(cf.leerCorredores());
        int opcion;
        Menu menu = new Menu();

        do {
            opcion = menu.menu();
            switch (opcion) {

                case 1:
                    this.darAlta();
                    break;
                case 2:
                    this.modificarCorredor();
                    break;
                case 3:
                    this.borrarCorredor();
                    break;
                case 4:
                    this.mostrarCorredores();
                    break;
                case 5:
                    this.ordenarPorFecha();
                    break;
            }
        } while (opcion != 0);
        cf.grabarCorredores(cc.getCorredores());

    }

    private void darAlta() {
        String[] datos = od.datosNuevoUsuario();
        try {
            cc.nuevoCorredor(datos);
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un problema, " + ex.getMessage());
        }
    }

    private void modificarCorredor() {
        String[] datos = od.datosModificarUsuario(cc);
        try {
            cc.modificarCorredor(datos);
        } catch (IllegalArgumentException e) {
            System.out.println("Ha ocurrido un problema, " + e.getMessage());
        } catch (CorredorException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    private void borrarCorredor() {
        String dni = od.obtenerDni();
        try {
            cc.borrarCorredor(dni);
        } catch (CorredorException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void mostrarCorredores() {
        od.listaCorredores(cc.getCorredores());
    }

    private void ordenarPorFecha() {
        cc.ordenar();
        this.mostrarCorredores();
    }

}

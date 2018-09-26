/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Vista.Menu;
import Vista.ObtenerDatos;

/**
 *
 * @author alumnop
 */
public class Controladora {

    
    private ControladorCorredores cc;
    private ObtenerDatos od;

    public Controladora() {
        this.cc = new ControladorCorredores();
        this.od = new ObtenerDatos();
    }

    public void iniciar(){
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
            }
        } while (opcion != 0);

    }

    private void darAlta() {
       String[] datos = od.datosNuevoUsuario();
       cc.nuevoCorredor(datos);
    }

    private void modificarCorredor() {
        String[] datos = od.datosModificarUsuario(cc);
        cc.modificarCorredor(datos);
    }

    private void borrarCorredor() {
        String dni = od.obtenerDni();
        cc.borrarCorredor(dni);
    }

}

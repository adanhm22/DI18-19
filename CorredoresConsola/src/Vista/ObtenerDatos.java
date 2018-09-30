/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladorCorredores;
import Modelo.Corredor;
import Modelo.Utiles;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Adán
 */
public class ObtenerDatos {

    public String[] datosModificarUsuario(ControladorCorredores controladorCorredores) {
        String[] datos = new String[5];
         boolean salida = false;
        do{
        System.out.println("Introduce DNI");
        datos[0] = Utiles.teclado.nextLine();
        if(datos[0].length()!=9){
            System.out.println("el dni introducido no es correcto");
        }else{
            salida= true;
        }
        }while(!salida);
        Corredor c = new Corredor(datos[0]);
        int zona = Collections.binarySearch(controladorCorredores.getCorredores(), c);
        if (zona < 0) {
            System.out.println("no existe el usuario");
            return null;
            // throw new
        }
        c = controladorCorredores.getCorredores().get(zona);
        String eleccion = "";
        salida = false;
        do {
            System.out.println("\u00bfQuieres modificar el nombre?");
            eleccion = Utiles.teclado.nextLine();
            if (!eleccion.toLowerCase().equals("si")) {
                if (!eleccion.toLowerCase().equals("no")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            } else if (!eleccion.toLowerCase().equals("no")) {
                if (!eleccion.toLowerCase().equals("si")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            }
        } while (!salida);
        if (eleccion.toLowerCase().equals("si")) {
            System.out.print("antiguo nombre: " + c.getNombre() + " nuevo nombre: ");
            datos[1] = Utiles.teclado.nextLine();
        }else{
            datos[1] = c.getNombre();
        }
        eleccion = "";
        salida = false;
        do {
            System.out.println("\u00bfQuieres modificar la fecha de nacimiento?");
            eleccion = Utiles.teclado.nextLine();
            if (!eleccion.toLowerCase().equals("si")) {
                if (!eleccion.toLowerCase().equals("no")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            } else if (!eleccion.toLowerCase().equals("no")) {
                if (!eleccion.toLowerCase().equals("si")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            }
        } while (!salida);
        if (eleccion.toLowerCase().equals("si")) {
            eleccion = "";
            salida = false;
            System.out.println("introduce el a\u00f1o de nacimiento");
            int anio = Integer.parseInt(Utiles.teclado.nextLine());
            System.out.println("introduce el numero del mes");
            int mes = Integer.parseInt(Utiles.teclado.nextLine());
            System.out.println("introduce el dia de nacimiento");
            int dia = Integer.parseInt(Utiles.teclado.nextLine());
            datos[2] = dia + "/" + mes + "/" + anio;
        }else{
            datos[2] = c.getFechaNac().getDay() + "/" + c.getFechaNac().getMonth() + "/" + c.getFechaNac().getYear()+1900;
        }
        eleccion = "";
        salida = false;
        do {
            System.out.println("\u00bfQuieres a\u00f1adir el numero de telefono?");
            eleccion = Utiles.teclado.nextLine();
            if (!eleccion.toLowerCase().equals("si")) {
                if (!eleccion.toLowerCase().equals("no")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            } else if (!eleccion.toLowerCase().equals("no")) {
                if (!eleccion.toLowerCase().equals("si")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            }
        } while (!salida);
        if (eleccion.toLowerCase().equals("si")) {
            System.out.print("Antiguo numero: " + c.getTelef() + " nuevo num: ");
            datos[3] = Utiles.teclado.nextLine();
        }else{
            datos[3] = String.valueOf(c.getTelef());
        }
        eleccion = "";
        salida = false;
        do {
            System.out.println("\u00bfQuieres a\u00f1adir la direccion?");
            eleccion = Utiles.teclado.nextLine();
            if (!eleccion.toLowerCase().equals("si")) {
                if (!eleccion.toLowerCase().equals("no")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            } else if (!eleccion.toLowerCase().equals("no")) {
                if (!eleccion.toLowerCase().equals("si")) {
                    System.out.println("valor introducido incorrecto, solo est\u00e1n permitidos si y no");
                } else {
                    salida = true;
                }
            }
        } while (!salida);
        if (eleccion.toLowerCase().equals("si")) {
            System.out.print("Antigua direccion: " + c.getDireccion()+ " nueva direccion: ");
            datos[4] = Utiles.teclado.nextLine();
        }else{
            datos[4] = c.getDireccion();
        }
        return datos;
    }

    public String[] datosNuevoUsuario() {
        
        String[] datos = new String[5];
        boolean salida = false;
        do{
        System.out.println("Introduce DNI");
        datos[0] = Utiles.teclado.nextLine();
        if(datos[0].length()!=9){
            System.out.println("el dni introducido no es correcto");
        }else{
            salida= true;
        }
        }while(!salida);
        System.out.println("Introduce el nombre");
        datos[1] = Utiles.teclado.nextLine();
        System.out.println("introduce el a\u00f1o de nacimiento");
        int anio = Integer.parseInt(Utiles.teclado.nextLine());
        System.out.println("introduce el numero del mes");
        int mes = Integer.parseInt(Utiles.teclado.nextLine());
        System.out.println("introduce el dia de nacimiento");
        int dia = Integer.parseInt(Utiles.teclado.nextLine());
        datos[2] = dia + "/" + mes + "/" + anio;
        System.out.println("Introduce el numero de telefono");
        datos[3] = Utiles.teclado.nextLine();
        System.out.println("introduce la direccion del corredor");
        datos[4] = Utiles.teclado.nextLine();
        return datos;
    }

    public String obtenerDni() {
        String dni;
        System.out.println("Introduce DNI");
        dni = Utiles.teclado.nextLine();
        return dni;
    }

    public void listaCorredores(List<Corredor> corredores) {
        for (Corredor corredore : corredores) {
            System.out.println(corredore);
        }
    }

}

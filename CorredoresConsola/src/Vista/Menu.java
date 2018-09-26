/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Modelo.Utiles.teclado;

/**
 *
 * @author Adán
 */
public class Menu {
    
    public int menu(){
        int opcion;
        
        System.out.println("Introduce opción");
        System.out.println("1- Dar de alta");
        System.out.println("2- Modificar corredor");
        System.out.println("3- Borrar corredor");
        System.out.println("0- Salir \n");
        
        opcion = Integer.parseInt(teclado.nextLine());
        if(opcion>3||opcion<0){
            System.out.println("Has introducido un valor no valido\n");
            return -1;
        }
        return opcion;
    }
}

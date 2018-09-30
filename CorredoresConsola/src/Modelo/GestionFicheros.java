/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adán
 */
public class GestionFicheros {

    private File ficheroLeer, ficheroEscribir;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;

    public class GestionFicherosException extends Exception {

    }

    //abrir y cerrar
    public void abrirFicheroLectura(String ruta) {
        if (fr == null) {
            this.ficheroLeer = new File(ruta);
            try {
                this.fr = new FileReader(ficheroLeer);
                this.br = new BufferedReader(fr);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El fichero ya está abierto");
        }
    }

    public void cerrarFicheroLectura() {
        if (fr != null) {
            try {
                this.fr.close();
                this.br.close();
                this.fr = null;
                this.bw = null;
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El fichero ya está cerrado");
        }
    }

    public void abrirFicheroEscritura(String ruta) {
        if (fw == null) {
            this.ficheroEscribir = new File(ruta);
            try {
                this.fw = new FileWriter(ficheroEscribir);
                this.bw = new BufferedWriter(fw);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El fichero ya está abierto");
        }
    }

    public void cerrarFicheroEscritura() {
        if (fw != null) {
            try {
                this.bw.flush();
                this.fw.close();
                this.bw.close();
                this.fw = null;
                this.bw = null;
            } catch (IOException ex) {
                Logger.getLogger(GestionFicheros.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("El fichero ya está cerrado");
        }
    }

    //leer y escribir
    public String leerLinea() throws IOException {
        if (fr != null) {
            if(!this.ficheroLeer.exists()){
                return null;
            }
            String linea = null;
            linea = br.readLine();
            return linea;
        } else {
            System.out.println("Se necesita abrir el fichero primero");
            return null;
        }
    }

    public String[] leerFichero() throws IOException {
        List<String> lineas = new ArrayList<>();
        if (fr != null) {
            boolean salir=false;
            do{
                String linea = br.readLine();
                if(linea==null){
                    salir=true;
                }else{
                    lineas.add(linea);
                }
            }while(!salir);
        } else {
            System.out.println("tienes que abrir primero el archivo");
        }
        String[] retornar = new String[lineas.size()];
        for (int i = 0; i < retornar.length; i++) {
            retornar[i]=lineas.get(i);
        }
        return retornar;
    }

    public void escribirLinea(String linea) throws IOException {
        if (this.fw != null) {
            bw.write(linea);
        } else {
            System.out.println("Se necesita abrir el fichero primero");
        }
    }

    public void escribirVariasLineas(String[] lineas) throws IOException {
        if (this.fw != null) {
            for (String linea : lineas) {
                bw.write(linea + "\n");
            }
        } else {
            System.out.println("Se necesita abrir el fichero primero");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import Modelo.Carrera;
import Modelo.CarreraFinalizada;
import Modelo.CarreraSinFinalizar;
import Modelo.Configuracion;
import Modelo.Corredor;
import Modelo.CorredorException;
import Modelo.Dorsal;
import Modelo.Utiles;
import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author alumnop
 */
public class Controladora implements Serializable{

    private Configuracion conf;
    private transient Timer rutina;
    private GestionCorredores gestionCorredores;
    private GestionCarreras gestionCarreras;
    
    private static Controladora CONTROLADORA;
    
    private Controladora() {
        this.gestionCorredores = new GestionCorredores();
        this.gestionCarreras=new GestionCarreras();
        this.conf=new Configuracion(true, UIManager.getInstalledLookAndFeels()[1], 1);
        if(conf.isTemporizadorActivado()){
            this.rutina=new Timer();
            this.rutina.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                            Controladora.grabarControladoraObjeto();
                        } catch (IOException ex) {
                            Exceptions.printStackTrace(ex);
                        }
                    }
            }, 0,conf.getMinutos()*60*1000);
        }
    }
    
    public static Controladora getInstance()
    {
        if(CONTROLADORA==null){
            try {
                CONTROLADORA=leerControladoraObjeto();
                if(CONTROLADORA==null)
                    CONTROLADORA=new Controladora();
            } catch (IOException | ClassNotFoundException ex) {
                Exceptions.printStackTrace(ex);
                CONTROLADORA=new Controladora();
            }
        }
        return CONTROLADORA;
    }
    
    public GestionCorredores getGestionCorredores() {
        return gestionCorredores;
    }

    public GestionCarreras getGestionCarreras() {
        return gestionCarreras;
    }

    public Configuracion getConf() {
        return conf;
    }
    

    public static Controladora leerControladoraObjeto() throws FileNotFoundException, IOException, ClassNotFoundException{
        File controlador = new File("controladora.dat");
            if(controlador.exists()){
                ObjectInputStream ois = null;
                FileInputStream fis = new FileInputStream(controlador);
                ois = new ObjectInputStream(fis);
                Controladora controladora = (Controladora) ois.readObject();
                ois.close();
                return controladora;
            }else{
                return null;
            }
    }
    
    public void cambiarConfiguracion(Configuracion conf,Component componente) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
        UIManager.setLookAndFeel(conf.getLookAndFeel().getClassName());
        SwingUtilities.updateComponentTreeUI(componente);
        if(this.rutina!=null){
            this.rutina.cancel();
            this.rutina=null;
        }
        if(conf.isTemporizadorActivado()){
            this.rutina=new Timer();
            this.rutina.schedule(new TimerTask() {
                @Override
                public void run() {
                    try {
                        Controladora.grabarControladoraObjeto();
                    } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                    }
 }
            }, 0,conf.getMinutos()*60*1000);
        }
        this.conf=conf;
    }
    
    public static void grabarControladoraObjeto() throws IOException{
        ObjectOutputStream oos = null;
        FileOutputStream fos = new FileOutputStream("controladora.dat");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(Controladora.getInstance());
        oos.close();
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

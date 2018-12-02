/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author adan
 */
public class Configuracion implements Serializable{
    private boolean temporizadorActivado;
    private transient LookAndFeelInfo lookAndFeel;
    private int minutos;

    public Configuracion(boolean temporizadorActivado, LookAndFeelInfo lookAndFeel, int minutos) {
        this.temporizadorActivado = temporizadorActivado;
        this.lookAndFeel = lookAndFeel;
        this.minutos = minutos;
    }

    public boolean isTemporizadorActivado() {
        return temporizadorActivado;
    }

    public void setTemporizadorActivado(boolean temporizadorActivado) {
        this.temporizadorActivado = temporizadorActivado;
    }

    public LookAndFeelInfo getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(LookAndFeelInfo lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "temporizadorActivado=" + temporizadorActivado + ", lookAndFeel=" + lookAndFeel + ", minutos=" + minutos + '}';
    }
    
    
}

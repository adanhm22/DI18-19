/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import Modelo.Dorsal;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alumnop
 */
public class Temporizador extends JLabel implements Serializable{
    
    private int horas,minutos,segundos;
    private List<TemporizadorListener> listeners;
    private List<Dorsal> dorsales;
    private int numClicks;
    private transient Timer timer;
    private transient MouseListener clickListener;

    public Temporizador() {
        listeners=new ArrayList<>();
        clickListener= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                if(numClicks>0){
                    numClicks--;
                    Dorsal dorsal = null;
                    int tiempo= (segundos+(60*minutos+(60*60*horas)));
                    if(!dorsales.isEmpty()){
                        do{
                dorsal=(Dorsal) JOptionPane.showInputDialog(
                        null, "Corredor con "+tiempo+" segundos",
                        null, JOptionPane.QUESTION_MESSAGE, null,
                        dorsales.toArray(),
                        dorsales.get(0));
                } while(dorsal==null);
                        dorsales.remove(dorsal);
                    }
                for (TemporizadorListener listener : listeners)
                    listener.onClick(dorsal,numClicks, horas,minutos,segundos);
                if(numClicks<=0){
                    for (TemporizadorListener listener : listeners)
                        listener.finalizar(horas,minutos,segundos);
                    timer.cancel();
                }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        };
        addMouseListener(clickListener);
        setText("0:0:0");
        dorsales=new ArrayList<>();
    }

    public int getNumClicks() {
        return numClicks;
    }

    public void setNumClicks(int numClicks) {
        this.numClicks = numClicks;
    }
    
    public boolean addListeners(TemporizadorListener... listeners){
        return this.listeners.addAll(Arrays.asList(listeners));
    }

    public List<TemporizadorListener> getListeners() {
        return listeners;
    }

    public List<Dorsal> getDorsales() {
        return dorsales;
    }

    public void setDorsales(List<Dorsal> dorsales) {
        this.dorsales = new ArrayList<>(dorsales);
    }
    
    public void start(){
        horas=0;
        segundos=0;
        minutos=0;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                    setText(String.format("%d:%d:%d",horas,minutos,segundos));
                    segundos+=1;
                    formatearTiempo();
            }
        }, 0, 1000);
            
    }
    
    public void registrarLlegada(){
        clickListener.mouseClicked(null);
    }
    
    private void formatearTiempo(){
        if(segundos>59){
            minutos++;
            segundos=0;
        }
        if(minutos>59){
            horas++;
            minutos=0;
        }
            
    }
    
}

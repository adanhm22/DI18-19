/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author alumnop
 */
public class Temporizador extends JLabel implements Serializable{
    private long tiempo;
    private int horas,segundos,minutos;
    private List<TemporizadorListener> listeners;
    private int numClicks,numClicksRestantes;
    private transient Timer timer;
    private transient MouseListener clickListener;

    public Temporizador() {
        listeners=new ArrayList<>();
        clickListener= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(timer!=null){
                    numClicksRestantes--;
                    
                    for (TemporizadorListener listener : listeners)
                            listener.onClick(numClicksRestantes, horas,minutos,segundos);
                    if(numClicksRestantes<=0){
                        for (TemporizadorListener listener : listeners)
                            listener.finalizar(horas,minutos,segundos);
                        timer.cancel();
                        timer=null;
                        numClicksRestantes=numClicks;
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
    
    public void start(){
        horas=0;
        minutos=0;
        segundos=0;
        if(timer!=null)
            timer.cancel();
        timer = new Timer();
        numClicksRestantes=numClicks;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private List<TemporizadorListener> listeners;
    private int numClicks;
    private transient Timer timer;
    private transient MouseListener clickListener;

    public Temporizador() {
        listeners=new ArrayList<>();
        clickListener= new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                numClicks--;
                if(numClicks>0)
                for (TemporizadorListener listener : listeners)
                    listener.onClick(numClicks, tiempo);
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
        tiempo=0l;
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(numClicks<=0){
                    for (TemporizadorListener listener : listeners)
                        listener.finalizar(tiempo);
                    timer.cancel();
                }else{
                    setText(String.format("%s:%s:%s",
                            Math.round((tiempo>60*60*60)?tiempo%(60*60*60):tiempo/(60*60)),
                            Math.round((tiempo>60*60)?tiempo%(60*60):tiempo/(60)),
                            Math.round(tiempo%60)));
                    tiempo+=1l;
                }
            }
        }, 0, 100);
            
    }
    
    public void registrarClick(){
        clickListener.mouseClicked(null);
    }
    
}

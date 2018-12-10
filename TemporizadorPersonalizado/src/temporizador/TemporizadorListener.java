/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import Modelo.Dorsal;
import java.io.Serializable;

/**
 *
 * @author alumnop
 */
public interface TemporizadorListener extends Serializable{
    public void onClick(Dorsal dorsal,int restantes,int horas,int minutos,int segundos);
    public void finalizar(int horas,int minutos,int segundos);
}

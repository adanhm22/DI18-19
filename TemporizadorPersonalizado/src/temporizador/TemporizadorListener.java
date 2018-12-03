/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporizador;

import java.io.Serializable;

/**
 *
 * @author alumnop
 */
public interface TemporizadorListener extends Serializable{
    public void onClick(int restantes,float tiempo);
    public void finalizar(float tiempo);
}

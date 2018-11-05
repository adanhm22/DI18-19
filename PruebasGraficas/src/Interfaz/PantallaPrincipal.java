/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.openide.util.Exceptions;

/**
 *
 * @author alumnop
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private Controladora con;

    /**
     * Creates new form PantallaPrincipal
     */

    public PantallaPrincipal() {
        initComponents();
        con = new Controladora();
        Image icono = new ImageIcon(getClass().getResource("/images/icono.png")).getImage();
        setIconImage(icono);
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            JMenuItem ji = new JMenuItem(info.getName());
            this.lookfeel.add(ji);
        }
        

    }
    
    private void cambiarLookFeel (String name ){
        System.out.println(name);
        for (UIManager.LookAndFeelInfo installedLookAndFeel : UIManager.getInstalledLookAndFeels()) {
            if(name.equals(installedLookAndFeel.getName())){
                try {
                    UIManager.setLookAndFeel(installedLookAndFeel.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (ClassNotFoundException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (InstantiationException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (IllegalAccessException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Exceptions.printStackTrace(ex);
                }
                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        alta = new javax.swing.JButton();
        botonNueva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonLCarreras = new javax.swing.JButton();
        jButtonLCorredores = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        lookfeel = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Pantalla Principal");

        alta.setText("Corredor");
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });

        botonNueva.setText("Carrera");
        botonNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaActionPerformed(evt);
            }
        });

        jLabel2.setText("Crear nuevo/a");

        jButtonLCarreras.setText("Lista de carreras");
        jButtonLCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLCarrerasActionPerformed(evt);
            }
        });

        jButtonLCorredores.setText("Lista de corredores");
        jButtonLCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLCorredoresActionPerformed(evt);
            }
        });

        jLabel3.setText("Mostrar listas");

        menu.setText("Configuracion");
        menu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });

        lookfeel.setText("Look&Feel");
        lookfeel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lookfeelItemStateChanged(evt);
            }
        });
        lookfeel.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                lookfeelMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
        });
        menu.add(lookfeel);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(175, 175, 175))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(botonNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(alta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButtonLCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonLCorredores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed
        // TODO add your handling code here:
        AltaUsuario au = new AltaUsuario(this, true, con);
        au.setVisible(true);
    }//GEN-LAST:event_altaActionPerformed

    private void botonNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaActionPerformed
        // TODO add your handling code here:
        NuevaCarrera nc = new NuevaCarrera(this, true,con);
        nc.setVisible(true);
    }//GEN-LAST:event_botonNuevaActionPerformed

    private void jButtonLCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLCarrerasActionPerformed
        // TODO add your handling code here:
        if(con.getListaCarrera().isEmpty())
            JOptionPane.showMessageDialog(this, "la lista está vacía","lista vacia",JOptionPane.ERROR_MESSAGE);
        else
            new ListaCarreras(this, true,con).setVisible(true);
    }//GEN-LAST:event_jButtonLCarrerasActionPerformed

    private void jButtonLCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLCorredoresActionPerformed
        // TODO add your handling code here:
        if(con.getCorredores().isEmpty()){
            JOptionPane.showMessageDialog(this, "la lista está vacía","lista vacia",JOptionPane.ERROR_MESSAGE);
        }else{
        new ListaCorredores(this,true,con).setVisible(true);
        }
    }//GEN-LAST:event_jButtonLCorredoresActionPerformed

    private void menuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuMenuSelected
        // TODO add your handling code here:
       
    }//GEN-LAST:event_menuMenuSelected

    private void lookfeelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lookfeelItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lookfeelItemStateChanged

    private void lookfeelMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_lookfeelMenuSelected
        // TODO add your handling code here:
        System.out.println(evt.toString());
    }//GEN-LAST:event_lookfeelMenuSelected

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Locale.setDefault(new Locale("es", "ES"));
                new PantallaPrincipal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JButton botonNueva;
    private javax.swing.JButton jButtonLCarreras;
    private javax.swing.JButton jButtonLCorredores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu lookfeel;
    private javax.swing.JMenu menu;
    // End of variables declaration//GEN-END:variables
}

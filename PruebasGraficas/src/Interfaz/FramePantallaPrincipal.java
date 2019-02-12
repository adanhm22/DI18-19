/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import Modelo.Configuracion;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.openide.util.Exceptions;

/**
 *
 * @author alumnop
 */
public class FramePantallaPrincipal extends javax.swing.JFrame {

    private Controladora con;

    /**
     * Creates new form PantallaPrincipal
     */

    public FramePantallaPrincipal() {
        initComponents();
        con = Controladora.getInstance();
        Image icono = new ImageIcon(getClass().getResource("/images/corredor.png")).getImage();
        setIconImage(icono);
        UIManager.installLookAndFeel(new UIManager.LookAndFeelInfo("JTatoo", com.jtattoo.plaf.smart.SmartLookAndFeel.class.getName()));
        for (final UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            JMenuItem ji = new JMenuItem(info.getName());
            this.lookfeel.add(ji);
            ji.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   cambiarLookFeel(info.getName());
                }
            });
        }
        setLocationRelativeTo(null);
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Controladora.grabarControladoraObjeto();   
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        } );
        
        //poner imagen
        imagen.setIcon(new ImageIcon("src/images/portada.png"));
        imagen.setText("");
        setTitle("Pantalla principal");
        try {
            Controladora.getInstance().aniadirAyuda(getContentPane(), "index");
        } catch (HelpSetException | MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    private void cambiarLookFeel (String name ){
        for (UIManager.LookAndFeelInfo installedLookAndFeel : UIManager.getInstalledLookAndFeels()) {
            if(name.equals(installedLookAndFeel.getName())){
                try {
                    Configuracion conf = Controladora.getInstance().getConf();
                    conf.setLookAndFeel(installedLookAndFeel);
                    Controladora.getInstance().cambiarConfiguracion(conf, this);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
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

        jMenu1 = new javax.swing.JMenu();
        botonCorredores = new javax.swing.JButton();
        botonCarreras = new javax.swing.JButton();
        botonConfiguracion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        lookfeel = new javax.swing.JMenu();
        configuracion = new javax.swing.JMenuItem();
        jMenuInformes = new javax.swing.JMenu();
        itemCarrerasNoFinalizadas = new javax.swing.JMenuItem();
        itemInformeCarrera = new javax.swing.JMenuItem();
        itemClasificacionCarrera = new javax.swing.JMenuItem();
        itemInformeCorredor = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));

        botonCorredores.setText("Gestion Corredores");
        botonCorredores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCorredoresActionPerformed(evt);
            }
        });

        botonCarreras.setText("Gestion Carreras");
        botonCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarrerasActionPerformed(evt);
            }
        });

        botonConfiguracion.setText("Configuracion");
        botonConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfiguracionActionPerformed(evt);
            }
        });

        jLabel1.setText("<html><body>Hecho por Adán<br>2ª Dam Sotrondio</body></html>");

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setText("imagen");

        menu.setText("Menu");

        lookfeel.setText("Look&Feel");
        menu.add(lookfeel);

        configuracion.setText("Configuracion");
        configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configuracionActionPerformed(evt);
            }
        });
        menu.add(configuracion);

        jMenuInformes.setText("Informes");

        itemCarrerasNoFinalizadas.setText("Lista de carreras no finalizadas");
        jMenuInformes.add(itemCarrerasNoFinalizadas);

        itemInformeCarrera.setText("informe sobre carrera");
        jMenuInformes.add(itemInformeCarrera);

        itemClasificacionCarrera.setText("clasificacion de una carrera");
        jMenuInformes.add(itemClasificacionCarrera);

        itemInformeCorredor.setText("informe sobre corredor");
        jMenuInformes.add(itemInformeCorredor);

        menu.add(jMenuInformes);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonConfiguracion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCarreras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addComponent(botonCorredores)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCorredores, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonConfiguracion)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarrerasActionPerformed
        // TODO add your handling code here:
        new DialogCarreras(this, true).setVisible(true);
    }//GEN-LAST:event_botonCarrerasActionPerformed

    private void botonCorredoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCorredoresActionPerformed
        // TODO add your handling code here:
        new DialogCorredores(this, true).setVisible(true);
    }//GEN-LAST:event_botonCorredoresActionPerformed

    private void botonConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfiguracionActionPerformed
        // TODO add your handling code here:
        new DialogConfiguracion(this, true).setVisible(true);
    }//GEN-LAST:event_botonConfiguracionActionPerformed

    private void configuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configuracionActionPerformed
        // TODO add your handling code here:
         new DialogConfiguracion(this, true).setVisible(true);
    }//GEN-LAST:event_configuracionActionPerformed

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
            java.util.logging.Logger.getLogger(FramePantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Locale.setDefault(new Locale("es", "ES"));
                new FramePantallaPrincipal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCarreras;
    private javax.swing.JButton botonConfiguracion;
    private javax.swing.JButton botonCorredores;
    private javax.swing.JMenuItem configuracion;
    private javax.swing.JLabel imagen;
    private javax.swing.JMenuItem itemCarrerasNoFinalizadas;
    private javax.swing.JMenuItem itemClasificacionCarrera;
    private javax.swing.JMenuItem itemInformeCarrera;
    private javax.swing.JMenuItem itemInformeCorredor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuInformes;
    private javax.swing.JMenu lookfeel;
    private javax.swing.JMenu menu;
    // End of variables declaration//GEN-END:variables
}

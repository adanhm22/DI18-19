/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import Controladora.GestionCarreras;
import Controladora.GestionCorredores;
import Modelo.Carrera;
import Modelo.CarreraSinFinalizar;
import java.net.MalformedURLException;
import java.util.List;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author alumnop
 */
public class DialogCarreras extends javax.swing.JDialog {

    /**
     * Creates new form DialogCarreras
     */
    public DialogCarreras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarDialog();
    }

    public DialogCarreras(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarDialog();
        parent.dispose();
    }

    private void iniciarDialog() {
        setLocationRelativeTo(null);
        //poner imagen
        imagen.setIcon(new ImageIcon("src/images/corredores.png"));
        imagen.setText("");
        comprobarCarreras();
        setTitle("Gestion de carreras");
        try {
            Controladora.getInstance().aniadirAyuda(getContentPane(), "gestion_carreras");
        } catch (HelpSetException | MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    
    
    private void comprobarCarreras() {

        

        GestionCarreras gestionCarreras
                = Controladora.getInstance().getGestionCarreras();

        if (gestionCarreras.getCarrerasFinalizadas().isEmpty()
                && gestionCarreras.getCarrerasSinFinalizar().isEmpty()) {
            this.botonIniciarCarrera.setEnabled(false);
            this.botonConsultarCarrera.setEnabled(false);
            
            this.errores.setText("no hay ninguna carrera creada");
        } else {
                this.botonConsultarCarrera.setEnabled(true);
                GestionCorredores gestionCorredores
                    = Controladora.getInstance().getGestionCorredores();

            if (gestionCorredores.getCorredores().isEmpty()) {
                this.botonIniciarCarrera.setEnabled(false);
                this.errores.setText("No hay ningun corredor creado");

            } else {
                this.botonIniciarCarrera.setEnabled(true);
                this.errores.setText("");
            }
            if(gestionCarreras.getCarrerasSinFinalizar().isEmpty()){
                this.botonIniciarCarrera.setEnabled(false);
                this.errores.setText("no hay ninguna carrera sin Disponible");
            }else{
                this.botonIniciarCarrera.setEnabled(true);
                this.errores.setText("");
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
        botonCarrera = new javax.swing.JButton();
        botonIniciarCarrera = new javax.swing.JButton();
        botonConsultarCarrera = new javax.swing.JButton();
        botonInicio = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        errores = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DialogCarreras.class, "DialogCarreras.jLabel1.text")); // NOI18N

        botonCarrera.setText(org.openide.util.NbBundle.getMessage(DialogCarreras.class, "DialogCarreras.botonCarrera.text")); // NOI18N
        botonCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCarreraActionPerformed(evt);
            }
        });

        botonIniciarCarrera.setText(org.openide.util.NbBundle.getMessage(DialogCarreras.class, "DialogCarreras.botonIniciarCarrera.text")); // NOI18N
        botonIniciarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarCarreraActionPerformed(evt);
            }
        });

        botonConsultarCarrera.setText(org.openide.util.NbBundle.getMessage(DialogCarreras.class, "DialogCarreras.botonConsultarCarrera.text")); // NOI18N
        botonConsultarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarCarreraActionPerformed(evt);
            }
        });

        botonInicio.setText(org.openide.util.NbBundle.getMessage(DialogCarreras.class, "DialogCarreras.botonInicio.text")); // NOI18N
        botonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioActionPerformed(evt);
            }
        });

        imagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagen.setText(org.openide.util.NbBundle.getMessage(DialogCarreras.class, "DialogCarreras.imagen.text")); // NOI18N

        errores.setForeground(new java.awt.Color(206, 41, 41));
        errores.setText(org.openide.util.NbBundle.getMessage(DialogCarreras.class, "DialogCarreras.errores.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonConsultarCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(errores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonIniciarCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(jLabel1))
                            .addComponent(botonInicio))
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonCarrera)
                        .addGap(18, 18, 18)
                        .addComponent(botonIniciarCarrera))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(botonConsultarCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInicio)
                    .addComponent(errores))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonInicioActionPerformed

    private void botonIniciarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarCarreraActionPerformed
        // TODO add your handling code here:
        List<CarreraSinFinalizar> carreras=Controladora.getInstance().
                getGestionCarreras().getCarrerasSinFinalizar();
        Carrera carreraSinFinalizar = (Carrera) JOptionPane.showInputDialog(this, 
                "selecciona carrera", "seleccionar carrera", 
                JOptionPane.QUESTION_MESSAGE, null,carreras.toArray(),carreras.get(0));
        if(carreraSinFinalizar!=null)
            new DialogIniciarCarreras(this, true, (CarreraSinFinalizar) carreraSinFinalizar).setVisible(true);
        comprobarCarreras();
    }//GEN-LAST:event_botonIniciarCarreraActionPerformed

    private void botonConsultarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarCarreraActionPerformed
        // TODO add your handling code here:
        new DialogConsultarCarreras(this, true).setVisible(true);
        comprobarCarreras();
    }//GEN-LAST:event_botonConsultarCarreraActionPerformed

    private void botonCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCarreraActionPerformed
        // TODO add your handling code here:
        new DialogAltaCarrera(this, true).setVisible(true);
        comprobarCarreras();
    }//GEN-LAST:event_botonCarreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCarrera;
    private javax.swing.JButton botonConsultarCarrera;
    private javax.swing.JButton botonIniciarCarrera;
    private javax.swing.JButton botonInicio;
    private javax.swing.JLabel errores;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

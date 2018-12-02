/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import Controladora.GestionCarreras;
import Modelo.Carrera;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author adan
 */
public class DialogAltaCarrera extends javax.swing.JDialog {

    private Carrera carreraModificar;
    /**
     * Creates new form DialogAltaCarrera
     */
    public DialogAltaCarrera(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.botonCrearCarrera.setEnabled(false);
        ValidationGroup grupo= validation.getValidationGroup();
        grupo.add(this.nombre, StringValidators.REQUIRE_NON_EMPTY_STRING);
        grupo.add(this.direccion, StringValidators.REQUIRE_NON_EMPTY_STRING);
        validation.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(validation.getProblem()==null)
                    botonCrearCarrera.setEnabled(true);
                else
                    botonCrearCarrera.setEnabled(false);
            }
        });
    }
    
    public DialogAltaCarrera(java.awt.Dialog parent, boolean modal,Carrera carreraModificar){
        this(parent,modal);
        this.carreraModificar=carreraModificar;
        this.botonCrearCarrera.setText("Modificar");
        this.direccion.setText(carreraModificar.getDireccion());
        this.nombre.setText(carreraModificar.getNombre());
        this.fecha.setValue(carreraModificar.getFechaCarrera());
        this.participantes.setValue(carreraModificar.getNumeroParticipantes());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAtras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        botonCrearCarrera = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        fecha = new javax.swing.JSpinner();
        participantes = new javax.swing.JSpinner();
        validation = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        botonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonAtras.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.botonAtras.text")); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.jLabel1.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.jLabel2.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.jLabel3.text")); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.jLabel4.text")); // NOI18N

        jLabel5.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.jLabel5.text")); // NOI18N

        botonCrearCarrera.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.botonCrearCarrera.text")); // NOI18N
        botonCrearCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearCarreraActionPerformed(evt);
            }
        });

        nombre.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.nombre.text")); // NOI18N

        direccion.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.direccion.text")); // NOI18N

        fecha.setModel(new javax.swing.SpinnerDateModel());

        participantes.setModel(new javax.swing.SpinnerNumberModel(4, 2, null, 1));

        botonLimpiar.setText(org.openide.util.NbBundle.getMessage(DialogAltaCarrera.class, "DialogAltaCarrera.botonLimpiar.text")); // NOI18N
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAtras)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(validation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre)
                                    .addComponent(direccion)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(participantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(botonCrearCarrera))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtras)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(participantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLimpiar)
                    .addComponent(botonCrearCarrera))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonCrearCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCarreraActionPerformed
        // TODO add your handling code here:
        GestionCarreras gestion = Controladora.getInstance().getGestionCarreras();
        if(carreraModificar==null){
        if(gestion.nuevaCarrera(nombre.getText(),direccion.getText(),(Date)fecha.getValue(),(int) participantes.getValue())){
            JOptionPane.showMessageDialog(this, "se ha añadido una carrera");
            this.botonLimpiarActionPerformed(evt);
        }else{
            JOptionPane.showMessageDialog(this, "la carrera ya existe",null,JOptionPane.ERROR_MESSAGE);
        }
        }else{
            Carrera carrera = new Carrera(nombre.getText().trim(), null, null, 0);
            if((!gestion.getCarrerasSinFinalizar().contains(carrera)
                    ||!gestion.getCarrerasFinalizadas().contains(carrera))
                    ||carrera.getNombre().equals(carreraModificar.getNombre())){
                if(carreraModificar.getNumeroParticipantes()>=(int)participantes.getValue()){
                    JOptionPane.showMessageDialog(this,
                            "hay más corredores en la carrera que numero máximo de participantes"
                            ,null,JOptionPane.ERROR_MESSAGE);
                }else{
                carreraModificar.setNombre(carrera.getNombre());
                carreraModificar.setDireccion(direccion.getText().trim());
                carreraModificar.setFechaCarrera((Date) fecha.getValue());
                carreraModificar.setNumeroParticipantes((int) participantes.getValue()); 
                dispose();
                }
            }else{
                JOptionPane.showMessageDialog(this, "la carrera ya existe",null,JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botonCrearCarreraActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        this.nombre.setText("");
        this.direccion.setText("");
        this.fecha.setValue(new Date());
        this.participantes.setValue(4);
    }//GEN-LAST:event_botonLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonCrearCarrera;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JTextField direccion;
    private javax.swing.JSpinner fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombre;
    private javax.swing.JSpinner participantes;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validation;
    // End of variables declaration//GEN-END:variables
}

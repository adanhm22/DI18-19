/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;

/**
 *
 * @author alumnop
 */
public class DialogConsultarCarreras extends javax.swing.JDialog {


    /**
     * Creates new form DialogConsultarCarreras
     */
    public DialogConsultarCarreras(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.botonSTerminar.setEnabled(false);
        setLocationRelativeTo(null);
        rellenarTabla(false);
    }

    private void rellenarTabla(boolean terminada){
            Controladora.getInstance().rellenarTablaCarreras(terminada,this.tabla);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonParticipantes = new javax.swing.JButton();
        botonSTerminar = new javax.swing.JButton();
        botonTerminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCarreras.class, "DialogConsultarCarreras.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCarreras.class, "DialogConsultarCarreras.jLabel1.text")); // NOI18N

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        botonModificar.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCarreras.class, "DialogConsultarCarreras.botonModificar.text")); // NOI18N

        botonEliminar.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCarreras.class, "DialogConsultarCarreras.botonEliminar.text")); // NOI18N

        botonParticipantes.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCarreras.class, "DialogConsultarCarreras.botonParticipantes.text")); // NOI18N

        botonSTerminar.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCarreras.class, "DialogConsultarCarreras.botonSTerminar.text")); // NOI18N
        botonSTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSTerminarActionPerformed(evt);
            }
        });

        botonTerminar.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCarreras.class, "DialogConsultarCarreras.botonTerminar.text")); // NOI18N
        botonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(botonParticipantes))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonSTerminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonTerminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSTerminar)
                    .addComponent(botonTerminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonModificar)
                    .addComponent(botonEliminar)
                    .addComponent(botonParticipantes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonSTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSTerminarActionPerformed
        // TODO add your handling code here:
        this.botonSTerminar.setEnabled(false);
        this.botonTerminar.setEnabled(true);
        this.botonModificar.setEnabled(true);
        this.botonModificar.setEnabled(true);
        rellenarTabla(false);
    }//GEN-LAST:event_botonSTerminarActionPerformed

    private void botonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarActionPerformed
        // TODO add your handling code here:
        this.botonTerminar.setEnabled(false);
        this.botonSTerminar.setEnabled(true);
        this.botonModificar.setEnabled(false);
        this.botonModificar.setEnabled(false);
        rellenarTabla(true);
    }//GEN-LAST:event_botonTerminarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonParticipantes;
    private javax.swing.JButton botonSTerminar;
    private javax.swing.JButton botonTerminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

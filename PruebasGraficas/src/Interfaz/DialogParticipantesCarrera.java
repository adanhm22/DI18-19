/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import Modelo.Carrera;
import Modelo.CarreraFinalizada;
import Modelo.CarreraSinFinalizar;
import Modelo.Corredor;
import Modelo.Dorsal;
import Modelo.Utiles;
import java.net.MalformedURLException;
import java.util.List;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Exceptions;

/**
 *
 * @author adan
 */
public class DialogParticipantesCarrera extends javax.swing.JDialog {

    private Carrera carrera;
    /**
     * Creates new form DialogParticipantesCarrera
     */
    public DialogParticipantesCarrera(java.awt.Dialog parent, boolean modal,Carrera carrera) {
        super(parent, modal);
        initComponents();
        this.carrera=carrera;
        if(carrera instanceof CarreraFinalizada){
            this.botonAniadir.setEnabled(false);
            this.botonBorrar.setEnabled(false);
        }
        rellenarTabla();
        setLocationRelativeTo(null);
        setTitle("participantes de la carrera "+carrera.getNombre());
        try {
            Controladora.getInstance().aniadirAyuda(getContentPane(), "participantes");
        } catch (HelpSetException | MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
    
    public void rellenarTabla() {
        if(carrera instanceof CarreraSinFinalizar)
            rellenarTablaNoFinalizada();
        else
            rellenarTablaFinalizada();           
    }
    
    private void rellenarTablaNoFinalizada(){
        String[] columnas = {"dorsal","dni", "nombre","nacimiento"};
        DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
        String[] campos=new String[4];
            for (Dorsal corredor : carrera.getCorredores()) {
                campos[0]=corredor.getDorsal();
                campos[1]=corredor.getCorredor().getDNI();
                campos[2]=corredor.getCorredor().getNombre();
                campos[3]=Utiles.sdf.format(corredor.getCorredor().getFechaNac());
                dtm.addRow(campos);
            }
        tabla.setModel(dtm);
    }
    
    private void rellenarTablaFinalizada() {
        String[] columnas = {"puesto","dorsal","dni", "nombre","nacimiento"};
        DefaultTableModel dtm = new DefaultTableModel(columnas, 0);
        String[] campos=new String[7];
        int posicion=1;
        for (Dorsal corredor : carrera.getCorredores()) {
           campos[0]=String.valueOf(posicion);
           posicion++;
           campos[1]=corredor.getDorsal();
           campos[2]=corredor.getCorredor().getDNI();
           campos[3]=corredor.getCorredor().getNombre();
           campos[4]=Utiles.sdf.format(corredor.getCorredor().getFechaNac());
           dtm.addRow(campos);
       }
       tabla.setModel(dtm);
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
        botonBorrar = new javax.swing.JButton();
        botonAniadir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonCrearCorredor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText(org.openide.util.NbBundle.getMessage(DialogParticipantesCarrera.class, "DialogParticipantesCarrera.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DialogParticipantesCarrera.class, "DialogParticipantesCarrera.jLabel1.text")); // NOI18N

        botonBorrar.setText(org.openide.util.NbBundle.getMessage(DialogParticipantesCarrera.class, "DialogParticipantesCarrera.botonBorrar.text")); // NOI18N
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonAniadir.setText(org.openide.util.NbBundle.getMessage(DialogParticipantesCarrera.class, "DialogParticipantesCarrera.botonAniadir.text")); // NOI18N
        botonAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirActionPerformed(evt);
            }
        });

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

        botonCrearCorredor.setText(org.openide.util.NbBundle.getMessage(DialogParticipantesCarrera.class, "DialogParticipantesCarrera.botonCrearCorredor.text")); // NOI18N
        botonCrearCorredor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearCorredorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(botonCrearCorredor)
                                .addGap(64, 64, 64))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(botonAniadir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBorrar)
                    .addComponent(botonAniadir)
                    .addComponent(botonCrearCorredor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirActionPerformed
        // TODO add your handling code here:
        //sale lista en la que selecciona un corredor para añadirlo
        if(carrera.getNumeroParticipantes()>carrera.getCorredores().size()){
        List<Corredor> corredores = Controladora.getInstance()
                .getGestionCarreras().getCorredoresFueraCarrera(carrera);
        if(corredores.size()>0){
        Corredor corredorAniadir = (Corredor) JOptionPane.showInputDialog(
                this, "seleciona corredor","añadir corredor"
                , JOptionPane.QUESTION_MESSAGE, null, corredores.toArray()
                , corredores.get(0));
        if(corredorAniadir!=null){
            String dorsal;
            do{
            dorsal = JOptionPane.showInputDialog("introduce dorsal");
            if(carrera.getCorredores().contains(new Dorsal(dorsal, corredorAniadir)))
                JOptionPane.showMessageDialog(this, "el dorsal ya existe");
            
            }while(carrera.getCorredores().contains(new Dorsal(dorsal, corredorAniadir)));
            if(dorsal!=null){
                Dorsal dorsalAniadir=new Dorsal(dorsal, corredorAniadir);
            carrera.getCorredores().add(dorsalAniadir);
            JOptionPane.showMessageDialog(this, "se ha añadido el corredor");
            }
            
        rellenarTabla();
        }
        }else{
            JOptionPane.showMessageDialog(this, "no hay corredores para añadir");
        }
        }else
            JOptionPane.showMessageDialog(this, "se ha alcanzado el numero máximo de corredores");
    }//GEN-LAST:event_botonAniadirActionPerformed

    private void botonCrearCorredorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCorredorActionPerformed
        // TODO add your handling code here:
        new DialogAltaCorredor(this, true).setVisible(true);
    }//GEN-LAST:event_botonCrearCorredorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:
        if(tabla.getSelectedRow()>=0){
            carrera.getCorredores().remove(tabla.getSelectedRow());
            rellenarTabla();
        }else{
             JOptionPane.showMessageDialog(this, "no has seleccionado corredor");
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAniadir;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCrearCorredor;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    
}

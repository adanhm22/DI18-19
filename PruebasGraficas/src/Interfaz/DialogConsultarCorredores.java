/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import Controladora.GestionCarreras;
import Modelo.Carrera;
import Modelo.Corredor;
import Modelo.CorredorException;
import Modelo.Dorsal;
import java.net.MalformedURLException;
import java.util.List;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;

/**
 *
 * @author alumnop
 */
public class DialogConsultarCorredores extends javax.swing.JDialog {

    /**
     * Creates new form DialogConsultarCorredores
     */
    public DialogConsultarCorredores(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        rellenarTabla();
        setTitle("consultarCorredores");
                try {
            Controladora.getInstance().aniadirAyuda(getContentPane(), "consultar_corredores");
        } catch (HelpSetException | MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void rellenarTabla(){
        Controladora.getInstance().rellenarTablaCorredores(tabla);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        botonModificar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonAniadirCarrera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonAtras.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCorredores.class, "DialogConsultarCorredores.botonAtras.text")); // NOI18N
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCorredores.class, "DialogConsultarCorredores.jLabel1.text")); // NOI18N

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

        botonModificar.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCorredores.class, "DialogConsultarCorredores.botonModificar.text")); // NOI18N
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonBorrar.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCorredores.class, "DialogConsultarCorredores.botonBorrar.text")); // NOI18N
        botonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed(evt);
            }
        });

        botonAniadirCarrera.setText(org.openide.util.NbBundle.getMessage(DialogConsultarCorredores.class, "DialogConsultarCorredores.botonAniadirCarrera.text")); // NOI18N
        botonAniadirCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(botonAtras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(botonModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(botonBorrar)
                        .addGap(45, 45, 45)
                        .addComponent(botonAniadirCarrera)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtras)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonModificar)
                    .addComponent(botonBorrar)
                    .addComponent(botonAniadirCarrera))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void botonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBorrarActionPerformed
        // TODO add your handling code here:
        if(tabla.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this, "no has seleccionado corredor");
        }else{
        int seleccion = JOptionPane.showConfirmDialog(this,"estás seguro de borrar el corredor?");
        if(seleccion==JOptionPane.OK_OPTION){
                try {
                    String dni = Controladora.getInstance()
                            .getGestionCorredores().getCorredores()
                            .get(this.tabla.getSelectedRow()).getDNI();
                    Controladora.getInstance().borrarCorredor(dni);
                    rellenarTabla();
                    JOptionPane.showMessageDialog(this, "el corredor se ha borrado");
                    if(Controladora.getInstance()
                            .getGestionCorredores().getCorredores().isEmpty())
                        dispose();
                } catch (CorredorException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage());
                }
            if(Controladora.getInstance().getGestionCorredores().getCorredores().isEmpty())
                dispose();
        }
        }
    }//GEN-LAST:event_botonBorrarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        // TODO add your handling code here:
        Corredor corredor = Controladora.getInstance().getGestionCorredores().getCorredores().get(this.tabla.getSelectedRow());
        new DialogAltaCorredor(this,true, corredor).setVisible(true);
        rellenarTabla();
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonAniadirCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirCarreraActionPerformed
        // TODO add your handling code here:
        if(tabla.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(this, "no has seleccionado corredor");
        }else{
            Corredor corredor = Controladora.getInstance().getGestionCorredores()
                    .getCorredores().get(tabla.getSelectedRow());
            GestionCarreras gestion = Controladora.getInstance().getGestionCarreras();
            List<Carrera> carreras = gestion.getCarrerasFueraCorredor(corredor);
            if(carreras.isEmpty())
                JOptionPane.showMessageDialog(this,"no hay carreras disponibles");
            else{
                Carrera carreraAniadir = (Carrera) JOptionPane.showInputDialog(
                this, "seleciona carrera","añadir carrera"
                , JOptionPane.QUESTION_MESSAGE, null, carreras.toArray()
                , carreras.get(0));
                if(carreraAniadir!=null){
            String dorsal;
            do{
            dorsal = JOptionPane.showInputDialog("introduce dorsal");
            if(carreraAniadir.getCorredores().contains(new Dorsal(dorsal, corredor)))
                JOptionPane.showMessageDialog(this, "el dorsal ya existe");
            }while(carreraAniadir.getCorredores().contains(new Dorsal(dorsal, corredor)));
            if(dorsal!=null){
            Dorsal dorsalAniadir=new Dorsal(dorsal, corredor);
            carreraAniadir.getCorredores().add(dorsalAniadir);
            JOptionPane.showMessageDialog(this, "Se ha añadido el corredor a la carrera");
            }
            rellenarTabla();
            }
        }
        }
    }//GEN-LAST:event_botonAniadirCarreraActionPerformed

  
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAniadirCarrera;
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import Modelo.CarreraSinFinalizar;
import Modelo.Dorsal;
import Modelo.Utiles;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.help.HelpSetException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.openide.util.Exceptions;
import temporizador.TemporizadorListener;

/**
 *
 * @author alumnop
 */
public class DialogIniciarCarreras extends javax.swing.JDialog {

    private File ficheroExportado;
    private CarreraSinFinalizar carreraEnCurso;
    List<Dorsal> dorsales;
    /**
     * Creates new form DialogIniciarCarreras
     */
    public DialogIniciarCarreras(java.awt.Dialog parent, boolean modal,CarreraSinFinalizar carrera) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.dorsales=new ArrayList<>();
        this.carreraEnCurso=carrera;
        comprobarCarrera();
        this.temporizador2.addListeners(new TemporizadorListener() {
            @Override
            public void onClick(int restantes, int horas,int minutos,int segundos) {
                Dorsal dorsalInput;
                List<Dorsal> dorsalest=new ArrayList<>(carreraEnCurso.getCorredores());
                dorsalest.removeAll(dorsales);
                int tiempo= (segundos+(60*minutos+(60*60*horas)));
                do{
                dorsalInput=(Dorsal) JOptionPane.showInputDialog(
                        DialogIniciarCarreras.this, "Corredor con "+tiempo+" segundos",
                        null, JOptionPane.QUESTION_MESSAGE, null,
                        dorsalest.toArray(),
                        dorsalest.get(0));
                } while(dorsalInput==null);
                Dorsal dorsalAniadir= 
                new Dorsal(dorsalInput.getDorsal(), dorsalInput.getCorredor()
                        ,horas,minutos,segundos);
                dorsales.add(dorsales.size(), dorsalAniadir);
                }
            @Override
            public void finalizar(int horas,int minutos,int segundos) {
                if(ficheroExportado==null){
                    ficheroExportado=new File("CarreraExportada");
                    if(!ficheroExportado.exists()){
                        ficheroExportado.mkdir();
                    }
                }
                    if(ficheroExportado.exists()&&ficheroExportado.isDirectory()){
                        File ficheroTXT = new File(
                        ficheroExportado.getAbsoluteFile()
                        +File.separator+"carrera "
                        +carreraEnCurso.getNombre()+".txt");
                        try {
                            FileWriter fos = new FileWriter(ficheroTXT);
                            BufferedWriter bos = new BufferedWriter(fos);
                            bos.write(carreraEnCurso.getNombre()+"\r\n");
                            bos.write(Utiles.sdf.format(carreraEnCurso.getFechaCarrera())+"\r\n");
                            for (Dorsal dorsal : dorsales) {
                                bos.write(dorsal.getDorsal()+
                                        "\t"+horas+":"+minutos+":"+segundos
                                        +"\t"+dorsal.getCorredor().getNombre()+"\r\n");
                            }
                            bos.flush();
                            bos.close();
                            fos.close();
                        } catch (FileNotFoundException ex) {
                            Exceptions.printStackTrace(ex);
                        } catch (IOException ex) {
                            Exceptions.printStackTrace(ex);
                        }finally{
                            Controladora.getInstance().finalizarCarrera(carreraEnCurso, dorsales);
                            new DialogResultados(DialogIniciarCarreras.this, true, dorsales).setVisible(true);
                        }
                        
                    }
                        
            }
        });
        this.temporizador2.setNumClicks(carreraEnCurso.getCorredores().size());
        setTitle("iniciar carrera "+this.carreraEnCurso.getNombre());
        try {
            Controladora.getInstance().aniadirAyuda(getContentPane(), "iniciar_carrera");
        } catch (HelpSetException | MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    public void comprobarCarrera(){
        if(carreraEnCurso.getCorredores().size()<2){
            error.setText("la carrera debe tener al menos 2 participantes");
            this.botonIniciar.setEnabled(false);
        }else{
            error.setText("");
            this.botonIniciar.setEnabled(true);
            this.temporizador2.setNumClicks(carreraEnCurso.getCorredores().size());
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

        jSpinner1 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botonParticipantes = new javax.swing.JButton();
        botonIniciar = new javax.swing.JButton();
        botonUnidad = new javax.swing.JButton();
        error = new javax.swing.JLabel();
        temporizador2 = new temporizador.Temporizador();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText(org.openide.util.NbBundle.getMessage(DialogIniciarCarreras.class, "DialogIniciarCarreras.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DialogIniciarCarreras.class, "DialogIniciarCarreras.jLabel1.text")); // NOI18N

        botonParticipantes.setText(org.openide.util.NbBundle.getMessage(DialogIniciarCarreras.class, "DialogIniciarCarreras.botonParticipantes.text")); // NOI18N
        botonParticipantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonParticipantesActionPerformed(evt);
            }
        });

        botonIniciar.setText(org.openide.util.NbBundle.getMessage(DialogIniciarCarreras.class, "DialogIniciarCarreras.botonIniciar.text")); // NOI18N
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });

        botonUnidad.setText(org.openide.util.NbBundle.getMessage(DialogIniciarCarreras.class, "DialogIniciarCarreras.botonUnidad.text")); // NOI18N
        botonUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUnidadActionPerformed(evt);
            }
        });

        error.setForeground(new java.awt.Color(235, 20, 20));
        error.setText(org.openide.util.NbBundle.getMessage(DialogIniciarCarreras.class, "DialogIniciarCarreras.error.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1))
                    .addComponent(error)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonUnidad)
                            .addComponent(botonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonParticipantes)
                            .addComponent(temporizador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonIniciar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temporizador2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonParticipantes)
                    .addComponent(botonUnidad))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUnidadActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showSaveDialog(this);
        ficheroExportado = chooser.getSelectedFile();
    }//GEN-LAST:event_botonUnidadActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
        // TODO add your handling code here:
        if(!botonIniciar.getText().equals("registrar llegada")){
            this.temporizador2.start();
            this.botonIniciar.setText("registrar llegada");
        }else{
            this.temporizador2.registrarLlegada();
        }
    }//GEN-LAST:event_botonIniciarActionPerformed

    private void botonParticipantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonParticipantesActionPerformed
        // TODO add your handling code here:
        new DialogParticipantesCarrera(this, true, carreraEnCurso).setVisible(true);
        comprobarCarrera();
    }//GEN-LAST:event_botonParticipantesActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonParticipantes;
    private javax.swing.JButton botonUnidad;
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSpinner jSpinner1;
    private temporizador.Temporizador temporizador2;
    // End of variables declaration//GEN-END:variables
}

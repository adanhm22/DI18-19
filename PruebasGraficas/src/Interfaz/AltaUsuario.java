/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controladora.Controladora;
import Modelo.Corredor;
import Modelo.CorredorException;
import Modelo.Utiles;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.validation.api.builtin.stringvalidation.Integer_no_negativo_no_requerido;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author alumnop
 */
public class AltaUsuario extends javax.swing.JDialog {

    private Controladora con;
    private Corredor corredor;

    /**
     * Creates new form AltaUsuario
     */
    public AltaUsuario(java.awt.Frame parent, boolean modal, Controladora con) {
        super(parent, modal);
        initComponents();
        this.con = con;
        botonValidacion.setEnabled(false);
        ValidationGroup group = validationPanel.getValidationGroup();
        group.add(dniTexto, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(nombreTexto, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(telefonoTexto, new Integer_no_negativo_no_requerido());

        validationPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel.getProblem() == null) {
                    botonValidacion.setEnabled(true);
                } else {
                    botonValidacion.setEnabled(false);
                }
            }
        });
        setLocationRelativeTo(null);
    }

    public AltaUsuario(java.awt.Dialog parent, boolean modal, Corredor corredor) {
        super(parent, modal);
        initComponents();
        this.corredor = corredor;
        this.dniTexto.setText(corredor.getDNI());
        this.nombreTexto.setText(this.corredor.getNombre());
        this.direccionTexto.setText(this.corredor.getDireccion());
        this.fecha.setValue(this.corredor.getFechaNac());
        this.telefonoTexto.setText(String.valueOf(this.corredor.getTelef()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonValidacion = new javax.swing.JButton();
        panelPrincipal = new javax.swing.JPanel();
        telefonoTexto = new javax.swing.JTextField();
        dniTexto = new javax.swing.JTextField();
        etiquetaDni = new javax.swing.JLabel();
        etiquetaNombre = new javax.swing.JLabel();
        fecha = new javax.swing.JSpinner();
        nombreTexto = new javax.swing.JTextField();
        direccionTexto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonLimpiar = new javax.swing.JButton();
        exito = new javax.swing.JLabel();
        validationPanel = new org.netbeans.validation.api.ui.swing.ValidationPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        botonValidacion.setText("Validar");
        botonValidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonValidacionActionPerformed(evt);
            }
        });

        telefonoTexto.setName("telefono"); // NOI18N

        dniTexto.setName("dni"); // NOI18N

        etiquetaDni.setText("DNI");

        etiquetaNombre.setText("Nombre");

        fecha.setModel(new javax.swing.SpinnerDateModel());

        nombreTexto.setName("nombre"); // NOI18N
        nombreTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextoActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha nacimiento");

        jLabel2.setText("Numero Telefono");

        jLabel3.setText("Direccion");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(etiquetaDni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dniTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaNombre)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefonoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(direccionTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaDni)
                    .addComponent(dniTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botonLimpiar.setText("Limpiar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(exito))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonValidacion)
                            .addComponent(botonLimpiar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(validationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonLimpiar)
                .addGap(18, 18, 18)
                .addComponent(botonValidacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exito))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonValidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonValidacionActionPerformed
        // TODO add your handling code here:
        if (!this.dniTexto.getText().equals("")) {
            if (corredor != null) {
                this.corredor.setNombre(this.nombreTexto.getText());
                this.corredor.setDireccion(this.direccionTexto.getText());
                try {
                    this.corredor.setTelef(Integer.parseInt(this.telefonoTexto.getText()));
                } catch (NumberFormatException n) {
                    this.corredor.setTelef(0);
                }
                this.corredor.setFechaNac((Date) this.fecha.getValue());
                this.corredor.setDNI(this.dniTexto.getText());
                JOptionPane.showMessageDialog(this, "se ha modificado al corredor", "Corredor modificado", JOptionPane.INFORMATION_MESSAGE);

            } else {
                String[] datos = new String[5];
                datos[0] = this.dniTexto.getText();
                datos[1] = this.nombreTexto.getText();
                Date fechaNac = (Date) this.fecha.getValue();
                datos[2] = Utiles.sdf.format(fechaNac);
                datos[3] = this.telefonoTexto.getText();
                datos[4] = this.direccionTexto.getText();

                try {
                    con.darAlta(datos);
                    JOptionPane.showMessageDialog(this, "el corredor con dni '" + datos[0] + "' ha sido añadido", "Corredor añadido", JOptionPane.INFORMATION_MESSAGE);
                } catch (CorredorException | IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "el dni no debe estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonValidacionActionPerformed

    private void nombreTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextoActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        // TODO add your handling code here:
        this.direccionTexto.setText("");
        this.dniTexto.setText("");
        this.nombreTexto.setText("");
        this.telefonoTexto.setText("");
        this.fecha.setValue(new Date());
    }//GEN-LAST:event_botonLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonValidacion;
    private javax.swing.JTextField direccionTexto;
    private javax.swing.JTextField dniTexto;
    private javax.swing.JLabel etiquetaDni;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel exito;
    private javax.swing.JSpinner fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombreTexto;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField telefonoTexto;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel;
    // End of variables declaration//GEN-END:variables
}

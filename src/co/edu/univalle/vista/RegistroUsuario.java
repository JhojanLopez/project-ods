/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.vista;

import co.edu.univalle.controlador.CtrRegistroUsuario;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JHOJAN L
 */
public class RegistroUsuario extends javax.swing.JFrame {

    /**
     * Creates new form RegistroUsuario
     */
    public RegistroUsuario() {
        initComponents();
        CtrRegistroUsuario ctrl = new CtrRegistroUsuario(this);
        jbRegistrar.addActionListener(ctrl);
        jbAtras.addActionListener(ctrl);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbAtras = new javax.swing.JButton();
        jcTipoUsuario = new javax.swing.JComboBox<>();
        jlUsuario = new javax.swing.JLabel();
        jlTipoUsuario = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jlEdad = new javax.swing.JLabel();
        jlGenero = new javax.swing.JLabel();
        jlPassword = new javax.swing.JLabel();
        jcGenero = new javax.swing.JComboBox<>();
        jtPassword = new javax.swing.JTextField();
        jtUsuario = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jbRegistrar = new javax.swing.JButton();
        jtEdad = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("NUEVO USUARIO");

        jbAtras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAtras.setText("Atras");

        jcTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Profesor", "Estudiante" }));

        jlUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlUsuario.setText("Usuario:");

        jlTipoUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTipoUsuario.setText("Tipo de usuario:");

        jlNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlNombre.setText("Nombre:");

        jlEdad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlEdad.setText("Edad:");

        jlGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlGenero.setText("Genero:");

        jlPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlPassword.setText("Contraseña:");

        jcGenero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Femenino", "Masculino" }));

        jtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbRegistrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbRegistrar.setText("OK");

        jtEdad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jtEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtEdadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jbAtras)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlGenero)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlTipoUsuario)
                                            .addComponent(jlEdad)
                                            .addComponent(jlPassword)
                                            .addComponent(jlNombre)
                                            .addComponent(jlUsuario))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jtPassword)
                                            .addComponent(jcTipoUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jcGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jtUsuario)
                                            .addComponent(jtNombre)
                                            .addComponent(jtEdad)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(313, 313, 313)
                        .addComponent(jbRegistrar)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbAtras)
                            .addComponent(jLabel1))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlTipoUsuario))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlUsuario))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNombre))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jlEdad))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlGenero)
                    .addComponent(jcGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPassword)
                    .addComponent(jtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jbRegistrar)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtEdadActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAtras;
    private javax.swing.JButton jbRegistrar;
    private javax.swing.JComboBox<String> jcGenero;
    private javax.swing.JComboBox<String> jcTipoUsuario;
    private javax.swing.JLabel jlEdad;
    private javax.swing.JLabel jlGenero;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlTipoUsuario;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JFormattedTextField jtEdad;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPassword;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {

        getJtNombre().setText("");
        getJtUsuario().setText("");
        getJtEdad().setText("");
        getJtPassword().setText("");
        getJcTipoUsuario().setSelectedIndex(0);
        getJcGenero().setSelectedIndex(0);

    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JButton getJbAtras() {
        return jbAtras;
    }

    public void setJbAtras(JButton jbAtras) {
        this.jbAtras = jbAtras;
    }

    public JButton getJbRegistrar() {
        return jbRegistrar;
    }

    public void setJbRegistrar(JButton jbRegistrar) {
        this.jbRegistrar = jbRegistrar;
    }

    public JComboBox<String> getJcGenero() {
        return jcGenero;
    }

    public void setJcGenero(JComboBox<String> jcGenero) {
        this.jcGenero = jcGenero;
    }

    public JComboBox<String> getJcTipoUsuario() {
        return jcTipoUsuario;
    }

    public void setJcTipoUsuario(JComboBox<String> jcTipoUsuario) {
        this.jcTipoUsuario = jcTipoUsuario;
    }

    public JLabel getJlEdad() {
        return jlEdad;
    }

    public void setJlEdad(JLabel jlEdad) {
        this.jlEdad = jlEdad;
    }

    public JLabel getJlGenero() {
        return jlGenero;
    }

    public void setJlGenero(JLabel jlGenero) {
        this.jlGenero = jlGenero;
    }

    public JLabel getJlNombre() {
        return jlNombre;
    }

    public void setJlNombre(JLabel jlNombre) {
        this.jlNombre = jlNombre;
    }

    public JLabel getJlPassword() {
        return jlPassword;
    }

    public void setJlPassword(JLabel jlPassword) {
        this.jlPassword = jlPassword;
    }

    public JLabel getJlTipoUsuario() {
        return jlTipoUsuario;
    }

    public void setJlTipoUsuario(JLabel jlTipoUsuario) {
        this.jlTipoUsuario = jlTipoUsuario;
    }

    public JLabel getJlUsuario() {
        return jlUsuario;
    }

    public void setJlUsuario(JLabel jlUsuario) {
        this.jlUsuario = jlUsuario;
    }

    public JFormattedTextField getJtEdad() {
        return jtEdad;
    }

    public void setJtEdad(JFormattedTextField jtEdad) {
        this.jtEdad = jtEdad;
    }

    public JTextField getJtNombre() {
        return jtNombre;
    }

    public void setJtNombre(JTextField jtNombre) {
        this.jtNombre = jtNombre;
    }

    public JTextField getJtPassword() {
        return jtPassword;
    }

    public void setJtPassword(JTextField jtPassword) {
        this.jtPassword = jtPassword;
    }

    public JTextField getJtUsuario() {
        return jtUsuario;
    }

    public void setJtUsuario(JTextField jtUsuario) {
        this.jtUsuario = jtUsuario;
    }

}

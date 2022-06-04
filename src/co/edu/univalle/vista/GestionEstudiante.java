/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.vista;

import co.edu.univalle.controlador.*;
import co.edu.univalle.modelo.Administrador;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author JHOJANL
 */
public class GestionEstudiante extends javax.swing.JInternalFrame {

    public static String ventanaEstudianteActiva;
    Administrador adminLog;
    private DefaultTableModel modelo;
    
    
    public GestionEstudiante(Administrador adminLog) {
        
        ventanaEstudianteActiva = "ventana activa";

        this.adminLog = adminLog;
        initComponents();
        CtrGestionEstudiante ctrl = new CtrGestionEstudiante(this, this.adminLog);
        jbMostrar.addActionListener(ctrl);
        jbCrear.addActionListener(ctrl);
        jbBuscar.addActionListener(ctrl);
        jbEliminar.addActionListener(ctrl);
        jbLimpiar.addActionListener(ctrl);
        jbModificar.addActionListener(ctrl);
        jbAgregaFilas.addActionListener(ctrl);
        jbEliminarFila.addActionListener(ctrl);
       
        modelo = (DefaultTableModel) jtablaGestionEstudiante.getModel();//establecemos el modelo
//        modelo.
       
//        this.jtablaGestionAdministrador.setModel(new gestionAdminTableModel());
//        addCheckbox(5);
//      
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtablaGestionEstudiante = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbBuscar = new javax.swing.JButton();
        jcBuscar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtBusqueda = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jbCrear = new javax.swing.JButton();
        jcAgregar = new javax.swing.JComboBox<>();
        jbModificar = new javax.swing.JButton();
        jcModificar = new javax.swing.JComboBox<>();
        jcEliminar = new javax.swing.JComboBox<>();
        jbEliminar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbMostrar = new javax.swing.JButton();
        jbAgregaFilas = new javax.swing.JButton();
        jbEliminarFila = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(850, 550));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ESTUDIANTES");

        jtablaGestionEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Usuario", "Edad", "Genero", "Contrasena", "Clase", "Avatar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtablaGestionEstudiante);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));

        jbBuscar.setText("Buscar..");

        jcBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Codigo", "Nombre", "Usuario" }));

        jLabel5.setText("Accion:");

        jLabel6.setText("Parametro:");

        jtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBuscar)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcBuscar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtBusqueda))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbBuscar)
                            .addComponent(jtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));

        jbCrear.setText("Crear..");

        jcAgregar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Seleccionado" }));

        jbModificar.setText("Modificar..");

        jcModificar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Seleccionado" }));

        jcEliminar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Seleccionado" }));

        jbEliminar.setText("Eliminar..");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcEliminar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcModificar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcAgregar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbCrear)
                        .addGap(18, 18, 18)
                        .addComponent(jbModificar)
                        .addGap(18, 18, 18)
                        .addComponent(jbEliminar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jcAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jcModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jcEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jbLimpiar.setText("Limpiar tabla");

        jbMostrar.setText("Mostrar todos");

        jbAgregaFilas.setText("+");

        jbEliminarFila.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbEliminarFila)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAgregaFilas)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jbLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbMostrar)
                    .addComponent(jbAgregaFilas)
                    .addComponent(jbEliminarFila))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLimpiar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBusquedaActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
       // TODO add your handling code here:
        ventanaEstudianteActiva = null;
    }//GEN-LAST:event_formInternalFrameClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregaFilas;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCrear;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbEliminarFila;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JComboBox<String> jcAgregar;
    private javax.swing.JComboBox<String> jcBuscar;
    private javax.swing.JComboBox<String> jcEliminar;
    private javax.swing.JComboBox<String> jcModificar;
    private javax.swing.JTextField jtBusqueda;
    private javax.swing.JTable jtablaGestionEstudiante;
    // End of variables declaration//GEN-END:variables

    public Administrador getAdminLog() {
        return adminLog;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public void setAdminLog(Administrador adminLog) {
        this.adminLog = adminLog;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JButton getJbAgregaFilas() {
        return jbAgregaFilas;
    }

    public void setJbAgregaFilas(JButton jbAgregaFilas) {
        this.jbAgregaFilas = jbAgregaFilas;
    }

    
    public JButton getJbCrear() {
        return jbCrear;
    }

    public void setJbAgregar(JButton jbAgregar) {
        this.jbCrear = jbAgregar;
    }

    public JButton getJbBuscar() {
        return jbBuscar;
    }

    public void setJbBuscar(JButton jbBuscar) {
        this.jbBuscar = jbBuscar;
    }

    public JButton getJbEliminarFila() {
        return jbEliminarFila;
    }

    public void setJbEliminarFila(JButton jbEliminarFila) {
        this.jbEliminarFila = jbEliminarFila;
    }
    
    

    public JButton getJbEliminar() {
        return jbEliminar;
    }

    public void setJbEliminar(JButton jbEliminar) {
        this.jbEliminar = jbEliminar;
    }

    public JButton getJbLimpiar() {
        return jbLimpiar;
    }

    public void setJbLimpiar(JButton jbLimpiar) {
        this.jbLimpiar = jbLimpiar;
    }

    public JButton getJbModificar() {
        return jbModificar;
    }

    public void setJbModificar(JButton jbModificar) {
        this.jbModificar = jbModificar;
    }

    public JButton getJbMostrar() {
        return jbMostrar;
    }

    public void setJbMostrar(JButton jbMostrar) {
        this.jbMostrar = jbMostrar;
    }

    public JComboBox<String> getJcAgregar() {
        return jcAgregar;
    }

    public void setJcAgregar(JComboBox<String> jcAgregar) {
        this.jcAgregar = jcAgregar;
    }

    public JComboBox<String> getJcBuscar() {
        return jcBuscar;
    }

    public void setJcBuscar(JComboBox<String> jcBuscar) {
        this.jcBuscar = jcBuscar;
    }

    public JComboBox<String> getJcEliminar() {
        return jcEliminar;
    }

    public void setJcEliminar(JComboBox<String> jcEliminar) {
        this.jcEliminar = jcEliminar;
    }

    public JComboBox<String> getJcModificar() {
        return jcModificar;
    }

    public void setJcModificar(JComboBox<String> jcModificar) {
        this.jcModificar = jcModificar;
    }

    public JTextField getJtBusqueda() {
        return jtBusqueda;
    }

    public void setJtBusqueda(JTextField jtBusqueda) {
        this.jtBusqueda = jtBusqueda;
    }

    public JTable getJtablaGestionEstudiante() {
        return jtablaGestionEstudiante;
    }

    public void setJtablaGestionEstudiante(JTable jtablaGestionEstudiante) {
        this.jtablaGestionEstudiante = jtablaGestionEstudiante;
    }

  


}
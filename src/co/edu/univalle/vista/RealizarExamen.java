package co.edu.univalle.vista;

import co.edu.univalle.controlador.CtrRealizarExamen;
import co.edu.univalle.modelo.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JHOJAN L
 */
public class RealizarExamen extends javax.swing.JFrame {

    private List<Pregunta> preguntasGeneradas;
    private Estudiante estudiante;
    private Examen examen;
    List<String> preguntas = new ArrayList<String>();
    List<String> respuestas = new ArrayList<String>();

    public RealizarExamen(List<Pregunta> preguntasGeneradas, Estudiante estudiante, Examen examen) {
        this.setContentPane(fondo);
        initComponents();
       

        this.preguntasGeneradas = preguntasGeneradas;
        this.estudiante = estudiante;
        this.examen = examen;

        CtrRealizarExamen ctrl = new CtrRealizarExamen(this);
        jbTerminarJuego.addActionListener(ctrl);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProgressBar = new javax.swing.JProgressBar();
        jlAdivinaPalabra = new javax.swing.JLabel();
        jlPregunta = new javax.swing.JLabel();
        jlErrores = new javax.swing.JLabel();
        jbTerminarJuego = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jlAdivinaPalabra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlAdivinaPalabra.setText("ADIVINA LA PALABRA");

        jlPregunta.setText("Pregunta 1 de 5");

        jbTerminarJuego.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlPregunta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 607, Short.MAX_VALUE)
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbTerminarJuego)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlErrores)
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jlAdivinaPalabra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbTerminarJuego)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlPregunta))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jlAdivinaPalabra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                        .addComponent(jlErrores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JButton jbTerminarJuego;
    private javax.swing.JLabel jlAdivinaPalabra;
    private javax.swing.JLabel jlErrores;
    private javax.swing.JLabel jlPregunta;
    // End of variables declaration//GEN-END:variables

   
    public List<Pregunta> getPreguntasGeneradas() {
        return preguntasGeneradas;
    }

    public void setPreguntasGeneradas(List<Pregunta> preguntasGeneradas) {
        this.preguntasGeneradas = preguntasGeneradas;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public JLabel getJlPregunta() {
        return jlPregunta;
    }

    public void setJlPregunta(JLabel jlPregunta) {
        this.jlPregunta = jlPregunta;
    }

    public JLabel getJlErrores() {
        return jlErrores;
    }

    public void setJlErrores(JLabel jlErrores) {
        this.jlErrores = jlErrores;
    }

   

    public JProgressBar getProgressBar() {
        return ProgressBar;
    }

    public void setProgressBar(JProgressBar ProgressBar) {
        this.ProgressBar = ProgressBar;
    }

    

    public JButton getJbTerminarJuego() {
        return jbTerminarJuego;
    }

    public void setJbTerminarJuego(JButton jbTerminarJuego) {
        this.jbTerminarJuego = jbTerminarJuego;
    }

    public JLabel getJlAdivinaPalabra() {
        return jlAdivinaPalabra;
    }

    public void setJlAdivinaPalabra(JLabel jlAdivinaPalabra) {
        this.jlAdivinaPalabra = jlAdivinaPalabra;
    }

    
    FondoPanel fondo = new FondoPanel();

   class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/imagenes/white.jpg")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
   
}

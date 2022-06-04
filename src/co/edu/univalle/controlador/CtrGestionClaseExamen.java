/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Examen;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.vista.DisenoAdivinaPalabra;
import co.edu.univalle.vista.GestionClaseExamen;
import static co.edu.univalle.vista.DisenoAdivinaPalabra.ventanaActivaAP;
import co.edu.univalle.vista.GestionClase;
import co.edu.univalle.vista.GestionClaseNotas;
import static co.edu.univalle.vista.GestionClaseNotas.ventanaNotasActiva;
import co.edu.univalle.vista.MostrarPregunta;
import static co.edu.univalle.vista.MostrarPregunta.ventanaMostrarActiva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrGestionClaseExamen implements ActionListener, MouseListener {

    private Profesor profesor;
    private Clase clase;
    private Examen examen;
    private GestionClaseExamen gestionClaseExamen;

    public CtrGestionClaseExamen(Profesor profesor, Clase clase, Examen examen, GestionClaseExamen gestionClaseExamen) {
        this.profesor = profesor;
        this.clase = clase;
        this.examen = examen;
        this.gestionClaseExamen = gestionClaseExamen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(gestionClaseExamen.getJbDiseno())) {

            if (!gestionClaseExamen.getJcTipoPregunta().getSelectedItem().equals("")) {

                if (gestionClaseExamen.getJcTipoPregunta().getSelectedIndex() == 1) {

                    if (ventanaActivaAP == null) {//si no esta abierta una vez
                        mostrarVentanaAP();
                    }

                } 

            } else {

                JOptionPane.showMessageDialog(gestionClaseExamen, "Selecciona un tipo de pregunta", "Error", 0);

            }

        } else if (e.getSource().equals(gestionClaseExamen.getJbMostrar())) {

            if (ventanaMostrarActiva == null) {

                MostrarPregunta mostrarPregunta = new MostrarPregunta(examen);
                gestionClaseExamen.getjDesktopPane1().add(mostrarPregunta);
                mostrarPregunta.setVisible(true);

            }

        }else if (e.getSource().equals(gestionClaseExamen.getJbMostrarNotas())) {

            if (ventanaNotasActiva == null) {

                GestionClaseNotas mostrarNotas = new GestionClaseNotas(profesor, clase);
                gestionClaseExamen.getjDesktopPane1().add(mostrarNotas);
                mostrarNotas.setVisible(true);

            }

        }

    }

    public void mostrarVentanaAP() {

        DisenoAdivinaPalabra disenoAP = new DisenoAdivinaPalabra(profesor, examen);
        gestionClaseExamen.getjDesktopPane1().add(disenoAP);
        disenoAP.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(gestionClaseExamen.getJlAtras())) {

            gestionClaseExamen.dispose();
            new GestionClase(profesor, clase).setVisible(true);

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

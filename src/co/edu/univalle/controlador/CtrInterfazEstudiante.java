/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Estudiante;
import co.edu.univalle.vista.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrInterfazEstudiante implements MouseListener {

    private InterfazEstudiante interfazEstudiante;
    private Estudiante estudiante;//estudiante logeado

    public CtrInterfazEstudiante(InterfazEstudiante interfazEstudiante, Estudiante estudiante) {
        this.interfazEstudiante = interfazEstudiante;
        this.estudiante = estudiante;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(interfazEstudiante.getJlSalir())) {

            cerrarSesion();

        } else if (e.getSource().equals(interfazEstudiante.getJlConfig())) {

            interfazEstudiante.dispose();
            new ConfiguracionEstudiante(estudiante).setVisible(true);

        } else if (e.getSource().equals(interfazEstudiante.getJlModulos())) {

            interfazEstudiante.dispose();
            new InterfazModulo(estudiante).setVisible(true);
            
        } else if (e.getSource().equals(interfazEstudiante.getJlJuego())) {

            if(estudiante.getCodigoClase()!=null){//SI ESTA AGREGADO A UNA CLASE
                
            interfazEstudiante.dispose();
            new InterfazEligeExamen(estudiante).setVisible(true);
            
            }else{
            
            JOptionPane.showMessageDialog(interfazEstudiante, "No estas agregado a una clase, "
                    + "avisale a tu profesor para que te agregue", "Aviso", 2);
            }
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

    public void cerrarSesion() {

        int respuesta = JOptionPane.showConfirmDialog(interfazEstudiante, "¿Estas seguro de cerrar sesion?",
                "Salir", JOptionPane.YES_NO_CANCEL_OPTION, 3);

        if (respuesta == JOptionPane.YES_OPTION) {

            interfazEstudiante.dispose();
            new IniciarSesion().setVisible(true);

        }

    }

}

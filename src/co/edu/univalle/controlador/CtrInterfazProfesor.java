/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.vista.ConfiguracionProfesor;
import co.edu.univalle.vista.IniciarSesion;
import co.edu.univalle.vista.InterfazProfesor;
import co.edu.univalle.vista.InterfazProfesorClase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrInterfazProfesor implements MouseListener {

    InterfazProfesor interfazProfe;
    Profesor profesor;

    public CtrInterfazProfesor(InterfazProfesor interfazProfe, Profesor profesor) {
        this.interfazProfe = interfazProfe;
        this.profesor = profesor;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(interfazProfe.getJlConfiguracion())) {

            interfazProfe.dispose();
            new ConfiguracionProfesor(profesor).setVisible(true);
                   
            
        } else if (e.getSource().equals(interfazProfe.getJlSalir())) {
            
            int respuesta = JOptionPane.showConfirmDialog(interfazProfe, "¿Estas seguro de cerrar sesion?",
                    
                    "Salir", JOptionPane.YES_NO_CANCEL_OPTION, 3);

            if (respuesta == JOptionPane.YES_OPTION) {

                interfazProfe.dispose();
                new IniciarSesion().setVisible(true);
            }

        } else if (e.getSource().equals(interfazProfe.getJlClase())) {
            
            interfazProfe.dispose();
            new InterfazProfesorClase(profesor).setVisible(true);

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

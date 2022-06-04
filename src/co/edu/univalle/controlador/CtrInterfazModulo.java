/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.vista.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrInterfazModulo implements MouseListener {

    private InterfazModulo interfazModulo;
    private Modulo modulo;
    private Estudiante estudiante;

    public CtrInterfazModulo(InterfazModulo interfazModulo, Estudiante estudiante) {
        this.interfazModulo = interfazModulo;
        this.estudiante = estudiante;
        this.modulo = new Modulo();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(interfazModulo.getJlAtras())) {

            interfazModulo.dispose();
            new InterfazEstudiante(estudiante).setVisible(true);

        } else if (e.getSource().equals(interfazModulo.getJlModulo1())) {

            mostrarModulo1();

        } else if (e.getSource().equals(interfazModulo.getJlModulo2())) {

            mostrarModulo2();

        } else if (e.getSource().equals(interfazModulo.getJlModulo3())) {

            mostrarModulo3();

        } else if (e.getSource().equals(interfazModulo.getJlModulo4())) {

            mostrarModulo4();

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

    public void mostrarModulo1() {

        try {

            this.modulo = DAOFactory.getModuloDAO().consultarPorId(1);
            interfazModulo.dispose();
            new VistaModulo1(modulo, estudiante).setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(interfazModulo, e, "Error", 0);
        }

    }

    public void mostrarModulo2() {

        try {

            this.modulo = DAOFactory.getModuloDAO().consultarPorId(2);
            interfazModulo.dispose();
            new VistaModulo2(modulo, estudiante).setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(interfazModulo, e, "Error", 0);
        }
    }

    public void mostrarModulo3() {

        try {

            this.modulo = DAOFactory.getModuloDAO().consultarPorId(3);
            interfazModulo.dispose();
            new VistaModulo3(modulo, estudiante).setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(interfazModulo, e, "Error", 0);
        }
    }

    public void mostrarModulo4() {

        try {

            this.modulo = DAOFactory.getModuloDAO().consultarPorId(4);
            interfazModulo.dispose();
            new VistaModulo4(modulo, estudiante).setVisible(true);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(interfazModulo, e, "Error", 0);
        }
    }

}

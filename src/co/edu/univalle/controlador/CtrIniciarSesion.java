/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.vista.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrIniciarSesion implements ActionListener, MouseListener, KeyListener {

    private IniciarSesion iniSesion;
    private Profesor profesor;
    private Estudiante estudiante;

    public CtrIniciarSesion(IniciarSesion iniSesion) {
        this.iniSesion = iniSesion;
        this.profesor = new Profesor();
        this.estudiante = new Estudiante();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(iniSesion.getJbRegistro())) {
            
            iniSesion.dispose();
            new RegistroUsuario().setVisible(true);
  
        } else if (e.getSource().equals(iniSesion.getJbIniciarSesion())) {

            validacionCampos();

        }

    }

    public void validacionCampos() {

        if (iniSesion.getJcTipoUsuario().getSelectedIndex() != 0 && !iniSesion.getJtCodigo().getText().equals("")
                && !iniSesion.getJtPassword().getText().equals("")) {

            if (iniSesion.getJcTipoUsuario().getSelectedIndex() == 1) {//si es profesor

                busquedaProfesor();
                
            } else {

                busquedaEstudiante();
            }

        } else {

            JOptionPane.showMessageDialog(iniSesion, "Complete todos los campos", "Error", 0);
        }
    }

    public void busquedaProfesor() {

        try {
            long codigo = Long.parseLong(iniSesion.getJtCodigo().getText());
            String pass = iniSesion.getJtPassword().getText();
            if (codigo != 0) {

                profesor = DAOFactory.getProfesorDAO().consultarPorId(codigo);

                if (profesor != null) {

                    if (profesor.getContrasena().equals(pass)) {

                        iniSesion.dispose();
                        new InterfazProfesor(profesor).setVisible(true);

                    } else {

                        JOptionPane.showMessageDialog(iniSesion, "Contrasena incorrecta",
                                "Error", 0);

                    }

                } else {

                    JOptionPane.showMessageDialog(iniSesion, "El profesor con el codigo: " + codigo + " no existe",
                            "Error", 0);

                }

            } else {

                JOptionPane.showMessageDialog(iniSesion, "Codigo invalido", "Error", 0);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(iniSesion, e, "Error", 0);

        }

    }
    public void busquedaEstudiante() {

        try {
            long codigo = Long.parseLong(iniSesion.getJtCodigo().getText());
            String pass = iniSesion.getJtPassword().getText();
            if (codigo != 0) {

                estudiante = DAOFactory.getEstudianteDAO().consultarPorId(codigo);

                if (estudiante != null) {

                    if (estudiante.getContrasena().equals(pass)) {

                        iniSesion.dispose();
                        new InterfazEstudiante(estudiante).setVisible(true);

                    } else {

                        JOptionPane.showMessageDialog(iniSesion, "Contrasena incorrecta",
                                "Error", 0);

                    }

                } else {

                    JOptionPane.showMessageDialog(iniSesion, "El Estudiante con el codigo: " + codigo + " no existe",
                            "Error", 0);

                }

            } else {

                JOptionPane.showMessageDialog(iniSesion, "Codigo invalido", "Error", 0);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(iniSesion, e, "Error", 0);

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        iniSesion.dispose();
        new RecuperarCuenta().setVisible(true);

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

    @Override
    public void keyTyped(KeyEvent e) {//eventos teclados

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.isAltDown() && e.getKeyCode() == e.VK_A) {

            iniSesion.dispose();
            new IniciarSesionAdmin().setVisible(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}

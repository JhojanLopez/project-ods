/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Estudiante;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.validacion.ValidacionEstudiante;
import co.edu.univalle.validacion.ValidacionProfesor;
import co.edu.univalle.vista.IniciarSesion;
import co.edu.univalle.vista.InterfazEstudiante;
import co.edu.univalle.vista.InterfazProfesor;
import co.edu.univalle.vista.RecuperarCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrRecuperarCuenta implements ActionListener, MouseListener {

    private RecuperarCuenta recuperaCuenta;
    private Profesor profesor;
    private Estudiante estudiante;

    public CtrRecuperarCuenta(RecuperarCuenta recuperaCuenta) {
        this.recuperaCuenta = recuperaCuenta;
        this.profesor = new Profesor();
        this.estudiante = new Estudiante();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(recuperaCuenta.getJbCambiarPassword())) {

            validacionCampos();

        }
    }

    public void validacionCampos() {

        if (recuperaCuenta.getJcTipoUsuario().getSelectedIndex() != 0 && !recuperaCuenta.getJtCodigo().getText().equals("")
                && !recuperaCuenta.getJtPassNew().getText().equals("")) {

            if (recuperaCuenta.getJcTipoUsuario().getSelectedIndex() == 1) {//si es profesor

                busquedaProfesor();

            } else {

                busquedaEstudiante();
            }

        } else {

            JOptionPane.showMessageDialog(recuperaCuenta, "Complete todos los campos", "Error", 0);
        }

    }

    public void busquedaProfesor() {
        try {
            long codigo = Long.parseLong(recuperaCuenta.getJtCodigo().getText());
            String pass = recuperaCuenta.getJtPassNew().getText();

            if (codigo != 0) {

                profesor = DAOFactory.getProfesorDAO().consultarPorId(codigo);

                if (profesor != null) {

                    profesor.setContrasena(pass);//establecemos la contrasena nueva momentaneamente
                    updateProfesor();//se actualizara 

                } else {

                    JOptionPane.showMessageDialog(recuperaCuenta, "El profesor con el codigo: " + codigo + " no existe",
                            "Error", 0);

                }

            } else {

                JOptionPane.showMessageDialog(recuperaCuenta, "Codigo invalido", "Error", 0);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(recuperaCuenta, e, "Error", 0);

        }

    }

    public void updateProfesor() {

        ValidacionProfesor validacion = new ValidacionProfesor(profesor);

        if (validacion.validacionPassword()) {//validamos que la pass sea correcta

            try {

                EntityManagerHelper.beginTransaction();
                DAOFactory.getProfesorDAO().modificar(profesor);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(recuperaCuenta, "Se actualizo su contrasena con exito", "Aviso", 1);

                recuperaCuenta.dispose();
                new InterfazProfesor(profesor).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(recuperaCuenta, e);
            }

        }

    }

    public void busquedaEstudiante() {
        try {
            long codigo = Long.parseLong(recuperaCuenta.getJtCodigo().getText());
            String pass = recuperaCuenta.getJtPassNew().getText();

            if (codigo != 0) {

                estudiante = DAOFactory.getEstudianteDAO().consultarPorId(codigo);

                if (estudiante != null) {

                    estudiante.setContrasena(pass);//establecemos la contrasena nueva momentaneamente
                    updateEstudiante();//se actualizara 

                } else {

                    JOptionPane.showMessageDialog(recuperaCuenta, "El estudiante con el codigo: " + codigo + " no existe",
                            "Error", 0);

                }

            } else {

                JOptionPane.showMessageDialog(recuperaCuenta, "Codigo invalido", "Error", 0);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(recuperaCuenta, e, "Error", 0);

        }
    }

    public void updateEstudiante() {

        ValidacionEstudiante validacion = new ValidacionEstudiante(estudiante);

        if (validacion.validacionPassword()) {//validamos que la pass sea correcta

            try {

                EntityManagerHelper.beginTransaction();
                DAOFactory.getEstudianteDAO().modificar(estudiante);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(recuperaCuenta, "Se actualizo su contrasena con exito", "Aviso", 1);

                recuperaCuenta.dispose();
                new InterfazEstudiante(estudiante).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(recuperaCuenta, e);
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(recuperaCuenta.getJlAtras())) {

            recuperaCuenta.dispose();
            new IniciarSesion().setVisible(true);
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

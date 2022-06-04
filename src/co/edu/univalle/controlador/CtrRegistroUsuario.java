/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Avatar;
import co.edu.univalle.vista.RegistroUsuario;
import co.edu.univalle.vista.IniciarSesion;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.modelo.Estudiante;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.validacion.ValidacionEstudiante;
import co.edu.univalle.validacion.ValidacionProfesor;
import co.edu.univalle.vista.InterfazEstudiante;
import co.edu.univalle.vista.InterfazProfesor;
import java.awt.event.*;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrRegistroUsuario implements ActionListener {

    private RegistroUsuario rUsuario;
    private Profesor profesor;
    private Estudiante estudiante;

    public CtrRegistroUsuario(RegistroUsuario rUsuario) {

        this.profesor = new Profesor();
        this.estudiante = new Estudiante();
        this.rUsuario = rUsuario;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(rUsuario.getJbRegistrar())) {

            validacionCampos();

        } else if (e.getSource().equals(rUsuario.getJbAtras())) {

            rUsuario.dispose();
            IniciarSesion iniSesion = new IniciarSesion();
            iniSesion.setVisible(true);
        }

    }

    public void validacionCampos() {

        if (rUsuario.getJcTipoUsuario().getSelectedIndex() != 0 && !rUsuario.getJtNombre().getText().equals("") && !rUsuario.getJtEdad().getText().equals("")
                && !rUsuario.getJtUsuario().getText().equals("") && rUsuario.getJcGenero().getSelectedIndex() != 0 && !rUsuario.getJtPassword().getText().equals("")) {

            if (rUsuario.getJcTipoUsuario().getSelectedIndex() == 1) {//creara un profesor entonces se validaran los datos como un profesor

                crearProfesor();

            } else {//si no lo es se validara un estudiante para posteriormente crearlo
                
                crearEstudiante();

            }

        } else {

            JOptionPane.showMessageDialog(rUsuario, "Complete todos los campos", "Error", 0);
        }

    }

    public void crearProfesor() {

        try {
            String nombre = rUsuario.getJtNombre().getText();
            String usuario = rUsuario.getJtUsuario().getText();
            int edad = Integer.parseInt(rUsuario.getJtEdad().getText());
            String genero = definirGenero(rUsuario.getJcGenero().getSelectedIndex());
            String contrasena = rUsuario.getJtPassword().getText();

            Avatar avatar = DAOFactory.getAvatarDAO().consultarPorId(new Integer(1));//se le asignara el avatar default que sera el cod 1

            profesor.setNombre(nombre);
            profesor.setUsuario(usuario);
            profesor.setEdad(edad);
            profesor.setGenero(genero);
            profesor.setContrasena(contrasena);
            profesor.setCodigoAvatar(avatar);

            insertProfesor();//se pasara a crear en la bd

        } catch (java.lang.NumberFormatException ex) {

            JOptionPane.showMessageDialog(rUsuario, "La edad debe ser un numero entero", "Error", 0);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rUsuario, e, "error", 0);

        }
    }

    public void insertProfesor() {

        ValidacionProfesor validacion = new ValidacionProfesor(this.profesor);//mandamos al profesor

        if (validacion.validacionNombre() && validacion.validacionUsuario() && validacion.validacionEdad()
                && validacion.validacionGenero() && validacion.validacionPassword()) {// se valida el profesor usando la clase ValidacionProfesor package validaciones

            try {
                EntityManagerHelper.beginTransaction();
                DAOFactory.getProfesorDAO().insertar(profesor);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                Profesor profesorCreado = DAOFactory.getProfesorDAO().consultarPorUsuario(profesor.getUsuario());

                JOptionPane.showMessageDialog(rUsuario, "Profesor creado con exito!\n"
                        + "Codigo generado: " + profesorCreado.getCodigo(), "", 3);

                rUsuario.dispose();
                new InterfazProfesor(profesor).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rUsuario, e, "Error", 0);
            }

        }
    }

    public void crearEstudiante() {
        try {
            String nombre = rUsuario.getJtNombre().getText();
            String usuario = rUsuario.getJtUsuario().getText();
            int edad = Integer.parseInt(rUsuario.getJtEdad().getText());
            String genero = definirGenero(rUsuario.getJcGenero().getSelectedIndex());
            String contrasena = rUsuario.getJtPassword().getText();
            
            Avatar avatar = DAOFactory.getAvatarDAO().consultarPorId(1);//se le asignara el avatar default que sera el cod 1

            estudiante.setNombre(nombre);
            estudiante.setUsuario(usuario);
            estudiante.setEdad(edad);
            estudiante.setGenero(genero);
            estudiante.setContrasena(contrasena);
            estudiante.setCodigoClase(null);
            estudiante.setCodigoAvatar(avatar);

            insertEstudiante();//se pasara a crear en la bd
        } catch (java.lang.NumberFormatException ex) {

            JOptionPane.showMessageDialog(rUsuario, "La edad debe ser un numero entero", "Error", 0);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rUsuario, e, "error", 0);

        }
    }

    public void insertEstudiante() {
        
         ValidacionEstudiante validacion = new ValidacionEstudiante(estudiante);

        if (validacion.validacionNombre() && validacion.validacionUsuario() && validacion.validacionEdad()
                && validacion.validacionGenero() && validacion.validacionPassword()) {// se valida el profesor usando la clase ValidacionAdministrador package validaciones

            try {
                EntityManagerHelper.beginTransaction();
                DAOFactory.getEstudianteDAO().insertar(estudiante);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                Estudiante estudianteCreado = DAOFactory.getEstudianteDAO().consultarPorUsuario(estudiante.getUsuario());

                JOptionPane.showMessageDialog(rUsuario, "Estudiante creado con exito!\n"
                        + "Codigo generado: " + estudianteCreado.getCodigo(), "", 3);

                rUsuario.dispose();
                new InterfazEstudiante(estudiante).setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rUsuario, e, "Error", 0);
            }

        }

    }

    public String definirGenero(int index) {

        String genero = "F";

        if (index == 2) {

            genero = "M";
        }

        return genero;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.validacion;

import co.edu.univalle.modelo.Estudiante;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.persistencia.DAOFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class ValidacionEstudiante {//validaciones para el profesor 

    private Estudiante estudiante;//profesor a validar

    public ValidacionEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public boolean validacionNombre() {

        if (estudiante.getNombre() != null && (estudiante.getNombre().matches("[a-zA-Z]+[ ][a-zA-Z]+") || estudiante.getNombre().matches("[a-zA-Z]+"))) {//si no es nulo y tiene solo cadenas es true y cumple con alguna de las dos plantillas

            try {//buscamos el estudiante a crear para determinar si ya existe el mismo nombre

                Estudiante estudianteBuscado = DAOFactory.getEstudianteDAO().consultarPorNombre(estudiante.getNombre());//busca por nombre

                if (estudianteBuscado == null) {//si NO existe el administrador

                    return true;//valida exitosamente el usuario del admin

                } else {//SI existe

                    JOptionPane.showMessageDialog(null, "El nombre del estudiante a crear ya existe", "Aviso", 2);
                    return false;
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "" + e, "Error", 0);
                System.out.println("" + e);
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "\tFormato Nombre:\n"
                    + "1.[Nombre]\n"
                    + "2.[Nombre] [Apellido]\n"
                    + "Sin numeros y caracteres especiales", "Aviso", 2);
            return false;
        }

    }

    public boolean validacionUsuario() {

        if (estudiante.getUsuario().matches("[a-zA-Z]+[-][0-9]+") || estudiante.getUsuario().matches("[a-zA-Z]+[0-9]*")) {//si cumple con el formato [Nombre Apellido] sera true

            if (estudiante.getUsuario().length() < 16) {//determinamos que tenga maximo 15 caracteres

                try {//buscamos el estudiante a crear para determinar si ya existe el mismo usuario

                    Estudiante estudianteBuscado = DAOFactory.getEstudianteDAO().consultarPorUsuario(estudiante.getUsuario());//busca por nombre

                    if (estudianteBuscado == null) {//si NO existe el estudiante

                        return true;//valida exitosamente el usuario del estudiante

                    } else {//SI existe

                        JOptionPane.showMessageDialog(null, "El nombre de usuario del estudiante a crear ya existe", "Aviso", 2);
                        return false;
                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "" + e, "Error", 0);
                    System.out.println("" + e);
                    return false;
                }

            } else {

                JOptionPane.showMessageDialog(null, "No se puede superar 15 caracteres", "Aviso", 2);
                return false;
            }

        } else {

            JOptionPane.showMessageDialog(null, "\tFormato Usuario:\n"
                    + "1.[NombreUsuario][-][numeros]\n"
                    + "2.[NombreUsuario][numeros]\n"
                    + "3.[NombreUsuario]\n"
                    + "Sin espacios ni otros caracteres especiales", "Aviso Usuario", 2);

            return false;
        }

    }

    public boolean validacionEdad() {

        if (estudiante.getEdad() > 13 && estudiante.getEdad() < 41) {//rango de edad

            return true;

        } else {

            JOptionPane.showMessageDialog(null, "La edad debe estar entre 14 a 40 años ", "Aviso", 2);
            return false;
        }

    }

    public boolean validacionGenero() {

        if (estudiante.getGenero().equals("M") || estudiante.getGenero().equals("F")) {

            return true;

        } else {

            JOptionPane.showMessageDialog(null, "El genero debe ser F o M ", "Aviso", 2);
            return false;
        }

    }

    public boolean validacionPassword() {

        String password = estudiante.getContrasena();

        if (password.length() >= 3) {//debe tener minimo 3 caracteres

            return true;

        } else {

            JOptionPane.showMessageDialog(null, "La contraseña debe tener minimo 3 caracteres", "Aviso", 2);

            return false;
        }

    }

    public boolean validacionModificar() {

        Estudiante estudianteBd = new Estudiante();//administrador con datos en la BD

        try {
            estudianteBd = DAOFactory.getEstudianteDAO().consultarPorId(estudiante.getCodigo());//guardo los datos del profesor a actualizar

            if (estudianteBd.getNombre().equals(estudiante.getNombre())) {//si los nombres son igual al de bd y el que va actualizar, seria true, si no lo es validara el nombre normalmente

                if (estudianteBd.getUsuario().equals(estudiante.getUsuario())) {// si es igual se actualizara de correcta forma

                    return true;

                } else if (validacionUsuario()) {//si no es igual se validara el nombre, si es valido  se terminara de validar el nombre y el usuario

                    return true;

                } else {
                    
                    return false;

                }
            } else if (validacionNombre()) {

                if (estudianteBd.getUsuario().equals(estudiante.getUsuario())) {//si es el mismo esta bien, sino pasara a validar el nuevo

                    return true;

                } else if (validacionUsuario()) {

                    return true;

                } else {

                    return false;

                }

            } else {
                return false;
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error", 0);
            return false;
        }

    }
}

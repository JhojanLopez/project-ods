/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.validacion;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.persistencia.DAOFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class ValidacionAdministrador {

    private Administrador admin;//administrador a validar

    public ValidacionAdministrador(Administrador admin) {
        this.admin = admin;
    }

    public boolean validacionNombre() {

        if (admin.getNombre() != null && admin.getNombre().matches("[a-zA-Z]+")) {//si no es nulo y tiene solo cadenas es true

            try {//buscamos el administrador a crear para determinar si ya existe el mismo nombre

                Administrador adminBuscado = DAOFactory.getAdministradorDAO().consultarPorNombre(admin.getNombre());//busca por nombre

                if (adminBuscado == null) {//si NO existe el administrador

                    return true;//valida exitosamente el usuario del admin

                } else {//SI existe

                    JOptionPane.showMessageDialog(null, "El nombre del administrador a crear ya existe", "Aviso", 2);
                    return false;
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "" + e, "Error", 0);
                System.out.println("" + e);
                return false;
            }

        } else {
            JOptionPane.showMessageDialog(null, "El nombre debe tener solo letras, sin espacios", "Aviso", 2);
            return false;
        }

    }

    public boolean validacionUsuario() {

        if (admin.getUsuario().matches("[a-zA-Z]+[0-9]*")) {//si cumple con el formato [Nombre Apellido] sera true

            if (admin.getUsuario().length() < 16) {//determinamos que tenga maximo 15 caracteres

                try {//buscamos el administrador a crear para determinar si ya existe el mismo usuario

                    Administrador adminBuscado = DAOFactory.getAdministradorDAO().consultarPorUsuario(admin.getUsuario());//busca por nombre

                    if (adminBuscado == null) {//si NO existe el administrador

                        return true;//valida exitosamente el usuario del admin

                    } else {//SI existe

                        JOptionPane.showMessageDialog(null, "El nombre de usuario del administrador a crear ya existe", "Aviso", 2);
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
                    + "1.[NombreUsuario][numeros]\n"
                    + "2.[NombreUsuario]\n"
                    + "Sin espacios ni otros caracteres especiales", "Aviso", 2);

            return false;
        }

    }

    public boolean validacionPassword() {

        String password = admin.getContrasena();

        if (password.length() >= 3) {//debe tener minimo 3 caracteres

            return true;

        } else {

            JOptionPane.showMessageDialog(null, "La contraseña debe tener minimo 3 caracteres", "Aviso", 2);

            return false;
        }

    }

    public boolean validacionModificar() {

        Administrador adminBd = new Administrador();//administrador con datos en la BD

        try {
            adminBd = DAOFactory.getAdministradorDAO().consultarPorId(admin.getCodigo());//guardo los datos del administrador a actualizar

            if (adminBd.getNombre().equals(admin.getNombre())) {//si los nombres son igual al de bd y el que va actualizar, seria true, si no lo es validara el nombre normalmente

                if (adminBd.getUsuario().equals(admin.getUsuario())) {// si es igual se actualizara de correcta forma

                    return true;

                } else if (validacionUsuario()) {//si no es igual se validara el nombre, si es valido  se terminara de validar el nombre y el usuario

                    return true;

                } else {
                       return false;
                }
            } else if (validacionNombre()) {

                if (adminBd.getUsuario().equals(admin.getUsuario())) {//si es el mismo esta bien, sino pasara a validar el nuevo

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

            return false;
        }

     
    }
}

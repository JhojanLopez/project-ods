/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.modelo.Avatar;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.validacion.ValidacionAdministrador;
import co.edu.univalle.validacion.ValidacionProfesor;
import co.edu.univalle.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrConfigProfesor implements ActionListener, MouseListener {

    private Profesor profesor;
    private ConfiguracionProfesor configProfesor;

    public CtrConfigProfesor(ConfiguracionProfesor configProfesor, Profesor profesorLog) {
        this.profesor = profesorLog;
        this.configProfesor = configProfesor;
        establecerJcAvatar();
        initComponents();
    }

    public void initComponents() {

        configProfesor.getJtNombre().setText(profesor.getNombre());
        configProfesor.getJtUsuario().setText(profesor.getUsuario());
        configProfesor.getJtEdad().setText("" + profesor.getEdad());
        configProfesor.getJtPass().setText(profesor.getContrasena());
        configProfesor.asignarImagen(configProfesor.getJlAvatar(), profesor.getCodigoAvatar().getImg());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(configProfesor.getJbActualizar())) {

            validacionActualizar();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(configProfesor.getJlAtras())) {

            configProfesor.dispose();
            new InterfazProfesor(profesor).setVisible(true);

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

    public void establecerJcAvatar() {

        List<String> listaJc = new ArrayList<String>();
        configProfesor.getJcListaAvatar().addItem("");

        try {
            List<Avatar> listaAvatar = DAOFactory.getAvatarDAO().consultar();//traemos la lista de los avatar
            for (int i = 0; i < listaAvatar.size(); i++) {

                if (i >= 0 && i <= 11) {
                    configProfesor.getJcListaAvatar().addItem(listaAvatar.get(i).getNombre());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(configProfesor, e);
        }

    }

    public void validacionActualizar() {

        String nombre = configProfesor.getJtNombre().getText();
        String usuario = configProfesor.getJtUsuario().getText();
        String contrasena = configProfesor.getJtPass().getText();
        String edadS = configProfesor.getJtEdad().getText();

        if (!configProfesor.getJcListaAvatar().getSelectedItem().equals("")
                && !nombre.equals("") && !usuario.equals("") && !contrasena.equals("") && !edadS.equals("")) {

            try {
                int edad = Integer.parseInt(edadS);
                Profesor profe = new Profesor(this.profesor.getCodigo(), nombre, usuario,
                        edad, this.profesor.getGenero(), contrasena);
                Actualizar(profe);

            } catch (java.lang.NumberFormatException ex) {

                JOptionPane.showMessageDialog(configProfesor, " La edad debe ser un numero entero", "Error", 0);
            } catch (Exception e) {

                JOptionPane.showMessageDialog(configProfesor, e, "Error", 0);
            }
        } else {

            JOptionPane.showMessageDialog(configProfesor, "Completa todos los datos para actualizar", "Aviso", 2);
        }

    }

    public void Actualizar(Profesor profe) {

        int codAvatar = definirCodAvatar((String) configProfesor.getJcListaAvatar().getSelectedItem());
        ValidacionProfesor validacion = new ValidacionProfesor(profe);

        if (validacion.validacionModificar() && validacion.validacionEdad() && validacion.validacionPassword()) {

            try {

                Avatar avatar = DAOFactory.getAvatarDAO().consultarPorId(codAvatar);//consulto por codi

                profe.setCodigoAvatar(avatar);

                EntityManagerHelper.beginTransaction();
                DAOFactory.getProfesorDAO().modificar(profe);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(configProfesor, "Actulizado los datos con exito", "Aviso", 2);

                this.profesor = profe;//actualizao el adminLog
                initComponents();//actualizo los datos en la ventana

            } catch (Exception e) {
                JOptionPane.showMessageDialog(configProfesor, e);
            }

        }

    }

    public int definirCodAvatar(String item) {

        try {
            Avatar avatar = DAOFactory.getAvatarDAO().consultarPorNombre(item);

            if (avatar != null) {

                return avatar.getCodigo();

            } else {

                JOptionPane.showMessageDialog(configProfesor, "El avatar o existe", "error", 0);

                return 0;
            }

        } catch (Exception e) {

            return 0;
        }

    }
}

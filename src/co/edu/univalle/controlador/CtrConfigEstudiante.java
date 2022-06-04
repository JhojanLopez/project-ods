/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.validacion.*;
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
public class CtrConfigEstudiante implements ActionListener, MouseListener {

    private Estudiante estudiante;
    private ConfiguracionEstudiante configEstudiante;

    public CtrConfigEstudiante(ConfiguracionEstudiante configEstudiante, Estudiante estudiante) {
        this.estudiante = estudiante;
        this.configEstudiante = configEstudiante;
        establecerJcAvatar();
        initComponents();
    }

    public void initComponents() {

        configEstudiante.getJtNombre().setText(estudiante.getNombre());
        configEstudiante.getJtUsuario().setText(estudiante.getUsuario());
        configEstudiante.getJtEdad().setText("" + estudiante.getEdad());
        configEstudiante.getJtPass().setText(estudiante.getContrasena());
        configEstudiante.asignarImagen(configEstudiante.getJlAvatar(), estudiante.getCodigoAvatar().getImg());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(configEstudiante.getJbActualizar())) {

            validacionActualizar();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(configEstudiante.getJlAtras())) {

            configEstudiante.dispose();
            new InterfazEstudiante(estudiante).setVisible(true);

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
        configEstudiante.getJcListaAvatar().addItem("");

        try {
            List<Avatar> listaAvatar = DAOFactory.getAvatarDAO().consultar();//traemos la lista de los avatar
            for (int i = 0; i < listaAvatar.size(); i++) {

                if (i >= 0 && i <= 11) {
                    configEstudiante.getJcListaAvatar().addItem(listaAvatar.get(i).getNombre());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(configEstudiante, e);
        }

    }

    public void validacionActualizar() {

        String nombre = configEstudiante.getJtNombre().getText();
        String usuario = configEstudiante.getJtUsuario().getText();
        String contrasena = configEstudiante.getJtPass().getText();
        String edadS = configEstudiante.getJtEdad().getText();

        if (!configEstudiante.getJcListaAvatar().getSelectedItem().equals("")
                && !nombre.equals("") && !usuario.equals("") && !contrasena.equals("") && !edadS.equals("")) {

            try {
                int edad = Integer.parseInt(edadS);
                Estudiante estudiante = new Estudiante(this.estudiante.getCodigo(), nombre, usuario,
                        edad, this.estudiante.getGenero(), contrasena);
                Actualizar(estudiante);

            } catch (java.lang.NumberFormatException ex) {

                JOptionPane.showMessageDialog(configEstudiante, " La edad debe ser un numero entero", "Error", 0);
            } catch (Exception e) {

                JOptionPane.showMessageDialog(configEstudiante, e, "Error", 0);
            }
        } else {

            JOptionPane.showMessageDialog(configEstudiante, "Completa todos los datos para actualizar", "Aviso", 2);
        }

    }

    public void Actualizar(Estudiante estudianteModificado) {

        int codAvatar = definirCodAvatar((String) configEstudiante.getJcListaAvatar().getSelectedItem());
        ValidacionEstudiante validacion = new ValidacionEstudiante(estudianteModificado);

        if (validacion.validacionModificar() && validacion.validacionEdad() && validacion.validacionPassword()) {

            try {

                Avatar avatar = DAOFactory.getAvatarDAO().consultarPorId(codAvatar);//consulto por codi

                estudianteModificado.setCodigoAvatar(avatar);

                EntityManagerHelper.beginTransaction();
                DAOFactory.getEstudianteDAO().modificar(estudianteModificado);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(configEstudiante, "Actulizado los datos con exito", "Aviso", 2);

                this.estudiante = estudianteModificado;//actualizao el adminLog
                initComponents();//actualizo los datos en la ventana

            } catch (Exception e) {
                JOptionPane.showMessageDialog(configEstudiante, e);
            }

        }

    }

    public int definirCodAvatar(String item) {

        try {
            Avatar avatar = DAOFactory.getAvatarDAO().consultarPorNombre(item);

            if (avatar != null) {

                return avatar.getCodigo();

            } else {

                JOptionPane.showMessageDialog(configEstudiante, "El avatar o existe", "error", 0);

                return 0;
            }

        } catch (Exception e) {

            return 0;
        }

    }
}

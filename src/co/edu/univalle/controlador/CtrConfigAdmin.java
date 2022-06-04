/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.modelo.Avatar;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.validacion.ValidacionAdministrador;
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
public class CtrConfigAdmin implements ActionListener, MouseListener {

    private Administrador adminLog;
    private ConfiguracionAdministrador configAdmin;

    public CtrConfigAdmin(ConfiguracionAdministrador configAdmin, Administrador adminLog) {
        this.adminLog = adminLog;
        this.configAdmin = configAdmin;
        establecerJcAvatar();
        initComponents();
    }

    public void initComponents() {

        configAdmin.getJtNombre().setText(adminLog.getNombre());
        configAdmin.getJtUsuario().setText(adminLog.getUsuario());
        configAdmin.getJtPass().setText(adminLog.getContrasena());
        configAdmin.asignarImagen(configAdmin.getJlAvatar(), adminLog.getCodigoAvatar().getImg());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(configAdmin.getJbActualizar())) {

            validacionActualizar();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(configAdmin.getJlAtras())) {

            configAdmin.dispose();
            new InterfazAdministrador(adminLog).setVisible(true);

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
        configAdmin.getJcListaAvatar().addItem("");

        try {
            List<Avatar> listaAvatar = DAOFactory.getAvatarDAO().consultar();//traemos la lista de los avatar
            for (int i = 0; i < listaAvatar.size(); i++) {

                if(i>=0 && i<=11){
                configAdmin.getJcListaAvatar().addItem(listaAvatar.get(i).getNombre());}

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(configAdmin, e);
        }

    }

    public void validacionActualizar() {

        String nombre = configAdmin.getJtNombre().getText();
        String usuario = configAdmin.getJtUsuario().getText();
        String contrasena = configAdmin.getJtPass().getText();

        if (!configAdmin.getJcListaAvatar().getSelectedItem().equals("")
                && !nombre.equals("") && !usuario.equals("") && !contrasena.equals("")) {

            try {
                Administrador admin = new Administrador(adminLog.getCodigo(), nombre, usuario, contrasena);
                Actualizar(admin);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(configAdmin, e, "Error", 0);
            }
        } else {

            JOptionPane.showMessageDialog(configAdmin, "Completa todos los datos para actualizar", "Aviso", 2);
        }

    }

    public void Actualizar(Administrador admin) {

        int codAvatar = definirCodAvatar((String) configAdmin.getJcListaAvatar().getSelectedItem());
        ValidacionAdministrador validacion = new ValidacionAdministrador(admin);

        if (validacion.validacionModificar() && validacion.validacionPassword()) {

            try {

                Avatar avatar = DAOFactory.getAvatarDAO().consultarPorId(codAvatar);//consulto por codi

                admin.setCodigoAvatar(avatar);

                EntityManagerHelper.beginTransaction();
                DAOFactory.getAdministradorDAO().modificar(admin);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(configAdmin, "Actulizado los datos con exito", "Aviso", 2);

                this.adminLog = admin;//actualizao el adminLog
                initComponents();//actualizo los datos en la ventana
            } catch (Exception e) {
                JOptionPane.showMessageDialog(configAdmin, e);
            }

        }

    }
     public int definirCodAvatar(String item) {

        try {
            Avatar avatar = DAOFactory.getAvatarDAO().consultarPorNombre(item);

            if (avatar != null) {

                return avatar.getCodigo();
           
            } else {

                JOptionPane.showMessageDialog(configAdmin, "El avatar o existe", "error", 0);

                return 0;
            }

        } catch (Exception e) {

            return 0;
        }

    }

}

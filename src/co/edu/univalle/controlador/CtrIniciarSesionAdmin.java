/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.vista.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrIniciarSesionAdmin implements ActionListener {

    private IniciarSesionAdmin iniciarSesionAdmin;

    public CtrIniciarSesionAdmin(IniciarSesionAdmin iniciarSesionAdmin) {
        this.iniciarSesionAdmin = iniciarSesionAdmin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(iniciarSesionAdmin.getJbRegistrar())) {

            if (!iniciarSesionAdmin.getJtCodigo().getText().equals("") && !iniciarSesionAdmin.getJtPassword().getText().equals("")) {

                consultarAdmin();

            } else {

                JOptionPane.showMessageDialog(iniciarSesionAdmin, "Completa todos los campos", "Error", 0);
            }
        } else if (e.getSource().equals(iniciarSesionAdmin.getJbAtras())) {

            iniciarSesionAdmin.dispose();
            new IniciarSesion().setVisible(true);

        }
    }

    public void consultarAdmin() {

        try {
            long codigoAdmin = Long.parseLong(iniciarSesionAdmin.getJtCodigo().getText());//capturo el codigo

            EntityManagerHelper.beginTransaction();
            Administrador adminLog = DAOFactory.getAdministradorDAO().consultarPorId(new Long(codigoAdmin));//busco el codigo
            EntityManagerHelper.closeEntityManager();
            validarAdmin(adminLog);//valido el administrador
            System.out.println("" + adminLog);

//            
        } catch (java.lang.NumberFormatException e) {

            JOptionPane.showMessageDialog(iniciarSesionAdmin, "El codigo ingresado no corresponde a un numero", "Error", 0);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(iniciarSesionAdmin, "" + ex, "Error", 0);
        }

    }

    public void validarAdmin(Administrador adminLog) {

        String passwordDigitada = iniciarSesionAdmin.getJtPassword().getText();

        if (adminLog != null) {

            if (passwordDigitada.equals(adminLog.getContrasena())) {
 
                iniciarSesionAdmin.dispose();
                new InterfazAdministrador(adminLog).setVisible(true);//mando el administrador logeado

            } else {

                JOptionPane.showMessageDialog(iniciarSesionAdmin, "Contrasena incorrecta!", "Error", 0);

            }

        } else {

            JOptionPane.showMessageDialog(iniciarSesionAdmin, "El administrador no esta registrado\n"
                    + "Codigo: " + iniciarSesionAdmin.getJtCodigo().getText() + " no encontrado", "Error", 0);

        }

    }

}

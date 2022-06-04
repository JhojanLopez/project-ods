/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.vista.*;
import static co.edu.univalle.vista.GestionAdministrador.ventanaAdministradorActiva;
import static  co.edu.univalle.vista.GestionProfesor.ventanaProfesorActiva;
import static co.edu.univalle.vista.GestionEstudiante.ventanaEstudianteActiva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrInterfazAdministrador implements ActionListener, MouseListener {

    InterfazAdministrador interfazAdmin;
    Administrador adminLog;
    List<Administrador> listaAdmin;//lista de los administradores

    public CtrInterfazAdministrador(InterfazAdministrador interfazAdmin, Administrador adminLog) {
        this.interfazAdmin = interfazAdmin;
        this.adminLog = adminLog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(interfazAdmin.getJbGestionAdmin())) {

            String ventanaAdminActiva = ventanaAdministradorActiva;

            if (ventanaAdminActiva == null) {//si esta desactivada se podra mostrar
                mostrarGestionAdministradores();
            }

        } else if (e.getSource().equals(interfazAdmin.getJbGestionProfesor())) {
            
            String ventanaProfeActiva = ventanaProfesorActiva;
            
            if(ventanaProfeActiva==null){
                mostrarGestionProfesores();
            
            }

        } else if (e.getSource().equals(interfazAdmin.getJbGestionEstudiante())) {
            
            String ventanaEstActiva = ventanaEstudianteActiva;
           
            if(ventanaEstActiva==null){
                mostrarGestionEstudiantes();
            
            }
        }

    }

    public void mostrarGestionAdministradores() {

        GestionAdministrador gestionAdmin = new GestionAdministrador(adminLog);//mostramos la gestion del admin
        interfazAdmin.getjDesktopPane1().add(gestionAdmin);
        gestionAdmin.setVisible(true);

    }

    public void mostrarGestionProfesores() {

        GestionProfesor gestionProfesor = new GestionProfesor(adminLog);//mostramos la gestion del admin
        interfazAdmin.getjDesktopPane1().add(gestionProfesor);
        gestionProfesor.setVisible(true);

    }

    public void mostrarGestionEstudiantes() {

        GestionEstudiante gestionEstudiante = new GestionEstudiante(adminLog);//mostramos la gestion del admin
        interfazAdmin.getjDesktopPane1().add(gestionEstudiante);
        gestionEstudiante.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(interfazAdmin.getJlSalir())) {
           

            int respuesta = JOptionPane.showConfirmDialog(interfazAdmin, "¿Estas seguro de cerrar sesion?",
                    "Salir", JOptionPane.YES_NO_CANCEL_OPTION, 3);

            if (respuesta == JOptionPane.YES_OPTION) {

                interfazAdmin.dispose();
                new IniciarSesion().setVisible(true);
            }
            
        }else if(e.getSource().equals(interfazAdmin.getJlConfig())){
        
            interfazAdmin.dispose();
            new ConfiguracionAdministrador(adminLog).setVisible(true);
        
        
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

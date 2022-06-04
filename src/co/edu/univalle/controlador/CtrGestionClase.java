/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Examen;
import co.edu.univalle.modelo.Modulo;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.vista.GestionClase;
import co.edu.univalle.vista.GestionClaseEstudiante;
import co.edu.univalle.vista.GestionClaseExamen;
import co.edu.univalle.vista.InterfazProfesorClase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrGestionClase implements ActionListener, MouseListener {

    private Clase clase;//clase escogida
    private Profesor profesor;//profesorlog
    private GestionClase gestionClase;

    public CtrGestionClase(Clase clase, Profesor profesor, GestionClase gestionClase) {
        this.clase = clase;
        this.profesor = profesor;
        this.gestionClase = gestionClase;

        setJclistaModulos();//establecemos los modulos disponibles en el combo box
        setJclistaExamenes();//mostramos los examenes creados
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(gestionClase.getJbCrearExamen())) {

            validacionCrearExamen();

        } else if (e.getSource().equals(gestionClase.getJbGestionarExamen())) {

            mostrarGestionExamen();

        } else if (e.getSource().equals(gestionClase.getJbGestionarEstudiantesClase())) {

            mostrarGestionEstudiantesClase();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(gestionClase.getJlAtras())) {

            gestionClase.dispose();
            new InterfazProfesorClase(profesor).setVisible(true);

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

    public void setJclistaModulos() {

        gestionClase.getJcListaModulosDispo().addItem("");

        try {
            List<Modulo> listaModulo = DAOFactory.getModuloDAO().consultar();//traemos la lista de la entidad a buscar
            List<Examen> listaExamen = DAOFactory.getExamenDAO().consultar();//lista de los examenes
            List<String> listaModulosUsados = new ArrayList();

            List<Modulo> listaModulosMostrar = listaModulo;//le pasamos los datos

            if (listaExamen != null) { //si la lista de examenes tienen datos

                for (int i = 0; i < listaExamen.size(); i++) {

                    if (listaExamen.get(i).getCodigoProfesor().getCodigo() == profesor.getCodigo()//si existen examenes con el codigo del profesor logeado y la clase actual
                            && listaExamen.get(i).getCodigoClase().getCodigo() == clase.getCodigo()) {

                        listaModulosUsados.add(listaExamen.get(i).getCodigoModulo().getNombre());//guardamos en una lista el nombre de los modulos usados

                    }

                }

                for (int x = 0; x < listaModulo.size(); x++) {//itero la lista de modulos 

                    for (int y = 0; y < listaModulosUsados.size(); y++) {//itero los modulos usados

                        if (listaModulo.get(x).getNombre().equals(listaModulosUsados.get(y))) {//como la listamodulo y mostrar son iguales entonces se procede a remover los modulos usados

                            listaModulosMostrar.remove(x);

                        }

                    }
                }

                for (int i = 0; i < listaModulosMostrar.size(); i++) {

                    gestionClase.getJcListaModulosDispo().addItem(listaModulosMostrar.get(i).getNombre());

                }

            } else {

                for (int i = 0; i < listaModulosMostrar.size(); i++) {

                    gestionClase.getJcListaModulosDispo().addItem(listaModulosMostrar.get(i).getNombre());

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void actualizarJcModulos() {

        gestionClase.getJcListaModulosDispo().removeAllItems();//elimina los actuales
        setJclistaModulos();//busca en la bd los datos actualizados
    }

    public void setJclistaExamenes() {

        gestionClase.getJcListaExamenes().addItem("");

        try {
            List<Examen> listaExamen = DAOFactory.getExamenDAO().consultar();//lista de los examenes

            if (listaExamen != null) { //si la lista de examenes tienen datos

                for (int i = 0; i < listaExamen.size(); i++) {

                    if (listaExamen.get(i).getCodigoProfesor().getCodigo() == profesor.getCodigo()//si existen examenes con el codigo del profesor logeado y la clase actual
                            && listaExamen.get(i).getCodigoClase().getCodigo() == clase.getCodigo()) {

                        gestionClase.getJcListaExamenes().addItem(listaExamen.get(i).getNombre());

                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void actualizarJcExamenes() {

        gestionClase.getJcListaExamenes().removeAllItems();//elimina los actuales
        setJclistaExamenes();//busca en la bd los datos actualizados
    }

    public void validacionCrearExamen() {

        if (!gestionClase.getJtNombreExamen().getText().equals("")
                && !gestionClase.getJcListaModulosDispo().getSelectedItem().equals("")) {

            if (gestionClase.getJtNombreExamen().getText().length() < 15) {

                String nombre = gestionClase.getJtNombreExamen().getText();

                try {

                    Examen examenBd = DAOFactory.getExamenDAO().consultarPorNombre(nombre);

                    if (examenBd == null) {//si no existe otro examen con el mismo nombre en la bd

                        //creamos el objeto del modulo escogido
                        Modulo modulo = DAOFactory.getModuloDAO().consultarPorNombre(gestionClase.getJcListaModulosDispo().getSelectedItem().toString());

                        crearExamen(nombre, modulo);//llamamos al metodo para la creacion en la bd
                    } else {

                        JOptionPane.showMessageDialog(gestionClase, "El nombre ya esta en uso en la base de datos, "
                                + "por favor ponle otro nombre", "Error", 0);

                    }

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(gestionClase, e, "Error", 0);

                }

            } else {

                JOptionPane.showMessageDialog(gestionClase, "El nombre no debe superar los 15 caracteres", "Aviso", 2);

            }

        } else {

            JOptionPane.showMessageDialog(gestionClase, "Completa todos los datos, tenga en cuenta que solo se puede crear un examen por modulo", "Aviso", 2);

        }

    }

    public void crearExamen(String nombre, Modulo modulo) {

        try {

            Examen examenInsert = new Examen(nombre, profesor, clase, modulo);
            EntityManagerHelper.beginTransaction();
            DAOFactory.getExamenDAO().insertar(examenInsert);//insertamos en la bd
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();

            JOptionPane.showMessageDialog(gestionClase, "Examen creado con exito!", "", 1);
            gestionClase.getJtNombreExamen().setText("");

            actualizarJcModulos();//actualizamos los dos JC combo box
            actualizarJcExamenes();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionClase, e, "Error", 0);

        }

    }

    public void mostrarGestionExamen() {

        if (!gestionClase.getJcListaExamenes().getSelectedItem().equals("")) {
            try {
                String nombreExamen = gestionClase.getJcListaExamenes().getSelectedItem().toString();
                Examen examen = DAOFactory.getExamenDAO().consultarPorNombre(nombreExamen);
                
                gestionClase.dispose();
                new GestionClaseExamen(profesor, clase, examen).setVisible(true);
                
            } catch (Exception e) {
            }
        } else {

            JOptionPane.showMessageDialog(gestionClase, "Selecciona un examen", "Aviso", 2);
        }

    }

    public void mostrarGestionEstudiantesClase() {

        gestionClase.dispose();
        new GestionClaseEstudiante(profesor,clase).setVisible(true);
    }

}

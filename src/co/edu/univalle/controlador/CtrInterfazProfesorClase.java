/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Avatar;
import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.vista.*;
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
public class CtrInterfazProfesorClase implements ActionListener, MouseListener {

    private InterfazProfesorClase interfazProfeClase;
    private Profesor profesor;

    public CtrInterfazProfesorClase(InterfazProfesorClase interfazProfeClase, Profesor profesor) {
        this.interfazProfeClase = interfazProfeClase;
        this.profesor = profesor;
        establecerJcClase();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(interfazProfeClase.getJbCrear())) {

            crearClase();

        } else if (e.getSource().equals(interfazProfeClase.getJbGestionarClase())) {

            mostrarGestionarClase();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(interfazProfeClase.getJlAtras())) {

            interfazProfeClase.dispose();
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

    public void establecerJcClase() {

        interfazProfeClase.getJcListaClases().addItem("");

       try {
            List<Clase> listaClases = DAOFactory.getClaseDAO().consultar();//traemos la lista de la entidad a buscar
            for (int i = 0; i < listaClases.size(); i++) {

                if (listaClases.get(i).getCodigoProfesor().getCodigo() == profesor.getCodigo()) {//si la clase es del profesor logeado

                    interfazProfeClase.getJcListaClases().addItem(listaClases.get(i).getNombre());
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(interfazProfeClase, e);
        }

    }

    public void actualizarJcClase() {

        interfazProfeClase.getJcListaClases().removeAllItems();//elimina los actuales
        establecerJcClase();//busca en la bd los datos actualizados
    }

    public void crearClase() {

        String nombreClase = interfazProfeClase.getJtNombre().getText();

        if (!nombreClase.equals("")) {

            try {

                Clase claseVerificar = DAOFactory.getClaseDAO().consultarPorNombre(nombreClase);

                if (claseVerificar == null) {//si no existe se verifica de manera correcta

                    Clase clase = new Clase(nombreClase, profesor);//creamos el objeto clase
                    EntityManagerHelper.beginTransaction();
                    DAOFactory.getClaseDAO().insertar(clase);//insertamos en la bd
                    EntityManagerHelper.commit();
                    EntityManagerHelper.closeEntityManager();

                    JOptionPane.showMessageDialog(interfazProfeClase, "Clase creada con exito!", "", 1);
                    interfazProfeClase.getJtNombre().setText("");
                    actualizarJcClase();//actualizamos el listado de las clases

                } else {

                    JOptionPane.showMessageDialog(interfazProfeClase, "Ya existe una clase con el mismo nombre, escoge otro nombre", "Aviso", 2);

                }

            } catch (Exception e) {
            }

        } else {

            JOptionPane.showMessageDialog(interfazProfeClase, "Ponle un nombre a tu clase", "Aviso", 2);

        }

    }

    public void mostrarGestionarClase() {

        String claseEscogida = (String) interfazProfeClase.getJcListaClases().getSelectedItem();

        if (!claseEscogida.equals("")) {

            try {
                Clase clase = DAOFactory.getClaseDAO().consultarPorNombre(claseEscogida);

                if (clase != null) {
                    
                    interfazProfeClase.dispose(); 
                    new GestionClase(profesor, clase).setVisible(true);

                } else {

                    JOptionPane.showMessageDialog(interfazProfeClase, "Clase no existe", "Error", 0);

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(interfazProfeClase, e, "Error", 0);
            }

        } else {

            JOptionPane.showMessageDialog(interfazProfeClase, "Escoge una clase", "Aviso", 2);
        }

    }

}

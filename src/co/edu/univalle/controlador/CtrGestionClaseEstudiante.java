/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Estudiante;
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
public class CtrGestionClaseEstudiante implements ActionListener, MouseListener {

    private Clase clase;//clase escogida
    private Profesor profesor;//profesorlog
    private GestionClaseEstudiante gestionClaseEstudiante;
    private List<Estudiante> listaEstudianteDisponibles;
    private List<Estudiante> listaEstudianteAgregados;

    public CtrGestionClaseEstudiante(Clase clase, Profesor profesor, GestionClaseEstudiante gestionClaseEstudiante) {
        this.clase = clase;
        this.profesor = profesor;
        this.gestionClaseEstudiante = gestionClaseEstudiante;

        consultarTablaEstudiantesDisponibles();
        consultarTablaEstudiantesAgregados();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(gestionClaseEstudiante.getJbAgregar())) {

            agregarEstudiantes();
            
        } else if (e.getSource().equals(gestionClaseEstudiante.getJbEliminar())) {
            
            eliminarEstudiantes();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(gestionClaseEstudiante.getJlAtras())) {

            gestionClaseEstudiante.dispose();
            new GestionClase(profesor, clase).setVisible(true);

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

    public void eliminarFilasEstudiantesDisponibles() {//elimina todas las filas de laas tablas

        int filasActuales = gestionClaseEstudiante.getModeloEstudiantesDisponibles().getRowCount();

        try {

            for (int i = filasActuales - 1; i >= 0; i--) {

                gestionClaseEstudiante.getModeloEstudiantesDisponibles().removeRow(i);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionClaseEstudiante, "" + e, "Error", 0);

        }

    }

    public void eliminarFilasEstudiantesAgregados() {//elimina todas las filas de laas tablas

        int filasActuales = gestionClaseEstudiante.getModeloEstudiantesClase().getRowCount();

        try {

            for (int i = filasActuales - 1; i >= 0; i--) {

                gestionClaseEstudiante.getModeloEstudiantesClase().removeRow(i);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionClaseEstudiante, "" + e, "Error", 0);

        }

    }

    public void consultarTablaEstudiantesDisponibles() {

        try {
            listaEstudianteDisponibles = DAOFactory.getEstudianteDAO().consultar();

            if (listaEstudianteDisponibles != null) {

                mostrarEstudiantesDisponibles();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionClaseEstudiante, e, "Error", 0);
        }

    }

    public void mostrarEstudiantesDisponibles() {

        eliminarFilasEstudiantesDisponibles();
        Object row[] = new Object[2];

        for (int i = 0; i < listaEstudianteDisponibles.size(); i++) {

            if (listaEstudianteDisponibles.get(i).getCodigoClase() == null) {

                row[0] = listaEstudianteDisponibles.get(i).getCodigo();
                row[1] = listaEstudianteDisponibles.get(i).getNombre();

                gestionClaseEstudiante.getModeloEstudiantesDisponibles().addRow(row);
            }
        }

    }

    public void consultarTablaEstudiantesAgregados() {

        try {

            listaEstudianteAgregados = DAOFactory.getEstudianteDAO().consultarPorClase(clase);

            if (listaEstudianteAgregados != null) {

                mostarEstudiantesAgregados();

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionClaseEstudiante, e, "Error", 0);
        }

    }

    public void mostarEstudiantesAgregados() {

        eliminarFilasEstudiantesAgregados();
        Object row[] = new Object[2];

        for (int i = 0; i < listaEstudianteAgregados.size(); i++) {

            row[0] = listaEstudianteAgregados.get(i).getCodigo();
            row[1] = listaEstudianteAgregados.get(i).getNombre();

            gestionClaseEstudiante.getModeloEstudiantesClase().addRow(row);

        }
    }

    public void agregarEstudiantes() {

        int row = gestionClaseEstudiante.getjTableEstudiantesDisponibles().getSelectedRow();//obtiene la fila seleccionada

        if (row > -1) {//si es -1 significa que no ha sido seleccionada ninguna
            try {

                Long codigoEstudiante = Long.parseLong(gestionClaseEstudiante.getModeloEstudiantesDisponibles().getValueAt(row, 0).toString());

                Estudiante estudiante = DAOFactory.getEstudianteDAO().consultarPorId(codigoEstudiante);//obtenemos el estudiante
                estudiante.setCodigoClase(clase);//le agregamos la clase

                EntityManagerHelper.beginTransaction();
                DAOFactory.getEstudianteDAO().modificar(estudiante);//le agrego la clase al estudainte
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                consultarTablaEstudiantesAgregados();//Actualizamos
                consultarTablaEstudiantesDisponibles();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionClaseEstudiante, e, "Error", 0);
            }

        } else {

            JOptionPane.showMessageDialog(gestionClaseEstudiante, "Selecciona un estudiante para agregar", "Error", 0);
        }

    }

    public void eliminarEstudiantes() {

        int row = gestionClaseEstudiante.getjTableEstudiantesClase().getSelectedRow();//obtiene la fila seleccionada

        if (row > -1) {//si es -1 significa que no ha sido seleccionada ninguna
            try {

                Long codigoEstudiante = Long.parseLong(gestionClaseEstudiante.getModeloEstudiantesClase().getValueAt(row, 0).toString());

                Estudiante estudiante = DAOFactory.getEstudianteDAO().consultarPorId(codigoEstudiante);//obtenemos el estudiante
                estudiante.setCodigoClase(null);//le quitamos la clase

                EntityManagerHelper.beginTransaction();
                DAOFactory.getEstudianteDAO().modificar(estudiante);//le agrego la clase al estudainte
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                consultarTablaEstudiantesAgregados();//Actualizamos
                consultarTablaEstudiantesDisponibles();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionClaseEstudiante, e, "Error", 0);
            }

        } else {

            JOptionPane.showMessageDialog(gestionClaseEstudiante, "Selecciona un estudiante para agregar", "Error", 0);
        }

    }

}

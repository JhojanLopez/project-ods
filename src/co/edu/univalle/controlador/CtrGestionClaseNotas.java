/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.vista.GestionClaseNotas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrGestionClaseNotas implements ActionListener {

    private GestionClaseNotas gestionClaseNotas;//vista a controlar
    private List<ExamenEstudiante> listaNotas;

    public CtrGestionClaseNotas(GestionClaseNotas gestionClaseNotas) {

        this.gestionClaseNotas = gestionClaseNotas;
        setJclistaExamenes();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(gestionClaseNotas.getJbBuscar())) {
            if (!gestionClaseNotas.getJcExamen().getSelectedItem().equals("")) {

                eliminarTodasFilas();
                buscarNotas();

            } else {

                JOptionPane.showMessageDialog(gestionClaseNotas, "Escoge un examen", "", 2);
            }
        }
    }

    public void setJclistaExamenes() {

        gestionClaseNotas.getJcExamen().addItem("");

        try {
            List<Examen> listaExamen = DAOFactory.getExamenDAO().consultar();//lista de los examenes

            if (listaExamen != null) { //si la lista de examenes tienen datos

                for (int i = 0; i < listaExamen.size(); i++) {

                    if (listaExamen.get(i).getCodigoProfesor().getCodigo() == gestionClaseNotas.getProfesor().getCodigo()//si existen examenes con el codigo del profesor logeado y la clase actual
                            && listaExamen.get(i).getCodigoClase().getCodigo() == gestionClaseNotas.getClase().getCodigo()) {

                        gestionClaseNotas.getJcExamen().addItem(listaExamen.get(i).getNombre());

                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void eliminarTodasFilas() {//elimina todas las filas de laas tablas

        int filasActuales = gestionClaseNotas.getJtablaGestionNotas().getRowCount();

        try {

            for (int i = filasActuales - 1; i >= 0; i--) {

                gestionClaseNotas.getModelo().removeRow(i);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionClaseNotas, "" + e, "Error", 0);
            System.out.println("" + gestionClaseNotas.getJtablaGestionNotas().getRowCount());

        }

    }

    public void buscarNotas() {

        String examenJc = gestionClaseNotas.getJcExamen().getSelectedItem().toString();

        try {

            Examen examen = DAOFactory.getExamenDAO().consultarPorNombre(examenJc);
            listaNotas = DAOFactory.getExamenEstudianteDAO().consultarPorExamen(examen.getCodigo());

            if (listaNotas != null) {

                mostrarNotas();

            } else {

                JOptionPane.showMessageDialog(gestionClaseNotas, "Aun no hay notas en este examen", "", 2);

            }

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    public void mostrarNotas() {
           
          Object row[] = new Object[3];

                for (int i = 0; i < listaNotas.size(); i++) {

                    row[0] = listaNotas.get(i).getEstudiante().getCodigo();
                    row[1] = listaNotas.get(i).getEstudiante().getNombre();
                    row[2] = listaNotas.get(i).getNota();

                    gestionClaseNotas.getModelo().addRow(row);
    
    }
}
}

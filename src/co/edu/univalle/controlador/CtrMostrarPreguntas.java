/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Examen;
import co.edu.univalle.modelo.Pregunta;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.vista.MostrarPregunta;
import java.awt.event.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrMostrarPreguntas implements ActionListener {

   
    private Examen examen;
    private Pregunta pregunta;
    private MostrarPregunta mostrarPregunta;
    private List<Pregunta> listaPregunta;

    public CtrMostrarPreguntas(Examen examen, MostrarPregunta mostrarPregunta) {
        this.examen = examen;
        this.mostrarPregunta = mostrarPregunta;
        pregunta = new Pregunta();
        mostrarPreguntas();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(mostrarPregunta.getJbActualizar())) {

            actualizar();
            
        } else if (e.getSource().equals(mostrarPregunta.getJbEliminar())) {

            eliminarPregunta();

        }

    }

    public void mostrarPreguntas() {

        try {

            listaPregunta = DAOFactory.getPreguntaDAO().consultarPorExamen(examen);

            if (listaPregunta != null) {

                Object row[] = new Object[4];

                for (int i = 0; i < listaPregunta.size(); i++) {

                    row[0] = listaPregunta.get(i).getCodigo();
                    row[1] = listaPregunta.get(i).getCodigoMetodologia().getTipo();
                    row[2] = listaPregunta.get(i).getEnunciado();
                    row[3] = listaPregunta.get(i).getRespuesta();

                    mostrarPregunta.getModelo().addRow(row);

                }
            }else{
              
                JOptionPane.showMessageDialog(mostrarPregunta, "No hay preguntas creadas aun", "Informacion", 1);
            
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(mostrarPregunta, e, "Error", 0);
        }

    }

    public void eliminarPregunta() {

        int row = mostrarPregunta.getjTablePregunta().getSelectedRow();//obtiene la fila seleccionada

        if (row > -1) {//si es -1 significa que no ha sido seleccionada ninguna

            try {

                Long codigoPregunta = Long.parseLong(mostrarPregunta.getModelo().getValueAt(row, 0).toString());

                Pregunta pregunta = DAOFactory.getPreguntaDAO().consultarPorId(codigoPregunta);

                EntityManagerHelper.beginTransaction();
                DAOFactory.getPreguntaDAO().eliminar(pregunta);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                JOptionPane.showMessageDialog(mostrarPregunta, "Pregunta eliminada con exito", "", JOptionPane.INFORMATION_MESSAGE);
                actualizar();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(mostrarPregunta, e, "Error", 0);

            }

        } else {
            JOptionPane.showMessageDialog(mostrarPregunta, "Selecciona una fila", "Aviso", 2);

        }
    }

    public void actualizar() {
        eliminarFilas();
        mostrarPreguntas();

    }

    public void eliminarFilas() {

        int filasActuales = mostrarPregunta.getModelo().getRowCount();

        try {

            for (int i = filasActuales - 1; i >= 0; i--) {

                mostrarPregunta.getModelo().removeRow(i);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(mostrarPregunta, "" + e, "Error", 0);

        }

    }

}

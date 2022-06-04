/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrEligeExamen implements ActionListener, MouseListener {

    private InterfazEligeExamen interfazEligeExamen;
    private List<Pregunta> preguntasGeneradas;
    private Examen examen;

    public CtrEligeExamen(InterfazEligeExamen interfazEligeExamen) {

        this.interfazEligeExamen = interfazEligeExamen;
        this.preguntasGeneradas = new ArrayList<Pregunta>();
        this.examen = new Examen();
        setClaseEstudiante();
        setJcListaExamenes();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(interfazEligeExamen.getjBCompite())) {

            if (!interfazEligeExamen.getJcListaExamen().getSelectedItem().equals("")) {

                generarExamen(interfazEligeExamen.getJcListaExamen().getSelectedItem().toString());//mandamos el examen escogido

            } else {

                JOptionPane.showMessageDialog(interfazEligeExamen, "Escoge un examen, si no te aparecen, aun no lo ha creado el profesor", "Error", 0);

            }

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(interfazEligeExamen.getJlAtras())) {

            interfazEligeExamen.dispose();
            new InterfazEstudiante(interfazEligeExamen.getEstudiante()).setVisible(true);

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

    public void setJcListaExamenes() {

        interfazEligeExamen.getJcListaExamen().addItem("");

        try {
            List<Examen> listaExamen = DAOFactory.getExamenDAO().consultar();//lista de los examenes

            if (listaExamen != null) { //si la lista de examenes tienen datos

                for (int i = 0; i < listaExamen.size(); i++) {

                    if (listaExamen.get(i).getCodigoClase().getCodigo()
                            == interfazEligeExamen.getClase().getCodigo())//si existen examenes con el codigo de la clase del estudiante
                    {

                        interfazEligeExamen.getJcListaExamen().addItem(listaExamen.get(i).getNombre());

                    }

                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void setClaseEstudiante() {

        try {
            Clase clase = DAOFactory.getClaseDAO().consultarPorId(interfazEligeExamen.getEstudiante().getCodigoClase().getCodigo());
            interfazEligeExamen.setClase(clase);// establecemos la clase

        } catch (Exception e) {

            JOptionPane.showMessageDialog(interfazEligeExamen, e, "Error", 0);
        }

    }

    public void generarExamen(String examenEscogido) {
        try {
            examen = DAOFactory.getExamenDAO().consultarPorNombre(examenEscogido);

            if (examen != null) {

                List<Pregunta> listaTotalPreguntas = DAOFactory.getPreguntaDAO().consultarPorExamen(examen);
//                (int)(Math.random() * palabras.length)
                if (listaTotalPreguntas != null && listaTotalPreguntas.size() > 4) {

                    Set<Pregunta> setTemp = new HashSet<Pregunta>();//lista donde no se admiten valores repetidos

                    boolean lleno = false;

                    while (lleno == false) {

                        int PosAleatoria = (int) (Math.random() * (listaTotalPreguntas.size()));

                        setTemp.add(listaTotalPreguntas.get(PosAleatoria));

                        if (setTemp.size() == 5) {

                            lleno = true;

                        }
                    }

                    preguntasGeneradas.addAll(setTemp);

                    System.out.println(preguntasGeneradas.toString());

                    mostrarExamen();

                } else {

                    JOptionPane.showMessageDialog(interfazEligeExamen, "El examen escogido no tiene un minino de 5 preguntas para ser realizado", examenEscogido, 0);

                }
//                examen.get;
//           

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(interfazEligeExamen, e, "", 0);
        }

    }

    public void mostrarExamen() {
    
        
        interfazEligeExamen.dispose();
        new RealizarExamen(preguntasGeneradas, interfazEligeExamen.getEstudiante(), examen).setVisible(true);
        
        
    }

}

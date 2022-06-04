/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Examen;
import co.edu.univalle.modelo.Metodologia;
import co.edu.univalle.modelo.Pregunta;
import co.edu.univalle.modelo.Profesor;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.vista.DisenoAdivinaPalabra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrDisenaAdivinaPalabra implements ActionListener {

    private DisenoAdivinaPalabra disenoAP;
    private Profesor profesor;
    private Examen examen;
    private Metodologia metodologia;

    public CtrDisenaAdivinaPalabra(DisenoAdivinaPalabra disenoAP, Profesor profesor, Examen examen) {
        this.disenoAP = disenoAP;
        this.profesor = profesor;
        this.examen = examen;
        objMetodologia();

    }

    public void objMetodologia() {//asignamos el objeto metodologia 1 AdivinaPalabara

        try {
            this.metodologia = DAOFactory.getMetodologiaDAO().consultarPorId(new Integer(1));

        } catch (Exception e) {
        }

    }

    ;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(disenoAP.getJbCrear())) {

            validarCampos();

        }

    }

    public void validarCampos() {

        if (!disenoAP.getJtEnunciado().getText().equals("") && !disenoAP.getJtRespuesta().getText().equals("")) {

            String respuesta = disenoAP.getJtRespuesta().getText();
            String enunciado = disenoAP.getJtEnunciado().getText();

            if (enunciado.length() < 150) {

                if (respuesta.matches("[a-zA-Z]+")) {

                    if (respuesta.length() > 3 && respuesta.length() < 18) {

                        crearPregunta();

                    } else {

                        JOptionPane.showMessageDialog(disenoAP, "La respuesta debe tener entre 4 a 17 caracteres", "Error", 0);

                    }

                } else {

                    JOptionPane.showMessageDialog(disenoAP, "La respuesta no debe tener espacios ni numeros", "Error", 0);

                }

            } else {

                JOptionPane.showMessageDialog(disenoAP, "El enunciado no puede sobrepasar los 150 caracteres", "Error", 0);

            }

        } else {

            JOptionPane.showMessageDialog(disenoAP, "Completa todos los campos", "Error", 0);

        }

    }

    public void crearPregunta() {

        try {
            String enunciado = disenoAP.getJtEnunciado().getText();
            String respuesta = disenoAP.getJtRespuesta().getText();

            Pregunta pregunta = new Pregunta();
            pregunta.setCodigoMetodologia(metodologia);
            pregunta.setCodigoProfesor(profesor);
            pregunta.setCodigoExamen(examen);
            pregunta.setEnunciado(enunciado);
            pregunta.setRespuesta(respuesta);

            EntityManagerHelper.beginTransaction();
            DAOFactory.getPreguntaDAO().insertar(pregunta);
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();

            JOptionPane.showMessageDialog(disenoAP, "Pregunta creada con exito!");
            limpiarDatos();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(disenoAP, e, "Error", 0);

        }

    }

    public void limpiarDatos() {

        disenoAP.getJtEnunciado().setText("");
        disenoAP.getJtRespuesta().setText("");

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Examen;
import co.edu.univalle.modelo.Pregunta;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface IpreguntaDAO {

    public void insertar(Pregunta pregunta) throws Exception;

    public void eliminar(Pregunta pregunta) throws Exception;

    public Pregunta consultarPorId(Long codigo) throws Exception;

    public List<Pregunta> consultarPorExamen(Examen examen) throws Exception;

    public List<Pregunta> consultar() throws Exception;
}

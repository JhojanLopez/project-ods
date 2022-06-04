/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.*;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface IexamenEstudianteDAO {

    public void insertar(ExamenEstudiante examenEstudiante) throws Exception;

    public void modificar(ExamenEstudiante examenEstudiante) throws Exception;
    
    public ExamenEstudiante consultarPorId(ExamenEstudiantePK examenEstudiantePK) throws Exception;

    public List<ExamenEstudiante> consultarPorExamen(int codigoExamen) throws Exception;

    public List<ExamenEstudiante> consultar() throws Exception;
}

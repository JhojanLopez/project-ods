/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Examen;
import co.edu.univalle.modelo.ExamenEstudiante;
import co.edu.univalle.modelo.ExamenEstudiantePK;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class ExamenEstudianteDAO implements IexamenEstudianteDAO {

    @Override
    public void insertar(ExamenEstudiante examenEstudiante) throws Exception {
        EntityManagerHelper.getEntityManager().persist(examenEstudiante);

    }

    @Override
    public void modificar(ExamenEstudiante examenEstudiante) throws Exception {
        EntityManagerHelper.getEntityManager().merge(examenEstudiante);
    }

    @Override
    public ExamenEstudiante consultarPorId(ExamenEstudiantePK examenEstudiantePK) throws Exception {
        return EntityManagerHelper.getEntityManager().find(ExamenEstudiante.class, examenEstudiantePK);
    }

    @Override
    public List<ExamenEstudiante> consultarPorExamen(int codigoExamen) throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("ExamenEstudiante.findByCodigoExamen");
        query.setParameter("codigoExamen", codigoExamen);
        return query.getResultList();
    }

    @Override
    public List<ExamenEstudiante> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("ExamenEstudiante.findAll");
        return query.getResultList();

    }

}

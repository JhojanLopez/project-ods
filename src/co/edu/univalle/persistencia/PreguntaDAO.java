/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Examen;
import co.edu.univalle.modelo.Pregunta;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class PreguntaDAO implements IpreguntaDAO {

    @Override
    public void insertar(Pregunta pregunta) throws Exception {
        EntityManagerHelper.getEntityManager().persist(pregunta);
    }

    @Override
    public void eliminar(Pregunta pregunta) throws Exception {
        EntityManagerHelper.getEntityManager().remove(pregunta);

    }

    @Override
    public List<Pregunta> consultarPorExamen(Examen examen) throws Exception {

        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Pregunta.findByExamen");
        query.setParameter("codigoExamen", examen);
        return query.getResultList();

    }

    @Override
    public List<Pregunta> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Pregunta.findAll");
        return query.getResultList();

    }

    @Override
    public Pregunta consultarPorId(Long codigo) throws Exception {
        return EntityManagerHelper.getEntityManager().find(Pregunta.class, codigo);
    }

}

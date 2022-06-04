/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Examen;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class ExamenDAO implements IexamenDAO {

    @Override
    public void insertar(Examen examen) throws Exception {
        EntityManagerHelper.getEntityManager().persist(examen);

    }

    @Override
    public Examen consultarPorId(int codigo) throws Exception {
        return EntityManagerHelper.getEntityManager().find(Examen.class, codigo);
    }

    @Override
    public Examen consultarPorNombre(String nombre) throws Exception {
        
        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Examen.findByNombre");
            query.setParameter("nombre", nombre);
            return (Examen) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Examen> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Examen.findAll");
        return query.getResultList();

    }

}

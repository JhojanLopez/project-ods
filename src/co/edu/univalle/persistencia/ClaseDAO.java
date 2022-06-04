/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Avatar;
import co.edu.univalle.modelo.Clase;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class ClaseDAO implements IclaseDAO {

    @Override
    public void insertar(Clase clase) throws Exception {
        EntityManagerHelper.getEntityManager().persist(clase);
    }

    @Override
    public Clase consultarPorId(int codigo) throws Exception {
        return EntityManagerHelper.getEntityManager().find(Clase.class, codigo);
    }

    @Override
    public Clase consultarPorNombre(String nombre) throws Exception {
        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Clase.findByNombre");
            query.setParameter("nombre", nombre);
            return (Clase) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Clase> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Clase.findAll");
        return query.getResultList();
    }

}

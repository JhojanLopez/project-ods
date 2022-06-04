/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Modulo;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class ModuloDAO implements ImoduloDAO {

    @Override
    public Modulo consultarPorId(int codigo) throws Exception {
        return EntityManagerHelper.getEntityManager().find(Modulo.class, codigo);
    }

    @Override
    public Modulo consultarPorNombre(String nombre) throws Exception {

        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Modulo.findByNombre");
            query.setParameter("nombre", nombre);
            return (Modulo) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Modulo> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Modulo.findAll");
        return query.getResultList();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.modelo.Profesor;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class ProfesorDAO implements IprofesorDAO {

    @Override
    public void insertar(Profesor profesor) throws Exception {
        EntityManagerHelper.getEntityManager().persist(profesor);
    }

    @Override
    public void modificar(Profesor profesor) throws Exception {
        EntityManagerHelper.getEntityManager().merge(profesor);
    }

    @Override
    public void eliminar(Profesor profesor) throws Exception {
        EntityManagerHelper.getEntityManager().remove(profesor);
    }

    @Override
    public Profesor consultarPorId(Long codigo) throws Exception {
      
        return EntityManagerHelper.getEntityManager().find(Profesor.class, codigo);
    }

    @Override
    public Profesor consultarPorNombre(String nombre) throws Exception {

        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Profesor.findByNombre");
            query.setParameter("nombre", nombre);
            return (Profesor) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Profesor consultarPorUsuario(String usuario) throws Exception {
        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Profesor.findByUsuario");
            query.setParameter("usuario", usuario);
            return (Profesor) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Profesor> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Profesor.findAll");
        return query.getResultList();
    }

}

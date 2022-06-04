/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Estudiante;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class EstudianteDAO implements IestudianteDAO {

    @Override
    public void insertar(Estudiante estudiante) throws Exception {
        EntityManagerHelper.getEntityManager().persist(estudiante);
    }

    @Override
    public void modificar(Estudiante estudiante) throws Exception {
        EntityManagerHelper.getEntityManager().merge(estudiante);
    }

    @Override
    public void eliminar(Estudiante estudiante) throws Exception {
        EntityManagerHelper.getEntityManager().remove(estudiante);
    }

    @Override
    public Estudiante consultarPorId(Long codigo) throws Exception {
        return EntityManagerHelper.getEntityManager().find(Estudiante.class, codigo);
    }

    @Override
    public Estudiante consultarPorNombre(String nombre) throws Exception {

        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Estudiante.findByNombre");
            query.setParameter("nombre", nombre);
            return (Estudiante) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Estudiante consultarPorUsuario(String usuario) throws Exception {
        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Estudiante.findByUsuario");
            query.setParameter("usuario", usuario);
            return (Estudiante) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Estudiante> consultarPorClase(Clase clase) throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Estudiante.findByCodigoClase");
        query.setParameter("codigoClase", clase);
        return query.getResultList();
        
    }

    @Override
    public List<Estudiante> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Estudiante.findAll");
        return query.getResultList();
    }

}

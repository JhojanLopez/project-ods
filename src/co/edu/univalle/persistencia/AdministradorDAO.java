/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Administrador;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class AdministradorDAO implements IadministradorDAO {

    @Override
    public void insertar(Administrador administrador) throws Exception {
        EntityManagerHelper.getEntityManager().persist(administrador);
    }

    @Override
    public void modificar(Administrador administrador) throws Exception {
        EntityManagerHelper.getEntityManager().merge(administrador);
    }

    @Override
    public void eliminar(Administrador administrador) throws Exception {
        EntityManagerHelper.getEntityManager().remove(administrador);
    }

    @Override
    public Administrador consultarPorId(Long codigo) throws Exception {
        return EntityManagerHelper.getEntityManager().find(Administrador.class, codigo);
    }

    @Override
    public Administrador consultarPorNombre(String nombre) throws Exception {

        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Administrador.findByNombre");
            query.setParameter("nombre", nombre);
            return (Administrador) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Administrador consultarPorUsuario(String usuario) throws Exception {
        try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Administrador.findByUsuario");
            query.setParameter("usuario", usuario);
            return (Administrador) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Administrador> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Administrador.findAll");
        return query.getResultList();
    }

}

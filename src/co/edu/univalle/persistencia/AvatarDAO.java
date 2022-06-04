/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.modelo.Avatar;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class AvatarDAO implements IavatarDAO{

    @Override
    public Avatar consultarPorId(int codigo) throws Exception {
      return EntityManagerHelper.getEntityManager().find(Avatar.class, codigo);
    }

    @Override
    public List<Avatar> consultar() throws Exception {
        Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Avatar.findAll");
        return query.getResultList();
   
    }

    @Override
    public Avatar consultarPorNombre(String nombre) throws Exception {
     try {

            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Avatar.findByNombre");
            query.setParameter("nombre", nombre);
            return (Avatar) query.getSingleResult();

        } catch (Exception e) {
            return null;
        }
    
    
    }


}

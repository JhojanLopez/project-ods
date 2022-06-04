/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Avatar;
import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Metodologia;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author JHOJAN L
 */
public class MetodologiaDAO implements ImetodologiaDAO {

    @Override
    public Metodologia consultarPorId(int codigo) throws Exception {
        return EntityManagerHelper.getEntityManager().find(Metodologia.class, codigo);
    }

}

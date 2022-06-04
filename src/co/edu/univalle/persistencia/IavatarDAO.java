/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Avatar;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface IavatarDAO {
    public Avatar consultarPorId(int codigo) throws Exception;
    public Avatar consultarPorNombre(String nombre) throws Exception;
    public List<Avatar> consultar() throws Exception;
}

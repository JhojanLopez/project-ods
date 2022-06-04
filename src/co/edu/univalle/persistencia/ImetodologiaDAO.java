/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;


import co.edu.univalle.modelo.Metodologia;
import co.edu.univalle.modelo.Modulo;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface ImetodologiaDAO {

    public Metodologia consultarPorId(int codigo) throws Exception;
}

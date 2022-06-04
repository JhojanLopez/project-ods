/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Clase;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface IclaseDAO {

    public void insertar(Clase clase) throws Exception;

    public Clase consultarPorId(int codigo) throws Exception;

    public Clase consultarPorNombre(String nombre) throws Exception;

    public List<Clase> consultar() throws Exception;
}

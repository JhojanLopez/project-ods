/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Administrador;
import co.edu.univalle.modelo.Profesor;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface IprofesorDAO {
    public void insertar(Profesor profesor) throws Exception;
    public void modificar(Profesor profesor) throws Exception;
    public void eliminar(Profesor profesor) throws Exception;
    public Profesor consultarPorId(Long codigo) throws Exception;
    public Profesor consultarPorNombre(String nombre) throws Exception;
    public Profesor consultarPorUsuario(String usuario) throws Exception;
    public List<Profesor> consultar() throws Exception;
}

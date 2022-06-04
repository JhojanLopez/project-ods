/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Administrador;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface IadministradorDAO {
    public void insertar(Administrador administrador) throws Exception;
    public void modificar(Administrador administrador) throws Exception;
    public void eliminar(Administrador administrador) throws Exception;
    public Administrador consultarPorId(Long codigo) throws Exception;
    public Administrador consultarPorNombre(String nombre) throws Exception;
    public Administrador consultarPorUsuario(String usuario) throws Exception;
    public List<Administrador> consultar() throws Exception;
}

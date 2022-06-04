/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import co.edu.univalle.modelo.Clase;
import co.edu.univalle.modelo.Estudiante;
import java.util.List;

/**
 *
 * @author JHOJANL
 */
public interface IestudianteDAO {
    public void insertar(Estudiante estudiante) throws Exception;
    public void modificar(Estudiante estudiante) throws Exception;
    public void eliminar(Estudiante estudiante) throws Exception;
    public Estudiante consultarPorId(Long codigo) throws Exception;
    public Estudiante consultarPorNombre(String nombre) throws Exception;
    public Estudiante consultarPorUsuario(String usuario) throws Exception;
    public List<Estudiante>consultarPorClase(Clase clase)throws Exception;
    public List<Estudiante> consultar() throws Exception;
}

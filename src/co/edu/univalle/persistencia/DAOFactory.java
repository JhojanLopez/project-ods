/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.persistencia;

import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class DAOFactory {

    private static IadministradorDAO administradorDAO = new AdministradorDAO();
    private static IavatarDAO avatarDAO = new AvatarDAO();
    private static IprofesorDAO profesorDAO = new ProfesorDAO();
    private static IestudianteDAO estudianteDAO = new EstudianteDAO();
    private static IclaseDAO claseDAO = new ClaseDAO();
    private static IexamenDAO examenDAO = new ExamenDAO();
    private static ImoduloDAO moduloDAO = new ModuloDAO();
    private static IpreguntaDAO preguntaDAO = new PreguntaDAO();
    private static ImetodologiaDAO metodologiaDAO = new MetodologiaDAO();
    private static IexamenEstudianteDAO examenEstudianteDAO = new ExamenEstudianteDAO();

    public static IexamenEstudianteDAO getExamenEstudianteDAO() {
        return examenEstudianteDAO;
    }

    public static ImetodologiaDAO getMetodologiaDAO() {
        return metodologiaDAO;
    }

    public static IpreguntaDAO getPreguntaDAO() {
        return preguntaDAO;
    }

    public static ImoduloDAO getModuloDAO() {
        return moduloDAO;
    }

    public static IexamenDAO getExamenDAO() {
        return examenDAO;
    }

    public static IadministradorDAO getAdministradorDAO() {
        return administradorDAO;
    }

    public static IavatarDAO getAvatarDAO() {
        return avatarDAO;
    }

    public static IprofesorDAO getProfesorDAO() {
        return profesorDAO;
    }

    public static IestudianteDAO getEstudianteDAO() {
        return estudianteDAO;
    }

    public static IclaseDAO getClaseDAO() {
        return claseDAO;
    }

}

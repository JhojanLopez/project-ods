/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.validacion.ValidacionAdministrador;
import co.edu.univalle.validacion.ValidacionProfesor;
import co.edu.univalle.vista.GestionProfesor;
import java.awt.event.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrGestionProfesor implements ActionListener {

    private GestionProfesor gestionProfesor;
    private List<Profesor> listaProfesor;
    private Administrador adminLog;

    public CtrGestionProfesor(GestionProfesor gestionProfesor, Administrador adminLog) {

        this.gestionProfesor = gestionProfesor;
        this.adminLog = adminLog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {//action performed determinara que metodo usar

        if (e.getSource().equals(gestionProfesor.getJbMostrar())) {

            consultarProfesoresDisponibles();//busca todos

        } else if (e.getSource().equals(gestionProfesor.getJbAgregaFilas())) {

            agregarFila();

        } else if (e.getSource().equals(gestionProfesor.getJbEliminarFila())) {

            eliminarFila();

        } else if (e.getSource().equals(gestionProfesor.getJbBuscar())) {

            String parametro = gestionProfesor.getJtBusqueda().getText();//capturo el parametro

            verificarBusqueda(parametro);

        } else if (e.getSource().equals(gestionProfesor.getJbCrear())) {

            crearProfesor();

        } else if (e.getSource().equals(gestionProfesor.getJbModificar())) {

            modificarProfesor();

        } else if (e.getSource().equals(gestionProfesor.getJbEliminar())) {

            eliminarProfesor();

        } else if (e.getSource().equals(gestionProfesor.getJbLimpiar())) {

            limpiarDatos();

        }

    }

    public void consultarProfesoresDisponibles() {//consulto todos los profesores
        try {

            EntityManagerHelper.beginTransaction();
            listaProfesor = DAOFactory.getProfesorDAO().consultar();
            EntityManagerHelper.closeEntityManager();
            mostrarTodosDatos();//muestra todos los datos en la JTable

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "" + ex, "Error", 0);
        }
    }

    public void limpiarDatos() {//limpia toda la tabla

        int filasActuales = gestionProfesor.getModelo().getRowCount() - 1;

        if (filasActuales >= 0) {

            String matriz[][] = new String[filasActuales + 1][7];

            for (int i = 0; i < matriz.length; i++) {

                for (int c = 0; c < matriz[0].length; c++) {

                    gestionProfesor.getJtablaGestionProfesor().setValueAt("", i, c);

                }
            }
        }
    }

    public void agregarFila() {//agrega una fila a la tabla

        Object row[] = new Object[1];
        gestionProfesor.getModelo().addRow(row);

    }

    public void eliminarTodasFilas() {//elimina todas las filas de laas tablas

        int filasActuales = gestionProfesor.getJtablaGestionProfesor().getRowCount();

        try {

            for (int i = filasActuales - 1; i >= 0; i--) {

                gestionProfesor.getModelo().removeRow(i);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionProfesor, "" + e, "Error", 0);
            System.out.println("" + gestionProfesor.getJtablaGestionProfesor().getRowCount());

        }

    }

    public void eliminarFila() {//elimina una fila de la tabla

        int filasActuales = gestionProfesor.getJtablaGestionProfesor().getRowCount() - 1;

        if (filasActuales >= 0) {
            gestionProfesor.getModelo().removeRow(filasActuales);
        }
    }

    public void verificarBusqueda(String parametro) {//determina que tipo de busqueda realizar

        if (!gestionProfesor.getJcBuscar().getSelectedItem().equals("")) {

            if (!parametro.equals("")) {

                if (gestionProfesor.getJcBuscar().getSelectedItem().equals("Codigo")) {//si busca por codigo

                    busquedaCodigo(parametro);

                } else if (gestionProfesor.getJcBuscar().getSelectedItem().equals("Nombre")) {//si busca por nombre

                    busquedaNombre(parametro);

                } else if (gestionProfesor.getJcBuscar().getSelectedItem().equals("Usuario")) {

                    busquedaUsuario(parametro);
                }

            } else {
                JOptionPane.showMessageDialog(gestionProfesor, "Digite datos para la busqueda", "Error", 0);

            }

        } else {

            JOptionPane.showMessageDialog(gestionProfesor, "Complete un parametro para la busqueda", "Error", 0);
        }

    }

    public void busquedaCodigo(String codigo) {

        try {
            long codigoBuscar = Long.parseLong(codigo);
            Profesor profesor = DAOFactory.getProfesorDAO().consultarPorId(codigoBuscar);

            if (profesor != null) {//si existe el administrador

                agregarDatos(profesor);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionProfesor, "El profesor buscado no existe", "Aviso", 2);

            }

        } catch (java.lang.NumberFormatException ex) {

            JOptionPane.showMessageDialog(gestionProfesor, "El dato digitado no corresponde a un numero", "error", 0);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionProfesor, "" + e, "error", 0);
            System.out.println("" + e);
        }
    }

    public void busquedaNombre(String nombre) {

        try {

            Profesor profesor = DAOFactory.getProfesorDAO().consultarPorNombre(nombre);//busca por nombre

            if (profesor != null) {//si existe el administrador

                agregarDatos(profesor);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionProfesor, "El Profesor buscado no existe", "Aviso", 2);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionProfesor, "" + e, "Error", 0);
            System.out.println("" + e);
        }

    }

    public void busquedaUsuario(String usuario) {

        try {

            Profesor profesor = DAOFactory.getProfesorDAO().consultarPorUsuario(usuario);//busca por nombre

            if (profesor != null) {//si existe el administrador

                agregarDatos(profesor);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionProfesor, "El Profesor buscado no existe", "Aviso", 2);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionProfesor, "" + e, "Error", 0);
            System.out.println("" + e);
        }
    }

    public void agregarDatos(Profesor profesor) {//agrega un profe a la tabla que se ha buscado

        eliminarTodasFilas();//elimina todos los datos de la tabla
        Object row[] = new Object[7];

        row[0] = profesor.getCodigo();
        row[1] = profesor.getNombre();
        row[2] = profesor.getUsuario();
        row[3] = profesor.getEdad();
        row[4] = profesor.getGenero();
        row[5] = profesor.getContrasena();
        row[6] = profesor.getCodigoAvatar();

        gestionProfesor.getModelo().addRow(row);

    }

    private void crearProfesor() {//creamos un objeto profesor para asignarlo en la BD

        if (!gestionProfesor.getJcAgregar().getSelectedItem().equals("")) {

            int row = gestionProfesor.getJtablaGestionProfesor().getSelectedRow();//obtiene la fila seleccionada
            try {

                if (row > -1) {//si es -1 significa que no ha sido seleccionada ninguna
                    String nombre = gestionProfesor.getModelo().getValueAt(row, 1).toString();//obtiene datos de la tabla
                    String usuario = gestionProfesor.getModelo().getValueAt(row, 2).toString();
                    int edad = Integer.parseInt(gestionProfesor.getModelo().getValueAt(row, 3).toString());
                    String genero = gestionProfesor.getModelo().getValueAt(row, 4).toString();
                    String contrasena = gestionProfesor.getModelo().getValueAt(row, 5).toString();
                    int codAvatarDigitado = Integer.parseInt(gestionProfesor.getModelo().getValueAt(row, 6).toString());

                    Profesor profesor = new Profesor();//Construyo el objeto
                    profesor.setNombre(nombre);
                    profesor.setUsuario(usuario);
                    profesor.setEdad(edad);
                    profesor.setGenero(genero);
                    profesor.setContrasena(contrasena);

                    codAvatar(profesor, codAvatarDigitado, 0);//determinamos el cod Avatar
                } else {

                    JOptionPane.showMessageDialog(gestionProfesor, "No has seleccionado ninguna fila", "Error", 0);

                }
            } catch (java.lang.NumberFormatException ex) {

                JOptionPane.showMessageDialog(gestionProfesor, "En la edad o codigo avatar se debe digitar un numero entero", "Error", 0);

            } catch (java.lang.NullPointerException exc) {

                JOptionPane.showMessageDialog(gestionProfesor, "Datos incompletos para crear el profesor", "Error", 0);
                System.out.println("" + exc);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionProfesor, "" + e, "Error", 0);

                System.out.println("" + e);
            }

        } else {

            JOptionPane.showMessageDialog(gestionProfesor, "Selecciona un parametro", "Aviso", 2);
        }
    }

    public void mostrarTodosDatos() {//muestro todos los admins disponibles (se excluye el administrador logeado)

        eliminarTodasFilas();
        Object row[] = new Object[7];

        for (int i = 0; i < listaProfesor.size(); i++) {

            row[0] = listaProfesor.get(i).getCodigo();
            row[1] = listaProfesor.get(i).getNombre();
            row[2] = listaProfesor.get(i).getUsuario();
            row[3] = listaProfesor.get(i).getEdad();
            row[4] = listaProfesor.get(i).getGenero();
            row[5] = listaProfesor.get(i).getContrasena();
            row[6] = listaProfesor.get(i).getCodigoAvatar();

            gestionProfesor.getModelo().addRow(row);

        }

    }

    public void codAvatar(Profesor profesor, int codAvatar, int funcion) {//determina si el codigo del avatar esta correcto, si existe o no

        List<Avatar> listaAvatar;
        boolean avatarExiste = false;
        int posEncontrada = 0;//posicion encontrada del codAvatar en bd

        try {
            listaAvatar = DAOFactory.getAvatarDAO().consultar();

            for (int i = 0; i < listaAvatar.size(); i++) {

                if (listaAvatar.get(i).getCodigo() == codAvatar) {//si se encuentra el codigo digitado

                    avatarExiste = true;
                    posEncontrada = i;
                    break;//rompemos el ciclo

                } else {//si no se encuentra

                    avatarExiste = false;
                }
            }

            if (avatarExiste) {//Si existe se establece en el objeto y se pasa a validar 

                if (funcion == 0) {//SI ES 0 inserta el profesor
                    profesor.setCodigoAvatar(listaAvatar.get(posEncontrada));
                    insertProfesor(profesor);// se pasa a validar el profesor e insertarlo

                } else if (funcion == 1) {//SI ES 1 actualiza el administrador

                    profesor.setCodigoAvatar(listaAvatar.get(posEncontrada));
                    updateProfesor(profesor);// se pasa a validar el administrador

                }
            } else {

                JOptionPane.showMessageDialog(gestionProfesor, "El codigo avatar digitado no existe", "Error", 0);
            }

        } catch (Exception e) {

            System.out.println("" + e);

        }

    }

    public void insertProfesor(Profesor profesor) {//se creara el profesorr pero primero se valida

        ValidacionProfesor validacion = new ValidacionProfesor(profesor);

        if (validacion.validacionNombre() && validacion.validacionUsuario() && validacion.validacionEdad()
               && validacion.validacionGenero() && validacion.validacionPassword()) {// se valida el profesor usando la clase ValidacionAdministrador package validaciones

            try {
                EntityManagerHelper.beginTransaction();
                DAOFactory.getProfesorDAO().insertar(profesor);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                Profesor profesorCreado = DAOFactory.getProfesorDAO().consultarPorUsuario(profesor.getUsuario());

                JOptionPane.showMessageDialog(gestionProfesor, "Profesor creado con exito!\n"
                        + "Codigo generado: " + profesorCreado.getCodigo(), "", 3);
                
                consultarProfesoresDisponibles();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionProfesor, e, "Error", 0);
            }

        }

    }

    public void modificarProfesor() {

        if (!gestionProfesor.getJcModificar().getSelectedItem().equals("")) {
            int row = gestionProfesor.getJtablaGestionProfesor().getSelectedRow();

            if (row > -1) {//Si selecciono una fila

                Object codigo = gestionProfesor.getModelo().getValueAt(row, 0);//obtiene datos de la tabla

                if (codigo != null) {

                    try {//se procede a modificar 
                        long codigoProfesor = Long.parseLong(gestionProfesor.getModelo().getValueAt(row, 0).toString());
                        String nombre = gestionProfesor.getModelo().getValueAt(row, 1).toString();//obtiene datos de la tabla
                        String usuario = gestionProfesor.getModelo().getValueAt(row, 2).toString();
                        int edad = Integer.parseInt(gestionProfesor.getModelo().getValueAt(row, 3).toString());
                        String genero = gestionProfesor.getModelo().getValueAt(row, 4).toString();
                        String contrasena = gestionProfesor.getModelo().getValueAt(row, 5).toString();
                        int codAvatarDigitado = Integer.parseInt(gestionProfesor.getModelo().getValueAt(row, 6).toString());

                        Profesor profesor = new Profesor();//Construyo el objeto
                        profesor.setCodigo(codigoProfesor);//establecemos el cod
                        profesor.setNombre(nombre);
                        profesor.setUsuario(usuario);
                        profesor.setEdad(edad);
                        profesor.setGenero(genero);
                        profesor.setContrasena(contrasena);

                        codAvatar(profesor, codAvatarDigitado, 1);//determinaamos el cod Avatar
                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(gestionProfesor, e, "Error", 0);
                        System.out.println("" + e);
                    }

                } else {

                    JOptionPane.showMessageDialog(gestionProfesor, "El profesor a modificar no existe", "Error", 0);

                }

            }

        } else {

            JOptionPane.showMessageDialog(gestionProfesor, "Selecciona un parametro para modificar", "Aviso", 2);

        }

    }

    public void updateProfesor(Profesor profesor) {//actualizara el profesor en la bd

        ValidacionProfesor validacion = new ValidacionProfesor(profesor);//mandamos el profesor que vamos a validar
        
        if (validacion.validacionModificar() && validacion.validacionEdad()
                && validacion.validacionGenero() && validacion.validacionPassword()) {

            try {

                EntityManagerHelper.beginTransaction();
                DAOFactory.getProfesorDAO().modificar(profesor);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(gestionProfesor, "Modificado con exito", "Aviso", 1);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionProfesor, e);
            }

        }
    }

    public void eliminarProfesor() {

        if (!gestionProfesor.getJcEliminar().getSelectedItem().equals("")) {

            int row = gestionProfesor.getJtablaGestionProfesor().getSelectedRow();

            if (row > -1) {//Si selecciono una fila

                Object codigo = gestionProfesor.getModelo().getValueAt(row, 0);//obtiene el cod del profesor

                if (codigo != null) {

                    try {//se procede a modificar 
                        long codigoProfesor = Long.parseLong(gestionProfesor.getModelo().getValueAt(row, 0).toString());

                        Profesor profesor = DAOFactory.getProfesorDAO().consultarPorId(codigoProfesor);

                        int respuesta = JOptionPane.showConfirmDialog(gestionProfesor, "Estas seguro de eliminar al profesor con codigo:"
                                + profesor.getCodigo(), "Aviso", JOptionPane.YES_NO_CANCEL_OPTION, 2);

                        if (respuesta == JOptionPane.YES_OPTION) {

                            EntityManagerHelper.beginTransaction();
                            DAOFactory.getProfesorDAO().eliminar(profesor);
                            EntityManagerHelper.commit();
                            EntityManagerHelper.closeEntityManager();

                            JOptionPane.showMessageDialog(gestionProfesor, "Profesor eliminado con exito", "", JOptionPane.INFORMATION_MESSAGE);
                            consultarProfesoresDisponibles();
                        }

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(gestionProfesor, e, "Error", 0);
                        System.out.println("" + e);
                    }

                } else {

                    JOptionPane.showMessageDialog(gestionProfesor, "El profesor a eliminar no existe", "Error", 0);

                }

            }

        } else {

            JOptionPane.showMessageDialog(gestionProfesor, "Selecciona un parametro para eliminar", "Aviso", 2);

        }
    }
}

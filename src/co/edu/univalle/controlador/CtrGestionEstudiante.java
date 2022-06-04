/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.validacion.ValidacionAdministrador;
import co.edu.univalle.validacion.ValidacionEstudiante;
import co.edu.univalle.validacion.ValidacionProfesor;
import co.edu.univalle.vista.GestionEstudiante;
import co.edu.univalle.vista.GestionProfesor;
import java.awt.event.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrGestionEstudiante implements ActionListener {

    private GestionEstudiante gestionEstudiante;
    private List<Estudiante> listaEstudiante;//lista la cual almacena todos los estudiantes de la bd
    private Administrador adminLog;

    public CtrGestionEstudiante(GestionEstudiante gestionEstudiante, Administrador adminLog) {

        this.gestionEstudiante = gestionEstudiante;
        this.adminLog = adminLog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {//action performed determinara que metodo usar

        if (e.getSource().equals(gestionEstudiante.getJbMostrar())) {

            consultarEstudiantesDisponibles();//busca todos

        } else if (e.getSource().equals(gestionEstudiante.getJbAgregaFilas())) {

            agregarFila();

        } else if (e.getSource().equals(gestionEstudiante.getJbEliminarFila())) {

            eliminarFila();

        } else if (e.getSource().equals(gestionEstudiante.getJbBuscar())) {

            String parametro = gestionEstudiante.getJtBusqueda().getText();//capturo el parametro

            verificarBusqueda(parametro);

        } else if (e.getSource().equals(gestionEstudiante.getJbCrear())) {

            crearEstudiante();

        } else if (e.getSource().equals(gestionEstudiante.getJbModificar())) {

            modificarEstudiante();

        } else if (e.getSource().equals(gestionEstudiante.getJbEliminar())) {

            eliminarEstudiante();

        } else if (e.getSource().equals(gestionEstudiante.getJbLimpiar())) {

            limpiarDatos();

        }

    }

    public void consultarEstudiantesDisponibles() {//consulto todos los estudiantes
        try {

            EntityManagerHelper.beginTransaction();
            listaEstudiante = DAOFactory.getEstudianteDAO().consultar();
            EntityManagerHelper.closeEntityManager();
            mostrarTodosDatos();//muestra todos los datos en la JTable

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "" + ex, "Error", 0);
        }
    }

    public void limpiarDatos() {//limpia toda la tabla

        int filasActuales = gestionEstudiante.getModelo().getRowCount() - 1;

        if (filasActuales >= 0) {

            String matriz[][] = new String[filasActuales + 1][8];

            for (int i = 0; i < matriz.length; i++) {

                for (int c = 0; c < matriz[0].length; c++) {

                    gestionEstudiante.getJtablaGestionEstudiante().setValueAt("", i, c);

                }
            }
        }
    }

    public void agregarFila() {//agrega una fila a la tabla

        Object row[] = new Object[1];
        gestionEstudiante.getModelo().addRow(row);

    }

    public void agregarDatos(Estudiante estudiante) {//agrega un profe a la tabla que se ha buscado

        eliminarTodasFilas();//elimina todos los datos de la tabla
        Object row[] = new Object[8];

        row[0] = estudiante.getCodigo();
        row[1] = estudiante.getNombre();
        row[2] = estudiante.getUsuario();
        row[3] = estudiante.getEdad();
        row[4] = estudiante.getGenero();
        row[5] = estudiante.getContrasena();
        row[6] = estudiante.getCodigoClase();
        row[7] = estudiante.getCodigoAvatar();

        gestionEstudiante.getModelo().addRow(row);

    }

    public void mostrarTodosDatos() {//muestro todos los admins disponibles (se excluye el administrador logeado)

        eliminarTodasFilas();
        Object row[] = new Object[8];

        for (int i = 0; i < listaEstudiante.size(); i++) {

            row[0] = listaEstudiante.get(i).getCodigo();
            row[1] = listaEstudiante.get(i).getNombre();
            row[2] = listaEstudiante.get(i).getUsuario();
            row[3] = listaEstudiante.get(i).getEdad();
            row[4] = listaEstudiante.get(i).getGenero();
            row[5] = listaEstudiante.get(i).getContrasena();
            row[6] = listaEstudiante.get(i).getCodigoClase();
            row[7] = listaEstudiante.get(i).getCodigoAvatar();

            gestionEstudiante.getModelo().addRow(row);

        }

    }

    public void eliminarTodasFilas() {//elimina todas las filas de laas tablas

        int filasActuales = gestionEstudiante.getJtablaGestionEstudiante().getRowCount();

        try {

            for (int i = filasActuales - 1; i >= 0; i--) {

                gestionEstudiante.getModelo().removeRow(i);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionEstudiante, "" + e, "Error", 0);

        }

    }

    public void eliminarFila() {//elimina una fila de la tabla

        int filasActuales = gestionEstudiante.getJtablaGestionEstudiante().getRowCount() - 1;

        if (filasActuales >= 0) {
            gestionEstudiante.getModelo().removeRow(filasActuales);
        }
    }

    public void verificarBusqueda(String parametro) {//determina que tipo de busqueda realizar

        if (!gestionEstudiante.getJcBuscar().getSelectedItem().equals("")) {

            if (!parametro.equals("")) {

                if (gestionEstudiante.getJcBuscar().getSelectedItem().equals("Codigo")) {//si busca por codigo

                    busquedaCodigo(parametro);

                } else if (gestionEstudiante.getJcBuscar().getSelectedItem().equals("Nombre")) {//si busca por nombre

                    busquedaNombre(parametro);

                } else if (gestionEstudiante.getJcBuscar().getSelectedItem().equals("Usuario")) {

                    busquedaUsuario(parametro);
                }

            } else {
                JOptionPane.showMessageDialog(gestionEstudiante, "Digite datos para la busqueda", "Error", 0);

            }

        } else {

            JOptionPane.showMessageDialog(gestionEstudiante, "Complete un parametro para la busqueda", "Error", 0);
        }

    }

    public void busquedaCodigo(String codigo) {

        try {
            long codigoBuscar = Long.parseLong(codigo);
            Estudiante estudiante = DAOFactory.getEstudianteDAO().consultarPorId(codigoBuscar);

            if (estudiante != null) {//si existe el estudiante

                agregarDatos(estudiante);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionEstudiante, "El estudiante buscado no existe", "Aviso", 2);

            }

        } catch (java.lang.NumberFormatException ex) {

            JOptionPane.showMessageDialog(gestionEstudiante, "El dato digitado no corresponde a un numero", "error", 0);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionEstudiante, "" + e, "error", 0);
            System.out.println("" + e);
        }
    }

    public void busquedaNombre(String nombre) {

        try {

            Estudiante estudiante = DAOFactory.getEstudianteDAO().consultarPorNombre(nombre);//busca por nombre

            if (estudiante != null) {//si existe el administrador

                agregarDatos(estudiante);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionEstudiante, "El estudiante buscado no existe", "Aviso", 2);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionEstudiante, "" + e, "Error", 0);
            System.out.println("" + e);
        }

    }

    public void busquedaUsuario(String usuario) {

        try {

            Estudiante estudiante = DAOFactory.getEstudianteDAO().consultarPorUsuario(usuario);//busca por nombre

            if (estudiante != null) {//si existe el administrador

                agregarDatos(estudiante);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionEstudiante, "El Estudiante buscado no existe", "Aviso", 2);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionEstudiante, "" + e, "Error", 0);
            System.out.println("" + e);
        }
    }

    private void crearEstudiante() {//creamos un objeto estudiante para asignarlo en la BD

        if (!gestionEstudiante.getJcAgregar().getSelectedItem().equals("")) {

            int row = gestionEstudiante.getJtablaGestionEstudiante().getSelectedRow();//obtiene la fila seleccionada
            try {

                if (row > -1) {//si es -1 significa que no ha sido seleccionada ninguna

                    String nombre = gestionEstudiante.getModelo().getValueAt(row, 1).toString();//obtiene datos de la tabla
                    String usuario = gestionEstudiante.getModelo().getValueAt(row, 2).toString();
                    int edad = Integer.parseInt(gestionEstudiante.getModelo().getValueAt(row, 3).toString());
                    String genero = gestionEstudiante.getModelo().getValueAt(row, 4).toString();
                    String contrasena = gestionEstudiante.getModelo().getValueAt(row, 5).toString();
                    Object codClaseDigitado = gestionEstudiante.getModelo().getValueAt(row, 6);
                    int codAvatarDigitado = Integer.parseInt(gestionEstudiante.getModelo().getValueAt(row, 7).toString());

                    Estudiante estudiante = new Estudiante();//Construyo el objeto
                    estudiante.setNombre(nombre);
                    estudiante.setUsuario(usuario);
                    estudiante.setEdad(edad);
                    estudiante.setGenero(genero);
                    estudiante.setContrasena(contrasena);

                    determinarCodClase(estudiante, codClaseDigitado, codAvatarDigitado, 0);
                } else {

                    JOptionPane.showMessageDialog(gestionEstudiante, "No has seleccionado ninguna fila", "Error", 0);

                }
            } catch (java.lang.NumberFormatException ex) {

                JOptionPane.showMessageDialog(gestionEstudiante, "La edad, monedas y codigo avatar deben ser un numero entero", "Error", 0);

            } catch (java.lang.NullPointerException exc) {

                JOptionPane.showMessageDialog(gestionEstudiante, "Datos incompletos para crear el estudiante", "Error", 0);
                System.out.println("" + exc);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionEstudiante, "" + e, "Error", 0);

                System.out.println("" + e);
            }

        } else {

            JOptionPane.showMessageDialog(gestionEstudiante, "Selecciona un parametro", "Aviso", 2);
        }
    }

    public void insertEstudiante(Estudiante estudiante) {//se creara el profesorr pero primero se valida

        ValidacionEstudiante validacion = new ValidacionEstudiante(estudiante);

        if (validacion.validacionNombre() && validacion.validacionUsuario() && validacion.validacionEdad()
                && validacion.validacionGenero() && validacion.validacionPassword()) {// se valida el profesor usando la clase ValidacionAdministrador package validaciones

            try {
                EntityManagerHelper.beginTransaction();
                DAOFactory.getEstudianteDAO().insertar(estudiante);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                Estudiante estudianteCreado = DAOFactory.getEstudianteDAO().consultarPorUsuario(estudiante.getUsuario());
                
                JOptionPane.showMessageDialog(gestionEstudiante, "Estudiante creado con exito!\n"
                        + "Codigo generado: " + estudianteCreado.getCodigo(), "", 3);

                consultarEstudiantesDisponibles();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionEstudiante, e, "Error", 0);
            }

        }

    }

    public void modificarEstudiante() {

        if (!gestionEstudiante.getJcModificar().getSelectedItem().equals("")) {
            int row = gestionEstudiante.getJtablaGestionEstudiante().getSelectedRow();

            if (row > -1) {//Si selecciono una fila

                Object codigo = gestionEstudiante.getModelo().getValueAt(row, 0);//obtiene datos de la tabla

                if (codigo != null) {

                    try {//se procede a modificar 
                        long codEstudiante = Long.parseLong(gestionEstudiante.getModelo().getValueAt(row, 0).toString());
                        String nombre = gestionEstudiante.getModelo().getValueAt(row, 1).toString();//obtiene datos de la tabla
                        String usuario = gestionEstudiante.getModelo().getValueAt(row, 2).toString();
                        int edad = Integer.parseInt(gestionEstudiante.getModelo().getValueAt(row, 3).toString());
                        String genero = gestionEstudiante.getModelo().getValueAt(row, 4).toString();
                        String contrasena = gestionEstudiante.getModelo().getValueAt(row, 5).toString();  
                        Object codClaseDigitado = gestionEstudiante.getModelo().getValueAt(row, 6);
                        int codAvatarDigitado = Integer.parseInt(gestionEstudiante.getModelo().getValueAt(row, 7).toString());

                        Estudiante estudiante = new Estudiante();//Construyo el objeto
                        estudiante.setCodigo(codEstudiante);
                        estudiante.setNombre(nombre);
                        estudiante.setUsuario(usuario);
                        estudiante.setEdad(edad);
                        estudiante.setGenero(genero);
                        estudiante.setContrasena(contrasena);
                        
                        determinarCodClase(estudiante, codClaseDigitado, codAvatarDigitado, 1);

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(gestionEstudiante, e, "Error", 0);
                        System.out.println("" + e);
                    }

                } else {

                    JOptionPane.showMessageDialog(gestionEstudiante, "El profesor a modificar no existe", "Error", 0);

                }

            }

        } else {

            JOptionPane.showMessageDialog(gestionEstudiante, "Selecciona un parametro para modificar", "Aviso", 2);

        }

    }

    public void updateEstudiante(Estudiante estudiante) {//actualizara el est en la bd

        ValidacionEstudiante validacion = new ValidacionEstudiante(estudiante);//mandamos el est que vamos a validar

        if (validacion.validacionModificar() && validacion.validacionEdad()
                && validacion.validacionGenero() && validacion.validacionPassword()) {

            try {

                EntityManagerHelper.beginTransaction();
                DAOFactory.getEstudianteDAO().modificar(estudiante);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(gestionEstudiante, "Modificado con exito", "Aviso", 1);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionEstudiante, e);
            }

        }
    }

    public void eliminarEstudiante() {

        if (!gestionEstudiante.getJcEliminar().getSelectedItem().equals("")) {

            int row = gestionEstudiante.getJtablaGestionEstudiante().getSelectedRow();

            if (row > -1) {//Si selecciono una fila

                Object codigo = gestionEstudiante.getModelo().getValueAt(row, 0);//obtiene el cod del profesor

                if (codigo != null) {

                    try {//se procede a modificar 
                        long codEstudiante = Long.parseLong(gestionEstudiante.getModelo().getValueAt(row, 0).toString());

                        Estudiante estudiante = DAOFactory.getEstudianteDAO().consultarPorId(codEstudiante);

                        int respuesta = JOptionPane.showConfirmDialog(gestionEstudiante, "Estas seguro de eliminar al profesor con codigo:"
                                + estudiante.getCodigo(), "Aviso", JOptionPane.YES_NO_CANCEL_OPTION, 2);

                        if (respuesta == JOptionPane.YES_OPTION) {

                            EntityManagerHelper.beginTransaction();
                            DAOFactory.getEstudianteDAO().eliminar(estudiante);
                            EntityManagerHelper.commit();
                            EntityManagerHelper.closeEntityManager();

                            JOptionPane.showMessageDialog(gestionEstudiante, "Estudiante eliminado con exito", "", JOptionPane.INFORMATION_MESSAGE);
                            consultarEstudiantesDisponibles();
                        }

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(gestionEstudiante, e, "Error", 0);
                        System.out.println("" + e);
                    }

                } else {

                    JOptionPane.showMessageDialog(gestionEstudiante, "El Estudiante a eliminar no existe", "Error", 0);

                }

            }

        } else {

            JOptionPane.showMessageDialog(gestionEstudiante, "Selecciona un parametro para eliminar", "Aviso", 2);

        }
    }

    public void determinarCodClase(Estudiante estudiante, Object codClaseDigitado, int codAvatarDigitado, int funcion) {

        List<Clase> listaClase;
        boolean claseExiste = false;
        int posEncontrada = 0;

        if (codClaseDigitado == null) {

            estudiante.setCodigoClase(null);//establecemos null
            codAvatar(estudiante, codAvatarDigitado, funcion);//mandamos a determinar el codigo del avatar

        } else if (codClaseDigitado != null) {

            try {
                int codClase = Integer.parseInt(codClaseDigitado.toString());

                listaClase = DAOFactory.getClaseDAO().consultar();

                for (int i = 0; i < listaClase.size(); i++) {

                    if (listaClase.get(i).getCodigo() == codClase) {//si se encuentra el codigo digitado

                        claseExiste = true;
                        posEncontrada = i;
                        break;//rompemos el ciclo

                    } else {//si no se encuentra

                        claseExiste = false;
                    }
                }

                if (claseExiste) {//Si existe se establece en el objeto  

                    estudiante.setCodigoClase(listaClase.get(posEncontrada));//asignamos el cod de la clase
                    codAvatar(estudiante, codClase, funcion);

                } else {//si no existe

                    JOptionPane.showMessageDialog(gestionEstudiante, "El codigo de clase digitado no existe", "Error", 0);
                }

            } catch (java.lang.NumberFormatException ex) {

                JOptionPane.showMessageDialog(gestionEstudiante, "El codigo de la clase debe ser un numero entero", "Error", 0);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(gestionEstudiante, e, "Error", 0);

            }

        }

    }

    public void codAvatar(Estudiante estudiante, int codAvatar, int funcion) {//determina si el codigo del avatar esta correcto, si existe o no

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

                if (funcion == 0) {//SI ES 0 inserta el estudiante
                    estudiante.setCodigoAvatar(listaAvatar.get(posEncontrada));
                    insertEstudiante(estudiante);// se pasa a validar el estudiante e insertarlo

                } else if (funcion == 1) {//SI ES 1 actualiza el administrador

                    estudiante.setCodigoAvatar(listaAvatar.get(posEncontrada));
                    updateEstudiante(estudiante);// se pasa a validar el administrador

                }

            } else {

                JOptionPane.showMessageDialog(gestionEstudiante, "El codigo avatar digitado no existe", "Error", 0);
            }

        } catch (Exception e) {

            System.out.println("" + e);

        }

    }

}

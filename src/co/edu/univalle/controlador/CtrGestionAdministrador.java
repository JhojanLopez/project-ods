/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.*;
import co.edu.univalle.persistencia.*;
import co.edu.univalle.validacion.ValidacionAdministrador;
import co.edu.univalle.vista.GestionAdministrador;
import java.awt.event.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JHOJAN L
 */
public class CtrGestionAdministrador implements ActionListener {

    private GestionAdministrador gestionAdmin;
    private List<Administrador> listaAdmin;
    private Administrador adminLog;

    public CtrGestionAdministrador(GestionAdministrador gestionAdmin, Administrador adminLog) {

        this.gestionAdmin = gestionAdmin;
        this.adminLog = adminLog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {//action performed determinara que metodo usar

        if (e.getSource().equals(gestionAdmin.getJbMostrar())) {

            consultarAdministradoresDisponibles();//busca todos

        } else if (e.getSource().equals(gestionAdmin.getJbAgregaFilas())) {

            agregarFila();

        } else if (e.getSource().equals(gestionAdmin.getJbEliminarFila())) {

            eliminarFila();

        } else if (e.getSource().equals(gestionAdmin.getJbBuscar())) {

            String parametro = gestionAdmin.getJtBusqueda().getText();//capturo el parametro

            verificarBusqueda(parametro);

        } else if (e.getSource().equals(gestionAdmin.getJbCrear())) {

            crearAdministrador();

        } else if (e.getSource().equals(gestionAdmin.getJbModificar())) {

            modificarAdministrador();

        } else if (e.getSource().equals(gestionAdmin.getJbEliminar())) {

            eliminarAdministrador();

        } else if (e.getSource().equals(gestionAdmin.getJbLimpiar())) {

            limpiarDatos();

        }

    }

    public void consultarAdministradoresDisponibles() {//consulto todos los administradores (se excluye el admin logeado)
        try {

            EntityManagerHelper.beginTransaction();
            listaAdmin = DAOFactory.getAdministradorDAO().consultar();
            EntityManagerHelper.closeEntityManager();

            for (int i = 0; i < listaAdmin.size(); i++) {//elimino de la lista al administrador logeado

                if (listaAdmin.get(i).equals(adminLog)) {

                    listaAdmin.remove(listaAdmin.get(i));
                }
            }

            mostrarTodosDatos();//muestra todos los datos en la JTable

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "" + ex, "Error", 0);
        }
    }

    public void limpiarDatos() {//limpia toda la tabla

        int filasActuales = gestionAdmin.getModelo().getRowCount() - 1;

        if (filasActuales >= 0) {

            String matriz[][] = new String[filasActuales + 1][5];

            for (int i = 0; i < matriz.length; i++) {

                for (int c = 0; c < matriz[0].length; c++) {

                    gestionAdmin.getJtablaGestionAdministrador().setValueAt("", i, c);

                }
            }
        }
    }

    public void agregarFila() {//agrega una fila a la tabla

        Object row[] = new Object[1];
        gestionAdmin.getModelo().addRow(row);

    }

    public void eliminarTodasFilas() {//elimina todas las filas de laas tablas

        int filasActuales = gestionAdmin.getJtablaGestionAdministrador().getRowCount();

        try {

            for (int i = filasActuales - 1; i >= 0; i--) {

                gestionAdmin.getModelo().removeRow(i);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionAdmin, "" + e, "Error", 0);
            System.out.println("" + gestionAdmin.getJtablaGestionAdministrador().getRowCount());

        }

    }

    public void eliminarFila() {//elimina una fila de la tabla

        int filasActuales = gestionAdmin.getJtablaGestionAdministrador().getRowCount() - 1;

        if (filasActuales >= 0) {
            gestionAdmin.getModelo().removeRow(filasActuales);
        }
    }

    public void verificarBusqueda(String parametro) {//determina que tipo de busqueda realizar

        if (!gestionAdmin.getJcBuscar().getSelectedItem().equals("")) {

            if (!parametro.equals("")) {

                if (gestionAdmin.getJcBuscar().getSelectedItem().equals("Codigo")) {//si busca por codigo

                    busquedaCodigo(parametro);

                } else if (gestionAdmin.getJcBuscar().getSelectedItem().equals("Nombre")) {//si busca por nombre

                    busquedaNombre(parametro);

                } else if (gestionAdmin.getJcBuscar().getSelectedItem().equals("Usuario")) {

                    busquedaUsuario(parametro);
                }

            } else {
                JOptionPane.showMessageDialog(gestionAdmin, "Digite datos para la busqueda", "Error", 0);

            }

        } else {

            JOptionPane.showMessageDialog(gestionAdmin, "Complete un parametro para la busqueda", "Error", 0);
        }

    }

    public void busquedaCodigo(String codigo) {

        try {
            long codigoBuscar = Long.parseLong(codigo);
            Administrador admin = DAOFactory.getAdministradorDAO().consultarPorId(codigoBuscar);

            if (admin != null) {//si existe el administrador

                agregarDatos(admin);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionAdmin, "El administrador buscado no existe", "Aviso", 2);

            }

        } catch (java.lang.NumberFormatException ex) {

            JOptionPane.showMessageDialog(gestionAdmin, "El dato digitado no corresponde a un numero", "error", 0);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionAdmin, "" + e, "error", 0);
            System.out.println("" + e);
        }
    }

    public void busquedaNombre(String nombre) {

        try {

            Administrador admin = DAOFactory.getAdministradorDAO().consultarPorNombre(nombre);//busca por nombre

            if (admin != null) {//si existe el administrador

                agregarDatos(admin);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionAdmin, "El administrador buscado no existe", "Aviso", 1);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionAdmin, "" + e, "Error", 0);
            System.out.println("" + e);
        }

    }

    public void busquedaUsuario(String usuario) {

        try {

            Administrador admin = DAOFactory.getAdministradorDAO().consultarPorUsuario(usuario);//busca por nombre

            if (admin != null) {//si existe el administrador

                agregarDatos(admin);

            } else {//si no existe

                JOptionPane.showMessageDialog(gestionAdmin, "El administrador buscado no existe", "Aviso", 1);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(gestionAdmin, "" + e, "Error", 0);
            System.out.println("" + e);
        }
    }

    public void agregarDatos(Administrador admin) {//agrega un admin a la tabla

        eliminarTodasFilas();//elimina todos los datos de la tabla
        Object row[] = new Object[5];

        row[0] = admin.getCodigo();
        row[1] = admin.getNombre();
        row[2] = admin.getUsuario();
        row[3] = admin.getContrasena();
        row[4] = admin.getCodigoAvatar();

        gestionAdmin.getModelo().addRow(row);

    }

    private void crearAdministrador() {//creamos un objeto administrador para asignarlo en la BD

        if (!gestionAdmin.getJcAgregar().getSelectedItem().equals("")) {

            int row = gestionAdmin.getJtablaGestionAdministrador().getSelectedRow();//obtiene la fila seleccionada
//            Object codAdmin =gestionAdmin.getModelo().getValueAt(row, 0);
//            
//            System.out.println(""+codAdmin);
//            
            try {

                if (row > -1) {//si es -1 significa que no ha sido seleccionada ninguna
                    String nombre = gestionAdmin.getModelo().getValueAt(row, 1).toString();//obtiene datos de la tabla
                    String usuario = gestionAdmin.getModelo().getValueAt(row, 2).toString();
                    String contrasena = gestionAdmin.getModelo().getValueAt(row, 3).toString();
                    int codAvatarDigitado = Integer.parseInt(gestionAdmin.getModelo().getValueAt(row, 4).toString());

                    Administrador admin = new Administrador();//Construyo el objeto
                    admin.setNombre(nombre);
                    admin.setUsuario(usuario);
                    admin.setContrasena(contrasena);

                    codAvatar(admin, codAvatarDigitado, 0);//determinaamos el cod Avatar
                } else {

                    JOptionPane.showMessageDialog(gestionAdmin, "No has seleccionado ninguna fila", "Error", 0);

                }
            } catch (java.lang.NumberFormatException ex) {

                JOptionPane.showMessageDialog(gestionAdmin, "El codigo avatar digitado no es un numero entero", "Error", 0);

            } catch (java.lang.NullPointerException exc) {

                JOptionPane.showMessageDialog(gestionAdmin, "Datos incompletos para crear el administrador", "Error", 0);
                System.out.println("" + exc);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionAdmin, "" + e, "Error", 0);

                System.out.println("" + e);
            }

        } else {

            JOptionPane.showMessageDialog(gestionAdmin, "Selecciona un parametro", "Aviso", 2);
        }
    }

    public void mostrarTodosDatos() {//muestro todos los admins disponibles (se excluye el administrador logeado)

        eliminarTodasFilas();
        Object row[] = new Object[5];

        for (int i = 0; i < listaAdmin.size(); i++) {

            row[0] = listaAdmin.get(i).getCodigo();
            row[1] = listaAdmin.get(i).getNombre();
            row[2] = listaAdmin.get(i).getUsuario();
            row[3] = listaAdmin.get(i).getContrasena();
            row[4] = listaAdmin.get(i).getCodigoAvatar();

            gestionAdmin.getModelo().addRow(row);

        }

    }

    public void codAvatar(Administrador admin, int codAvatar, int funcion) {//determina si el codigo del avatar esta correcto, si existe o no

        List<Avatar> listaAvatar;
        boolean avatarExiste = false;
        int posEncontrada = 0;//posicion encontrada de 
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

            if (avatarExiste) {//Si existe se establece en el objeto y se pasa a validar lo

                if (funcion == 0) {//SI ES 0 inserta el admin
                    admin.setCodigoAvatar(listaAvatar.get(posEncontrada));
                    insertAdministrador(admin);// se pasa a validar el administrador

                } else if (funcion == 1) {//SI ES 1 actualiza el administrador

                    admin.setCodigoAvatar(listaAvatar.get(posEncontrada));
                    updateAdministrador(admin);// se pasa a validar el administrador

                }
            } else {

                JOptionPane.showMessageDialog(gestionAdmin, "El codigo avatar digitado no existe", "Error", 0);
            }

        } catch (Exception e) {

            System.out.println("" + e);

        }

    }

    public void insertAdministrador(Administrador admin) {//se creara el administrador pero primero se valida

        ValidacionAdministrador validacion = new ValidacionAdministrador(admin);

        if (validacion.validacionNombre() && validacion.validacionUsuario() && validacion.validacionPassword()) {// se valida el admin usando la clase ValidacionAdministrador package validaciones

            try {
                EntityManagerHelper.beginTransaction();
                DAOFactory.getAdministradorDAO().insertar(admin);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();

                Administrador adminCreado = DAOFactory.getAdministradorDAO().consultarPorUsuario(admin.getUsuario());

                JOptionPane.showMessageDialog(gestionAdmin, "Administrador creado con exito!\n"
                        + "Codigo generado: " + adminCreado.getCodigo(), "", 3);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionAdmin, e, "Error", 0);
            }

        }

    }

    public void modificarAdministrador() {

        if (!gestionAdmin.getJcModificar().getSelectedItem().equals("")) {
            int row = gestionAdmin.getJtablaGestionAdministrador().getSelectedRow();

            if (row > -1) {//Si selecciono una fila

                Object codigo = gestionAdmin.getModelo().getValueAt(row, 0);//obtiene datos de la tabla

                if (codigo != null) {

                    try {//se procede a modificar 
                        long codigoAdmin = Long.parseLong(gestionAdmin.getModelo().getValueAt(row, 0).toString());
                        String nombre = gestionAdmin.getModelo().getValueAt(row, 1).toString();//obtiene datos de la tabla
                        String usuario = gestionAdmin.getModelo().getValueAt(row, 2).toString();
                        String contrasena = gestionAdmin.getModelo().getValueAt(row, 3).toString();
                        int codAvatarDigitado = Integer.parseInt(gestionAdmin.getModelo().getValueAt(row, 4).toString());

                        Administrador admin = new Administrador();//Construyo el objeto
                        admin.setCodigo(codigoAdmin);//establecemos el cod
                        admin.setNombre(nombre);
                        admin.setUsuario(usuario);
                        admin.setContrasena(contrasena);

                        codAvatar(admin, codAvatarDigitado, 1);//determinaamos el cod Avatar
                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(gestionAdmin, e, "Error", 0);
                        System.out.println("" + e);
                    }

                } else {

                    JOptionPane.showMessageDialog(gestionAdmin, "El administrador a modificar no existe", "Error", 0);

                }

            }

        } else {

            JOptionPane.showMessageDialog(gestionAdmin, "Selecciona un parametro para modificar", "Aviso", 2);

        }

    }

    public void updateAdministrador(Administrador admin) {//actualizara el administrador en la bd

        ValidacionAdministrador validacion = new ValidacionAdministrador(admin);//mandamos el administrador que vamos a validar
        if (validacion.validacionModificar() && validacion.validacionPassword()) {

            try {

                EntityManagerHelper.beginTransaction();
                DAOFactory.getAdministradorDAO().modificar(admin);
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                JOptionPane.showMessageDialog(gestionAdmin, "Modificado con exito", "Aviso", 2);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(gestionAdmin, e);
            }

        }
    }

    public void eliminarAdministrador() {

        if (!gestionAdmin.getJcEliminar().getSelectedItem().equals("")) {

            int row = gestionAdmin.getJtablaGestionAdministrador().getSelectedRow();

            if (row > -1) {//Si selecciono una fila

                Object codigo = gestionAdmin.getModelo().getValueAt(row, 0);//obtiene datos de la tabla

                if (codigo != null) {

                    try {//se procede a modificar 
                        long codigoAdmin = Long.parseLong(gestionAdmin.getModelo().getValueAt(row, 0).toString());

                        if (codigoAdmin != adminLog.getCodigo()) {//Si no se selecciono asi mismo

                            Administrador admin = DAOFactory.getAdministradorDAO().consultarPorId(codigoAdmin);
                            int respuesta = JOptionPane.showConfirmDialog(gestionAdmin, "Estas seguro de eliminar al administrador con codigo:"
                                    + admin.getCodigo(), "Aviso", JOptionPane.YES_NO_CANCEL_OPTION, 2);

                            if (respuesta == JOptionPane.YES_OPTION) {

                                EntityManagerHelper.beginTransaction();
                                DAOFactory.getAdministradorDAO().eliminar(admin);
                                EntityManagerHelper.commit();
                                EntityManagerHelper.closeEntityManager();

                                JOptionPane.showMessageDialog(gestionAdmin, "Administrador eliminado con exito", "", JOptionPane.INFORMATION_MESSAGE);
                                consultarAdministradoresDisponibles();
                            }
                        } else {

                            JOptionPane.showMessageDialog(gestionAdmin,
                                    "Su usuario no se puede eliminar, debe requerirlo a otro administrador ", "Error", 0);

                        }

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(gestionAdmin, e, "Error", 0);
                        System.out.println("" + e);
                    }

                } else {

                    JOptionPane.showMessageDialog(gestionAdmin, "El administrador a eliminar no existe", "Error", 0);

                }

            }

        } else {

            JOptionPane.showMessageDialog(gestionAdmin, "Selecciona un parametro para eliminar", "Aviso", 2);

        }
    }
}

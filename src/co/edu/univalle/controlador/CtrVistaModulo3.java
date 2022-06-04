/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Modulo;
import co.edu.univalle.vista.InterfazModulo;
import co.edu.univalle.vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author JHOJAN L
 */
public class CtrVistaModulo3 implements ActionListener, MouseListener {

    private VistaModulo3 vistamodulo;
    private String submodulo1;
    private String submodulo2;
    private String submodulo3;
    private String submodulo4;
    private String submodulo5;

    public CtrVistaModulo3(VistaModulo3 vistaModulo, Modulo modulo) {
        this.vistamodulo = vistaModulo;
        initComponents();
    }

    public void initComponents() {

        this.submodulo1 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>¿QUE ES UN LENGUAJE DE PROGRAMACION?</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "<br>"
                + "El lenguaje de programación, es un lenguaje formal en donde se le proporciona a una persona la "
                + "capacidad de poder escribir una serie de instrucciones en forma de proceso (algoritmo), esto para "
                + "poder controlar el comportamiento físico o lógico de una computadora.\n"
                + "<br>"
                + "<br>"
                + "Existen tres tipos fundamentales de lenguajes de programación: lenguaje de alto nivel, lenguaje de"
                + " medio nivel y lenguaje de bajo nivel, siendo el más bajo un lenguaje más parecido al lenguaje "
                + "máquina de una computadora, hasta los lenguajes que se parecen más a lenguaje usado por los seres"
                + " humanos, es decir, el de alto nivel."
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo3_submodulo1.jpg\" width=\"300\" height=\"200\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo2 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>LENGUAJES MAS USADOS</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + " El tema de los lenguajes de programación es bastante amplio, así que para no andar mucho en el tema "
                + "y que no te satures de información, veremos algunos de los lenguajes de programación más usados en "
                + "la actualidad.\n"
                + "<br>\n"
                + "<br>\n"
                + "La elección del lenguaje depende mucho en el entorno en que te quieras desempeñar, por eso pondremos"
                + " una breve lista de los lenguajes más usados en la actualidad y así te animes a encontrar el tuyo, aqui mencionamos algunos:\n"
                + "<br>\n"
                + "<br>\n"
                + "<ul>"
                + "<li>Java"
                + "<li>PHP"
                + "<li>Phyton</ul>"
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo3_submodulo2.png\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo3 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo3_submodulo3.jpg\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Java es un lenguaje de programación que está orientado a objetos, si te interesa el desarrollo de "
                + "aplicaciones o el desarrollo de sitios web, Java es uno de los mejores lenguajes de programación"
                + " para hacerlo.\n"
                + "  <br>\n"
                + "  <br>\n"
                + "También es muy utilizado en el mundo de los videojuegos, además este es uno de los lenguajes más "
                + "usados, ya que cualquier sitio web, utiliza Java y si no tiene su paquetería correspondiente,"
                + " es un hecho que ese sitio web no funcione bien.\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Una sentencia basica seria:\n"
                + "  <br>\n"
                + "public class HolaMundo {\n"
                + "public static void main(String[] args) {\n"
                + "System.out.println(“Hola Mundo”);\n"
                + "}\n"
                + "}\n"
                + "  <br>\n"
                + "Imprime:\n"
                + "  <br>\n"
                + "Hola mundo"
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "  </p>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo4 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo3_submodulo4.png\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Este es un lenguaje que está enfocado al desarrollo web, donde este código es interpretado por un "
                + "intérprete en el servidor web implementando módulos o un ejecutable de interfaz de entrada común."
                + "  <br>\n"
                + "  <br>\n"
                + "Cabe mencionar que este lenguaje se asocia mucho con las bases de datos, ya que es el enlace de "
                + "información de los usuarios con los servidores web, muy recomendable para los desarrolladores"
                + " Back End."
                + "  <br>\n"
                + "  <br>\n"
                + "Una sentencia basica seria:\n"
                + "  </p>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo3_submodulo4.5.png\" width=\"450\" height=\"290\">\n"
                + "  </DIV>\n"
                + "  <br>\n"
                + "  </p>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo5 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo3_submodulo5.jpg\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Uno de los mejores lenguajes de programación para aprender de forma rápida (hasta en cierto punto) "
                + "es Python.\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Python es un lenguaje de programación interpretado donde su mayor filosofía es la legibilidad del"
                + " código, además de que es un lenguaje multiparadigma (al igual que c#) y es capaz de soportar"
                + " programación orientada a objetos, programación imperativa y, en menor medida, programación "
                + "funcional,un lenguaje ideal para empezar.\n"
                + "  <br>\n"
                + "  <br>\n"
                + "  Una sentencia basica seria:"
                + "  <br>\n"
                + "Print(“Hola Mundo”);\n"
                + "  <br>\n"
                + "o también print “Hola Mundo”\n"
                + "  <br>\n"
                + "Imprime:"
                + "  <br>\n"
                + "Hola mundo en Python"
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "  </p>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistamodulo.getJbSubModulo1())) {

            mostrarSubmodulo1();

        } else if (e.getSource().equals(vistamodulo.getJbSubModulo2())) {

            mostrarSubmodulo2();

        } else if (e.getSource().equals(vistamodulo.getJbSubModulo3())) {

            mostrarSubmodulo3();

        } else if (e.getSource().equals(vistamodulo.getJbSubModulo4())) {

            mostrarSubmodulo4();

        } else if (e.getSource().equals(vistamodulo.getJbSubModulo5())) {

            mostrarSubmodulo5();

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(vistamodulo.getJlAtras())) {

            vistamodulo.dispose();
            new InterfazModulo(vistamodulo.getEstudiante()).setVisible(true);

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void limpiarJEditorPane() {

        vistamodulo.getjEditorPane().setText("");
    }

    public void mostrarSubmodulo1() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo1);

        } catch (Exception e) {

            System.out.println("" + e);
        }

    }

    public void mostrarSubmodulo2() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo2);

        } catch (Exception e) {

            System.out.println("" + e);
        }

    }

    public void mostrarSubmodulo3() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo3);

        } catch (Exception e) {

            System.out.println("" + e);
        }

    }

    public void mostrarSubmodulo4() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo4);

        } catch (Exception e) {

            System.out.println("" + e);
        }

    }

    public void mostrarSubmodulo5() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo5);

        } catch (Exception e) {

            System.out.println("" + e);
        }

    }

}

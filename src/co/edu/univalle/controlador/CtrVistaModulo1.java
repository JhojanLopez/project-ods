/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.Modulo;
import co.edu.univalle.vista.InterfazModulo;
import co.edu.univalle.vista.VistaModulo1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author JHOJAN L
 */
public class CtrVistaModulo1 implements ActionListener, MouseListener {

    private VistaModulo1 vistamodulo;
    private String submodulo1;
    private String submodulo2;
    private String submodulo3;


    public CtrVistaModulo1(VistaModulo1 vistaModulo, Modulo modulo) {
        this.vistamodulo = vistaModulo;
        initComponents();
    }

    public void initComponents() {
   
        this.submodulo1 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1> ¿QUE ES LA PROGRAMACION?</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "     En la actualidad,la noción de programación se encuentra muy asociada a la creación de      aplicaciones de informática y videojuegos. En este sentido, es el proceso por el cual una persona desarrolla un programa, valiéndose de una herramienta que le permita escribir el código (el cual puede estar en uno o varios lenguajes, como C++, Java y Python, entre otros) y de otra que sea capaz de “traducirlo” a lo que se conoce como lenguaje de máquina, que puede \"comprender\" el microprocesador.\n"
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo1_submodulo1.jpg\" width=\"300\" height=\"200\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo2 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1> HISTORIA DE LA PROGRAMACION</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "   Para que la computadora entienda nuestras instrucciones debe usarse un lenguaje específico conocido"
                + " como código máquina, que la máquina lee fácilmente, pero que es excesivamente complicado para las "
                + "personas. De hecho, solo consiste en cadenas extensas de números 0 y 1.\n"
                + "<br>\n"
                + "<br>\n"
                + "Para facilitar el trabajo, los primeros operadores de computadoras decidieron crear un traductor para"
                + " reemplazar los 0 y 1 por palabras o abstracción de palabras y letras provenientes del inglés; "
                + "este se conoce como lenguaje ensamblador. Por ejemplo, para sumar se usa la letra A de la palabra "
                + "inglesa add (sumar). El lenguaje ensamblador sigue la misma estructura del lenguaje máquina, pero "
                + "las letras y palabras son más fáciles de recordar y entender que los números.\n"
                + "<br>\n"
                + "<br>\n"
                + "La necesidad de recordar secuencias de programación para las acciones usuales llevó a denominarlas"
                + " con nombres fáciles de memorizar y asociar: ADD (sumar), SUB (restar), MUL (multiplicar), "
                + "CALL (ejecutar subrutina), etc. A esta secuencia de posiciones se le denominó \"instrucciones\", y"
                + " a este conjunto de instrucciones se le llamó lenguaje ensamblador. Posteriormente aparecieron "
                + "diferentes lenguajes de programación, los cuales reciben su denominación porque tienen una estructura"
                + " sintáctica semejante a la de los lenguajes escritos por los humanos, denominados también lenguajes "
                + "de alto nivel. \n"
                + "<br>\n"
                + "<br>\n"
                + "El primer programador de computadora conocido fue una mujer: Ada Lovelace, hija de Anabella Milbanke"
                + " Byron y Lord Byron. Anabella inició en las matemáticas a Ada quien, después de conocer a Charles"
                + " Babbage, tradujo y amplió una descripción de su máquina analítica. Incluso aunque Babbage nunca "
                + "completó la construcción de cualquiera de sus máquinas, el trabajo que Ada realizó con estas le hizo"
                + " ganarse el título de primera programadora de computadoras del mundo. El nombre del lenguaje de"
                + " programación Ada fue escogido como homenaje a esta programadora.\n"
                + "A finales de 1953, John Backus sometió una propuesta a sus superiores en IBM para desarrollar una alternativa más práctica al lenguaje ensamblador, para programar la computadora central IBM 704. El histórico equipo Fortran de Backus consistió en los programadores Richard Goldberg, Sheldon F. Best, Harlan Herrick, Peter Sheridan, Roy Nutt, Robert Nelson, Irving Ziller, Lois Haibt y David Sayre. \n"
                + "El primer manual para el lenguaje Fortran apareció en octubre de 1956, con el primer compilador Fortran entregado en abril de 1957. Esto era un compilador optimizado, porque los clientes eran reacios a usar un lenguaje de alto nivel a menos que su compilador pudiera generar código cuyo desempeño fuera comparable al de un código hecho a mano en lenguaje ensamblador.\n"
                + "En 1960, se creó COBOL, uno de los lenguajes usados aún en la actualidad, en informática de gestión.\n"
                + "A medida que la complejidad de las tareas que realizaban las computadoras aumentaba, se hizo necesario disponer de un método más eficiente para programarlas. Entonces, se crearon los lenguajes de alto nivel, como lo fue BASIC en las versiones introducidas en los microordenadores de la década de 1980. "
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo1_submodulo2.jpg\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo3 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>VENTAJAS</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "<ul>"
                + "<li>Código más corto y eficiente."
                + "<li>Optimización sencilla, ya que la ejecución se gestiona mediante un algoritmo."
                + "<li>Es posible el mantenimiento independiente del desarrollo de la aplicación.</ul>"
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>DESVENTAJAS</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "<ul>"
                + "<li>Basado en una forma de pensar no habitual en las personas (estado de solución)"
                + "<li>Las características de casos de aplicación individuales se pueden considerar en la programación, pero únicamente de forma compleja"
                + "<li>En parte, difícil de comprender para personas ajenas al tema</ul>"
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

        }

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

}

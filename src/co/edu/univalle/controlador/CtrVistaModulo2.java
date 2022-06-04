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
public class CtrVistaModulo2 implements ActionListener, MouseListener {

    private VistaModulo2 vistamodulo;
    private String submodulo1;
    private String submodulo2;
    private String submodulo3;
    private String submodulo4;

    public CtrVistaModulo2(VistaModulo2 vistaModulo, Modulo modulo) {
        this.vistamodulo = vistaModulo;
        initComponents();
    }

    public void initComponents() {

        this.submodulo1 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>IMPORTANCIA DE LA PROGRAMACION</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "    El rol de la programación en los últimos sesenta años ha sido crucial para comprender la "
                + "evolución que ha tenido la sistematización de tareas y el manejo de la información que hoy en día "
                + "damos como un hecho. En efecto, la misma tiene como principal función el hecho de conseguir que "
                + "innumerables trabajos que antes ejercíamos de forma manual y con un alto costo sean ejecutados"
                + " por un ordenador con un ahorro significativo de tiempo. Por otro lado, dada la increíble cantidad "
                + "de información que hoy en día se maneja para distintas tareas, la programación es una herramienta de "
                + "enorme valor porque permite bucear en la misma con muchísima facilidad.\n"
                + "  <br>\n"
                + "  <br>\n"
                + "A lo largo de la historia, el hombre se ha visto en la obligación de realizar un número constante"
                + " de tareas para poder sobrevivir. Con el paso del tiempo y el desarrollo de la tecnología, estas "
                + "tareas fueron ejerciéndose cada vez con un mayor grado de productividad. \n"
                + "  <br>\n"
                + "  <br>\n"
                + "El proceso de mejora fue lento pero continuo hasta la revolución industrial, momento en el cual"
                + " vemos como existe una rápida sustitución de actividades manuales por el trabajo llevado a cabo"
                + " mediante máquinas. Así, los bienes de capital fueron aumentando cada vez más la productividad, "
                + "circunstancia que todavía está en proceso de expansión. Con el desarrollo de las primeras"
                + " computadoras, ya no solo el trabajo físico pudo reemplazarse por máquinas, sino también el "
                + "trabajo intelectual. En efecto, las computadoras pueden realizar cada vez con mayor poder cifras"
                + " enormes de cálculos complejos que tienen la posibilidad de procesar y generar datos para el "
                + "beneficio humano. La programación, en particular, es la adaptación de ese potencial de las "
                + "computadoras a las necesidades del hombre, generando distintos procesos automáticos que generan "
                + "resultados que sirven desde diversos aspectos, como por ejemplo el laboral, el estético, el lúdico,"
                + " etc.\n"
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/modulo2_submodulo1.jpg\" width=\"300\" height=\"200\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo2 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>PROGRAMACION EN LA VIDA COTIDIANA</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "La programación a través de los años a tomado un papel fundamental para el desarrollo de la especie"
                + " humana ya que este grandioso proceso ha permitido el surgimiento de la llamada era informática o "
                + "tecnológica.  \n"
                + "  <br>\n"
                + "  <br>\n"
                + "La programación ha sido fundamental para el desarrollo humano ya que nos permite hacer que las"
                + " maquinas realicen procesos que los humanos no podemos hacer con gran facilidad e inclusos muchas "
                + "veces nos resultan imposibles de realizar. Estos procesos se dan gracias a la inserción de algoritmos"
                + " a la maquina la cual realiza las funciones que queremos según las especificaciones de la "
                + "programación que tenga."
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/modulo2_submodulo2.jpg\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo3 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>PROGRAMACION EN UNA EMPRESA</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "<br>\n"
                + "En los ambientes típicos de los nuevos negocios, pequeños grupos de individuos se reúnen y crean un "
                + "equipo complementario donde cada uno pone sus habilidades al servicio del sueño de crear una "
                + "compañía la importancia de la programación en el mundo actual destaca porque es una habilidad que "
                + "abre nuevas puertas en el mundo de la tecnología. Además, ya es una experticia requerida junto a "
                + "otras más convencionales como la contabilidad, administración y el marketing. \n"
                + "<br>"
                + "<br>\n"
                + "Algo que no parece cambiar gracias a los avances de la tecnología, demostrando la importancia de la"
                + "programación en la vida diaria, por lo tanto, si quieres innovar tu negocio, saber los lenguajes de "
                + "programación son un ingrediente necesario para tu éxito."
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/modulo2_submodulo3.jpg\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo4 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>PROGRAMACIÓN: UNA CARRERA QUE GARANTIZA RÁPIDA INSERCIÓN LABORAL</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "<br>"
                + "Para 2025 se crearán 149 millones de nuevos puestos de trabajos vinculados con la programación a "
                + "nivel global, según el Banco Mundial. Las organizaciones de todo tipo y tamaño demandan "
                + "profesionales de esta disciplina, pero los talentos son escasos. Se trata de un problema mundial y "
                + "nacional. Por eso, quienes estudien programación o desarrollo web acceden a empleos con grandes "
                + "beneficios. Vea más en Finanzas Personales.\n"
                + "<br>"
                + "<br>"
                + "Cerca de 2 millones de empleos en programación serán generados en Colombia, de acuerdo a"
                + " este informe del Banco Mundial. Por tal motivo, los profesionales pueden encontrar una rápida"
                + " inserción laboral en este campo."
                + "<br>"
                + "<br>"
                + "Digital House, organización de edtech enfocada en el desarrollo de talento tecnológico y habilidades"
                + " digitales que impactan a la sociedad, anunció que se encuentran abiertas las nuevas inscripciones "
                + "para iniciar la carrera Certified Tech Developer en agosto y septiembre de 2021.\n"
                + "<br>"
                + "<br>"
                + "Esta propuesta fue diseñada junto a Mercado Libre y Globant para formar a los mejores perfiles de"
                + " la región. Es por eso que el plan de estudios se actualiza de forma constante para garantizar la"
                + " capacitación de programadores que tengan todos los conocimientos necesarios para insertarse con "
                + "éxito en el mercado laboral."
                + "  </p>\n"
                + "  <br>\n"
                + "  <br>\n"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/modulo2_submodulo4.jpg\" width=\"350\" height=\"220\">\n"
                + "  </DIV>\n"
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

    public void mostrarSubmodulo4() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo4);

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

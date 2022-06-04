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
public class CtrVistaModulo4 implements ActionListener, MouseListener {

    private VistaModulo4 vistamodulo;
    private String submodulo1;
    private String submodulo2;
    private String submodulo3;
    private String submodulo4;
    private String submodulo5;
    private String submodulo6;
    private String submodulo7;

    public CtrVistaModulo4(VistaModulo4 vistaModulo, Modulo modulo) {
        this.vistamodulo = vistaModulo;
        initComponents();
    }

    public void initComponents() {

        this.submodulo1 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>APRENDE A PROGRAMAR</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "  <br>\n"
                + "  <br>\n"
                + "En el mundo de la programación, existen una infinidad de software para programar y que hace que la"
                + " programación sea más entretenida y más comprensible para el lenguaje humano.\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Si has elegido adentrarte en este mundo de la programación, es muy seguro que te harás la siguiente "
                + "pregunta, ¿Qué software de programación debo de usar?, o tal vez te preguntaras, ¿qué lenguaje de "
                + "programación debo aprender para empezar?, ¿es difícil?\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Son preguntas muy frecuentes que, los que inician en este medio, se hacen y que en realidad no es"
                + " muy complejo responderlas pero que te ayudarán a meterte mejor en la programación.\n"
                + "  <br>\n"
                + "  <br>\n"
                + "Algo que ayuda a todo el que se inicia en este medio, es el software para programar, una ayuda "
                + "bastante interesante y que hace más fácil la programación."
                + "  </p>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo2 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>¿QUE ES EL SOFTWARE DE PROGRAMACION?</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "  El software de programación es el conjunto de herramientas que le permiten al programador crear o "
                + "desarrollar programas informáticos en un determinado lenguaje de programación.\n"
                + "<br>\n"
                + "<br>\n"
                + "Se compone por los siguientes elementos:\n"
                + "<br>\n"
                + "<ul>"
                + "<li>Editores de texto.\n"
                + "<li>Compiladores.\n"
                + "<li>Intérpretes.\n"
                + "<li>Enlazadores.\n"
                + "<li>Depuradores"
                + "<li>IDE (entornos de desarrollo integrados).\n"
                + "</ul>"
                + "<br>\n"
                + "<br>\n"
                + "Algo curioso es que los IDE integran a los elementos anteriores de la lista, "
                + "permitiendo que los programadores no ingresen tantos comandos y sea más fácil la programación, "
                + "además de que cuentan con una avanzada interfaz gráfica de usuario, lo que hace la programación"
                + " más sencilla."
                + "  </p>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo3 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>METODOS</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "En la programación, un método es una subrutina cuyo código es definido en una clase y puede"
                + " pertenecer tanto a una clase, como es el caso de los métodos de clase o estáticos, como a un objeto,"
                + " como es el caso de los métodos de instancia. Análogamente a los procedimientos en lenguajes"
                + " imperativos, un método consiste generalmente de una serie de sentencias para llevar a cabo una"
                + " acción, un juego de parámetros de entrada que regularán dicha acción o, posiblemente, un valor de "
                + "salida (o valor de retorno) de algún tipo.\n"
                + "<br>"
                + "<br>"
                + "La diferencia entre un procedimiento (generalmente llamado función si devuelve un valor) y un"
                + " método es que este último, al estar asociado con un objeto o clase en particular, puede acceder y"
                + " modificar los datos privados del objeto correspondiente de forma tal que sea consistente con el "
                + "comportamiento deseado para el mismo. Así, es recomendable entender a un método no como una secuencia "
                + "de instrucciones sino como la forma en que el objeto es útil (el método para hacer su trabajo)."
                + " Por lo tanto, podemos considerar al método como el pedido a un objeto para que realice una tarea "
                + "determinada o como la vía para enviar un mensaje al objeto y que este reaccione acorde a dicho mensaje."
                + ""
                + "  </p>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo4 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>TIPOS DE METODOS</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "Como ya se mencionó, los métodos de instancia están relacionados con un objeto en particular, "
                + "mientras que los métodos estáticos o de clase (también denominados métodos compartidos), están "
                + "asociados a una clase en particular. En una implementación de constructores, siendo estos métodos "
                + "de instancia especiales llamados automáticamente cuando se crea una instancia de alguna clase."
                + "<br>"
                + "<br>"
                + " En Java y C++ se distinguen por tener el mismo nombre de las clases a la que están asociados. "
                + "Lenguajes como Smalltalk no requieren constructores ni destructores.\n"
                + "Los métodos de acceso son un tipo de método normalmente pequeño y simple que se limita a "
                + "proveer información acerca del estado de un objeto. Aunque introduce una nueva dependencia, "
                + "la utilización de métodos es preferida a acceder directamente a la información para proveer "
                + "de una nueva capa de abstracción (programación orientada a objetos). Por ejemplo, si una clase"
                + " que modela una cuenta bancaria provee de un método de acceso \"obtenerBalance()\" en versiones "
                + "posteriores de la clase se podría cambiar el código de dicho método substancialmente sin que el "
                + "código dependiente de la clase tuviese que ser modificado (un cambio sería necesario siempre que el"
                + " tipo de dato devuelto por el método cambie). Los métodos de acceso que pueden cambiar el estado de"
                + " un objeto son llamados, frecuentemente, métodos de actualización o métodos de mutación; a su vez,"
                + " los objetos que proveen de dichos métodos son denominados objetos mutables."
                + "<br>"
                + "<br>"
                + "La diferencia entre un procedimiento (generalmente llamado función si devuelve un valor) y un"
                + " método es que este último, al estar asociado con un objeto o clase en particular, puede acceder y"
                + " modificar los datos privados del objeto correspondiente de forma tal que sea consistente con el "
                + "comportamiento deseado para el mismo. Así, es recomendable entender a un método no como una secuencia "
                + "de instrucciones sino como la forma en que el objeto es útil (el método para hacer su trabajo)."
                + " Por lo tanto, podemos considerar al método como el pedido a un objeto para que realice una tarea "
                + "determinada o como la vía para enviar un mensaje al objeto y que este reaccione acorde a dicho mensaje."
                + "  </p>\n"
                + "<br>"
                + "<br>"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo4_submodulo4.jpg\" width=\"450\" height=\"290\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo5 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>¿QUE ES UNA VARIABLE?</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "Una variable es donde se guarda (y se recupera) datos que se utilizan en un programa.\n"
                + "Cuando escribimos código, las variables se utilizan para:\n"
                + "<ul>"
                + "<li>Guardar datos y estados.\n"
                + "<li>Asignar valores de una variable a otra.\n"
                + "<li>Representar valores dentro de una expresión matemática.\n"
                + "<li>Mostrar valores por pantalla.</ul>"
                + "<br>"
                + "<br>"
                + "Todas las variables deben ser de un tipo de datos, ya sea un dato de tipo primitivo, como un "
                + "número o texto, o un dato abstracto, como un objeto que se ha creado.\n"
                + "Así que básicamente podemos decir que una variable es :"
                + " Tipo de dato ->identificador variable -> valor almacenado."
                + "  </p>\n"
                + "<br>"
                + "<br>"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo4_submodulo5.png\" width=\"450\" height=\"290\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo6 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>SENTENCIA CONDICIONAL</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "En programación, una sentencia condicional es una instrucción o grupo de instrucciones que se "
                + "pueden ejecutar o no en función del valor de una condición.\n"
                + "<br>"
                + "<br>"
                + "Los tipos más conocidos de sentencias condicionales son el SI..ENTONCES "
                + "(if..then), el SI...ENTONCES..SI NO (if..then..else) y el SEGÚN (case o switch), aunque también "
                + "podríamos mencionar al manejo de excepciones como una alternativa más moderna para evitar "
                + "el \"anidamiento\" de sentencias condicionales.\n"
                + "<br>"
                + "<br>"
                + "Las sentencias condicionales constituyen, junto con los bucles, los pilares de la programación "
                + "estructurada, y su uso es una evolución de una sentencia en lenguaje ensamblador que ejecutaba "
                + "la siguiente línea o no en función del valor de una condición."
                + "  </p>\n"
                + "<br>"
                + "<br>"
                + "   <DIV ALIGN=\"center\"> \n"
                + "	<img src=\"file:src/imagenes/Modulo4_submodulo6.png\" width=\"350\" height=\"190\">\n"
                + "  </DIV>\n"
                + "  </body>\n"
                + "</html>\n"
                + "";

        this.submodulo7 = "<html>\n"
                + "  <head>\n"
                + "</head>\n"
                + "  <body>\n"
                + "      <DIV ALIGN=\"center\">\n"
                + "    	 <h1>CICLOS</h1>\n"
                + "     </DIV>\n"
                + "    <p ALIGN=\"justify\" style=\"color:black;font-family: Times New Roman; Times, serif;font-size:12px;\">\n"
                + "<br>"
                + "Un bucle o ciclo, en programación, es una secuencia de instrucciones de código que se ejecuta "
                + "repetidas veces, hasta que la condición asignada a dicho bucle deja de cumplirse. Los tres bucles "
                + "más utilizados en programación son el bucle while, el bucle for y el bucle do-while.\n"
                 + "<br>"
                + "<br>"
                + "Ejemplos:\n"
                + "<br>"
                + "Array lista= {1.2.3.4.5.6.7.8.9}; lista de numeros\n"
                + "<br>"
                + "For(i = 1; i<lista; i++){  \n"
                + "Lista += lista + i;\n"
                + "}\n"
                + "<br>"
                + "“la i vale 1 mientras esta sea menor a la lista seguirá recorriendo y sumando 1 hasta que no "
                + "cumpla la condición.”\n"
                + "<br>"
                + "Algunos lenguajes de programación tienen sentencias que permiten \"escapar\" de los bucles sin "
                + "llegar a la condición de fin, como el romper o el devolver.\n"
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

        } else if (e.getSource().equals(vistamodulo.getJbSubModulo6())) {

            mostrarSubmodulo6();

        } else if (e.getSource().equals(vistamodulo.getJbSubModulo7())) {

            mostrarSubmodulo7();

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

    public void mostrarSubmodulo5() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo5);

        } catch (Exception e) {

            System.out.println("" + e);
        }

    }

    public void mostrarSubmodulo6() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo6);

        } catch (Exception e) {

            System.out.println("" + e);
        }

    }

    public void mostrarSubmodulo7() {

        try {

            limpiarJEditorPane();
            vistamodulo.getjEditorPane().setText(submodulo7);

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

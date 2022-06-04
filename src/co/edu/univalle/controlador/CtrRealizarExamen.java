/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.univalle.controlador;

import co.edu.univalle.modelo.ExamenEstudiante;
import co.edu.univalle.modelo.ExamenEstudiantePK;
import co.edu.univalle.persistencia.DAOFactory;
import co.edu.univalle.persistencia.EntityManagerHelper;
import co.edu.univalle.vista.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import jdk.nashorn.internal.runtime.regexp.joni.exception.JOniException;

/**
 *
 * @author JHOJAN L
 */
public class CtrRealizarExamen implements ActionListener {

    private RealizarExamen realizarExamen;
    private String pregunta;
    private String respuesta;
    private JButton teclado[] = new JButton[26];
    private JLabel letras[];
    private JLabel jlEnunciado;
    private int numeroPregunta;
    private float nota;
    private int aciertos;
    private int errores;

    public CtrRealizarExamen(RealizarExamen realizarExamen) {
        this.realizarExamen = realizarExamen;
        initComponents();
        asignacionExamen();//inicializa la pregunta y la respuesta, ademas crea 
        asignacionVisual();//inicializa el teclado

//        this.respuesta = realizarExamen.getPreguntasGeneradas().get(0).getRespuesta();
        // administrarExamen();
    }

    public void initComponents() {
        this.jlEnunciado = new JLabel();
        jlEnunciado.setBounds(70, 150, 800, 40);
        realizarExamen.add(jlEnunciado);

        this.respuesta = "";
        this.nota = (float) 0.0;
        this.aciertos = 0;
        this.errores = 0;
        this.numeroPregunta = 1;

    }

    public void asignacionExamen() {

        this.respuesta = realizarExamen.getPreguntasGeneradas().get(numeroPregunta - 1).getRespuesta().toUpperCase();
        this.pregunta = realizarExamen.getPreguntasGeneradas().get(numeroPregunta - 1).getEnunciado();
        crearEtiquetas(respuesta);//Crea la palabra a adivinar en 
        crearEnunciado(pregunta);

    }

    public void asignacionVisual() {

        crearTeclado(250, 375, 46);//crea el teclado
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(realizarExamen.getJbTerminarJuego())) {

            int x = JOptionPane.showConfirmDialog(jlEnunciado, "¿Estas seguro que quieres terminar tu intento?",
                    "", 1);

            if (x == JOptionPane.YES_OPTION) {

                realizarExamen.dispose();
                new InterfazEstudiante(realizarExamen.getEstudiante()).setVisible(true);
            }
        }

        for (int i = 0; i < teclado.length; i++) {
            if (e.getSource().equals(teclado[i])) {

                if (evaluarLetra(teclado[i].getText())) {

                } else {

                    errores++;
                    realizarExamen.getJlErrores().setText("Error: "+errores+" de "+(respuesta.length()));
                    int porcentaje = (errores * 100) / respuesta.length();

                    aumentarBarra(porcentaje);
                }

                evaluar();
            }
        }

    }

    public void crearEnunciado(String pregunta) {

        jlEnunciado.setText("");
        jlEnunciado.setText("<html>"
                + "<p ALIGN=\"justify\"> "
                + pregunta
                + "</p>"
                + "</html>");
    }

    public void crearTeclado(int col, int fila, int tamBoton) {
        int colAux = col;
        int letra = 65;
        int i = 0;
        for (int f = 0; f < 3; f++) {//mostrar el abedecario 26 letras
            for (int c = 0; c < 9; c++) {
                if (letra != 91) {

                    teclado[i] = new JButton((char) letra + "");
                    teclado[i].setBounds(col, fila, tamBoton, tamBoton);
                    teclado[i].addActionListener(this);
                    realizarExamen.add(teclado[i]);
                    col += tamBoton + 5;
                    letra++;
                    i++;
                }
            }
            fila += tamBoton + 5;
            col = colAux;
        }
    }

    public boolean evaluarLetra(String etiquetaBoton) {//determina si la letra escogida es correcta

        boolean esta = false;
        char letraPalabra = ' ';
        char letraBoton = etiquetaBoton.charAt(0);//CONVERTIR A CHAR

        for (int i = 0; i < respuesta.length(); i++) {
            letraPalabra = respuesta.charAt(i);

            if (letraPalabra == letraBoton) {

                aciertos++;
                esta = true;
                letras[i].setText(etiquetaBoton);
                switch (letraPalabra) {
                    default:
                        teclado[(int) letraPalabra - 65].setEnabled(false);
                }
            }
        }
        return esta;

    }

    public void resetTeclado() {

        for (JButton teclado1 : teclado) {
            teclado1.setEnabled(true);
        }

    }

    public void crearEtiquetas(String palabra) {//SE CREAN LAS LABEL DE ACUERDO A LA PALABRA

        int longitudPalabra = palabra.length();//obtener la longitud de la palabra mas larga(aqui doy una respsta en concreto)
        System.out.println(longitudPalabra);
        letras = new JLabel[longitudPalabra];  //crear el array de etiquetas de acuerdo a la longitud de la palabra                
        for (int i = 0; i < letras.length; i++) {
            letras[i] = new JLabel("");
            letras[i].setHorizontalAlignment(SwingConstants.CENTER);
            letras[i].setBorder(new EtchedBorder());
            realizarExamen.add(letras[i]);

        }

        crearEtiquetasPalabra(270, longitudPalabra);
    }

    public void crearEtiquetasPalabra(int fila, int respuesta) {//muestra el marco donde se vera la palabra a adivinar

        int tamEtiquetas = 48;
        int espacioEtiquetas = (respuesta - 1) * 5;
        int col = (900 - ((respuesta * tamEtiquetas) + espacioEtiquetas)) / 2;

        for (int i = 0; i < respuesta; i++) {
            letras[i].setBounds(col, fila, tamEtiquetas, tamEtiquetas);
            letras[i].setVisible(true);
            col += tamEtiquetas + 5;
        }
    }

    public void resetEtiquetas() {

        for (int i = 0; i < letras.length; i++) {

            letras[i].setText("");
            letras[i].setBorder(null);
        }

    }

    public void evaluar() {

        if (aciertos == respuesta.length()) {//si acierta la palabra entonces

            if (numeroPregunta != 5) {
                numeroPregunta++;//aumenta el numero de pregunta
                realizarExamen.getProgressBar().setValue(0);//reinicia la barra de progreso
                realizarExamen.getJlErrores().setText("");
                aciertos = 0;
                errores = 0;
                resetTeclado();
                resetEtiquetas();
                asignacionExamen();//actualizamos la pregunta y respuesta
                nota = (float) (nota + 1.0);
                realizarExamen.getJlPregunta().setText("Pregunta " + numeroPregunta + " de 5");

            }

        } else if (errores == respuesta.length()) {//si tiene muchos errores por defecto se cancela la evaluacion

            if (nota == 0.0 || nota == 1.0 || nota == 2.0) {

                JOptionPane.showMessageDialog(realizarExamen, "¿Que paso? tu nota es " + nota
                        + "\n¡Animo! esfuerzate en tu proximo intento", "", 1);

            }

            if (nota == 3.0) {

                JOptionPane.showMessageDialog(realizarExamen, "Tu nota es " + nota
                        + "\nNo es la esperada pero siempre se puede mejorar estudiando", "", 1);

            }

            if (nota == 4.0) {

                JOptionPane.showMessageDialog(realizarExamen, "Tu nota es " + nota
                        + "\n¡Gran trabajo! te falta poco para ser un experto", "", 1);

            }

            guardarNota();

        }

        if (numeroPregunta == 5 && aciertos == respuesta.length()) {

            nota = (float) 5.0;
            JOptionPane.showMessageDialog(jlEnunciado, "Felicitaciones tu nota es " + nota
                    + " sin duda eres un genio", "", 1);

            guardarNota();
        }

    }

    public void guardarNota() {

        try {

            ExamenEstudiantePK examenEstudiantePK = new ExamenEstudiantePK(realizarExamen.getEstudiante().getCodigo(),
                    realizarExamen.getExamen().getCodigo());

            ExamenEstudiante examenEstudianteBD = DAOFactory.getExamenEstudianteDAO().consultarPorId(examenEstudiantePK);

            if (examenEstudianteBD != null) {//si ya esta en la tabla se modifica la nota

                examenEstudianteBD.setNota(nota);
                EntityManagerHelper.beginTransaction();
                DAOFactory.getExamenEstudianteDAO().modificar(examenEstudianteBD);//modifico los datos
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                
                cerrarRealizarExamen();

            } else {//si no esta en la tabla se crea la nota

                ExamenEstudiante examenEstudiante = new ExamenEstudiante(examenEstudiantePK,nota);

                EntityManagerHelper.beginTransaction();
                DAOFactory.getExamenEstudianteDAO().insertar(examenEstudiante);//modifico los datos
                EntityManagerHelper.commit();
                EntityManagerHelper.closeEntityManager();
                cerrarRealizarExamen();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(realizarExamen, e, "", 0);
        }
    }

    public void cerrarRealizarExamen() {
     
        realizarExamen.dispose();
        new InterfazEstudiante(realizarExamen.getEstudiante()).setVisible(true);
    
    }

    public void aumentarBarra(int porcentaje) {

//        jProgressBar1.setUI(basicUi);
//        jProgressBar1.setBackground(Color.red);
        if (porcentaje >= 1 && porcentaje <= 30) {
            UIManager.put("nimbusOrange", Color.YELLOW);
            realizarExamen.getProgressBar().setValue(porcentaje);
        }
        if (porcentaje >= 31 && porcentaje <= 50) {
            UIManager.put("nimbusOrange", Color.ORANGE);
            realizarExamen.getProgressBar().setValue(porcentaje);
        }
        if (porcentaje >= 51 && porcentaje <= 90) {
            UIManager.put("nimbusOrange", Color.RED);
            realizarExamen.getProgressBar().setValue(porcentaje);
        }
        if (porcentaje >= 91) {
            UIManager.put("nimbusOrange", Color.RED);
            realizarExamen.getProgressBar().setValue(porcentaje);
            
           

        }

    }
}

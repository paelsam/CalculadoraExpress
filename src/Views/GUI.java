package Views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controllers.GameController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    JMenuBar mbMenu;
    JMenu mMenu;
    JMenuItem miIniciarJuego;
    JLabel lAciertos, lFallos, lNumAciertos, lNumFallos, lTiempo, lPuntuacion, lIgual;
    JTextField tTiempo, tPuntuacion;
    JPanel pAciertosFallos, pNumeros;
    JPanel pValoresAleatorios, pTiempoPuntuacion, pNorte, pEste;
    JButton botones[];
    JButton bEliminar, bIgual, bMenos;
    JLabel lNumero1, lOperacion, lNumero2, lResultado;

    public GUI() {
        setTitle("Calculadora Express");
        setSize(740, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        setBackground(new Color(225, 228, 253));
        iniciarGUI();

    }

    public void iniciarGUI() {
        botones = new JButton[12];

        mbMenu = new JMenuBar();
        mMenu = new JMenu("Menu");
        miIniciarJuego = new JMenuItem("Iniciar Juego");

        lAciertos = new JLabel("Aciertos: ");
        lFallos = new JLabel("Fallos: ");
        lNumAciertos = new JLabel();
        lNumFallos = new JLabel();
        lTiempo = new JLabel("Tiempo restante: ");
        lPuntuacion = new JLabel("Puntuación: ");

        lIgual = new JLabel("=");
        lIgual.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lIgual.setForeground(new Color(102, 106, 156));
        lNumero1 = new JLabel();
        lNumero1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumero1.setForeground(new Color(102, 106, 156));
        lOperacion = new JLabel();
        lOperacion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lOperacion.setForeground(new Color(102, 106, 156));
        lNumero2 = new JLabel();
        lNumero2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumero2.setForeground(new Color(102, 106, 156));
        lResultado = new JLabel();
        lResultado.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lResultado.setForeground(new Color(102, 106, 156));

        lNumero1.setPreferredSize(new Dimension(90, 80));
        lNumero2.setPreferredSize(new Dimension(90, 80));
        lOperacion.setPreferredSize(new Dimension(70, 80));
        lResultado.setPreferredSize(new Dimension(90, 80));

        lIgual.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lIgual.setHorizontalAlignment(SwingConstants.CENTER);
        lIgual.setVerticalAlignment(SwingConstants.CENTER);
        lNumero1.setHorizontalAlignment(SwingConstants.CENTER);
        lNumero1.setVerticalAlignment(SwingConstants.CENTER);
        lNumero2.setHorizontalAlignment(SwingConstants.CENTER);
        lNumero2.setVerticalAlignment(SwingConstants.CENTER);
        lOperacion.setHorizontalAlignment(SwingConstants.CENTER);
        lOperacion.setVerticalAlignment(SwingConstants.CENTER);
        lResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lResultado.setVerticalAlignment(SwingConstants.CENTER);

        lNumero1.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lNumero2.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lOperacion.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lResultado.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));

        lAciertos.setHorizontalAlignment(SwingConstants.CENTER);
        lAciertos.setVerticalAlignment(SwingConstants.CENTER);
        lFallos.setHorizontalAlignment(SwingConstants.CENTER);
        lFallos.setVerticalAlignment(SwingConstants.CENTER);
        lAciertos.setForeground(new Color(8, 193, 24));
        lFallos.setForeground(Color.RED);
        lTiempo.setForeground(new Color(102, 106, 156));
        lPuntuacion.setForeground(new Color(102, 106, 156));
        lAciertos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lFallos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumAciertos.setForeground(new Color(8, 193, 24));
        lNumAciertos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumFallos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumFallos.setForeground(Color.RED);

        tTiempo = new JTextField();
        tPuntuacion = new JTextField();

        for (int i = 0; i <= 9; i++) {
            botones[i] = new JButton(Integer.toString(i));
            botones[i].setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            botones[i].setBackground(new Color(37, 40, 80));
            botones[i].setForeground(Color.WHITE);
        }
        botones[10] = new JButton("Eliminar");
        botones[10].setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        botones[10].setBackground(new Color(37, 40, 80));
        botones[10].setForeground(Color.WHITE);
        botones[11] = new JButton("Check");
        botones[11].setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        botones[11].setBackground(new Color(37, 40, 80));
        botones[11].setForeground(Color.WHITE);
        bMenos = new JButton("-");
        bMenos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        bMenos.setBackground(new Color(37, 40, 80));
        bMenos.setForeground(Color.WHITE);

        pAciertosFallos = new JPanel(new GridLayout(1, 4));
        pEste = new JPanel(new BorderLayout());
        pNumeros = new JPanel(new GridLayout(4, 3, 4, 4));
        pValoresAleatorios = new JPanel(new GridBagLayout());
        pTiempoPuntuacion = new JPanel(new GridLayout(1, 4));
        pNorte = new JPanel(new BorderLayout());

        // setPreferedSize(new Dimension(90, 80)) A todos los labels
        // setHorizontal
        // setHorizontalAlignment
        // SwingConstants.CENTER
        // setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray,
        // Color.WHITE));
        // lNum1.setVerticalAlignment(SwingConstants.CENTER)

        mbMenu.add(mMenu);
        mMenu.add(miIniciarJuego);

        pAciertosFallos.add(lAciertos);
        pAciertosFallos.add(lNumAciertos);
        pAciertosFallos.add(lFallos);
        pAciertosFallos.add(lNumFallos);

        pNumeros.add(botones[7]);
        pNumeros.add(botones[8]);
        pNumeros.add(botones[9]);
        pNumeros.add(botones[4]);
        pNumeros.add(botones[5]);
        pNumeros.add(botones[6]);
        pNumeros.add(botones[1]);
        pNumeros.add(botones[2]);
        pNumeros.add(botones[3]);
        pNumeros.add(botones[10]);
        pNumeros.add(botones[0]);
        pNumeros.add(botones[11]);

        pValoresAleatorios.add(lNumero1);
        pValoresAleatorios.add(lOperacion);
        pValoresAleatorios.add(lNumero2);
        pValoresAleatorios.add(lIgual);
        pValoresAleatorios.add(lResultado);

        lTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        lTiempo.setVerticalAlignment(SwingConstants.CENTER);
        lTiempo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        lPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
        lPuntuacion.setVerticalAlignment(SwingConstants.CENTER);
        lPuntuacion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        pTiempoPuntuacion.add(lTiempo);
        pTiempoPuntuacion.add(tTiempo);
        pTiempoPuntuacion.add(lPuntuacion);
        pTiempoPuntuacion.add(tPuntuacion);

        pAciertosFallos.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pValoresAleatorios.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pNumeros.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pTiempoPuntuacion.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));

        pAciertosFallos.setBackground(new Color(225, 228, 253));
        pValoresAleatorios.setBackground(new Color(225, 228, 253));
        pTiempoPuntuacion.setBackground(new Color(225, 228, 253));

        pNorte.add(mbMenu, BorderLayout.NORTH);
        pNorte.add(pAciertosFallos, BorderLayout.SOUTH);
        pEste.add(bMenos, BorderLayout.NORTH);
        pEste.add(pNumeros, BorderLayout.CENTER);

        add(pNorte, BorderLayout.NORTH);
        add(pValoresAleatorios, BorderLayout.CENTER);
        add(pEste, BorderLayout.EAST);
        add(pTiempoPuntuacion, BorderLayout.SOUTH);

        setVisible(true);

    }

    public void setLnumero1(int numero) {
        lNumero1.setText(String.valueOf(numero));
    }

    public void setLnumero2(int numero) {
        lNumero2.setText(String.valueOf(numero));
    }

    public void setOperador(String operador) {
        lOperacion.setText(operador);
    }

    public String getSolucion() {
        return lResultado.getText();
    }

    public void setSolucion(String numero) {
        lResultado.setText(numero);
    }

    public void setAciertos(int aciertos) {
        lNumAciertos.setText(String.valueOf(aciertos));
    }

    public void setFallos(int fallos) {
        lNumFallos.setText(String.valueOf(fallos));
    }

    public void borrarSolucion() {
        lResultado.setText("");
    }

    public void setPuntuacion(String puntuacion) {
        tPuntuacion.setText(puntuacion);
    }

    public int getPuntuacion() {
        return Integer.parseInt(tPuntuacion.getText());
    }

    /*
     * class ManejaEventos implements ActionListener {
     * 
     * public ManejaEventos() {
     * }
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * for (int i = 0; i < 10; i++) {
     * if (e.getSource() == botones[i]) {
     * setSolucion(i);
     * }
     * }
     * 
     * if (e.getSource() == botones[11]) {
     * GameController.Jugar();
     * GameController.ImprimirEcuacion();
     * }
     * if (e.getSource() == miIniciarJuego) {
     * GameController.ImprimirEcuacion();
     * }
     * if (e.getSource() == botones[10]) {
     * borrarSolucion();
     * }
     * throw new
     * UnsupportedOperationException("Unimplemented method 'actionPerformed'");
     * }
     * 
     * }/*
     */

}

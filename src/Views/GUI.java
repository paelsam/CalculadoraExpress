package Views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase encargada de manejar la pantalla del juego
 * y configurar sus respectivos componentes
 */
public class GUI extends JFrame {
    private static int[] ordenBotones = { 7, 8, 9, 4, 5, 6, 1, 2, 3, 10, 0, 11 };

    // Páneles
    JPanel pAciertosFallos, pNumeros, pContenedorNumeros;
    JPanel pValoresAleatorios, pTiempoPuntuacion, pNorte;

    // Menu bar
    JMenuBar mbMenu;
    JMenu mMenu;
    JMenuItem miIniciarJuego;
    JLabel lAciertos, lFallos;
    JLabel lNumAciertos, lNumFallos;

    // Barra de tiempo y de puntuación
    JLabel lTiempo, lPuntuacion, lIgual;
    JTextField tTiempo, tPuntuacion;

    // Labels para almacenar números aleatorios
    JLabel lNumero1, lOperacion, lNumero2, lResultado;

    // Botones
    JButton botones[], bMenos;

    /**
     * Contructor de la clase GUI
     * 
     * Configura todas las características que tendrá la pantalla
     */
    public GUI() {
        setTitle("Calculadora Express");
        setSize(750, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(new Color(225, 228, 253));
    }

    public void iniciarGUI() {
        // Instanciando botones
        botones = new JButton[12];
        bMenos = new JButton("-");

        // Instanciando elementos del menú
        mbMenu = new JMenuBar();
        mMenu = new JMenu("Menu");
        miIniciarJuego = new JMenuItem("Iniciar Juego");

        lAciertos = new JLabel("Aciertos: ");
        lFallos = new JLabel("Fallos: ");
        lNumAciertos = new JLabel();
        lNumFallos = new JLabel();

        // Instanciando los labels de tiempo y punación
        lTiempo = new JLabel("Tiempo restante: ");
        lPuntuacion = new JLabel("Puntuación: ");

        // Instanciando los JTextFields que contendrán los valores
        // del tiempo y la puntuación de cada partida
        tTiempo = new JTextField();
        tPuntuacion = new JTextField();

        // Deshabilitada la edición de los JTextFields por defecto
        tTiempo.setEditable(false);
        tPuntuacion.setEditable(false);

        // Instanciando los labels que contendrán los números aleatorios
        lIgual = new JLabel("=");
        lNumero1 = new JLabel();
        lOperacion = new JLabel();
        lNumero2 = new JLabel();
        lResultado = new JLabel();

        // Instanciando todos los botones y añadiendoles estilos
        for (int i = 0; i < 12; i++) {
            botones[i] = new JButton(Integer.toString(i));
            botones[i].setFont(new Font("Comic Sans MS", Font.BOLD, 18));
            botones[i].setBackground(new Color(37, 40, 80));
            botones[i].setForeground(Color.WHITE);
        }
        botones[10] = new JButton(new ImageIcon(getClass().getResource("/assets/borrar.png")));
        botones[10].setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        botones[10].setBackground(new Color(37, 40, 80));
        botones[10].setForeground(Color.WHITE);

        botones[11] = new JButton(new ImageIcon(getClass().getResource("/assets/check.png")));
        botones[11].setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        botones[11].setBackground(new Color(37, 40, 80));
        botones[11].setForeground(Color.WHITE);
        // Desabilitado por defecto botones[11]: checkButton
        toggleCheckButton();

        // Añadiendo estlilo al botón de menos
        bMenos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        bMenos.setBackground(new Color(37, 40, 80));
        bMenos.setForeground(Color.WHITE);
        bMenos.setFocusable(false);

        // Deshabilitando el focus de todos los componentes posibles
        tTiempo.setFocusable(false);
        tPuntuacion.setFocusable(false);
        lIgual.setFocusable(false);
        lNumero1.setFocusable(false);
        lNumero2.setFocusable(false);
        lOperacion.setFocusable(false);
        lResultado.setFocusable(false);

        // Asignando el tamaño de los labels que contendrán los números aleatorios
        lNumero1.setPreferredSize(new Dimension(90, 80));
        lNumero2.setPreferredSize(new Dimension(90, 80));
        lOperacion.setPreferredSize(new Dimension(70, 80));
        lResultado.setPreferredSize(new Dimension(90, 80));

        // Añadiendo fuentes e alineaciones a los labels
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

        // Añadiendo bordes y estilo a los labels
        lNumero2.setHorizontalAlignment(JLabel.CENTER);
        lNumero2.setVerticalAlignment(JLabel.CENTER);
        lNumero2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumero1.setForeground(new Color(102, 106, 156));
        lNumero2.setForeground(new Color(102, 106, 156));
        lOperacion.setForeground(new Color(102, 106, 156));

        lNumero1.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lNumero2.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lNumero1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        lOperacion.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lOperacion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        lResultado.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lResultado.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lResultado.setForeground(new Color(255, 204, 0));

        // Alineando labels de aciertos y fallos
        lAciertos.setHorizontalAlignment(SwingConstants.CENTER);
        lAciertos.setVerticalAlignment(SwingConstants.CENTER);
        lFallos.setHorizontalAlignment(SwingConstants.CENTER);
        lFallos.setVerticalAlignment(SwingConstants.CENTER);

        // Asignando colores y fuentes a los labels
        lAciertos.setForeground(new Color(8, 193, 24));
        lFallos.setForeground(Color.RED);
        lNumAciertos.setForeground(new Color(8, 193, 24));
        lNumFallos.setForeground(Color.RED);
        lTiempo.setForeground(new Color(102, 106, 156));
        lPuntuacion.setForeground(new Color(102, 106, 156));
        lAciertos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lFallos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumAciertos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        lNumFallos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        // Dando formato y ubicacion a algunos componentes de la gui
        lTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        lTiempo.setVerticalAlignment(SwingConstants.CENTER);
        lTiempo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        lPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
        lPuntuacion.setVerticalAlignment(SwingConstants.CENTER);
        lPuntuacion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));

        // Creado panel de manera externa para centrar los labels
        // De los valores aleatorios
        FlowLayout panel = new FlowLayout(FlowLayout.CENTER, 20, 20);
        panel.setVgap(60);

        // Definiendo páneles
        pAciertosFallos = new JPanel(new GridLayout(1, 4));
        pContenedorNumeros = new JPanel(new BorderLayout());
        pNumeros = new JPanel(new GridLayout(4, 3, 4, 4));
        pValoresAleatorios = new JPanel(panel);
        pTiempoPuntuacion = new JPanel(new GridLayout(1, 4));
        pNorte = new JPanel(new BorderLayout());

        // Dando belleza a los algunos paneles
        pAciertosFallos.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pValoresAleatorios.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pNumeros.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pTiempoPuntuacion.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));

        pAciertosFallos.setBackground(new Color(225, 228, 253));
        pValoresAleatorios.setBackground(new Color(225, 228, 253));
        pTiempoPuntuacion.setBackground(new Color(225, 228, 253));

        pTiempoPuntuacion.add(lTiempo);
        pTiempoPuntuacion.add(tTiempo);
        pTiempoPuntuacion.add(lPuntuacion);
        pTiempoPuntuacion.add(tPuntuacion);

        mbMenu.add(mMenu);
        mMenu.add(miIniciarJuego);

        pAciertosFallos.add(lAciertos);
        pAciertosFallos.add(lNumAciertos);
        pAciertosFallos.add(lFallos);
        pAciertosFallos.add(lNumFallos);

        // Añadiendo los botones en el orden correcto al panel de números
        for (int indice : ordenBotones) {
            pNumeros.add(botones[indice]);
        }

        pValoresAleatorios.add(lNumero1);
        pValoresAleatorios.add(lOperacion);
        pValoresAleatorios.add(lNumero2);
        pValoresAleatorios.add(lIgual);
        pValoresAleatorios.add(lResultado);

        // Adicionando algunos botones al panel que contine los botones de numeros
        pContenedorNumeros.add(bMenos, BorderLayout.NORTH);
        pContenedorNumeros.add(pNumeros, BorderLayout.CENTER);

        pNorte.add(mbMenu, BorderLayout.NORTH);
        pNorte.add(pAciertosFallos, BorderLayout.SOUTH);

        add(pNorte, BorderLayout.NORTH);
        add(pValoresAleatorios, BorderLayout.CENTER);
        add(pContenedorNumeros, BorderLayout.EAST);
        add(pTiempoPuntuacion, BorderLayout.SOUTH);

        // Eventos
        ActionEventHandler event = new ActionEventHandler();

        // Añadiendo EventListeners
        for (JButton boton : botones) {
            boton.setFocusable(false);
            boton.addActionListener(event);
        }

        // Añadiendo KeyListener a la ventana
        this.addKeyListener(event);
        bMenos.addActionListener(event);
        miIniciarJuego.addActionListener(event);

        // pack: Ajusta todos los componentes al tamaño de la ventana
        pack();
        setVisible(true);
    }

    /**
     * Configura el texto de la etiqueta de aciertos
     * 
     * @param aciertos Entero que representa los aciertos del juego
     */
    public void setAciertos(int aciertos) {
        lNumAciertos.setText(Integer.toString(aciertos));
    }

    /**
     * funcion que configura el texto de la etiqueta de fallos
     * 
     * @param fallos Entero que representa los fallos del juego
     */
    public void setFallos(int fallos) {
        lNumFallos.setText(Integer.toString(fallos));
    }

    /**
     * Configura el texto de la etiqueta numero1 de la gui
     * 
     * @param numero1 Entero que representa el numero uno de la ecuacion
     *                matematica
     */
    public void setNumero1(int numero1) {
        if (numero1 == 0) {
            lNumero1.setText("");
        } else {
            lNumero1.setText(Integer.toString(numero1));
        }
    }

    /**
     * Configura el texto de la etiqueta numero 2 de la gui
     * 
     * @param numero2 Entero que representa el numero dos de la ecuación matematica
     */
    public void setNumero2(int numero2) {
        if (numero2 == 0) {
            lNumero2.setText("");
        } else {
            lNumero2.setText(Integer.toString(numero2));
        }
    }

    /**
     * Configura el texto de la etiqueta operador de la gui
     * 
     * @param operador Caracter que representa el operador de la ecuacion
     *                 matematica
     */
    public void setOperador(char operador) {
        lOperacion.setText(Character.toString(operador));
    }

    /**
     * Configura el texto del componente lResultado de la gui
     * 
     * @param resultado String que representa el el resultado del label lResultado
     */
    public void setResultado(String resultado) {
        lResultado.setText(lResultado.getText() + resultado);
    }

    /**
     * Obtiene el texto de la etiqueta resultado
     * 
     * @return lResltado String de la etiqueta resultado de la gui.
     */

    public String getResultado() {
        return lResultado.getText();
    }

    /**
     * Borra el texto de la etiqueta resultado de la gui
     * 
     * @return void
     */
    public void deleteResultado() {
        lResultado.setText("");
    }

    /**
     * Configura el campo de texto de la puntuacion de la gui
     * 
     * @param puntuacion entero que representa la puntuacion del juego
     * 
     * @return void
     */
    public void setPuntuacion(int puntuacion) {
        tPuntuacion.setText(Integer.toString(puntuacion));
    }

    /**
     * Configura el campo de texto del tiempo de la gui
     * 
     * @param tiempoRestante Entero que representa el tiempo restante de la
     *                       partida
     * 
     * @return void
     */
    public void setTiempoRestante(int tiempoRestante) {
        tTiempo.setText(Integer.toString(tiempoRestante));
    }

    /**
     * Habilita/Desabilita el boton de check (botones[11])
     * 
     * @return void
     */
    public void toggleCheckButton() {
        if (botones[11].isEnabled())
            botones[11].setEnabled(false);
        else
            botones[11].setEnabled(true);
    }

    /**
     * Habilita/Desabilita el MenuItem iniciarJuego dependiendo de su estado
     * 
     * @return void
     */
    public void toggleMIIniciarJuego() {
        if (miIniciarJuego.isEnabled())
            miIniciarJuego.setEnabled(false);
        else
            miIniciarJuego.setEnabled(true);
    }

    public class ActionEventHandler implements ActionListener, KeyListener {

        /**
         * Se ejucuta cuando se hacer cualquier acción en
         * la pantalla
         * 
         * @return void
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == bMenos) {
                if (!lResultado.getText().contains("-"))
                    lResultado.setText("-" + lResultado.getText());
                else
                    lResultado.setText(lResultado.getText().substring(1));
            }

            if (e.getSource() == miIniciarJuego) {
                GameController.iniciarJuego();
                GameController.iniciarCuentaRegresiva();
                toggleMIIniciarJuego();
                botones[11].setEnabled(true);
                return;
            }

            for (int indice : ordenBotones) {
                if (e.getSource() == botones[10]) {
                    deleteResultado();
                    break;
                }
                if (e.getSource() == botones[11]) {
                    GameController.verificarResultado();
                    GameController.iniciarJuego();
                    // Se borra después de inciar el juego
                    deleteResultado();
                    break;
                }
                if (e.getSource() == botones[indice]) {
                    setResultado(botones[indice].getText());
                    break;
                }
            }
        }

        /**
         * Implemeta los métodos abstractos de la clase abstracta
         * KeyListener para el manejo de los eventos del teclado.
         * Se ejecuta cuando una recla es presionada.
         * 
         * @return void
         */
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ENTER:
                    // No funciona hasta hasta que el menuitem esté deshabilado
                    if (!miIniciarJuego.isEnabled()) {
                        GameController.verificarResultado();
                        GameController.iniciarJuego();
                        // Se borra después de inciar el juego
                        deleteResultado();
                    }
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    deleteResultado();
                    break;
                case KeyEvent.VK_MINUS:
                    setResultado("-");
                    break;
                default:
                    break;
            }
            // DEl 0 al 9 porque los botones 10 y 11 no son números
            for (int i = 0; i <= 9; i++) {
                int keyCodeE = KeyEvent.getExtendedKeyCodeForChar(botones[i].getText().charAt(0));
                if (keyCodeE == e.getKeyCode()) {
                    setResultado(botones[i].getText());
                    break;
                }
            }
        }

        /**
         * Ejecuta una acción cuando una tecla es presionada, pero no acepta teclas
         * especiales
         * 
         * @return void
         */
        @Override
        public void keyTyped(KeyEvent e) {
        }

        /**
         * Ejecuta una acción cuando una tecla es presionada y luego soltada
         * 
         * @return void
         */
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}

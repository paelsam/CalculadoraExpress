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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class GUI extends JFrame 
{
    private static int[] ordenBotones = {7,8,9,4,5,6,1,2,3,10,0,11};
    
    JMenuBar mbMenu;
    JMenu mMenu;
    JMenuItem miIniciarJuego;
    JLabel lAciertos, lFallos, lNumAciertos, lNumFallos;
    JLabel lTiempo, lPuntuacion, lIgual;
    JTextField tTiempo, tPuntuacion;
    JPanel pAciertosFallos, pNumeros, pContenedorNumeros;
    JPanel pValoresAleatorios, pTiempoPuntuacion, pNorte;
    JButton botones[], bMenos;
    JLabel lNumero1, lOperacion, lNumero2, lResultado;
    
    public GUI() 
    {
        setTitle("Calculadora Express");
        setSize(750, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setFont(new Font("Comic Sans MS",Font.BOLD,18));
        setBackground(new Color(225,228,253));
        iniciarGUI();

    }

    public void iniciarGUI()
    {
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
        lNumero1 = new JLabel();
        lOperacion = new JLabel();
        lNumero2 = new JLabel();
        lResultado = new JLabel();

        tTiempo = new JTextField();
        tPuntuacion = new JTextField();


        // Asignando el tamaño de los labels
        lNumero1.setPreferredSize(new Dimension(90, 80));
        lNumero2.setPreferredSize(new Dimension(90, 80));
        lOperacion.setPreferredSize(new Dimension(70, 80));
        lResultado.setPreferredSize(new Dimension(90, 80));


        // Añadiendo fuentes e alineaciones a los labels
        lIgual.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        lIgual.setHorizontalAlignment(SwingConstants.CENTER); lIgual.setVerticalAlignment(SwingConstants.CENTER);
        lNumero1.setHorizontalAlignment(SwingConstants.CENTER); lNumero1.setVerticalAlignment(SwingConstants.CENTER);
        lNumero2.setHorizontalAlignment(SwingConstants.CENTER); lNumero2.setVerticalAlignment(SwingConstants.CENTER);
        lOperacion.setHorizontalAlignment(SwingConstants.CENTER);lOperacion.setVerticalAlignment(SwingConstants.CENTER);
        lResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lResultado.setVerticalAlignment(SwingConstants.CENTER);

        // Añadiendo bordes a los labels
        lNumero2.setHorizontalAlignment(JLabel.CENTER);
        lNumero2.setVerticalAlignment(JLabel.CENTER);
        lNumero1.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lNumero2.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lOperacion.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        lResultado.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));

        // Alineando labels de aciertos y fallos
        lAciertos.setHorizontalAlignment(SwingConstants.CENTER); lAciertos.setVerticalAlignment(SwingConstants.CENTER);
        lFallos.setHorizontalAlignment(SwingConstants.CENTER); lFallos.setVerticalAlignment(SwingConstants.CENTER);
        
        // Asignando colores y fuentes a los labels de aciertos y fallos
        lAciertos.setForeground(new Color(8,193,24));
        lFallos.setForeground(Color.RED);
        lTiempo.setForeground(new Color(102,106,156));
        lPuntuacion.setForeground(new Color(102,106,156));
        lAciertos.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        lFallos.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        
        // Definiendo los botones
        for (int i = 0; i < 12; i++)
        {   
            botones[i] = new JButton(Integer.toString(i));
            botones[i].setFont(new Font("Comic Sans MS",Font.BOLD,18));
            botones[i].setBackground(new Color(37, 40, 80));
            botones[i].setForeground(Color.WHITE);
            
        }
        botones[10] = new JButton(new ImageIcon(getClass().getResource("/assets/borrar.png")));
        botones[10].setFont(new Font("Comic Sans MS",Font.BOLD,18));
        botones[10].setBackground(new Color(37, 40, 80));
        botones[10].setForeground(Color.WHITE);

        botones[11] = new JButton(new ImageIcon(getClass().getResource("/assets/check.png")));
        botones[11].setFont(new Font("Comic Sans MS",Font.BOLD,18));
        botones[11].setBackground(new Color(37, 40, 80));
        botones[11].setForeground(Color.WHITE);

        bMenos = new JButton("-");
        bMenos.setFont(new Font("Comic Sans MS",Font.BOLD,18));
        bMenos.setBackground(new Color(37, 40, 80));
        bMenos.setForeground(Color.WHITE);

        // Creado panel para centrar los labels
        FlowLayout panel = new FlowLayout(FlowLayout.CENTER, 20, 20);
        panel.setVgap(60);

        // Definiendo páneles
        pAciertosFallos = new JPanel(new GridLayout(1, 4));
        pContenedorNumeros = new JPanel( new BorderLayout() );
        pNumeros = new JPanel(new GridLayout(4,3, 4, 4));
        pValoresAleatorios = new JPanel(panel);
        pTiempoPuntuacion = new JPanel(new GridLayout(1, 4));
        pNorte = new JPanel(new BorderLayout());

        mbMenu.add(mMenu);
        mMenu.add(miIniciarJuego);

        pAciertosFallos.add(lAciertos);
        pAciertosFallos.add(lNumAciertos);
        pAciertosFallos.add(lFallos);
        pAciertosFallos.add(lNumFallos);
        
        // Añadiendo los botones en el orden correcto
        for ( int indice : ordenBotones ) {
            pNumeros.add(botones[indice]);
        }

        pValoresAleatorios.add(lNumero1); pValoresAleatorios.add(lOperacion);
        pValoresAleatorios.add(lNumero2); pValoresAleatorios.add(lIgual);
        pValoresAleatorios.add(lResultado);

        lTiempo.setHorizontalAlignment(SwingConstants.CENTER);
        lTiempo.setVerticalAlignment(SwingConstants.CENTER);
        lTiempo.setFont(new Font("Comic Sans MS",Font.BOLD,18));

        lPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
        lPuntuacion.setVerticalAlignment(SwingConstants.CENTER);
        lPuntuacion.setFont(new Font("Comic Sans MS",Font.BOLD,18)); 

        pTiempoPuntuacion.add(lTiempo); pTiempoPuntuacion.add(tTiempo);
        pTiempoPuntuacion.add(lPuntuacion); pTiempoPuntuacion.add(tPuntuacion);

        pAciertosFallos.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pValoresAleatorios.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pNumeros.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));
        pTiempoPuntuacion.setBorder(BorderFactory.createBevelBorder(WIDTH, Color.lightGray, Color.WHITE));

        pAciertosFallos.setBackground(new Color(225, 228, 253));
        pValoresAleatorios.setBackground(new Color(225, 228, 253));
        pTiempoPuntuacion.setBackground(new Color(225, 228, 253));

        pContenedorNumeros.add(bMenos, BorderLayout.NORTH);
        pContenedorNumeros.add(pNumeros, BorderLayout.CENTER);

        pNorte.add(mbMenu, BorderLayout.NORTH); pNorte.add(pAciertosFallos, BorderLayout.SOUTH);

        
        add(pNorte, BorderLayout.NORTH);
        add(pValoresAleatorios, BorderLayout.CENTER);
        add(pContenedorNumeros, BorderLayout.EAST);
        add(pTiempoPuntuacion, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }





}

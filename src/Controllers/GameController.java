package Controllers;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import Models.Game;
import Views.GUI;

/**
 * clase GameController: es el controlador del juego que gestiona las
 * interacciones entre la clase GUI y la clase Game.
 * contiene a la clase GUI y la clase Game.
 * 
 * @version 1.0
 */
public class GameController {

    private static final int TIEMPO_DE_PARTIDA = 60;

    static private int tiempoRestante = TIEMPO_DE_PARTIDA;
    static GUI gui;
    static Game game;
    static Timer temporizador;

    /**
     * funcion que instancia los objetos gui, game, temporizador e invoca la funcion
     * gui.iniciarGui para que se ejecute el frame y sus componentes.
     */
    public static void iniciarVentana() {
        gui = new GUI();
        game = new Game();
        temporizador = new Timer();
        gui.iniciarGUI();
    }

    /**
     * funcion que gestiona el temporizador de la GUI para que el tiempo corra en
     * forma regresiva y al terminarse se ejecute la funcion
     * juego terminado.
     */
    public static void iniciarCuentaRegresiva() {
        temporizador.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Tiempo restante: " + tiempoRestante);
                if (tiempoRestante > 0) {
                    tiempoRestante--;
                    gui.setTiempoRestante(tiempoRestante);
                } else {
                    temporizador.cancel();
                    temporizador.purge();
                    juegoTerminado();
                }
            }
        }, 0, 1000);
    }

    /**
     * funcion que inicia el juego, se asigna un estado inicial del los componentes
     * de la GUi relacionados con el la clase Game.
     */
    public static void iniciarJuego() {
        // asigando valores a los tributos de la operacion matematica en la clase Game
        game.obtenerOperaciónAleatoria(1, 40);
        game.obtenerResultado();

        // configurando los valores de los componentes de la gui
        gui.setNumero1(game.getNumeroUno());
        gui.setNumero2(game.getNumeroDos());
        gui.setOperador(game.getOperador());
        gui.setAciertos(game.getAciertosTotales());
        gui.setPuntuacion(game.getPuntuacionTotal());
        gui.setFallos(game.getFallosTotales());
        gui.setPuntuacion(game.getPuntuacionTotal());
    }

    /**
     * funcion que verifica que el resultado de la gui sea igual al valor de la
     * variable resultado del objeto game de la clase Game
     * y modifica adecuadamente los respectivos componentes de la gui para que se
     * muestren en pantalla.
     */
    public static void verificarResultado() {

        if (gui.getResultado().isEmpty())
            return;

        int resultadoInput = Integer.parseInt(gui.getResultado());

        // verificando si el resultado que biene de la gui es igual al resultado de game

        if (resultadoInput == game.getResultado()) {
            game.setAciertosPartida(game.getAciertosPartida() + 1);
            game.setAciertosTotales(game.getAciertosTotales() + 1);
            game.setPuntuacionPartida(game.getPuntuacionPartida() + 100);
            game.setPuntuacionTotal(game.getPuntuacionTotal() + 100);
        } else {
            game.setFallosPartida(game.getFallosPartida() + 1);
            game.setFallosTotales(game.getFallosTotales() + 1);
            game.setPuntuacionPartida(game.getPuntuacionPartida() - 50);
            game.setPuntuacionTotal(game.getPuntuacionTotal() - 50);
        }
    }

    /**
     * funcion que reinicia el estado del juego, es desir los valores de los
     * atributos de el objeto game de la clase Game para que
     * el juego se reinicie y se comience una nueva partida
     */
    public static void reiniciar() {

        temporizador = new Timer();
        tiempoRestante = TIEMPO_DE_PARTIDA;

        // reiniciando atributos de la clase Game
        game.setAciertosPartida(0);
        game.setFallosPartida(0);
        game.setPuntuacionPartida(0);
        game.setAciertosTotales(0);
        game.setFallosTotales(0);
        game.setPuntuacionTotal(0);

        // reiniciando valores de los componentes de la gui
        gui.setNumero1(0);
        gui.setNumero2(0);
        gui.toggleMIIniciarJuego();
        gui.setOperador(' ');
        gui.setAciertos(0);
        gui.setFallos(0);
        gui.setPuntuacion(0);
    }

    /**
     * funcion que muestra un mensaje de finalizacion del juego con los datos de la
     * partida y pregunta si el usuario desea seguir jugando
     * 
     * @return JOptionPane- ventana de informacion y opciones
     */
    public static int gameOver() {
        String mensaje = "Se acabó el tiempo :(" +
                "\nAciertos en esta partida: " + game.getAciertosPartida() +
                "\nFallos en esta partida: " + game.getFallosPartida() +
                "\nPuntos en esta partida: " + game.getPuntuacionPartida() +
                "\n¿Deseas continuar jugando otra partida?";
        return JOptionPane.showConfirmDialog(gui, mensaje, "Partida terminada", JOptionPane.YES_NO_OPTION);
    }

    /**
     * funcion que restablece los valore iniciales de algunos atributos del objeto
     * game de la clase Game y reinicia el juego.
     */
    public static void juegoTerminado() {
        int respuesta = gameOver();

        if (respuesta == 0) {
            // Reiniciando los aciertos por partida
            game.setAciertosPartida(0);
            game.setFallosPartida(0);
            game.setPuntuacionPartida(0);

            // Restableciendo el timer
            temporizador = new Timer();
            tiempoRestante = TIEMPO_DE_PARTIDA;
            iniciarJuego();
            iniciarCuentaRegresiva();
        } else {
            reiniciar();
            gui.toggleCheckButton();
        }
    }
}
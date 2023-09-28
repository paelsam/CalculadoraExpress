package Controllers;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import Models.Game;
import Views.GUI;

/**
 * 
 * Controlador del juego que gestiona las
 * interacciones entre la clase GUI y la clase Game.
 * 
 * Contiene la clase GUI y la clase Game.
 * 
 * @version 1.0
 */
public class GameController {

    private static final int TIEMPO_DE_PARTIDA = 60;
    private static int tiempoRestante = TIEMPO_DE_PARTIDA;

    private static GUI gui;
    private static Game game;
    private static Timer temporizador;

    /**
     * Instancia los objetos gui, game y temporizador e invoca la funcion
     * gui.iniciarGui para que se ejecute la clase GUI y sus componentes.
     * 
     * @return void
     */
    public static void iniciarVentana() {
        gui = new GUI();
        game = new Game();
        temporizador = new Timer();
        gui.iniciarGUI();
    }

    /**
     * Gestiona el temporizador de la GUI para que el tiempo corra en
     * forma regresiva y al terminarse se ejecute la funcion
     * juego terminado.
     * 
     * @return void
     */
    public static void iniciarCuentaRegresiva() {
        temporizador.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if (tiempoRestante > 0) {
                    System.out.println("Tiempo restante: " + tiempoRestante);
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
     * Inicia el juego, se asigna un estado inicial del los componentes
     * de la GUi relacionados con el la clase Game.
     * 
     * @return void 
     */
    public static void iniciarJuego() {
        // Asignando valores a los atributos de la operacion matemática en el objeto game
        game.obtenerOperacionAleatoria(1, 400);
        game.obtenerResultado();

        // Asignado los valores del objeto game a al objeto gui
        gui.setNumero1(game.getNumeroUno());
        gui.setNumero2(game.getNumeroDos());
        gui.setOperador(game.getOperador());
        gui.setAciertos(game.getAciertosTotales());
        gui.setPuntuacion(game.getPuntuacionTotal());
        gui.setFallos(game.getFallosTotales());
        gui.setPuntuacion(game.getPuntuacionTotal());
    }

    /**
     * Verifica que el texto del label de resultado de la gui sea igual al valor del
     * atributo resultado del objeto game, y modifica adecuadamente los respectivos 
     * componentes de la gui para que se muestren en pantalla.
     * 
     * @see Models.Game
     * @see Views.GUI
     * 
     * @return void
     */
    public static void verificarResultado() {

        // Si no hay resultado, no se realiza ninguna acción
        if (gui.getResultado().isEmpty())
            return;

        int resultadoInput = Integer.parseInt(gui.getResultado());

        // Verificar si el resultado del objeto gui es igual al resultado del objeto game

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
     * Reinicia el juego a su estado incial, es decir, los valores de los
     * atributos del objeto game de la clase Game y de la gui de la clase GUI 
     * para que el juego se reinicie y se comience una nueva partida
     * 
     * @return void
     */
    public static void reiniciar() {

        temporizador = new Timer();
        tiempoRestante = TIEMPO_DE_PARTIDA;

        // Reiniciando atributos de la clase Game
        game.setAciertosPartida(0);
        game.setFallosPartida(0);
        game.setPuntuacionPartida(0);
        game.setAciertosTotales(0);
        game.setFallosTotales(0);
        game.setPuntuacionTotal(0);

        // Reinciando valores de los componentes de la gui
        gui.setNumero1(0);
        gui.setNumero2(0);
        gui.toggleMIIniciarJuego();
        gui.setOperador(' ');
        gui.setAciertos(0);
        gui.setFallos(0);
        gui.setPuntuacion(0);
    }

    /**
     * Muestra un mensaje de finalizacion del juego con los datos de la
     * partida y pregunta si el usuario desea seguir jugando
     * 
     * @return {@link javax.swing.JOptionPane.showConfirmDialog } : retorna 0 o 1
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
     * Reestablece los valores iniciales de algunos atributos del objeto
     * game de la clase Game y reinicia el juego.
     * 
     * @return void
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
        } if ( respuesta == 1) {
            reiniciar();
            gui.toggleCheckButton();
        }
        return;
    }
}
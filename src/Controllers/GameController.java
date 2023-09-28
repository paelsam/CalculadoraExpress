package Controllers;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import Models.Game;
import Views.GUI;

public class GameController {

    private static final int TIEMPO_DE_PARTIDA = 5; 

    static private int tiempoRestante = TIEMPO_DE_PARTIDA;
    static GUI gui;
    static Game game;
    static Timer temporizador;

    public static void iniciarVentana() {
        gui = new GUI();
        game = new Game();
        temporizador = new Timer();
        gui.iniciarGUI();
    }

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

    public static void iniciarJuego() {
        game.obtenerOperaciónAleatoria(1, 40);
        game.obtenerResultado();

        gui.setNumero1(game.getNumeroUno());
        gui.setNumero2(game.getNumeroDos());
        gui.setOperador(game.getOperador());
        gui.setAciertos(game.getAciertosTotales());
        gui.setPuntuacion(game.getPuntuacionTotal());
        gui.setFallos(game.getFallosTotales());
        gui.setPuntuacion(game.getPuntuacionTotal());
    }

    public static void verificarResultado() {

        if (gui.getResultado().isEmpty())
            return;

        int resultadoInput = Integer.parseInt(gui.getResultado());

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

    public static void reiniciar() {

        temporizador = new Timer();
        tiempoRestante = TIEMPO_DE_PARTIDA;

        game.setAciertosPartida(0);
        game.setFallosPartida(0);
        game.setPuntuacionPartida(0);
        game.setAciertosTotales(0);
        game.setFallosTotales(0);
        game.setPuntuacionTotal(0);

        gui.setNumero1(0);
        gui.setNumero2(0);
        gui.toggleMIIniciarJuego();
        gui.setOperador(' ');
        gui.setAciertos(0);
        gui.setFallos(0);
        gui.setPuntuacion(0);
    }

    public static int gameOver() {
        String mensaje = "Se acabó el tiempo :(" +
                "\nAciertos en esta partida: " + game.getAciertosPartida() +
                "\nFallos en esta partida: " + game.getFallosPartida() +
                "\nPuntos en esta partida: " + game.getPuntuacionPartida() +
                "\n¿Deseas continuar jugando otra partida?";
        return JOptionPane.showConfirmDialog(gui, mensaje, "Partida terminada", JOptionPane.YES_NO_OPTION);
    }

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
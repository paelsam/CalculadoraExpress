package Controllers;

import java.util.Timer;
import java.util.TimerTask;

import Models.Game;
import Views.GUI;

public class GameController {
    
    static private int tiempoRestante = 60;
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
                if ( tiempoRestante > 0 ) {
                    tiempoRestante--;
                    gui.setTiempoRestante( tiempoRestante );
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
        
        gui.setNumero1( game.getNumeroUno() );
        gui.setNumero2( game.getNumeroDos() );
        gui.setOperador( game.getOperador() );
    }

    public static void verificarResultado() {

        int resultadoInput = Integer.parseInt( gui.getResultado() );

        if ( resultadoInput == game.getResultado() ) {
            game.setAciertos( game.getAciertos() + 1 );
            gui.setAciertos( game.getAciertos() );

            game.setPuntuacion( game.getPuntuacion() + 100 );
            gui.setPuntuacion( game.getPuntuacion() );
        } else {
            game.setFallos( game.getFallos() + 1 );
            gui.setFallos( game.getFallos() );

            game.setPuntuacion( game.getPuntuacion() - 50 );
            gui.setPuntuacion( game.getPuntuacion() );

        }
    }

    public static void reiniciar() {

        temporizador = new Timer();
        tiempoRestante = 60;
        game.setAciertos(0); game.setFallos(0); game.setPuntuacion(0);
        gui.setAciertos(0); gui.setFallos(0); gui.setPuntuacion(0);
        gui.setNumero1(0); gui.setNumero2(0); gui.toggleMIIniciarJuego();
    }

     public static void juegoTerminado() {
        int respuesta = gui.gameOver();
        
        if ( respuesta == 0 ) {
            // Restableciendo el timer
            temporizador = new Timer();
            tiempoRestante = 60;
            iniciarJuego();
            iniciarCuentaRegresiva();
        } else {
            reiniciar();
        }

    }
}
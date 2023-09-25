package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import Models.Game;
import Views.GUI;
import Views.GestionEventos;
import javax.swing.Timer;

public class GameController {
    static Game game;
    static GUI gui;
    static GestionEventos gestiongui;
    public static ActionListener actionListener;
    static int tiempoRestante;

    public static void iniciar() {
        actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                tiempoRestante--;
                gui.setTiempo(String.valueOf(tiempoRestante));

                if (tiempoRestante <= 0) {
                    ((Timer) e.getSource()).stop();
                    int numero = JOptionPane.showConfirmDialog(null,
                            "Se acabo el tiempo:(\nAsiertos en esta partida " + game.getAciertos()
                                    + "\nFallos en esta partida: "
                                    + game.getFallos() + "\nPuntos en esta partida:" + game.getPuntuacion()
                                    + "\n¿Desea Continuar jugando otra partida?",
                            "time over", JOptionPane.YES_NO_OPTION);
                    if (numero == 0) {
                        tiempoRestante = 10;
                        gui.startTemporizador();
                    } else {
                        gui.dispose();
                        iniciar();
                    }

                }
            }

        };
        game = new Game();
        gui = new GUI();
        gestiongui = new GestionEventos(gui);
        game.setAciertos(0);
        game.setFallos(0);
        game.setPuntuacion(0);
        tiempoRestante = 10;

    };

    public static void ImprimirEcuacion() {
        game.obtenerOperaciónAleatoria(1, 400);
        game.obtenerResultado();
        gui.setLnumero1(game.getNumeroUno());
        gui.setLnumero2(game.getNumeroDos());
        gui.setOperador(game.getOperador());

    }

    public static void Jugar() {

        if (gui.getSolucion().equals(String.valueOf(game.getResultado()))) {

            game.setPuntuacion(game.getPuntuacion() + 100);
            game.setAciertos(game.getAciertos() + 1);
            gui.setAciertos(game.getAciertos());
            gui.setPuntuacion(String.valueOf(game.getPuntuacion()));

        } else if (!gui.getSolucion().equals("")) {

            game.setFallos(game.getFallos() + 1);
            if (game.getPuntuacion() > 0) {
                game.setPuntuacion(game.getPuntuacion() - 50);
            }

            gui.setFallos(game.getFallos());
            gui.setPuntuacion(String.valueOf(game.getPuntuacion()));

        }
        gui.borrarSolucion();
    }

}
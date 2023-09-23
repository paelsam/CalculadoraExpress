package Controllers;

import Models.Game;
import Views.GUI;
import Views.GestionEventos;

public class GameController {
    static Game game;
    static GUI gui;
    static GestionEventos gestiongui;

    public static void iniciar() {
        game = new Game();
        gui = new GUI();
        gestiongui = new GestionEventos(gui);
        game.setAciertos(0);
        game.setFallos(0);

    }

    public static void ImprimirEcuacion() {
        game.obtenerOperaciónAleatoria(1, 400);
        game.obtenerResultado();
        gui.setLnumero1(game.getNumeroUno());
        gui.setLnumero2(game.getNumeroDos());
        gui.setOperador(game.getOperador());

    }

    public static void Jugar() {

        if (gui.getSolucion().equals(String.valueOf(game.getResultado()))) {

            int aciertos = game.getAciertos() + 1;
            game.setAciertos(aciertos);
            gui.setAciertos(game.getAciertos());

        } else if (!gui.getSolucion().equals("")) {
            int fallos = game.getFallos() + 1;

            game.setFallos(fallos);
            gui.setFallos(game.getFallos());
        }
        gui.borrarSolucion();
    }

}
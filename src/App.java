import Views.GUI;
import Models.Game;
import Controllers.GameController;

public class App {
    public static void main(String[] args) throws Exception {

        /*
         * GUI interfaz = new GUI();
         * interfaz.setLnumero1(2);
         * interfaz.setLnumero2(34);
         * interfaz.setOperador("+");/*
         */
        GameController.iniciar();
        // GameController.Jugar();

        /*
         * Game game = new Game();
         * game.obtenerOperaciónAleatoria(1, 400);
         * game.obtenerResultado();
         * System.out.println(game.getNumeroUno());
         * System.out.println(game.getOperador());
         * System.out.println(game.getNumeroDos());
         * System.out.println(game.getResultado());/*
         */

    }
}

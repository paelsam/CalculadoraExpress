package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import Controllers.GameController;

public class GestionEventos implements ActionListener {

    GUI gui;
    // int tiempoRestate = 60;
    // Timer temporizador;

    public GestionEventos(GUI gui) {
        this.gui = gui;
        for (int i = 0; i < 12; i++) {
            gui.botones[i].addActionListener(this);
        }
        gui.miIniciarJuego.addActionListener(this);
        gui.bMenos.addActionListener(this);
        // temporizador = new Timer(1000, this);
        // temporizador.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == gui.botones[i]) {
                gui.setSolucion(gui.getSolucion().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == gui.botones[11]) {

            GameController.Jugar();
            GameController.ImprimirEcuacion();
        }
        if (e.getSource() == gui.miIniciarJuego) {

            GameController.ImprimirEcuacion();
        }
        if (e.getSource() == gui.botones[10]) {
            gui.borrarSolucion();
        }

        if (e.getSource() == gui.bMenos) {
            gui.setSolucion("-" + gui.getSolucion());
        }
        /*
         * tiempoRestate--;
         * gui.tTiempo.setText(String.valueOf(tiempoRestate));
         * 
         * if (tiempoRestate <= 0) {
         * ((Timer) e.getSource()).stop();
         * JOptionPane.showMessageDialog(null, "tiempo agotado");
         * }
         */

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}

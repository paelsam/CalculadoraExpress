package Views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Controllers.GameController;

public class GestionEventos implements ActionListener, KeyListener {

    GUI gui;
    boolean bandera = false;

    public GestionEventos(GUI gui) {
        this.gui = gui;
        for (int i = 0; i < 12; i++) {
            gui.botones[i].addActionListener(this);
        }
        gui.miIniciarJuego.addActionListener(this);
        gui.bMenos.addActionListener(this);
        gui.addKeyListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == gui.botones[i] && bandera) {
                gui.setSolucion(gui.getSolucion().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == gui.botones[11] && bandera) {

            GameController.Jugar();
            GameController.ImprimirEcuacion();
        }
        if (e.getSource() == gui.miIniciarJuego) {
            gui.startTemporizador();

            GameController.ImprimirEcuacion();
            bandera = true;
        }
        if (e.getSource() == gui.botones[10] && bandera) {
            gui.borrarSolucion();
        }

        if (e.getSource() == gui.bMenos && bandera) {
            gui.setSolucion("-" + gui.getSolucion());
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Character.isDigit(e.getKeyChar())) {
            gui.setSolucion(gui.getSolucion().concat(String.valueOf(e.getKeyChar())));

        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            GameController.Jugar();
            GameController.ImprimirEcuacion();
        }
        if (e.getKeyCode() == 8) {

            gui.borrarSolucion();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

}

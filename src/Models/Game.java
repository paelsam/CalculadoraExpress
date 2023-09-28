package Models;

/*
 * Clase Game: implementa la logica de el juego.Esta clase esta contenida en la clase Gamecontroller
 * @version 1.0
 */

public class Game {

    private static char[] operadores = { '+', '-', '*', '%' };
    private char operador;
    private int numeroUno, numeroDos, resultado;
    private int aciertosTotales, aciertosPartida;
    private int fallosTotales, fallosPartida;
    private int puntuacionTotal, puntuacionPartida;

    /*
     * constructor de la clase game
     */
    public Game() {
        aciertosPartida = 0;
        aciertosTotales = 0;
        fallosPartida = 0;
        fallosTotales = 0;
        puntuacionPartida = 0;
        puntuacionTotal = 0;
    }

    /*
     * funcion que asigna valores aleatorios en un rango determinado a la variables
     * numemroUno,numeroDos y operadores
     * 
     * @param int min-valor minimo del rango aleatorio
     * 
     * @param int max- valor maximo del rango aleatorio
     * 
     * @return void
     */
    public void obtenerOperaciónAleatoria(int min, int max) {
        this.numeroUno = (int) (Math.random() * max) + min;
        this.numeroDos = (int) (Math.random() * max) + min;
        operador = operadores[(int) (Math.random() * operadores.length)];
    }

    /*
     * funcion que asigna una determinada operacion matematica entre las variable
     * numeroUno y numeroDos
     * 
     * @return int resultado- resultado de la operacion matematica
     */
    public int obtenerResultado() {
        switch (operador) {
            case '+':
                resultado = numeroUno + numeroDos;
                break;
            case '-':
                resultado = numeroUno - numeroDos;
                break;
            case '*':
                resultado = numeroUno * numeroDos;
                break;
            case '%':
                resultado = numeroUno % numeroDos;
                break;
            default:
                throw new Error("Operador no encontrado", null);
        }
        return resultado;
    }

    /**
     * getter
     * 
     * @return variable numeroUno
     */
    public int getNumeroUno() {
        return this.numeroUno;
    }

    /**
     * getter
     * 
     * @return vairable numeroDos
     */

    public int getNumeroDos() {
        return this.numeroDos;
    }

    /**
     * getter
     * 
     * @return variable resultado
     */
    public int getResultado() {
        return this.resultado;
    }

    /**
     * getter
     * 
     * @return variable operador
     */
    public char getOperador() {
        return this.operador;
    }

    /**
     * getter
     * 
     * @return variable aciertosPartida
     */
    public int getAciertosPartida() {
        return this.aciertosPartida;
    }

    /**
     * getter
     * 
     * @return variable fallosPartida
     */
    public int getFallosPartida() {
        return this.fallosPartida;
    }

    /**
     * getter
     * 
     * @return variable puntuacionPartida
     */
    public int getPuntuacionPartida() {
        return this.puntuacionPartida;
    }

    /**
     * getter
     * 
     * @return variable aciertosTotales
     */
    public int getAciertosTotales() {
        return this.aciertosTotales;
    }

    /**
     * getter
     * 
     * @return variable fallosTotales
     */
    public int getFallosTotales() {
        return this.fallosTotales;
    }

    /**
     * getter
     * 
     * @return variable puntuacionTotal
     */
    public int getPuntuacionTotal() {
        return this.puntuacionTotal;
    }

    /**
     * setter
     * 
     * @param puntuacionPartida - entero que representa la puntuacion de la partida
     */
    public void setPuntuacionPartida(int puntuacionPartida) {
        this.puntuacionPartida = puntuacionPartida;
    }

    /**
     * setter
     * 
     * @param aciertosPartida - entero que representa los aciertos de la partida
     */
    public void setAciertosPartida(int aciertosPartida) {
        this.aciertosPartida = aciertosPartida;
    }

    /**
     * setter
     * 
     * @param fallosPartida - entero que representa los fallos de la partida
     */
    public void setFallosPartida(int fallosPartida) {
        this.fallosPartida = fallosPartida;
    }

    /**
     * setter
     * 
     * @param puntuacionTotal - entero que representa la puntuacion total de la
     *                        partida
     */
    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    /**
     * setter
     * 
     * @param aciertosTotales - entero que representa los aciertos de la partida
     */

    public void setAciertosTotales(int aciertosTotales) {
        this.aciertosTotales = aciertosTotales;
    }

    /**
     * setter
     * 
     * @param fallosTotales- entero que representa los fallos totales
     */
    public void setFallosTotales(int fallosTotales) {
        this.fallosTotales = fallosTotales;
    }

}

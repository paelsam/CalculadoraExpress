package Models;

/**
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
    public void obtenerOperacionAleatoria(int min, int max) {
        this.numeroUno = (int) (Math.random() * max) + min;
        this.numeroDos = (int) (Math.random() * max) + min;
        operador = operadores[(int) (Math.random() * operadores.length)];
    }

    /**
     * Asigna una determinada operacion matematica entre las variable
     * numeroUno y numeroDos
     * 
     * @return resultado Entero del resultado de la operacion matematica
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
     * Obtiene el valor de numeroUno
     * 
     * @return numeroUno
     */
    public int getNumeroUno() {
        return this.numeroUno;
    }

    /**
     *  Obtiene el valor de numeroDos
     * 
     * @return numeroDos
     */

    public int getNumeroDos() {
        return this.numeroDos;
    }

    /**
     * Obtiene el valor del resultado
     * 
     * @return resultado
     */
    public int getResultado() {
        return this.resultado;
    }

    /**
     * Obtiene el valor del operador
     * 
     * @return operador
     */
    public char getOperador() {
        return this.operador;
    }

    /**
     * Obtiene el valor de los aciertos en la partida
     * 
     * @return aciertosPartida
     */
    public int getAciertosPartida() {
        return this.aciertosPartida;
    }

    /**
     * Obtiene el valor de los fallos en la partida
     * 
     * @return fallosPartida
     */
    public int getFallosPartida() {
        return this.fallosPartida;
    }

    /**
     *  Obtiene el valor de la puntuación en la partida
     * 
     * @return puntuacionPartida
     */
    public int getPuntuacionPartida() {
        return this.puntuacionPartida;
    }

    /**
     *  Obtiene el valor de los aciertos totales
     * 
     * @return aciertosTotales
     */
    public int getAciertosTotales() {
        return this.aciertosTotales;
    }

    /**
     * Obtiene el valor de los fallos totales
     * 
     * @return fallosTotales
     */
    public int getFallosTotales() {
        return this.fallosTotales;
    }

    /**
     *  Obtiene el valor de la puntuación total
     * 
     *  @return puntuacionTotal
     */
    public int getPuntuacionTotal() {
        return this.puntuacionTotal;
    }

    /**
     * setter
     * 
     * @param puntuacionPartida entero que representa la puntuacion de la partida
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
     * Modifica el valor de los fallos en partida
     * 
     * @param fallosPartida - entero que representa los fallos de la partida
     * 
     * @return void
     */
    public void setFallosPartida(int fallosPartida) {
        this.fallosPartida = fallosPartida;
    }

    /**
     * Modifica el valor de la puntuación total
     * 
     * @param puntuacionTotal - entero que representa la puntuacion total de la
     *                        partida
     * @return void
     */
    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    /**
     * Modifica el valor de los aciertos totales
     * 
     * @param aciertosTotales entero que representa los aciertos de la partida
     * 
     * @return void
     */
    public void setAciertosTotales(int aciertosTotales) {
        this.aciertosTotales = aciertosTotales;
    }

    /**
     * Modifica el valor de los fallos totales
     * 
     * @param fallosTotales Entero que representa los aciertos de la partida
     * 
     * @return void
     */
    public void setFallosTotales(int fallosTotales) {
        this.fallosTotales = fallosTotales;
    }

}

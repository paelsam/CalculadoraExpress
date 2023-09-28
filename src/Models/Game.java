package Models;

public class Game {

    private static char[] operadores = { '+', '-', '*', '%' };
    private char operador;
    private int numeroUno, numeroDos, resultado;
    private int aciertosTotales, aciertosPartida;
    private int fallosTotales, fallosPartida;
    private int puntuacionTotal, puntuacionPartida;

    public Game() {
        aciertosPartida = 0; aciertosTotales = 0;
        fallosPartida = 0; fallosTotales = 0;
        puntuacionPartida = 0; puntuacionTotal = 0;
    }

    public void obtenerOperaciónAleatoria(int min, int max) {
        this.numeroUno = (int)(Math.random() * max) + min;
        this.numeroDos = (int)(Math.random() * max) + min;
        operador = operadores[(int)(Math.random() *operadores.length)];
    }

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

    public int getNumeroUno() {
        return this.numeroUno;
    }

    public int getNumeroDos() {
        return this.numeroDos;
    }

    public int getResultado() {
        return this.resultado;
    }

    public char getOperador() {
        return this.operador;
    }

    public int getAciertosPartida() {
        return this.aciertosPartida;
    }

    public int getFallosPartida() {
        return this.fallosPartida;
    }

    public int getPuntuacionPartida() {
        return this.puntuacionPartida;
    }

    public int getAciertosTotales() {
        return this.aciertosTotales;
    }

    public int getFallosTotales() {
        return this.fallosTotales;
    }

    public int getPuntuacionTotal() {
        return this.puntuacionTotal;
    }

    public void setPuntuacionPartida(int puntuacionPartida) {
        this.puntuacionPartida = puntuacionPartida;
    }

    public void setAciertosPartida(int aciertosPartida) {
        this.aciertosPartida = aciertosPartida;
    }

    public void setFallosPartida(int fallosPartida) {
        this.fallosPartida = fallosPartida;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    public void setAciertosTotales(int aciertosTotales) {
        this.aciertosTotales = aciertosTotales;
    }

    public void setFallosTotales(int fallosTotales) {
        this.fallosTotales = fallosTotales;
    }

}

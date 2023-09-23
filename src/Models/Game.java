package Models;

import java.util.Random;

public class Game {

    // ! Declaración de variables sujeta a cambios
    private static String[] operadores = { "+", "-", "x", "%" };
    private String operador;
    private int numeroUno, numeroDos, resultado;
    private int aciertos, fallos, puntuacion;

    public void obtenerOperaciónAleatoria(int min, int max) {
        Random random = new Random();
        this.numeroUno = random.nextInt(max - min + 1) + min;
        this.numeroDos = random.nextInt(max - min + 1) + min;
        int indicealeatorio = random.nextInt(4);

        this.operador = operadores[indicealeatorio];

    }

    public void obtenerResultado() {
        switch (operador) {
            case "+":
                this.resultado = numeroUno + numeroDos;
                break;
            case "-":
                this.resultado = numeroUno - numeroDos;
                break;
            case "x":
                this.resultado = numeroUno * numeroDos;
                break;
            case "%":
                this.resultado = numeroUno % numeroDos;
                break;

        }

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

    public int getAciertos() {
        return this.aciertos;
    }

    public int getFallos() {
        return this.fallos;
    }

    public String getOperador() {
        return this.operador;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;

    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

}

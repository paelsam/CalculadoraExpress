package Models;

public class Game 
{
    
    private static char[] operadores = {'+', '-', '*', '%'};
    private char operador; 
    private int numeroUno, numeroDos, resultado;
    private int aciertos, fallos, puntuacion; 

    public void obtenerOperaciónAleatoria(int min, int max)
    {
        numeroUno = (int)(Math.random() * max) + min;        
        numeroDos = (int)(Math.random() * max) + min;
        operador = operadores[(int)(Math.random() * operadores.length)];
    }

    public int obtenerResultado()
    {
        switch (operador) 
        {
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

    public int getAciertos() {
        return this.aciertos;
    }

    public int getFallos() {
        return this.fallos;
    }

    public char getOperador() {
        return this.operador;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}



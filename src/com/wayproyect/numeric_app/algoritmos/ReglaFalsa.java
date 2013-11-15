package com.wayproyect.numeric_app.algoritmos;

/**
 * Created with IntelliJ IDEA.
 * User: ADMIN
 * Date: 14/11/13
 * Time: 11:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReglaFalsa {
    private String function;

    /**
     * Este metodo crea un funcion a la cual se le aplicara el método de
     * regla falsa teniendo como parametro de entrada un double x, el cual
     * sirve para la construccion de la funcion dentro del metodo
     *
     * @param x
     * @return
     */
    private double funcion(double x) {
        try {
            return new EvalFunction().eval(function, x);
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    /**
     * Metodo de regla falsa
     *
     * @param a
     * @param b
     * @param error
     * @return
     */
    public double metodoDeReglaFalsa(String function, double a, double b, double error) {
        this.function = function;
        double fa, fb, fc;
        double c = 0;
        if ((funcion(a) * funcion(b) > 0)) {
            System.out.println("Error en el intervalo inicial, para este intervalo" +
                    " no existen raices. ");
        } else {
            fa = funcion(a);
            fb = funcion(b);
            c = b - ((fb * (b - a)) / (fb - fa));
            fc = funcion(c);
            do {
                if ((fa * fc) > 0) {
                    a = c;
                    fa = funcion(a);
                    fb = funcion(b);
                    c = b - ((fb * (b - a)) / (fb - fa));
                    fc = funcion(c);
                } else if ((fb * fc) > 0) {
                    b = c;
                    fa = funcion(a);
                    fb = funcion(b);
                    c = b - ((fb * (b - a)) / (fb - fa));
                    fc = funcion(c);

                }
            } while (Math.abs(fc) * 100 >= error && Math.abs(fc) != 0);

        }
        return c;
    }
}

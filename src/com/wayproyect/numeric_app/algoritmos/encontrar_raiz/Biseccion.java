package com.wayproyect.numeric_app.algoritmos.encontrar_raiz;

import com.wayproyect.numeric_app.algoritmos.EvalFunction;

import java.text.DecimalFormat;

/**
 * Created with wayproyect
 * User: ADMIN
 * Date: 15/11/13
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class Biseccion {
    private double er;
    private String fx;

    /**
     * Este metodo crea un funcion a la cual se le aplicara el método de
     * Biseccion teniendo como parametro de entrada un double x, el cual
     * sirve para la construccion de la funcion dentro del metodo
     *
     * @param x
     * @return
     */
    private double funcion(double x) {
        // return Math.sqrt( x*x +1 ) -4;
        try {
            return new EvalFunction().eval(fx, x);
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    /**
     * Metodo de Biseccion el cual le halla las raices de una funciones en un intervalo
     * ingresado como  parametro de entrada [a, b] y un el error con el cual
     * deseamos hallar nuestra funcion
     *
     * @param a
     * @param b
     * @param error
     * @return
     */
    public double metodoDeBiseccion(String fx, double a, double b, double error) {
        this.fx = fx;
        double c = 0.0;
        double fa;
        double fb;
        double fc;
        if ((funcion(a) * funcion(b)) > 0) {
            System.out.println("Error en el intervalo, en ese intervalo no existen raices");
        } else {
            c = (a + b) / (double) 2;
            do {

                fa = funcion(a);
                fb = funcion(b);
                fc = funcion(c);
                if ((fa * fc) > 0) {
                    a = c;
                    fa = funcion(a);
                    fb = funcion(b);
                    c = (a + b) / (double) 2;
                    fc = funcion(c);
                } else if ((fb * fc) > 0) {
                    b = c;
                    fa = funcion(a);
                    fb = funcion(b);
                    c = (a + b) / (double) 2;
                    fc = funcion(c);

                }


            } while (Math.abs(fc) >= error && Math.abs(fc) != 0);
            this.er = Math.abs(fc);
        }
        System.out.println("valor de la funcion: " + funcion(c));
        return c;
    }

    public String getER() {
        DecimalFormat df = new DecimalFormat("#.######%");
        return df.format(er);
    }
}

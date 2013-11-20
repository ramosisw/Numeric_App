package com.wayproyect.numeric_app.algoritmos.encontrar_raiz;

import com.wayproyect.numeric_app.algoritmos.EvalFunction;

import java.text.DecimalFormat;

/**
 * Created with Wayproyect
 * User: ADMIN
 * Date: 16/11/13
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class NewtonRaphson {
    private double er;
    private String fx;
    private String dfx;

    /**
     * @param x
     * @return
     */
    private double funcion(double x) {
        try {
            return new EvalFunction().eval(fx, x);
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    private double dfuncion(double x) {
        try {
            return new EvalFunction().eval(dfx, x);
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    public double metodoDeNewtonRaphson(String fx, String dfx, double x, double error) {
        this.fx = fx;
        this.dfx = dfx;
        double i = 1000;
        int k = 0;
        while (Math.abs(funcion(x)) > error && k < i) {
            x -= funcion(x) / dfuncion(x);
            k++;
        }

        if (k < i && !Double.isInfinite(x) && !Double.isNaN(x)) {
            this.er = Math.abs(funcion(x));
            return x;
        } else {
            System.out.println("No se puede :P");
            return Double.NaN;
        }
    }

    public String getER() {
        DecimalFormat df = new DecimalFormat("#.######%");
        return df.format(er);
    }
}

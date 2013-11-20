package com.wayproyect.numeric_app.algoritmos.encontrar_raiz;

import com.wayproyect.numeric_app.algoritmos.EvalFunction;

import java.text.DecimalFormat;

/**
 * Created with Wayproyect
 * User: ADMIN
 * Date: 19/11/13
 * Time: 11:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Secante {
    private String fx;
    private double er;

    private double funcion(double x) {
        // return Math.sqrt( x*x +1 ) -4;
        try {
            return new EvalFunction().eval(fx, x);
        } catch (Exception e) {
            return Double.NaN;
        }
    }

    public double metodoDeSecante(String fx, double xi, double xi_1, double er) {
        this.fx = fx;
        double fxi = funcion(xi);
        double fxi_1 = funcion(xi_1);
        double xi1 = xi - (fxi * (xi - xi_1)) / (fxi - fxi_1);
        int i = 1000;
        int k = 0;

        while (Math.abs(fxi) > er && k < i) {
            xi_1 = xi;
            xi = xi1;
            fxi = funcion(xi);
            fxi_1 = funcion(xi_1);
            xi1 = xi - (fxi * (xi - xi_1)) / (fxi - fxi_1);
            k++;
        }
        if (k < i && !Double.isInfinite(xi) && !Double.isNaN(xi)) {
            this.er = Math.abs(funcion(xi));
            return xi;
        } else {
            return Double.NaN;
        }
    }

    public String getER() {
        DecimalFormat df = new DecimalFormat("#.######%");
        return df.format(er);
    }
}

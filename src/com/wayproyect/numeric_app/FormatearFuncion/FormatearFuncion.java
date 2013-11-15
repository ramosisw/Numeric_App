package com.wayproyect.numeric_app.FormatearFuncion;
/**
 * Aqui se forma bien la ecuacion ya que puede ser introducida de diferentes maneras y los algorimos solo la aceptan de 1
 * Valida: x + 3 * 5 + ( x ^ 3 )
 * No Valida: x+3*5+(x^3)
 * Entonces formatea la funcion a uno aceptado
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author Julio C. Ramos
 */

public class FormatearFuncion {

    private String fx;

    /**
     * @param fx funcion en formato texto Ej. x + 3
     */
    public FormatearFuncion(String fx) {
        this.fx = fx;

    }

    /**
     * @param fx funcion de x
     * @return la funcion ya formateada
     */
    private String formatEcu(String fx) {
        fx = fx.replaceAll(" ", "").toLowerCase();
        String salida = "";
        Map<Character, Integer> key = new HashMap<Character, Integer>();
        key.put('+', 1);
        key.put('*', 1);
        key.put('/', 1);
        key.put('^', 1);
        key.put('-', 2);//valor diferente, ya que puede haber numeros negativos
        key.put('(', 0);
        key.put(')', 0);
        key.put('{', 0);
        key.put('}', 0);
        key.put('[', 0);
        key.put(']', 0);
        for (int i = 0; i < fx.length(); i++) {
            char caracter = fx.charAt(i);
            int x = key.get(caracter) == null ? 0 : key.get(caracter);
            if (x == 2) {//que sea un numero negativo
                if (i != 0) {//que no este al inicio de la cadena
                    x = key.get(fx.charAt(i - 1)) == null ? -1 : key.get(fx.charAt(i - 1));
                    if (x > 0) {
                        salida += fx.charAt(i);
                    } else {
                        salida += " " + fx.charAt(i) + " ";
                    }
                }
            } else if (key.get(caracter) != null) {
                salida += " " + fx.charAt(i) + " ";
            } else {
                salida += fx.charAt(i);
            }
        }

        return salida.replaceAll("  ", " ").trim();
    }

    /**
     * @return funcion formateada
     */
    public String getFx() {
        return this.formatEcu(fx);
    }
}

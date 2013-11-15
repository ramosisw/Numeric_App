package com.wayproyect.numeric_app.algoritmos;

import com.wayproyect.numeric_app.FormatearFuncion.FormatearFuncion;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Julio C. Ramos
 *         ramos.isw@gmail.com
 */
public class ShutingYard {

    String cadena[];
    Stack<String> salida;
    Stack<String> cola; // o Cola<String> cola; 	
    Map<String, Integer> op; //cala esa sally no se si sea la correcta.. luego 

    /**
     * @param cadena funcion algebraica ej. x + 2 * cos ( x )
     * @param x      el valor que tomara x en la funcion
     */
    public ShutingYard(String cadena, double x) {
        String replace = cadena.toLowerCase();
        replace = new FormatearFuncion(replace).getFx().replace("x", x + "");
        //System.out.println(replace);
        op = new HashMap<String, Integer>();
        //Agregar al Map el orden de procedencia de los signos
        op.put("+", 2); //despues 
        op.put("-", 2);
        op.put("*", 3); // y despues xD
        op.put("/", 3);
        op.put("^", 4); //finalmente 
        op.put("sin", 5);
        op.put("cos", 5);
        op.put("tan", 5);
        op.put("e", 5);
        op.put("log", 5);
        op.put("ln", 5);
        op.put("(", 0);
        op.put(")", 0);
        op.put("{", 0);
        op.put("}", 0);
        op.put("[", 0);
        op.put("]", 0);

        this.cadena = replace.split(" ");
        salida = new Stack<String>();
        cola = new Stack<String>(); // o new Cola();
    }

    /**
     * @return la ecuacion convertida con el algoritmo ShutingYard
     */
    public String runShuting() {
        try {
            for (String cade : cadena) {
                //System.out.println(cade +", "+op.get(cade));
                if (op.get(cade.toLowerCase()) == null) {
                    salida.push(cade);
                } else if (cola.empty() || cade.equals("(")) {
                    cola.push(cade);
                } else if (cola.empty() || cade.equals("{")) {
                    cola.push(cade);
                } else if (cola.empty() || cade.equals("[")) {
                    cola.push(cade);
                } else if (cade.equals(")")) {
                    String aux = cola.pop();
                    while (!aux.equals("(")) {
                        salida.push(aux);
                        aux = cola.pop();
                    }
                } else if (cade.equals("}")) {
                    String aux = cola.pop();
                    while (!aux.equals("{")) {
                        salida.push(aux);
                        aux = cola.pop();
                    }
                } else if (cade.equals("]")) {
                    String aux = cola.pop();
                    while (!aux.equals("[")) {
                        salida.push(aux);
                        aux = cola.pop();
                    }
                } else {
                    String aux = cola.pop();
                    int x, y;
                    x = op.get(cade);
                    y = op.get(aux);

                    while (!cola.empty() && x <= y && x != 4) {
                        salida.push(aux);
                        aux = cola.pop();
                        y = op.get(aux); //Listo, cambia el hashtCode, por get
                    }
                    if (cola.empty() && x <= y && x != 4) {
                        cola.push(cade);
                        salida.push(aux);
                    } else {
                        cola.push(aux);
                        cola.push(cade);
                    }
                }

            }//fin for

            while (!cola.empty()) {
                salida.push(cola.pop());
            }
            String aux = "";
            while (!salida.empty()) {
                aux += salida.pop() + " ";
            }
            String out[] = aux.trim().split(" ");
            aux = "";
            for (int i = out.length - 1; i >= 0; i--) {
                aux += out[i] + " ";
            }
            return aux.trim();
        } catch (Exception e) {
            System.err.println("Ocurrio un error al ejecutar el algoritmo ShutingYard : " + e);
            return null;
        }
//LISTO TERMINAMOS EL SHUTING YARD :D		
    }
}

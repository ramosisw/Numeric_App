package com.wayproyect.numeric_app.algoritmos;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Julio C. Ramos ramos.isw@gmail.com Con esta Clase se evalua la
 *         expresion convertida con el algorimo ShutingYard
 */
public class RPN {

    String cadena[];
    Stack<String> rpn;
    Map<String, Integer> op;

    /**
     * @param cadena cadena ya procesada
     */
    public RPN(String cadena) {
        op = new HashMap<String, Integer>();
        op.put("sin", 5);
        op.put("cos", 6);
        op.put("tan", 7);
        op.put("e", 8);
        op.put("ln", 9);
        op.put("log", 10);
        this.cadena = cadena.split(" ");
        rpn = new Stack<String>();
    }

    /**
     * @return el valor evaluado de la expresion matematica
     */
    public double evaluo() throws Exception {
        try {
            for (String caden : cadena) {//Esto hay que arreglar

                if (esNumero(caden)) {
                    rpn.push(caden);
                } else {
                    String y_temp;
                    double x = 0, y;
                    if (op.get(caden) == null) {
                        y_temp = rpn.pop();
                        String x_temp = rpn.pop();
                        y = Double.parseDouble(y_temp);
                        x = Double.parseDouble(x_temp);
                    } else {
                        y_temp = rpn.pop();
                        y = Double.parseDouble(y_temp);
                    }


                    double resultado = 0.0;//Agrega un valor al resultado
                    if (op.get(caden) == null) {
                        char operador = '+';
                        try {
                            operador = caden.charAt(0);
                        } catch (Exception e) {
                            System.out.println("Er: " + caden);
                        }
                        switch (operador) {
                            case '+':
                                resultado = x + y;
                                break;
                            case '-':
                                resultado = x - y;
                                break;

                            case '*':
                                resultado = x * y;
                                break;

                            case '/':
                                resultado = x / y;
                                break;
                            case '^':
                                resultado = Math.pow(x, y);
                                break;
                        }//fin switch
                    } else {
                        int idx = op.get(caden);
                        switch (idx) {
                            case 5:
                                resultado = Math.sin(Math.toRadians(y));
                                break;
                            case 6:
                                resultado = Math.cos(Math.toRadians(y));
                                break;
                            case 7:
                                resultado = Math.tan(Math.toRadians(y));
                                break;
                            case 8:
                                resultado = Math.exp(y);
                                break;
                            case 9:
                                resultado = Math.log(y);
                                break;
                            case 10:
                                resultado = Math.log10(y);
                                break;
                        }
                    }
                    rpn.push(resultado + "");
                }//fin else xD

            }//fin for
            return Double.parseDouble(rpn.pop());
        } catch (Exception e) {
            Exception c = new Exception("Error al Evaluar la funcion puede que este mal escrita");
            StackTraceElement[] stackTrace = c.getStackTrace();
            stackTrace[0] = new StackTraceElement(this.getClass().toString(), "Evaluo", "RPN.java", 38);
            c.setStackTrace(stackTrace);
            throw c;
        }


    }//fin metodo evaluo

    /**
     * @param cadena estring que puede ser o no un numero
     * @return si la cadena es un numero valido
     */
    private boolean esNumero(String cadena) {
        boolean r;
        try {
            Double.parseDouble(cadena);
            r = true;
        } catch (NumberFormatException e) {
            r = false;
        }
        return r;
    }
}

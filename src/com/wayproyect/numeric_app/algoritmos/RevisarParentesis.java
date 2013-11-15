package com.wayproyect.numeric_app.algoritmos;

import java.util.Stack;

/**
 * @author Ramos Con esta clase se revisaran los parentecis para saber si estan
 *         valanceados o no
 */
public class RevisarParentesis {

    String cadena[];
    Stack stack1;
    Stack stack2;
    Stack stack3;

    /**
     * @param cadena es la cadena que se revisaran los parentecis
     */
    public RevisarParentesis(String cadena) {
        this.cadena = cadena.split(" ");
        this.stack1 = new Stack();
        this.stack2 = new Stack();
        this.stack3 = new Stack();
    }

    /**
     * @return si los parentecis estan valanceados
     */
    public boolean revisar() {
        boolean regreso = true;

        for (String caden : cadena) {
            //Revisar parentecis ()
            if (caden.equals(")") && stack1.empty()) {
                regreso = false;
                break;
            } else if (caden.equals("}") && stack1.empty()) {
                regreso = false;
                break;
            } else if (caden.equals("]") && stack1.empty()) {
                regreso = false;
                break;
            } else if (caden.equals(")") && !stack1.empty()) {
                if (!stack1.pop().equals("(")) {
                    regreso = false;
                    break;
                }
            } else if (caden.equals("}") && !stack1.empty()) {
                if (!stack1.pop().equals("{")) {
                    regreso = false;
                    break;
                }
            } else if (caden.equals("]") && !stack1.empty()) {
                if (!stack1.pop().equals("[")) {
                    regreso = false;
                    break;
                }
            } else if (caden.equals("(")) {
                stack1.push(caden);
            } else if (caden.equals("{")) {
                stack1.push(caden);
            } else if (caden.equals("[")) {
                stack1.push(caden);
            }
        }//fin For

        if (regreso && stack1.empty() && stack2.empty() && stack3.empty()) {
            return true;
        } else {
            return false;
        }//fin IF ELSE

    }//Fin Metodo revisar();
}

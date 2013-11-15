package com.wayproyect.numeric_app.algoritmos;

import com.wayproyect.numeric_app.FormatearFuncion.FormatearFuncion;

/**
 * @author Julio C. Ramos
 *         ramos.isw@gmail.com con esta clase se evaluara una funcion
 */
public class EvalFunction {
    /**
     * @param function cadena de la funcion
     * @param x        valor de x en la funcion
     * @return el valor de la funcion ya evaluada
     */
    public double eval(String function, double x) throws Exception {
        String replace = function.toLowerCase();
        replace = new FormatearFuncion(replace).getFx().replace("x", x + "");
        //System.out.println(replace);
        RevisarParentesis Rp = new RevisarParentesis(replace);
        if (Rp.revisar()) {
            ShutingYard Sy = new ShutingYard(replace, x);
            String RSy = Sy.runShuting();
            //System.out.println(RSy);
            RPN rpn = new RPN(RSy);
            return rpn.evaluo();
        } else {
            Exception c = new Exception();
            StackTraceElement[] stackTrace = c.getStackTrace();
            stackTrace[0] = new StackTraceElement(this.getClass().toString(), "Revisar", "EvalFunction.java", 21);
            c.setStackTrace(stackTrace);
            throw c;
        }
    }
}

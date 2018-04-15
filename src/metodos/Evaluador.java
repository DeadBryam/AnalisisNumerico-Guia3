/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import org.nfunk.jep.JEP;

/**
 *
 * @author villa
 */
public class Evaluador {

    JEP jep = new JEP();
    private final String error = "((xr-x1)/xr)*100";
    final double tolenrancia = 0.05;

    public Evaluador() {
        jep.addStandardFunctions();
        jep.addStandardConstants();
    }

    public double Evaluar(double valor, String funcion) {
        jep.addVariable("x", valor);
        jep.parseExpression(funcion);
        return jep.getValue();
    }
    
    public double calcularError(double xb, double xa) {
        jep.addVariable("xr", xb);
        jep.addVariable("x1", xa);
        jep.parseExpression(error);
        return jep.getValue();
    }

}

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
 
    JEP j = new JEP();
    
    public double Evaluar(double valor,String funcion){
        j.addVariable("x", valor);
        j.parseExpression(funcion);
        return j.getValue();
    }
    
}

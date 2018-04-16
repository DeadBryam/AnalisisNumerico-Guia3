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

    public int gradoMayor(String funcion){
        String separador = " ";
        String filtrado;
        String[] f;
        int mayor = 0;

        System.out.println(funcion);
        f = funcion.split(" [+,-] ");
        filtrado = String.join(separador, f);
        f = filtrado.split(" \\d+");
        filtrado = String.join(separador, f);
        f = filtrado.split("x.");

        for (String fl : f) {
            if (!fl.isEmpty() && Integer.parseInt(fl.trim()) > mayor) {
                mayor = Integer.parseInt(fl.trim());
            }
        }
        return mayor;
    }
    
    public static double[] obtenerCoeficientes(int grado, String funcion) {
        String[] f = funcion.split(" [+,-] ");
        double[] coef = new double[grado];
        String filtro = String.join(" ", f);

        for (int i = grado; i > 0; i--) {
            for (String fl : f) {
                if (fl.contains("x^" + i)) {
                    if (funcion.matches(".*- \\d+x." + i + ".*")) {
                        coef[grado - i] = Double.parseDouble("-" + fl.replace("x^" + i, ""));
                    } else if (fl.replace("x^" + i, "").isEmpty()) {
                        coef[grado - i] = 1;
                    } else {
                        coef[grado - i] = Double.parseDouble(fl.replace("x^" + i, ""));
                    }
                } else if (fl.matches("\\d")) {
                    if (funcion.matches(".*- \\d+\\b.*")) {
                        coef[grado - 1] = Double.parseDouble("-" + fl);
                    } else {
                        coef[grado - 1] = Double.parseDouble(fl);
                    }
                }
            }
            if (String.valueOf(coef[grado - i]).isEmpty()) {
                coef[grado - i] = 0.0;
            }
        }
        return coef;
    }
}

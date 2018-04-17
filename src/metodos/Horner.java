/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author doratt
 */
public class Horner {
    final static double es = 0.05;
    double intervaloInferior, intervaloSuperior;
    Evaluador ev = new Evaluador();
    
    //<editor-fold desc="Métodos">
    public double[] divisiónSintetica(double [] coeficientes, double x1){
        double R,S;
        double[] resultados1 = new double[coeficientes.length];
        double[] resultados2 = new double[coeficientes.length];
        resultados2[0]=coeficientes[0];
        resultados1[0]=coeficientes[0]*x1;
        for(int i=1; i<coeficientes.length; i++){
        resultados1[i]=resultados2[i-1]*x1;
        resultados2[i]=coeficientes[i]+resultados1[i];
        }
        return resultados2;
    }
     public double[] divisiónSinteticaDos(double [] coeficientes, double x1){
        double R,S;
        double[] resultados1 = new double[coeficientes.length];
        double[] resultados2 = new double[coeficientes.length];
        resultados2[0]=coeficientes[0];
        resultados1[0]=coeficientes[0]*x1;
        for(int i=1; i<coeficientes.length-1; i++){
        resultados1[i]=resultados2[i-1]*x1;
        resultados2[i]=coeficientes[i]+resultados1[i];
        }
        return resultados2;
    }
     public DefaultTableModel horner(double x1, double[] coeficientes){
         DefaultTableModel dtm = new DefaultTableModel(new Object[]{"X0","X1","ERROR"},0);
         double xn, R, S, ea;
         do {  
             R = divisiónSintetica(coeficientes, x1)[coeficientes.length-1];
             S = divisiónSinteticaDos(divisiónSintetica(coeficientes, x1), x1)[coeficientes.length-2];
             xn=x1-R/S;
             ea=((xn-x1)/xn)*100;
             dtm.addRow(new Object[]{x1,xn,ea});
             x1=xn;
         } while (Math.abs(ea)>es);
         return dtm;
     }
     
     //</editor-fold>
}

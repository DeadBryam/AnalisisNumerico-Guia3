/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.Arrays;

/**
 *
 * @author doratt
 */
public class Bairstow {
    int grado;
    double r,s, r0, s0, ear, eas, x1, x2;
    final static double es = 0.05;
    
    public double[] calcularValores(int grado, double[] coeficientes, double r0, double s0){
        this.r0=r0;
        this.s0=s0;
        this.grado=grado;
        double[] bs = new double[coeficientes.length];
        bs[0]=coeficientes[0];
        bs[1]=coeficientes[1]+(r0*bs[0]);
        int f = 0;
        for(int i=2; i<=grado; i++){
            bs[i]=coeficientes[i]+(r0*bs[i-1])+(s0*bs[i-2]);
        }
      return bs;
    }
    
    public void bairstow(double b0, double b1, double c1, double c2, double c3){
        double dr,ds, d, dx, dy;
        do{
        d=(c2*c2)-(c1*c3);
        dx=(-b1*c2)-(-b0*c3);
        dy=(c2*(-b0))-(c1*(-b1));
        dr=dx/d;
        ds=dy/d;
        
        this.r=r0+dr;
        this.s=s0+ds;
        
        ear=Math.abs(dr/r)*100;
        eas=Math.abs(ds/s)*100;
        r0=r;
        s0=s;
        }while(ear>es && eas>es);
      
        x1=(r+Math.sqrt(Math.pow(r, 2.0)+(4*s)))/2;
        x2=(r-Math.sqrt(Math.pow(r, 2.0)+(4*s)))/2;
        System.out.println(x1);
        System.out.println(x2);
    }
}

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
    double r, s, r0, s0, ear, eas, x1, x2, x3, x4;
    double[] bs, cs, coefmenor;
    final static double tolerancia = 0.05;
    Horner hor = new Horner();

    public double[] calcularValores(double[] coeficientes) {
        double[] bb = new double[coeficientes.length];
        bb[0] = coeficientes[0];
        bb[1] = coeficientes[1] + (this.r0 * bb[0]);
        int f = 0;
        for (int i = 2; i <= grado; i++) {
            bb[i] = coeficientes[i] + (r0 * bb[i - 1]) + (s0 * bb[i - 2]);
        }
        //System.out.println(Arrays.toString(bb));
        return bb;
    }

    public void bairstow(double r0, double s0, double[] coeficientes, int grado) {
        this.r0 = r0;
        this.s0 = s0;
        this.grado = grado;
        double dr, ds, d, dx, dy, b0, b1, c1, c2, c3;
        do {
            this.bs = encontrarValores(coeficientes, grado);
            this.cs = encontrarValores(this.bs, grado);
            b0 = this.bs[bs.length - 1];
            b1 = this.bs[bs.length - 2];
            c1 = cs[bs.length-2];
            c2 = cs[bs.length-3];
            c3 = cs[bs.length-4];
            d = (c2 * c2) - (c1 * c3);
            dx = (-b1 * c2) - (-b0 * c3);
            dy = (c2 * (-b0)) - (c1 * (-b1));
            dr = dx / d;
            ds = dy / d;
            this.r = this.r0 + dr;
            this.s = this.s0 + ds;

            ear = Math.abs(dr / r) * 100;
            eas = Math.abs(ds / s) * 100;
            this.r0 = this.r;
            this.s0 = this.s;
        } while (ear > tolerancia || eas > tolerancia);
        if((Math.pow(r, 2.0) + (4 * s))<0){
            System.out.println(this.r/2 +" + "+ Math.sqrt(-(Math.pow(r, 2.0) + (4 * s)))/ 2 +"i");    
            System.out.println(this.r/2 +" - "+ Math.sqrt(-(Math.pow(r, 2.0) + (4 * s)))/ 2 +"i");    
        }else{
        x1 = (this.r + Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
        x2 = (this.r - Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
        }
        
        this.grado = this.grado - 2;
        coefmenor = divisiónSintetica(divisiónSintetica(coeficientes, x1), x2);

        if (this.grado == 2) {
            x3 = (r + Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
            System.out.println(x3);
            x4 = (r - Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
            System.out.println(x4);
        } else if (this.grado == 1) {
            x3 = (coefmenor[1]) / coefmenor[0];
            System.out.println(x3);
        }
    }

    public double[] encontrarValores(double[] coeficientes, int gradoFuncion) {
        double[] bn = new double[coeficientes.length];
        bn[gradoFuncion] = coeficientes[0];
        bn[gradoFuncion - 1] = coeficientes[1] + (r0 * bn[gradoFuncion]);
        for (int i = 2; i <= gradoFuncion; i++) {
            bn[gradoFuncion - i] = coeficientes[i] + (r0 * bn[gradoFuncion - (i-1)]) + (s0 * bn[gradoFuncion - (i - 2)]);
        }
        return invertirVector(bn);
    }

    public double[] divisiónSintetica(double[] coeficientes, double x1) {
        double R, S;
        double[] resultados1 = new double[coeficientes.length];
        double[] resultados2 = new double[coeficientes.length];
        resultados2[0] = coeficientes[0];
        resultados1[0] = coeficientes[0] * x1;
        for (int i = 1; i < coeficientes.length; i++) {
            resultados1[i] = resultados2[i - 1] * x1;
            resultados2[i] = coeficientes[i] + resultados1[i];
        }
        return resultados2;
    }

    public double[] invertirVector(double[] array) {
        double[] arrayInvertido = new double[array.length];
        int maximo = array.length;

        for (int i = 0; i < array.length; i++) {
            arrayInvertido[maximo - 1] = array[i];
            maximo--;
        }
        return arrayInvertido;
    }
}

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
    double[] bs,cs, coeficientes;
    final static double es = 0.05;
    Horner hor = new Horner();

    public double[] calcularValores(double[] coeficientes) {
        double[] bs = new double[coeficientes.length];
        bs[0] = coeficientes[0];
        bs[1] = coeficientes[1] + (this.r0 * bs[0]);
        int f = 0;
        for (int i = 2; i <= grado; i++) {
            bs[i] = coeficientes[i] + (r0 * bs[i - 1]) + (s0 * bs[i - 2]);
        }
        System.out.println(Arrays.toString(coeficientes));
        System.out.println(Arrays.toString(this.bs));
        System.out.println(Arrays.toString(bs));
        return bs;
    }

    public void bairstow(double r0, double s0, double[] coeficientes, int grado) {
        this.r0=r0;
        this.s0=s0;
        this.grado = grado;
        this.coeficientes = coeficientes;
        double dr, ds, d, dx, dy, b0, b1, c1, c2, c3;
        do {
            do {
                this.bs = (calcularValores(coeficientes));
                this.cs = calcularValores(this.bs);
                b0 = this.bs[bs.length - 1];
                b1 = this.bs[bs.length - 2];
                c1 = cs[cs.length - 2];
                c2 = cs[1];
                c3 = cs[0];
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
            } while (ear > es || eas > es);
            x1 = (this.r + Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
            x2 = (this.r - Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
            this.grado = this.grado - 2;
            System.out.println(x1);
            System.out.println(x2);
        } while (this.grado >= 3);
        if (this.grado == 2) {
            x3 = (r + Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
            System.out.println(x3);
            x4 = (r - Math.sqrt(Math.pow(r, 2.0) + (4 * s))) / 2;
            System.out.println(x4);
        } else if (this.grado == 1) {
            x3 = (-1*this.s) / this.r;
            System.out.println(x3);
        }
    }

}

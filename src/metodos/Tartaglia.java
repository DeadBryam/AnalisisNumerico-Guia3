/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author doratt
 */
public class Tartaglia {

    double G, H, D, a;

    public double calcularDiscriminante(double a, double b, double c) {
        this.a = a;
        this.H = ((3 * b) - Math.pow(a, 2)) / 9;
        this.G = ((-9 * a * b) + (27 * c) + (2 * Math.pow(a, 3))) / 54;
        this.D = (Math.pow(G, 2)) + (Math.pow(H, 3));
        return D;
    }

    public List<Object> calcularRaices(double discriminante) {
        if (discriminante < 0) {
            return calcularRaicesRealesDistintas();
        } else if (discriminante > 0) {
            return calcularRaizRealY2Complejas();
        } else {
            return calcular2RaicesRealesYUnaDistinta();
        }
    }

    public List<Object> calcular2RaicesRealesYUnaDistinta() {
        double x1, x2, x3, p, q;
        List<Object> raices = new ArrayList<>();
        p = 3 * H;
        q = 2 * G;
        x1 = ((-3 * q) / (2 * p)) - (this.a / 3);
        x2 = x1;
        x3 = ((-4 * Math.pow(p, 2)) / (9 * q)) - (this.a / 3);
        raices.add(x1);
        raices.add(x2);
        raices.add(x3);
        return raices;
    }

    public List<Object> calcularRaizRealY2Complejas() {
        double x1, x2, x3, P, Q;
        List<Object> raices = new ArrayList<>();
        P= Math.cbrt((-G + Math.sqrt(D)));
        Q= Math.cbrt((-G - Math.sqrt(D)));
        x1 = (P + Q) - (this.a / 3);
        x2 = ((P + Q) / -2) - (this.a / 3);
        x3 = ((P + Q) / -2) - (this.a / 3);
        raices.add(String.valueOf(x1));
        raices.add(x2+" + "+String.valueOf(P+Q));
        raices.add(x3+" - "+String.valueOf(P+Q));

        return raices;
    }

    public List<Object> calcularRaicesRealesDistintas() {
        double x1, x2, x3;
        List<Object> raices = new ArrayList<>();
        x1 = (2 * (Math.sqrt(-H)) * (Math.cos((calcularAngulo()) / 3))) - (this.a / 3);
        x2 = (2 * (Math.sqrt(-H)) * (Math.cos(((calcularAngulo()) / 3) + Math.toRadians(120)))) - this.a / 3;
        x3 = (2 * (Math.sqrt(-H)) * Math.cos(((calcularAngulo()) / 3) + Math.toRadians(240))) - this.a / 3;
        raices.add(x1);
        raices.add(x2);
        raices.add(x3);

        return raices;
    }

    public double calcularAngulo() {
        return Math.acos(-G / Math.sqrt(-(Math.pow(H, 3))));
    }
}

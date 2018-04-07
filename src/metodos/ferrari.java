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
public class ferrari {
    double U, V, W, P, Q, R, x1, x2, x3, x4;
    tartaglia tar = new tartaglia();
    
    public List<Double> ferrari(double a, double b, double c, double d){
        List<Double> raices = new ArrayList<>();
        P=(8*b-3*Math.pow(a, 2))/8;
        Q=(8*c-4*a*b+Math.pow(a, 3))/8;
        R=((256*d)-(64*a*c)+(16*Math.pow(a, 2)*b)-(3*Math.pow(a, 4)))/256;
        U = Double.parseDouble(String.valueOf(tar.calcularRaices(tar.calcularDiscriminante((-P/2.0), -R, (4*P*R-Math.pow(Q, 2))/8)).get(0)));
        V=Math.sqrt((2*U)-P);
        W=Math.sqrt(Math.pow(U, 2)-R);
        x1=((V+Math.sqrt(Math.pow(V, 2)-4*(U-W)))/2)-a/4.0;
        x2=((V-Math.sqrt(Math.pow(V, 2)-4*(U-W)))/2)-a/4.0;
        x3=((-V+Math.sqrt(Math.pow(V, 2)-4*(U-W)))/2)-a/4.0;
        x4=((-V-Math.sqrt(Math.pow(V, 2)-4*(U-W)))/2)-a/4.0;
        raices.add(x1);
        raices.add(x2);
        raices.add(x3);
        raices.add(x4);
        return raices;
    }
    
    
}

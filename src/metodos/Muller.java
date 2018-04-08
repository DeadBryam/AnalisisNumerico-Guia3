/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

/**
 *
 * @author villa
 */
public class Muller {
    private double x0,x1,x2;
    private String funcion;
    Evaluador ev = new Evaluador();

    //<editor-fold desc="Getters y Setters">
    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Evaluador getEv() {
        return ev;
    }

    public void setEv(Evaluador ev) {
        this.ev = ev;
    }
    //</editor-fold>
    
    public double[] calcularCoeficientes(){
        double h0,h1,s0,s1,a,b,c;
        h0=x1-x0;
        h1=x2-x1;
        s0=(ev.Evaluar(x1, funcion) - ev.Evaluar(x0, funcion))/h0;
        s1=(ev.Evaluar(x2, funcion) - ev.Evaluar(x1, funcion))/h1;
        a=(s1-s0)/(h1+h0);
        b=(a*h1)+s1;
        c=ev.Evaluar(x2, funcion);
        return new double[]{a,b,c};
    }
    
    public void calcularRaiz(){
        double x3,d,error;
        
        do {            
             if(calcularCoeficientes()[1]<0){
        d=calcularCoeficientes()[1]-Math.sqrt((calcularCoeficientes()[1]*calcularCoeficientes()[1])-4*calcularCoeficientes()[0]*calcularCoeficientes()[2]);
        }else{
            d=calcularCoeficientes()[1]+Math.sqrt((calcularCoeficientes()[1]*calcularCoeficientes()[1])-4*calcularCoeficientes()[0]*calcularCoeficientes()[2]);
        }
        x3 = x2 - ((2*calcularCoeficientes()[2])/d);
        error = ev.calcularError(x3, x2);
        System.out.println(x3 +" --- "+error);
        x0 = x1;
        x1 = x2;
        x2 = x3;
        } while (Math.abs(error)>ev.tolenrancia);
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extras;

/**
 *
 * @author villa
 */
public class Complex {
    double entera,imaginaria;

    public Complex(double entera, double imaginaria) {
        this.entera = entera;
        this.imaginaria = imaginaria;
    }

    public double getEntera() {
        return entera;
    }

    public void setEntera(double entera) {
        this.entera = entera;
    }

    public double getImaginaria() {
        return imaginaria;
    }

    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }
    
    public Complex add(Complex nuevo){
        return new Complex(this.entera+nuevo.getEntera(), this.imaginaria+nuevo.imaginaria);
    }
    
    public Complex mult(Complex nuevo){
        return new Complex((this.entera*nuevo.entera)-(this.imaginaria*nuevo.imaginaria), (this.entera*nuevo.imaginaria)+(nuevo.entera*this.imaginaria));
    }
    
    public Complex substract(Complex nuevo){
        return new Complex(this.entera-nuevo.getEntera(), this.imaginaria-nuevo.imaginaria);
    }
    
    @Override
    public String toString(){
        if(this.imaginaria>0){
            return (String.valueOf(this.entera + " + " + this.imaginaria+"i"));
        }
            return (String.valueOf(this.entera + " " + this.imaginaria+"i"));
    }
}

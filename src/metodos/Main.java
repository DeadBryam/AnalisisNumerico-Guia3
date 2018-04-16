/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;



/**
 *
 * @author doratt
 */
public class Main {
    
    public static void main(String[] args) {
        Bairstow bair = new Bairstow();
        double[] bs, cs;
        
        bs= (bair.calcularValores(3, new double[]{1,5,7,3}, -2, -2));
        cs = bair.calcularValores(3, bs, -2, -2);
        System.out.println(Arrays.toString(bs));
        System.out.println(Arrays.toString(cs));
        bair.bairstow(bs[bs.length-1], bs[bs.length-2], cs[cs.length-2], cs[1], cs[0]);
    }
    
    
}

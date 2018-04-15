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
public class Main {
    
    public static void main(String[] args) {
      
        Horner hor = new  Horner();
        
        System.out.println(Arrays.toString(hor.horner(-1.2, new double[]{1,1,-2,-6,-4})));
        
    }
    
    
}

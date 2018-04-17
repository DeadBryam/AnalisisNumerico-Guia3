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
        Bairstow bair = new Bairstow();
        bair.bairstow(-1, -1, new double[]{1, -1.1, 2.3, 0.5,3.3}, 4);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticorp3cm2;

import rp.MinimaDistancia;
import rp.ValoresEstaticos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class GeneticoRP3CM2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ValoresEstaticos.calcularConjuntoEntrenamiento();
        Individuo.md = new MinimaDistancia();
        
        Individuo i1= new Individuo();
        System.out.println(i1.getFitness());
        Individuo i2= new Individuo();
        System.out.println(i2.getFitness());
        Individuo i3= new Individuo(i2);
         System.out.println(i3.getFitness());
        
       
        
       
       
    }
    
}

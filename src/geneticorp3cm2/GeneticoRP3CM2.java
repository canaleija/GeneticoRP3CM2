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
        MinimaDistancia md = new MinimaDistancia();
        md.clasificar(new int[]{1,1,1,1,1,1,1,1,1,1});
        System.out.println(md.getPorcentajeClasificacion());
        for (int x=0;x<1000;x++){
         int f[] = ValoresEstaticos.generarFactoresAleatorios(10);   
         md.clasificar(f);
         System.out.println(md.getPorcentajeClasificacion());
        }
        
       
        
       
       
    }
    
}

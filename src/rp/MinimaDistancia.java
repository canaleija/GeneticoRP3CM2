/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import java.util.ArrayList;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MinimaDistancia {
   
    private double porcentajeClasificacion;
   
    
    
    public MinimaDistancia(){
       this.porcentajeClasificacion = 0;
    }
       
    public void clasificar(int[] factorDiscriminante){
        // recorremos los patrones a clasificar
        ArrayList<Patron> conjuntoAClasificar = ValoresEstaticos.conjuntoAClasificar;
        int ind;
        double dis;
        for (Patron p: conjuntoAClasificar){
          // medir las distancias y definir cual es la mas corta
          ind = 0;
          dis = calculaDistancia(p,ValoresEstaticos.medias.get(0),factorDiscriminante);
          for (int x=1;x<ValoresEstaticos.medias.size();x++){
             double aux = calculaDistancia(p, ValoresEstaticos.medias.get(x), factorDiscriminante);
             if(aux<dis){
               dis = aux;
               ind = x;
             }
          }
          // se genera la clasificacion 
          p.setClaseResultado(ValoresEstaticos.medias.get(ind).getClase());
        }
        System.out.println();
        
    }

    private double calculaDistancia(Patron p1, Patron p2, int[] factorDiscriminante) {
        // implementar distancia euclidiana
        double acumulado = 0;
        for (int x = 0; x < p1.getVector().length;x++){
            // si es igual a 1 acumulamos
            if (factorDiscriminante[x]==1){
            acumulado+=Math.pow(p2.getVector()[x]-p1.getVector()[x],2);
           }
        }
        return Math.sqrt(acumulado);
    }

   
    
}

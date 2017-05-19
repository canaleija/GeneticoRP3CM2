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
public class ValoresEstaticos {
    
    public static ArrayList<Patron> conjuntoEntrenamiento;
    public static ArrayList<Patron> conjuntoAClasificar;
    public static ArrayList<Patron> medias;
    public static ArrayList<String> clases;
    
    public static void calcularConjuntoEntrenamiento(){
       // leemos los datos 
       
       
       calcularClases();
       calcularMedias();
    }
    public static void calcularClases(){
        clases = new ArrayList<>();
        clases.add(conjuntoEntrenamiento.get(0).getClase());
        // recorremos el conjunto de entrenamiento
        for (int x=1;x<conjuntoEntrenamiento.size();x++){
           // verficar la existencia de la clase 
           String nom = conjuntoEntrenamiento.get(x).getClase();
           if (!clases.contains(nom)){
            clases.add(nom);
           }
        }
      
    
    }
    public static void calcularMedias(){
        int []contadores = new int[clases.size()];
        
        medias = new ArrayList<>();
        for (int x=0; x < clases.size();x++){
          medias.add(new Patron(new double[conjuntoEntrenamiento.get(0).getVector().length],clases.get(x)));
        }
        // recorremos el conjunto de entrenamiento
        for (Patron patron: conjuntoEntrenamiento){
             String clase = patron.getClase();
             int pos = clases.indexOf(clase);
             acumular(pos,patron);
             contadores[pos]++;
        }
         // TODO: dividir PARA CALCULAR LOS PROMEDIOS
        
        
    }
    private static void acumular(int pos, Patron patron) {
        // acumulamos el patron al media en  pos
        for (int x=0; x<medias.get(pos).getVector().length;x++){
          medias.get(pos).getVector()[x]+=patron.getVector()[x];
        }
    }
    
    
    
    
}

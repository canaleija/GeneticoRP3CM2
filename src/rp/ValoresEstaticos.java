/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

import java.util.ArrayList;
import java.util.Random;

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
       conjuntoEntrenamiento = generarAleatorio(1000, 10, 10);
//       conjuntoEntrenamiento.add(new Patron(new double[]{3.4,5,7.8}, "Conejo"));
//       conjuntoEntrenamiento.add(new Patron(new double[]{2.3,4.5,9}, "Conejo"));
//       conjuntoEntrenamiento.add(new Patron(new double[]{21,22,23}, "Conejo"));
//       conjuntoEntrenamiento.add(new Patron(new double[]{2.7,3.1,3.5}, "Conejo"));
//       conjuntoEntrenamiento.add(new Patron(new double[]{9,9.6,3.5}, "Conejo"));
//      
//       conjuntoEntrenamiento.add(new Patron(new double[]{10.2,22.4,15.6}, "Perro"));
//       conjuntoEntrenamiento.add(new Patron(new double[]{17.6,20.4,21.3}, "Perro"));
//       conjuntoEntrenamiento.add(new Patron(new double[]{14.7,16.7,11.5}, "Perro"));
//       //conjuntoEntrenamiento.add(new Patron(new double[]{16.5,14.7,11.8}, "Perro"));
//       conjuntoEntrenamiento.add(new Patron(new double[]{2.7,3.1,3.5}, "Perro"));

       
       conjuntoAClasificar = (ArrayList<Patron>) conjuntoEntrenamiento.clone();
       calcularClases();
       calcularMedias();
       System.out.println();
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
        // recorremos las medias
        for (int x=0; x < medias.size();x++){
           for (int y=0; y < medias.get(x).getVector().length;y++){
                medias.get(x).getVector()[y]/=contadores[x];
           }
        }
       
        
    }
    private static void acumular(int pos, Patron patron) {
        // acumulamos el patron al media en  pos
        for (int x=0; x<medias.get(pos).getVector().length;x++){
          medias.get(pos).getVector()[x]+=patron.getVector()[x];
        }
    }
    
    private static ArrayList<Patron> generarAleatorio(int num, int rango,int numC){
      ArrayList<Patron> aux = new ArrayList<>();
      Random ran = new Random();
        for (int x=0; x< num;x++){
          Patron p;
          double arreglo[] = new double[numC];
          for (int y=0; y < numC;y++){
           arreglo[y] = ran.nextInt(rango);
          }
          p = new Patron(arreglo, ""+ran.nextInt(10));
          aux.add(p);
        }
        return aux;
    }
    
    public static int[] generarFactoresAleatorios(int numC){
     String jaja = "";
     int aux[] = new int[numC];
     Random ran = new Random();
     for (int x=0; x < numC;x++){
         int i = ran.nextInt(2);
         jaja+=""+i;
         aux[x] = i;
                             
     }
     System.out.print(jaja+" -");
     return aux;
    }
    
    
    
    
}

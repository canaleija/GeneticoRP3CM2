/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticorp3cm2;

import rp.MinimaDistancia;
import rp.Tokenizador;
import rp.ValoresEstaticos;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Individuo {
    public static MinimaDistancia md;
    // atributos instancia 
    private int[] genotipo;
    private double fitness;
    
    public Individuo() {
        this.genotipo =  ValoresEstaticos.generarFactoresAleatorios(Tokenizador.numCaracteristicas);
       // calcular fitness
       calcularFitness();
      
    }
    
    public Individuo(int[] genotipo){
      this.genotipo = genotipo.clone();
      calcularFitness();
    
    }
        
    public Individuo(Individuo ind) {
        this.genotipo =  ind.getGenotipo().clone();
        this.fitness = ind.getFitness();
       // calcular fitness
      
    }

    /**
     * @return the genotipo
     */
    public int[] getGenotipo() {
        return genotipo;
    }

    /**
     * @return the fitness
     */
    public double getFitness() {
        return fitness;
    }

    /**
     * @param fitness the fitness to set
     */
    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public void calcularFitness() {
        if (md!=null){
          md.clasificar(genotipo);
          this.fitness = md.getPorcentajeClasificacion();
        
        }
        
    }
    
    
   
    
    
}

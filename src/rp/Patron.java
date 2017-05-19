/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Patron {
    public static int[] fd;
    private double[] vector;
    private String clase;
    private String claseResultado;
    
    public Patron (double[] vector,String clase){
      this.vector = vector.clone();
      this.clase = clase;
      this.claseResultado = null;
    }
    
    
    public double calculaDistancia(Patron patron){
        // la distancia se calcula en base al numero 
        // caracteristicas
        
    return 0;
    }
    public boolean isClasificadoCorrectamente(){
    // comparar los sting
    return this.getClase().equals(getClaseResultado());
    
    }

    /**
     * @return the vector
     */
    public double[] getVector() {
        return vector;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @return the claseResultado
     */
    public String getClaseResultado() {
        return claseResultado;
    }

    /**
     * @param claseResultado the claseResultado to set
     */
    public void setClaseResultado(String claseResultado) {
        this.claseResultado = claseResultado;
    }
    
}

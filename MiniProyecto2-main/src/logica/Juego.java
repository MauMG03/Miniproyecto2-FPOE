/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author jose9
 */
public class Juego {
    
    private ArrayList <Baldosa> baldosas;
    private ArrayList <Integer> posiciones; 
    private int numVidas;
    private int puntaje;
    private boolean accion;
    
    public Juego()
    {
        numVidas = 3;
        puntaje = 0;
        accion = false;
        baldosas = new ArrayList<Baldosa>();
        posiciones = new ArrayList<Integer>();
        for(int i = 0; i < 3;i++){
            baldosas.add(new Baldosa());
        }
        for(int i = 1; i <= 8;i++){
            posiciones.add(i);
        }
        iniciarJuego();
    }
    
    public void setAccion(boolean accion){
        this.accion = accion;
    }
    
    public ArrayList <Baldosa> getBaldosas(){
        return baldosas;
    }
    
    public int getPuntaje(){
        return puntaje;
    }
    
    public int getNumVidas(){
        return numVidas;
    }
    
    public boolean getAccion(){
        return accion;
    }
    
    public void iniciarJuego(){
        for(Baldosa baldosa : baldosas){
            baldosa.setID();
        }
        asignarPosiciones();
    }
    
    public void asignarPosiciones(){
        for(Baldosa baldosa : baldosas){
            int random = (int)(Math.random()* posiciones.size());
            baldosa.setPosicion(posiciones.get(random));
            posiciones.remove(random);
        }
    }
    
    public void desasignarPosiciones(){
        for(Baldosa baldosa : baldosas){
            posiciones.add(baldosa.getPosicion());
            baldosa.setPosicion(0);
        }
    }
    
    public void cambiarIDs(){
        for(Baldosa baldosa : baldosas){
            baldosa.setID();
        }
    }
    
    public void cambiarBaldosa(){
        int random = (int)(Math.random() * baldosas.size());
        
        baldosas.get(random).setID();
    }
    
    public void acierto(){
        desasignarPosiciones();
        if(baldosas.size() < 8){
            baldosas.add(new Baldosa());
        }
        asignarPosiciones();
        cambiarIDs();
        puntaje += 100;
        accion = false;
    }
    
    public void fallo(){
        numVidas -= 1;
        desasignarPosiciones();
        if(baldosas.size() > 3){
            baldosas.remove(baldosas.size() - 1);
        }
        asignarPosiciones();
        cambiarIDs();
    }
       
    public void compararBaldosas(){
        for (int i = 0; i < baldosas.size();i++) {
            for (int j = 0; j < baldosas.size();j++) {
                if(i == j){
                    //no evalua
                }
                else if(baldosas.get(i).getID() == baldosas.get(j).getID()){
                    if(accion){
                        acierto();
                        return;
                    }
                    else{
                        fallo();
                        return;
                    }   
                }
                if(i == baldosas.size()-1 && j == baldosas.size()-1){
                    if(accion){
                        fallo();
                        return;
                    }
                }
            }
        }
    }
}
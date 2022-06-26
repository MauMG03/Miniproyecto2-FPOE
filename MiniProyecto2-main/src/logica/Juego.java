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
    
    public Juego()
    {
        numVidas = 3;
        puntaje = 0;
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
    
    public ArrayList <Baldosa> getBaldosas(){
        return baldosas;
    }
    
    public void iniciarJuego(){
        for(Baldosa baldosa : baldosas){
            baldosa.setID();
        }
        asignarPosiciones();
    }
    
    public void asignarPosiciones(){
        int i = baldosas.size();
        for(Baldosa baldosa : baldosas){
            int random = (int)(Math.random() * i);
            baldosa.setPosicion(posiciones.get(random));
            posiciones.remove(random);
            i--;
        }
    }
    
    public void cambiarBaldosa(){
        int random = (int)(Math.random() * baldosas.size());
        
        baldosas.get(random - 1).setID();
    }
       
    public void compararBaldosas(){
        for (Baldosa baldosa1 : baldosas) {
            for (Baldosa baldosa2 : baldosas) {
                if(baldosa1.getID() == baldosa2.getID()){
                    numVidas -= 1;
                    if(baldosas.size() > 3){
                        baldosas.remove(baldosas.size() - 1);
                    }
                }
            }
        }
    }
}

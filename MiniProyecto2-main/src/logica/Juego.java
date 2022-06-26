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
    
    Juego()
    {
        numVidas = 0;
        for(int i = 0; i <= 3;i++){
            baldosas.add(new Baldosa());
        }
        for(int i = 1; i <= 8;i++){
            posiciones.add(i);
        }
    }
    
    public void iniciarJuego(){
        for(Baldosa baldosa : baldosas){
            baldosa.setID();
        }
        asignarPosiciones();
    }
    
    public void asignarPosiciones(){
        for(Baldosa baldosa : baldosas){
            int random = (int)(Math.random() * baldosas.size());
            baldosa.setPosicion(posiciones.get(random - 1));
            posiciones.remove(random - 1);
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

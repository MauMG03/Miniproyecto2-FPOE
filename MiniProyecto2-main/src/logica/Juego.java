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
    private ArrayList <Integer> idBaldosas;
    private int numVidas;
    private int puntaje;
    private int aciertos;
    private int errores;
    private int tiempo;
    private int baldosaCambiada;
    private boolean accion;
    private boolean hayAcierto;
    private boolean hayFallo;
    private boolean finDelJuego;
    private boolean pausa;
    
    public Juego()
    {
        numVidas = 3;
        puntaje = 0;
        aciertos = 0;
        errores = 0;
        tiempo = 3000;
        baldosaCambiada = -1;
        accion = false;
        hayAcierto = false;
        hayFallo = false;
        finDelJuego = false;
        pausa = false;
        baldosas = new ArrayList<Baldosa>();
        posiciones = new ArrayList<Integer>();
        idBaldosas = new ArrayList<Integer>();
        for(int i = 0; i < 3;i++){
            baldosas.add(new Baldosa());
        }
        for(int i = 1; i <= 8;i++){
            posiciones.add(i);
        }
        for(int i = 1; i <20;i++){
            idBaldosas.add(i);
        }
        iniciarJuego();
    }
    
    public void setAccion(boolean accion){
        this.accion = accion;
    }
    
    public void setHayAcierto(boolean hayAcierto){
        this.hayAcierto = hayAcierto;
    }
    
    public void setHayFallo(boolean hayFallo){
        this.hayFallo = hayFallo;
    }
    
    public void setPausa(boolean pausa){
        this.pausa = pausa;
    }
    
    public ArrayList <Baldosa> getBaldosas(){
        return baldosas;
    }
    
    public int getNumVidas(){
        return numVidas;
    }
    
    public int getPuntaje(){
        return puntaje;
    }
    
    public int getAciertos(){
        return aciertos;
    }
    
    public int getErrores(){
        return errores;
    }
    
    public int getTiempo(){
        return tiempo;
    }
    
    public int getBaldosaCambiada(){
        return baldosaCambiada;
    }
    
    public boolean getAccion(){
        return accion;
    }
    
    public boolean getHayAcierto(){
        return hayAcierto;
    }
    
    public boolean getHayFallo(){
        return hayFallo;
    }
    
    public boolean getFinDelJuego(){
        return finDelJuego;
    }
    
    public boolean getPausa(){
        return pausa;
    }
    
    public void iniciarJuego(){
        cambiarIDs();
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
    
    public void cambiarRonda(){
        desasignarPosiciones();
        if(hayAcierto){
            if(baldosas.size() < 8){
                baldosas.add(new Baldosa());
            }
        }
        else if(hayFallo){
            if(baldosas.size() > 3){
                baldosas.remove(baldosas.size() - 1);
            }
        }
        asignarPosiciones();
        cambiarIDs();
    }
    
    public void cambiarIDs(){
        for(Baldosa baldosa : baldosas){
            int random = (int)(Math.random() * idBaldosas.size());
            baldosa.setIDFijo(idBaldosas.get(random));
            idBaldosas.remove(idBaldosas.get(random));
        }
        for(Baldosa baldosa : baldosas){
            idBaldosas.add(baldosa.getID());
        }
        hayAcierto = false;
        hayFallo = false;
    }
    
    public void cambiarBaldosa(){
        int random = (int)(Math.random() * baldosas.size());
        
        baldosas.get(random).setID();
        baldosaCambiada = baldosas.get(random).getPosicion();
    }
    
    public void acierto(){
        puntaje += 100;
        accion = false;
        aciertos += 1;
        tiempo = tiempo - (tiempo*5/100);
        baldosaCambiada = -1;
        hayAcierto = true;
        pausa = true;
    }
    
    public void fallo(){
        numVidas -= 1;
        errores += 1;
        if(numVidas == 0){
            finDelJuego = true;
        }else{
            hayFallo = true;
        }
        pausa = true;
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 * @author Mauricio Munoz Gutierrez
 * @author Jose Luis Hincapie Bucheli
 * 
 * Profesor Luis Johany Romo Portilla
 * 
 * Fundamentos de Programacion Orientada por Eventos
 * Grupo 1
 * 
 * Miniproyecto 2
 */

public class Baldosa {
    private int id;
    private int posicion;
    
    Baldosa(){
        id = 0;
        posicion = (int)(Math.random() * 8);
    }
    
    public void setID(){
        id = (int)(Math.random()*20);
    }
    
    public void setIDFijo(int id){
        this.id = id;
    }
    
    public void setPosicion(int posicion){
        this.posicion = posicion;
    }
    
    public int getID(){
        return id;
    }
    
    public int getPosicion(){
        return posicion;
    }
}

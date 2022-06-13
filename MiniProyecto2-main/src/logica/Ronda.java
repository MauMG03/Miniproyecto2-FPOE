/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author jose9
 */
public class Ronda {
    private int puntaje;
    private int fallos;
    private int aciertos;
    private int turno;
    
    Ronda()
    {
        turno++;
    }
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getFallos() {
        return fallos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public int getTurno() {
        return turno;
    }
    
    
}

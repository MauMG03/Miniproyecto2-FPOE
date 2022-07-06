package modelo;
import interfaz.VentanaPrincipal;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

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

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}

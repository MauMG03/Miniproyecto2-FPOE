/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author jose9
 */
public class VentanaPrincipal extends JFrame{
    private JLabel lblTitle;
    private JLabel lblHTP;
    private JLabel lblWP;
    private JLabel lblPlay;
    private JLabel lblInfo;
    private JLabel lblExit;
    private JButton btnNext;
    private JButton btnBack;
    private int seccion;
    
    private Container contenedorInicial;
    public VentanaPrincipal()
    {
        iniciarComponentes();   
        setSize(700,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Pair Colors");
        setResizable(false);
        SwingUtilities.updateComponentTreeUI(contenedorInicial);
    }
    
    private void iniciarComponentes()
    {
        seccion = 0;
        
        lblTitle = new JLabel("Pair Colors", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 50));
        lblTitle.setBounds(180,50,320,70);
        
        lblHTP = new JLabel("Como Jugar");
        lblHTP.setFont(new Font("Serif", Font.PLAIN, 40));
        lblHTP.setBounds(100,300,195,70);
        
        lblWP = new JLabel("Por que Jugar");
        lblWP.setFont(new Font("Serif", Font.PLAIN, 40));
        lblWP.setBounds(350,300,220,70);
        
        lblPlay = new JLabel("Jugar");
        lblPlay.setFont(new Font("Serif", Font.PLAIN, 40));
        lblPlay.setBounds(280,380,90,70);
        
        lblInfo = new JLabel("");
        lblInfo.setFont(new Font("Serif", Font.PLAIN, 20));
        lblInfo.setBounds(90,300,500,300);
        
        lblExit = new JLabel("X");
        lblExit.setBounds(600,20,40,40);
        lblExit.setFont(new Font("Serif", Font.PLAIN, 35));
        lblExit.setVisible(false);
        lblExit.setEnabled(false);
        
        btnNext = new JButton("Siguiente");
        btnNext.setBounds(500, 550, 100, 30);
        btnNext.setVisible(false);
        
        btnBack = new JButton("Atras");
        btnBack.setBounds(50,550,100,30);
        btnBack.setVisible(false);
        
        contenedorInicial = getContentPane();
        contenedorInicial.setLayout(null);
        contenedorInicial.add(lblTitle);
        contenedorInicial.add(lblHTP);
        contenedorInicial.add(lblWP);
        contenedorInicial.add(lblPlay);
        contenedorInicial.add(lblExit);
        contenedorInicial.add(lblInfo);
        contenedorInicial.add(btnNext);
        contenedorInicial.add(btnBack);
        
        lblHTP.addMouseListener(new ManejadorEventosMouse());
        lblWP.addMouseListener(new ManejadorEventosMouse());
        lblExit.addMouseListener(new ManejadorEventosMouse());
        btnNext.addMouseListener(new ManejadorEventosMouse());
        btnBack.addMouseListener(new ManejadorEventosMouse());
    }
    
    public void seccionTutorial(){
        if(seccion == 1){
            lblTitle.setText("Como Jugar");
            
            lblHTP.setEnabled(false);
            lblWP.setEnabled(false);
            lblPlay.setEnabled(false);
            lblHTP.setVisible(false);
            lblWP.setVisible(false);
            lblPlay.setVisible(false);
            
            lblExit.setEnabled(true);
            lblExit.setVisible(true);
            
            btnBack.setVisible(false);
            btnNext.setVisible(true);

            lblInfo.setText("<html>En Pair Colors aparece en pantalla " 
                    + "una serie de baldosas.Las baldosas van cambiando de "
                    + "1 en 1 mostrando distintos diseños.<p>Podras saber "
                    + "que baldosa cambia en cada momento gracias a un "
                    + "reborde de color azul.<html>");
        }
        if(seccion == 2){
            btnBack.setVisible(true);
            
            lblInfo.setText("<html>En el momento en el que veas en pantalla "
                    + "dos baldosas identicas, debes presionar mediante el "
                    + "pulsador blanco que aparece en la zona inferior derecha."
                    + "<html>"
            );
        }
        if(seccion == 3){
            btnNext.setVisible(true);
            lblInfo.setText("<html>Hay dos formas de presionar el pulsador:"
                    + "<p>- Pulsar directamente el boton blanco en pantalla"
                    + "<p>- Pulsar la barra espacio del teclado");
        }
        if(seccion == 4){
            btnNext.setVisible(false);
            lblInfo.setText("<html>¡OJO! Si no pulsas a tiempo perderas vidas "
                    + ". A medida que el juego avanza el ritmo al que cambian "
                    + "las baldosas es mayor y tu tiempo de reaccion es menor "
                    + "<p>¡Buena Suerte!");
        }
    }
    
    public void pQJugar(){
        lblTitle.setText("¿Por qué Jugar?");
        
        lblHTP.setEnabled(false);
        lblWP.setEnabled(false);
        lblPlay.setEnabled(false);
        lblHTP.setVisible(false);
        lblWP.setVisible(false);
        lblPlay.setVisible(false);
            
        lblExit.setEnabled(true);
        lblExit.setVisible(true);
        
        lblInfo.setText("<html>Este juego pone en acción la habilidad para "
                + "comparar patrones visuales, entrenando además la atención "
                + "a los detalles y la velocidad perceptiva. Estas capacidades "
                + "son relevantes cuando hay que decidir entre estímulos "
                + "semejantes y hay que hacerlo de forma rápido, por ejemplo "
                + "al reconocer fotografías, caras, objetos cotidianos o "
                + "palabras escritas.<html>");
    }
    
    public void menuPrincipal(){
        lblTitle.setText("Pair Colors");
        
        lblHTP.setEnabled(true);
        lblWP.setEnabled(true);
        lblPlay.setEnabled(true);
        lblHTP.setVisible(true);
        lblWP.setVisible(true);
        lblPlay.setVisible(true);
        
        lblExit.setEnabled(false);
        lblExit.setVisible(false);
            
        btnBack.setVisible(false);
        btnNext.setVisible(false);
        
        lblInfo.setText("");
    }
    
    class ManejadorEventosMouse implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == lblHTP){
                seccion = 1;
                seccionTutorial();
            }
            
            if(e.getSource() == btnNext){
                switch(seccion){
                    case 1:
                        seccion = 2;
                        break;
                    case 2:
                        seccion = 3;
                        break;
                    case 3:
                        seccion = 4;
                        break;
                    default:
                        
                }
                seccionTutorial();
            }
            if(e.getSource() == btnBack){
                switch(seccion){
                    case 2:
                        seccion = 1;
                        break;
                    case 3:
                        seccion = 2;
                        break;
                    case 4:
                        seccion = 3;
                        break;
                    default:
                        
                }
                seccionTutorial();
            }
            if(e.getSource() == lblWP){
                pQJugar();
            }
            if(e.getSource() == lblExit){
                menuPrincipal();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        
        }

        @Override
        public void mouseExited(MouseEvent e) {
        
        }
        
    }
}

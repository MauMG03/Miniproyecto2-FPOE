/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
        lblTitle = new JLabel("Pair Colors");
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 50));
        lblTitle.setBounds(230,50,500,70);
        
        lblHTP = new JLabel("Como Jugar");
        lblHTP.setFont(new Font("Serif", Font.PLAIN, 40));
        lblHTP.setBounds(100,350,500,70);
        
        lblWP = new JLabel("Por que Jugar");
        lblWP.setFont(new Font("Serif", Font.PLAIN, 40));
        lblWP.setBounds(350,350,500,70);
        
        lblPlay = new JLabel("Jugar");
        lblPlay.setFont(new Font("Serif", Font.PLAIN, 40));
        lblPlay.setBounds(300,420,500,70);
        
        contenedorInicial = getContentPane();
        contenedorInicial.setLayout(null);
        contenedorInicial.add(lblTitle);
        contenedorInicial.add(lblHTP);
        contenedorInicial.add(lblWP);
        contenedorInicial.add(lblPlay);
        
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import logica.Baldosa;
import logica.Juego;

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
    private JLabel lblPuntaje;
    private JLabel lblVidas;
    private JLabel lblBoton;
    private JLabel lblPuntajeFinal;
    private JLabel lblErrores;
    private JLabel lblAciertos;
    private JButton btnNext;
    private JButton btnBack;
    private int seccion;
    private int pausa;
    
    private Juego miJuego;
    private ImageIcon[] imagenes = new ImageIcon[20];
    private JLabel[] lblBaldosas = new JLabel[8];
    
    private Timer timerGame;
    private Timer entreRonda;
    
    
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
        cargarImagenes();
        seccion = 0;
        pausa = 0;
        
        lblTitle = new JLabel("Pair Colors", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.PLAIN, 50));
        lblTitle.setBounds(90,50,500,70);
        
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
        
        lblPuntaje = new JLabel("");
        lblPuntaje.setBounds(30,20,200,30);
        lblPuntaje.setFont(new Font("Serif", Font.PLAIN, 20));
        lblPuntaje.setVisible(false);
        lblPuntaje.setEnabled(false);
        
        lblVidas = new JLabel("");
        lblVidas.setBounds(500,20,100,30);
        lblVidas.setFont(new Font("Serif", Font.PLAIN, 20));
        lblVidas.setVisible(false);
        lblVidas.setEnabled(false);
        
        lblBoton = new JLabel("X");
        lblBoton.setBounds(600,600,40,40);
        lblBoton.setFont(new Font("Serif", Font.PLAIN, 35));
        lblBoton.setVisible(false);
        lblBoton.setEnabled(false);
        
        lblPuntajeFinal = new JLabel("Puntaje final: ", SwingConstants.CENTER);
        lblPuntajeFinal.setFont(new Font("Serif", Font.PLAIN, 40));
        lblPuntajeFinal.setBounds(180,220,320,70);
        lblPuntajeFinal.setVisible(false);
        
        lblAciertos = new JLabel("Aciertos: ", SwingConstants.CENTER);
        lblAciertos.setFont(new Font("Serif", Font.PLAIN, 40));
        lblAciertos.setBounds(180,320,320,70);
        lblAciertos.setVisible(false);
        
        lblErrores = new JLabel("Errores: ", SwingConstants.CENTER);
        lblErrores.setFont(new Font("Serif", Font.PLAIN, 40));
        lblErrores.setBounds(180,420,320,70);
        lblErrores.setVisible(false);
        
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
        contenedorInicial.add(lblPuntaje);
        contenedorInicial.add(lblVidas);
        contenedorInicial.add(lblBoton);
        contenedorInicial.add(lblPuntajeFinal);
        contenedorInicial.add(lblAciertos);
        contenedorInicial.add(lblErrores);
        contenedorInicial.add(btnNext);
        contenedorInicial.add(btnBack);
        posicionarLblBaldosas();
        
        lblHTP.addMouseListener(new ManejadorEventos());
        lblWP.addMouseListener(new ManejadorEventos());
        lblPlay.addMouseListener(new ManejadorEventos());
        lblExit.addMouseListener(new ManejadorEventos());
        lblBoton.addMouseListener(new ManejadorEventos());
        btnNext.addMouseListener(new ManejadorEventos());
        btnBack.addMouseListener(new ManejadorEventos());
        this.addKeyListener(new ManejadorEventos());
    }
    
    public void cargarImagenes(){
        int i = 0;
        for (ImageIcon imagen : imagenes){
            try {
                imagen = new ImageIcon(getClass().getResource
                                        ("/imagenes/"+(i+1)+".png"));
            } catch (Exception e) {
                imagen = new ImageIcon(getClass().getResource
                                        ("/imagenes/"+(i+1)+".jpg"));
            }
            Image image = (imagen).getImage().getScaledInstance
                                        (80, 80, Image.SCALE_SMOOTH);
            imagenes[i]= new ImageIcon(image);
            i++;
        }
    }
    
    public void posicionarLblBaldosas(){
        lblBaldosas[0] = new JLabel();
        lblBaldosas[0].setBounds(300,30,85,85);
        
        lblBaldosas[1] = new JLabel();
        lblBaldosas[1].setBounds(300,130,85,85);
        
        lblBaldosas[2] = new JLabel();
        lblBaldosas[2].setBounds(70,250,85,85);
        
        lblBaldosas[3] = new JLabel();
        lblBaldosas[3].setBounds(170,250,85,85);
        
        lblBaldosas[4] = new JLabel();
        lblBaldosas[4].setBounds(430,250,85,85);
        
        lblBaldosas[5] = new JLabel();
        lblBaldosas[5].setBounds(530,250,85,85);
        
        lblBaldosas[6] = new JLabel();
        lblBaldosas[6].setBounds(300,370,85,85);
        
        lblBaldosas[7] = new JLabel();
        lblBaldosas[7].setBounds(300,470,85,85);
      
        for(JLabel baldosa : lblBaldosas){
            baldosa.setEnabled(false);
            baldosa.setVisible(false);
            
            contenedorInicial.add(baldosa);
        }
    }
    
    public void mostrarBaldosas(){
        for(JLabel baldosa : lblBaldosas){
            baldosa.setEnabled(true);
            baldosa.setVisible(true);
        }
    }
    
    public void pintar(){
        
        for(int i = 0; i < lblBaldosas.length;i++){
            lblBaldosas[i].setIcon(null);
            lblBaldosas[i].setBorder(null);
        }
        for(Baldosa baldosa : miJuego.getBaldosas()){
            lblBaldosas[baldosa.getPosicion()-1].
                                    setIcon(imagenes[baldosa.getID()]);
        }
        
        Border border = BorderFactory.createLineBorder(Color.GRAY, 3,true);
        Border borderG = BorderFactory.createLineBorder(Color.GREEN, 3,true);
        Border borderR = BorderFactory.createLineBorder(Color.RED, 3,true);
        
        if(miJuego.getBaldosaCambiada() == 0){
            lblBaldosas[miJuego.getBaldosaCambiada()].setBorder(border);
        }
        else if(miJuego.getBaldosaCambiada() > 0){
            lblBaldosas[miJuego.getBaldosaCambiada()-1].setBorder(border);
        }
        else{
            //no pinta borde
        }
        if(miJuego.getHayAcierto()){
            for(int i = 0; i < miJuego.getBaldosas().size();i++){
                for(int j = 0; j < miJuego.getBaldosas().size();j++){
                    if(i == j){
                        //No pinta borde
                    }
                    else if(miJuego.getBaldosas().get(i).getID() == 
                            miJuego.getBaldosas().get(j).getID()){
                        int pI = miJuego.getBaldosas().get(i).getPosicion();
                        int pJ = miJuego.getBaldosas().get(j).getPosicion();
                        pintarBordesPares(borderG, pI, pJ);
                        timerGame.stop();
                    }
                }
            }
        }
        if(miJuego.getHayFallo()){
            for(int i = 0; i < miJuego.getBaldosas().size();i++){
                for(int j = 0; j < miJuego.getBaldosas().size();j++){
                    if(i == miJuego.getBaldosas().size()-1 &&
                            j == miJuego.getBaldosas().size()-1){
                        for(int k = 0; k< miJuego.getBaldosas().size();k++){
                            if(miJuego.getBaldosas().get(k).getPosicion() == 0){
                                lblBaldosas[miJuego.getBaldosas().get(k).
                                        getPosicion()].setBorder(borderR);
                            }
                            else{
                                lblBaldosas[miJuego.getBaldosas().get(k).
                                        getPosicion()-1].setBorder(borderR);
                            }
                        }
                    }
                    else if(i == j){
                        //No pinta borde
                    }
                    else if(miJuego.getBaldosas().get(i).getID() == 
                            miJuego.getBaldosas().get(j).getID()){
                        int pI = miJuego.getBaldosas().get(i).getPosicion();
                        int pJ = miJuego.getBaldosas().get(j).getPosicion();
                        pintarBordesPares(borderR, pI, pJ);
                        timerGame.stop();
                        i = miJuego.getBaldosas().size();
                        j = miJuego.getBaldosas().size();
                    }
                }
            }
        }
    }
    
    public void pintarBordesPares(Border borde,int i,int j){
        for(int k = 0; k < lblBaldosas.length; k++){
            lblBaldosas[k].setBorder(null);
        }
        if(i == 0){
            lblBaldosas[i].setBorder(borde);
            lblBaldosas[j].setBorder(borde);
        }
        else if(j == 0){
            lblBaldosas[i-1].setBorder(borde);
            lblBaldosas[j].setBorder(borde);
        }
        else{
            lblBaldosas[i-1].setBorder(borde);
            lblBaldosas[j-1].setBorder(borde);
        }
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
    
    public void iniciarJuego(){
        
        lblTitle.setText("");
        lblTitle.setVisible(false);
        
        lblHTP.setEnabled(false);
        lblWP.setEnabled(false);
        lblPlay.setEnabled(false);
        lblPuntaje.setEnabled(true);
        lblVidas.setEnabled(true);
        lblBoton.setEnabled(true);
        
        lblHTP.setVisible(false);
        lblWP.setVisible(false);
        lblPlay.setVisible(false);
        lblPuntaje.setVisible(true);
        lblVidas.setVisible(true);
        lblBoton.setVisible(true);
        
        mostrarBaldosas();
        miJuego = new Juego();
        seccion = 5;
        
        lblPuntaje.setText("Puntaje: " + miJuego.getPuntaje());
        lblVidas.setText("Vidas: " + miJuego.getNumVidas());
        
        pintar();
        
        timerGame = new Timer(miJuego.getTiempo(),((e) -> {
                miJuego.compararBaldosas();
                disminuirTiempo();
                finDelJuego();
                if(miJuego.getPausa()){
                    //Nada
                }else{
                    miJuego.cambiarBaldosa();
                }
                pintar();
                entreRonda.start();
                miJuego.setAccion(false);
                SwingUtilities.updateComponentTreeUI(contenedorInicial);
                
                lblPuntaje.setText("Puntaje: " + miJuego.getPuntaje());
                lblVidas.setText("Vidas: " + miJuego.getNumVidas());
        }));
        timerGame.start();
        
        entreRonda = new Timer(1,(e)->{
            if(miJuego.getPausa()){
                pausa += 1;
                if(pausa == 1){
                    pintar();
                }
                else if(pausa >= 200){
                    pausa = 0;
                    miJuego.setPausa(false);
                    pintar();
                    miJuego.cambiarRonda();
                    miJuego.setHayAcierto(false);
                    miJuego.setHayFallo(false);
                    entreRonda.stop();
                    timerGame.start();
                }
            }
            else{
                entreRonda.stop();
            }
        });
        SwingUtilities.updateComponentTreeUI(contenedorInicial);
    }
    
    public void disminuirTiempo(){
        if(miJuego.getHayAcierto()){
            timerGame.stop();            
            timerGame = new Timer(miJuego.getTiempo(),((e) -> {
                miJuego.compararBaldosas();
                disminuirTiempo();
                finDelJuego();
                if(miJuego.getPausa()){
                    //Nada
                }else{
                    miJuego.cambiarBaldosa();
                }
                pintar();
                entreRonda.start();
                miJuego.setAccion(false);
                SwingUtilities.updateComponentTreeUI(contenedorInicial);
                
                lblPuntaje.setText("Puntaje: " + miJuego.getPuntaje());
                lblVidas.setText("Vidas: " + miJuego.getNumVidas());
            }));
            timerGame.start();
        }
    }
    
    public void finDelJuego(){
        if(miJuego.getFinDelJuego()){
            timerGame.stop();
            
            for(int i = 0; i < lblBaldosas.length;i++){
                lblBaldosas[i].setIcon(null);
                lblBaldosas[i].setVisible(false);
            }
            
            lblPuntaje.setVisible(false);
            lblVidas.setVisible(false);
            lblBoton.setVisible(false);
            lblBoton.setEnabled(false);
            lblTitle.setVisible(true);
            
            lblPuntajeFinal.setVisible(true);
            lblAciertos.setVisible(true);
            lblErrores.setVisible(true);
            
            lblTitle.setText("FIN DEL JUEGO");
            lblPuntajeFinal.setText("Puntaje: " + miJuego.getPuntaje());
            lblAciertos.setText("Aciertos: " + miJuego.getAciertos());
            lblErrores.setText("Errores: " + miJuego.getErrores());
            
            SwingUtilities.updateComponentTreeUI(contenedorInicial);
        }
    }
    
    class ManejadorEventos extends KeyAdapter implements MouseListener{

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
            if(e.getSource() == lblPlay){
                iniciarJuego();
            }
            if(e.getSource() == lblBoton){
                if(entreRonda.isRunning()){
                    //No puede cambiar el estado de accion a true
                }
                else{
                    miJuego.setAccion(true);
                }
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
        
        @Override
        public void keyPressed(KeyEvent ke){
            if(seccion == 5){
                if(ke.getKeyCode() == 32){
                    if(entreRonda.isRunning()){
                        //No puede cambiar el estado de accion a true
                    }
                    else{
                        miJuego.setAccion(true);
                    }
                }
            }           
        }
    }
}
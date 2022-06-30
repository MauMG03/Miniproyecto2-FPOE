/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JPanel;
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
    
    private fondoJuego pnlFondo;
    
    private Juego miJuego;
    private ImageIcon[] imagenesB = new ImageIcon[20];
    private ImageIcon[] imagenesM = new ImageIcon[7];
    private ImageIcon fondo;
    private JLabel[] lblBaldosas = new JLabel[8];
    
    private Timer timerGame;
    private Timer entreRonda;
    
    private AudioClip cambioBS;
    private AudioClip aciertoS;
    private AudioClip falloS;
    private AudioClip finS;
    
    private Container contenedorInicial;
    public VentanaPrincipal()
    {
        pnlFondo = new fondoJuego();
        this.setContentPane(pnlFondo);
        iniciarComponentes();   
        setSize(700,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Adosa2");
        setResizable(false);
        SwingUtilities.updateComponentTreeUI(contenedorInicial);
    }
    
    private void iniciarComponentes()
    {
        cargarImagenes();
        asignarSonidos();
        seccion = 0;
        pausa = 0;
        
        lblTitle = new JLabel();
        lblTitle.setBounds(90,10,500,150);
        lblTitle.setIcon(imagenesM[0]);
        
        lblHTP = new JLabel();
        lblHTP.setBounds(90,290,200,80);
        lblHTP.setIcon(imagenesM[3]);
        
        lblWP = new JLabel();
        lblWP.setBounds(360,290,240,85);
        lblWP.setIcon(imagenesM[5]);
        
        lblPlay = new JLabel("Jugar");
        lblPlay.setBounds(235,410,200,70);
        lblPlay.setIcon(imagenesM[2]);
        
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
        for (ImageIcon imagen : imagenesB){
            imagen = new ImageIcon(getClass().getResource
                                        ("/imagenes/baldosa-"+(i+1)+".png"));
            Image image = (imagen).getImage().getScaledInstance
                                        (80, 80, Image.SCALE_SMOOTH);
            imagenesB[i] = new ImageIcon(image);
            i++;
        }
        i = 0;
        for(ImageIcon imagen : imagenesM){
            imagen = new ImageIcon(getClass().getResource
                                        ("/imagenes/adosa2-0"+(i+1)+".png"));
            if(i == 0){
                Image image = (imagen).getImage().getScaledInstance
                                        (500, 150, Image.SCALE_SMOOTH);
                imagenesM[i] = new ImageIcon(image);
            }
            else if(i == 1 || i == 2){
                Image image = (imagen).getImage().getScaledInstance
                                        (200, 70, Image.SCALE_SMOOTH);
                imagenesM[i] = new ImageIcon(image);
            }
            else if(i == 5 || i == 6){
                Image image = (imagen).getImage().getScaledInstance
                                        (240, 85, Image.SCALE_SMOOTH);
                imagenesM[i] = new ImageIcon(image);
            }
            else{
                Image image = (imagen).getImage().getScaledInstance
                                        (200, 80, Image.SCALE_SMOOTH);
                imagenesM[i] = new ImageIcon(image);
            }
            i++;
        }
    }
    
    public void asignarSonidos(){
        aciertoS = java.applet.Applet.newAudioClip(
                (getClass().getResource("/sonidos/aciertoS.wav")));

        cambioBS = java.applet.Applet.newAudioClip(
                (getClass().getResource("/sonidos/cambioB.wav")));
        
        falloS = java.applet.Applet.newAudioClip(
                (getClass().getResource("/sonidos/fallo.wav")));
        
        finS = java.applet.Applet.newAudioClip(
                (getClass().getResource("/sonidos/fin.wav")));
    }
    
    public void reproducirSonidos(){
        if(!miJuego.getHayAcierto() && 
                    !miJuego.getHayFallo() && 
                    !miJuego.getFinDelJuego()){                        
            cambioBS.play();
        }
        if(miJuego.getHayAcierto()){
            aciertoS.play();
        }
        if(miJuego.getHayFallo()){
            falloS.play();
        }
        
    }
    
    public void posicionarLblBaldosas(){
        int size = 88;
        
        lblBaldosas[0] = new JLabel();
        lblBaldosas[0].setBounds(300,30,size,size);
        
        lblBaldosas[1] = new JLabel();
        lblBaldosas[1].setBounds(300,130,size,size);
        
        lblBaldosas[2] = new JLabel();
        lblBaldosas[2].setBounds(70,250,size,size);
        
        lblBaldosas[3] = new JLabel();
        lblBaldosas[3].setBounds(170,250,size,size);
        
        lblBaldosas[4] = new JLabel();
        lblBaldosas[4].setBounds(430,250,size,size);
       
        lblBaldosas[5] = new JLabel();
        lblBaldosas[5].setBounds(530,250,size,size);
        
        lblBaldosas[6] = new JLabel();
        lblBaldosas[6].setBounds(300,370,size,size);
        
        lblBaldosas[7] = new JLabel();
        lblBaldosas[7].setBounds(300,470,size,size);
      
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
                                    setIcon(imagenesB[baldosa.getID()]);
        }
        
        Border borderC = BorderFactory.createLineBorder(Color.cyan, 4,true);
        Border borderG = BorderFactory.createLineBorder(Color.GREEN, 4,true);
        Border borderR = BorderFactory.createLineBorder(Color.RED, 4,true);
        
        if(miJuego.getBaldosaCambiada() == 0){
            lblBaldosas[miJuego.getBaldosaCambiada()].setBorder(borderC);
        }
        else if(miJuego.getBaldosaCambiada() > 0){
            lblBaldosas[miJuego.getBaldosaCambiada()-1].setBorder(borderC);
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
        if(miJuego.getHayFallo() || miJuego.getNumVidas() == 0){
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

            lblInfo.setText("<html>En Adosa2 aparece en pantalla " 
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
                reproducirSonidos();
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
                    miJuego.cambiarRonda();
                    pintar();
                    miJuego.setHayAcierto(false);
                    miJuego.setHayFallo(false);
                    entreRonda.stop();
                    timerGame.start();
                }
            }
            else{
                entreRonda.stop();
                finDelJuego();
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
                reproducirSonidos();
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
            if(!entreRonda.isRunning()){
                
            }else{
                timerGame.stop();
                finS.play();
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

                lblPuntajeFinal.setText("Puntaje: " + miJuego.getPuntaje());
                lblAciertos.setText("Aciertos: " + miJuego.getAciertos());
                lblErrores.setText("Errores: " + miJuego.getErrores());

                SwingUtilities.updateComponentTreeUI(contenedorInicial);
            }     
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
            if(e.getSource() == lblHTP){
                lblHTP.setIcon(imagenesM[4]);
            }
            if(e.getSource() == lblWP){
                lblWP.setIcon(imagenesM[6]);
            }
            if(e.getSource() == lblPlay){
                lblPlay.setIcon(imagenesM[1]);
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == lblHTP){
                lblHTP.setIcon(imagenesM[3]);
            }
            if(e.getSource() == lblWP){
                lblWP.setIcon(imagenesM[5]);
            }
            if(e.getSource() == lblPlay){
                lblPlay.setIcon(imagenesM[2]);
            }
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
    
    class fondoJuego extends JPanel{
        private Image imagen;
        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource
                                            ("/imagenes/fondo.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
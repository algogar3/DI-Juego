package com.albertogomez.di;

//LIBRERÍAS NECESARIAS
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.albertogomez.di.Bola.OnPuntoMarcado;

public class Pong extends JFrame implements ActionListener, OnPuntoMarcado {

	/*** CONSTANTES ***/
	// Tamaño inicial de la ventana
	public static int ANCHURA_INICIAL = 650;
    public static int ALTURA_INICIAL = 400;
    
    /*** VARIABLES ***/
    JMenuItem salir;
    JMenuItem nuevaPartida;
    Partida partida;
    JPanel marcador;
    JLabel etiquetaJugador;
    JLabel etiquetaComputer;
    JLabel marcadorJugador;
    JLabel marcadorComputer;
    Bola bola;
    Obstaculos obstaculo;

    /*** CONSTRUCTORES ***/
    // Constructor vacío
    public Pong() {
    	super("SUPER PONG!!");
    	partida = new Partida();
    	obstaculo = new Obstaculos();
    	bola = partida.getBola();
    	bola.setOnPuntoMarcadoListener(this);
    	iniciarGUI();
    }
    
    /*** MÉTODOS ***/
    // Método iniciarGUI()
    // FUNCIONALIDAD: Configura el aspecto visible de la ventana
    public void iniciarGUI(){
    	// Elementos de la barra de menú
    	JMenuBar barraMenu = new JMenuBar();
    	JMenu menuJuego = new JMenu("Juego");
    	nuevaPartida = new JMenuItem("Nueva partida");
    	salir = new JMenuItem("Salir");
    	
    	// Escuchadores
    	nuevaPartida.addActionListener(this);
    	salir.addActionListener(this);
    	
    	// Se añaden los elementos de la barra de menú
    	/*
    	menuJuego.add(nuevaPartida);
    	menuJuego.addSeparator();
    	*/
    	menuJuego.add(salir);
    	barraMenu.add(menuJuego);
    	setJMenuBar(barraMenu);
    	
    	setPreferredSize(new Dimension(ANCHURA_INICIAL, ALTURA_INICIAL));
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel marcador
        marcador = new JPanel(new GridLayout(2,2));
        
        etiquetaJugador = new JLabel("JUGADOR", JLabel.CENTER);
        etiquetaJugador.setForeground(Color.WHITE);
        etiquetaJugador.setOpaque(true);
        etiquetaJugador.setBackground(new Color(50,200,0));
        
        etiquetaComputer = new JLabel("COMPUTER", JLabel.CENTER);
        etiquetaComputer.setForeground(Color.WHITE);
        etiquetaComputer.setOpaque(true);
        etiquetaComputer.setBackground(new Color(255,50,0));
        
        marcadorJugador = new JLabel("0", JLabel.CENTER);
        marcadorComputer = new JLabel("0", JLabel.CENTER);
        marcadorComputer.setOpaque(true);
        marcadorJugador.setOpaque(true);
        
        marcador.add(etiquetaJugador);
        marcador.add(etiquetaComputer);
        marcador.add(marcadorJugador);
        marcador.add(marcadorComputer);
        add(marcador, BorderLayout.PAGE_START);
        
        //partida = new Partida();
        add(partida, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    // Método main
    public static void main(String[] args) {
        new Pong();
    }

    /*** MÉTODOS DE LA INTERFAZ ComponentListener ***/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == salir){
			JOptionPane.showMessageDialog(this, "Gracias por jugar a Super Pong!!\nEl resultado ha sido "
		+ partida.getBola().getJugador().getPuntuacion() + " a " + partida.getBola().getComputer().getPuntuacion(), "Hasta Pronto", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
	}

    /*** MÉTODOS DE LA INTERFAZ ComponentListener ***/
	@Override
	public void onJugadorAnota(int puntuacion) {
		marcadorJugador.setText(String.valueOf(puntuacion));
		try{
			Thread.currentThread();
			Thread.sleep(100);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void onComputerAnota(int puntuacion) {
		marcadorComputer.setText(String.valueOf(puntuacion));
		try{
			Thread.currentThread();
			Thread.sleep(100);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}	
}

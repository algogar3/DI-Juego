package com.albertogomez.di;

//LIBRERÍAS NECESARIAS
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Partida extends JPanel implements ActionListener, KeyListener{
	
	/*** VARIABLES ***/
	// Declaración de los objetos necesarios para jugar la partida
	Jugador jugador = new Jugador();
	Computer computer = new Computer(this); // Se pasa la partida como parámetro en el constructor para que el computer sepa
											// donde está la bola y pueda dirigirse hacia arriba o hacia abajo
	Obstaculos obstaculo = new Obstaculos();
	Bola bola = new Bola(this, jugador, computer);
	
	
	/*** CONTRUCTORES ***/
	// Constructor
	public Partida(){	
		// Objeto Timer. Llama al método actionPerformed cada 20ms
		Timer time = new Timer(20, this);
		time.start();
		
		// Métodos de la clase JPanel, por eso se extiende de JPanel. Polimorfismo.
		addKeyListener(this); // Se suscribe la clase como oyente de la interfaz KeyListener
		setFocusable(true); // Necesario para que nuestra clase reciba las notificaciones del teclado
	}
	
	/*** MÉTODOS ***/
	// Método update
	// FUNCIONALIDAD: Actualiza el estado de la partida
	public void update() {
	    // Se llama al método update de cada uno de los objetos
		jugador.update();
		bola.update();
		computer.update();

		// Se comprueba si la bola ha chocado con algún elemento para cambiar su dirección
		bola.comprobarColisionCon(jugador);
		bola.comprobarColisionCon(computer);
		bola.comprobarColisionCon(obstaculo);
	}
	
	// Método paint
	// FUNCIONALIDAD: pinta elementos de la partida y llama a métodos que pintan otros elementos
	public void paint(Graphics g) {
		// Fondo
        g.setColor(Color.black);
        g.fillRect(0, 0, getRootPane().getContentPane().getWidth(), getRootPane().getContentPane().getHeight());

        // Se llama al método paint propio de cada uno de los objetos de la partida
        jugador.paint(g);
        bola.paint(g);
        computer.paint(g);
        obstaculo.paint(g);
    }
	
	/*** GETTERS Y SETTERS ***/
	// Método getBola, usado en la clase Computer para obtener la posición de la bola en cada momento
	public Bola getBola() {
	    return bola;
	}

	/*** MÉTODOS DE LA INTERFAZ OnPuntoMarcado ***/
	@Override
	public void keyPressed(KeyEvent e) {
		// Se presiona la tecla subir
		if (e.getKeyCode() == KeyEvent.VK_UP) {
            jugador.setYVelocidad(-5);
            // Se hace tope con el límite del tablero
            if (jugador.getY() < 20) {
                jugador.setYVelocidad(0);
            }
        } 
		// Se presiona la tecla bajar
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jugador.setYVelocidad(5);
            // Se hace tope con el límite del tablero
            if (jugador.getY() > (getRootPane().getContentPane().getHeight() - 50 - jugador.ALTO)) {
                jugador.setYVelocidad(0);
            }
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            jugador.setYVelocidad(0);
        }
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// Vacío
	}

	/*** MÉTODOS DE LA INTERFAZ ActionListener ***/
	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
        repaint(); // Llama al método paint del componente (Clase Graphics)
	}
}

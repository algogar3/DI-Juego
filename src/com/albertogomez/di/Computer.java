package com.albertogomez.di;

//LIBRERÍAS NECESARIAS
import java.awt.Color;
import java.awt.Graphics;

public class Computer {
	/*** CONSTANTES ***/
	// Tamaño del pad
	public static final int ANCHO = 10;
	public static final int ALTO = 40;
	
	/*** VARIABLES ***/
	// Configuraciones iniciales
	private int y = Pong.ALTURA_INICIAL / 2;
	private int yVelocidad = 0;
	private int puntuacion = 0;
	private Partida partida;
	private int x = Pong.ANCHURA_INICIAL - (35 + ANCHO);

	/*** CONTRUCTORES ***/
	// Constructor con parámetros
	public Computer(Partida partida){
		this.partida = partida;
	}

	/*** MÉTODOS ***/
	// Método update
	// FUNCIONALIDAD: Actualiza la posición del pad del computer
	public void update() {
		if (partida.getBola().getY() < y + (ALTO/2)) {
            // El pad del computer está por debajo de la bola
			yVelocidad = -3;
        } else if (partida.getBola().getY() > y + (ALTO/2)) {
        	// El pad del computer está por encima de la bola
        	yVelocidad = 3;
        }
		// Actualización de la posición del pad del computer
        y = y + yVelocidad;
        x = partida.getRootPane().getContentPane().getWidth() - (35 + ANCHO);
	}

	// Método paint
	// FUNCIONALIDAD: Pinta el pad del computer
	public void paint(Graphics g) {
		g.setColor(Color.red);
	    g.fillRect(x, y, ANCHO, ALTO);
	}

	/*** GETTERS Y SETTERS ***/
	// Método getY
    public int getY() {
        return y;
    }
    
 // Método getX
    public int getX() {
        return x;
    }
    
    // Método setPuntuacion
	public void setPuntuacion(int puntuacion){
		this.puntuacion = puntuacion;
	}
	
	// Método getPuntuacion
	public int getPuntuacion(){
		return this.puntuacion;
	}

}

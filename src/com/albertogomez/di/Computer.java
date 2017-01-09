package com.albertogomez.di;

//LIBRER�AS NECESARIAS
import java.awt.Color;
import java.awt.Graphics;

public class Computer {
	/*** CONSTANTES ***/
	// Tama�o del pad
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
	// Constructor con par�metros
	public Computer(Partida partida){
		this.partida = partida;
	}

	/*** M�TODOS ***/
	// M�todo update
	// FUNCIONALIDAD: Actualiza la posici�n del pad del computer
	public void update() {
		if (partida.getBola().getY() < y + (ALTO/2)) {
            // El pad del computer est� por debajo de la bola
			yVelocidad = -3;
        } else if (partida.getBola().getY() > y + (ALTO/2)) {
        	// El pad del computer est� por encima de la bola
        	yVelocidad = 3;
        }
		// Actualizaci�n de la posici�n del pad del computer
        y = y + yVelocidad;
        x = partida.getRootPane().getContentPane().getWidth() - (35 + ANCHO);
	}

	// M�todo paint
	// FUNCIONALIDAD: Pinta el pad del computer
	public void paint(Graphics g) {
		g.setColor(Color.red);
	    g.fillRect(x, y, ANCHO, ALTO);
	}

	/*** GETTERS Y SETTERS ***/
	// M�todo getY
    public int getY() {
        return y;
    }
    
 // M�todo getX
    public int getX() {
        return x;
    }
    
    // M�todo setPuntuacion
	public void setPuntuacion(int puntuacion){
		this.puntuacion = puntuacion;
	}
	
	// M�todo getPuntuacion
	public int getPuntuacion(){
		return this.puntuacion;
	}

}

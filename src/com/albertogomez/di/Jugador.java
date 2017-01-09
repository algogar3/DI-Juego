package com.albertogomez.di;

// LIBRER�AS NECESARIAS
import java.awt.Color;
import java.awt.Graphics;

public class Jugador {
	/*** CONSTANTES ***/
	// Tama�o del pad
	public static final int ANCHO = 10;
	public static final int ALTO = 40;
	// Posici�n x del pad
	public static final int X = 35;
	
	/*** VARIABLES ***/
	// Configuraciones iniciales
	private int y = Pong.ALTURA_INICIAL/2 - ALTO/2 - 40;
	private int yVelocidad = 0;
	private int puntuacion = 0;

	/*** CONTRUCTORES ***/
	// Constructor vac�o
	public Jugador(){}

	/*** M�TODOS ***/
	// M�todo update
	// FUNCIONALIDAD: Actualiza la posici�n del pad del jugador
	public void update() {
	    y = y + yVelocidad;
	}

	// M�todo paint
	// FUNCIONALIDAD: Pinta el pad del jugador
	public void paint(Graphics g) {
	    g.setColor(Color.green);
	    g.fillRect(X, y, ANCHO, ALTO);
	}

	/*** GETTERS Y SETTERS ***/
	// M�todo setYVelocidad
	public void setYVelocidad(int velocidad) {
	    this.yVelocidad = velocidad;
	}

	// M�todo getY
	public int getY() {
	    return y;
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

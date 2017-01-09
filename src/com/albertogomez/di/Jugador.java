package com.albertogomez.di;

// LIBRERÍAS NECESARIAS
import java.awt.Color;
import java.awt.Graphics;

public class Jugador {
	/*** CONSTANTES ***/
	// Tamaño del pad
	public static final int ANCHO = 10;
	public static final int ALTO = 40;
	// Posición x del pad
	public static final int X = 35;
	
	/*** VARIABLES ***/
	// Configuraciones iniciales
	private int y = Pong.ALTURA_INICIAL/2 - ALTO/2 - 40;
	private int yVelocidad = 0;
	private int puntuacion = 0;

	/*** CONTRUCTORES ***/
	// Constructor vacío
	public Jugador(){}

	/*** MÉTODOS ***/
	// Método update
	// FUNCIONALIDAD: Actualiza la posición del pad del jugador
	public void update() {
	    y = y + yVelocidad;
	}

	// Método paint
	// FUNCIONALIDAD: Pinta el pad del jugador
	public void paint(Graphics g) {
	    g.setColor(Color.green);
	    g.fillRect(X, y, ANCHO, ALTO);
	}

	/*** GETTERS Y SETTERS ***/
	// Método setYVelocidad
	public void setYVelocidad(int velocidad) {
	    this.yVelocidad = velocidad;
	}

	// Método getY
	public int getY() {
	    return y;
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

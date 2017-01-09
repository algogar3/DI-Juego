package com.albertogomez.di;

import java.awt.Color;
import java.awt.Graphics;

public class Obstaculos {
	/*** CONSTANTES ***/
	// Tamaño del obstaculo
	public static final int ANCHO = 20;
	public static final int ALTO = 80;
	// Posición del obstaculo
	public static final int X = 200;
	public static final int Y = 200;
	
	/*** CONTRUCTORES ***/
	// Constructor vacío
	public Obstaculos(){}
	
	// Método paint
	// FUNCIONALIDAD: Pinta el pad del jugador
	public void paint(Graphics g) {
		g.setColor(Color.pink);
		g.fillRect(X, Y, ANCHO, ALTO);
	}
}

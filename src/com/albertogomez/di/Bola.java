package com.albertogomez.di;

//LIBRERÍAS NECESARIAS
import java.awt.Color;
import java.awt.Graphics;

public class Bola {
	/*** VARIABLES ***/
	// Configuraciones iniciales
	private static int x = Pong.ANCHURA_INICIAL / 2;
    private static int y = Pong.ALTURA_INICIAL / 2;
    private int xVelocidad = -4;
    private int yVelocidad = 4;
    private int tamanyo = 5;
    private Partida partida;
    private Jugador jugador;
    private Computer computer;
    private OnPuntoMarcado escuchador;
    
    /*** CONTRUCTORES ***/
	// Constructor vacío
	public Bola(Partida partida, Jugador jugador, Computer computer){
		this.partida = partida;
		this.jugador = jugador;
		this.computer = computer;
	}

	/*** MÉTODOS ***/
	// Método update
	// FUNCIONALIDAD: Actualiza la posición de la bola
	public void update() {
        x = x + xVelocidad;
        y = y + yVelocidad;

        // Si se anota un punto, se cambia la direccion de la bola
        if (x < 0 || (x + tamanyo > partida.getRootPane().getContentPane().getWidth())){
            if(xVelocidad < 0){
            	// Punto del computer
            	computer.setPuntuacion(computer.getPuntuacion() + 1);
            	escuchador.onComputerAnota(computer.getPuntuacion());
            }
            else{
            	// punto del jugador
            	jugador.setPuntuacion(jugador.getPuntuacion() + 1);
            	escuchador.onJugadorAnota(jugador.getPuntuacion());
            }
        	cambiarDireccionX();
            
        }

        // COMPROBACIÓN CHOQUE PARED (HORIZONTAL)
        if (y < 0 || (y > partida.getRootPane().getContentPane().getHeight() - 40)){
        	cambiarDireccionY();
        }
    }
	
	 // Método paint
	 // FUNCIONALIDAD: Pinta la bola
	 public void paint(Graphics g) {
		 g.setColor(Color.yellow);
	     g.fillOval(x, y, tamanyo, tamanyo);
	 }

	 // Método cambiarDireccionX
	 // FUNCIONALIDAD: Cambia la dirección de la bola en el eje X
	 private void cambiarDireccionX() {
	     xVelocidad = -xVelocidad;
	 }

	 // Método cambiarDireccionY
	 // FUNCIONALIDAD: Cambia la dirección de la bola en el eje Y
	 private void cambiarDireccionY() {
	     yVelocidad = -yVelocidad;
	 }
	 
	 // Método comprobarColisionCon (MÉTODO SOBRECARGADO)
	 // FUNCIONALIDAD: Comprueba si la bola ha chocado con el pad del jugador o del computer
	 public void comprobarColisionCon(Jugador jugador) {
	     if (this.x >= jugador.X && this.x <= jugador.X + jugador.ANCHO) {
	        if (this.y >= jugador.getY() && this.y <= jugador.getY() + jugador.ALTO) {
	            // La bola ha chocado con el pad del jugador
	        	cambiarDireccionX();
	        }
	    }
	 }

	 // Método comprobarColisionCon (MÉTODO SOBRECARGADO)
	 // FUNCIONALIDAD: Comprueba si la bola ha chocado con el pad del jugador o del computer
	 public void comprobarColisionCon(Computer computer) {
	     if (this.x >= computer.getX() && this.x <= computer.getX() + computer.ANCHO) {
	         if (this.y >= computer.getY() && this.y <= computer.getY() + computer.ALTO) {
	        	// La bola ha chocado con el pad del computer
	        	 cambiarDireccionX();
	         }
	     }
	 }
	 
	 // Método comprobarColisionCon (MÉTODO SOBRECARGADO)
	 // FUNCIONALIDAD: Comprueba si la bola ha chocado con los obstáculos
	 public void comprobarColisionCon(Obstaculos obstaculo) {
	     if (this.x >= obstaculo.X && this.x <= obstaculo.X + obstaculo.ANCHO) {
	         if (this.y >= obstaculo.Y && this.y <= obstaculo.Y + obstaculo.ALTO) {
	        	// La bola ha chocado con el obstáculo
	        	 cambiarDireccionX();
	         }
	     }
	 }
	 
	 /*** GETTERS Y SETTERS ***/
	 // Método getX
	 public int getX() {
	     return x;
	 }

	// Método getY
	 public int getY() {
	     return y;
	 }
	 
	// Método getJugador
	public Jugador getJugador() {
	    return jugador;
	}
		 
	// Método getComputer
	public Computer getComputer() {
	    return computer;
	}
	
	/*** DECLARACIÓN DE LA INTERFAZ OnPuntoMarcado ***/
	public interface OnPuntoMarcado{
		// Método al que se llamará cuando el jugador anote un punto
		void onJugadorAnota(int puntuacion);
		// Método al que se llamará cuando el computer anote un punto
		void onComputerAnota(int puntuacion);
	}
	
	/*** MÉTODO DE SUSCRIPCIÓN COMO OYENTE DE LA INTERFAZ ***/
	public void setOnPuntoMarcadoListener(OnPuntoMarcado escuchador){
		this.escuchador = escuchador;
	}
}

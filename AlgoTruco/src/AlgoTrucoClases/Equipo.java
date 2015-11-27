package AlgoTrucoClases;

import java.util.ArrayList;

public class Equipo{

	private ArrayList<Jugador> jugadores;
	private int puntosDeRonda;
	public int puntajeDeEquipo;
	public boolean quiero;

	public Equipo( ArrayList<Jugador> jugadoresDeEquipo ){

		this.jugadores = jugadoresDeEquipo;
		this.puntajeDeEquipo = 0;
		this.puntosDeRonda = 0;
		this.quiero = true;

	}

	public int obtenerCantidadDeJugadores() {
		return (this.jugadores.size());
	}

	public int obtenerPuntaje() {
		return (this.puntajeDeEquipo);
	}

	public boolean ganoPartida() {
		return (this.obtenerPuntaje() >= 30);

	}

	public void sumarPuntos(int nuevosPuntos) {
		(this.puntajeDeEquipo) += nuevosPuntos;
	}

	public void actualizarPuntos() {
		this.puntajeDeEquipo += this.puntosDeRonda;
		this.puntosDeRonda = 0;
	}

	public boolean responderTruco(Ronda unaRonda){
		return (this.jugadores.get(0).responderTruco(unaRonda));
	}

	public boolean devolverQuiero(){
		return this.quiero;
	}

	public void tieneQuiero(){
		this.quiero = true;
	}

	public void noTieneQuiero(){
		this.quiero = false;
	}

	public void irse(Ronda unaRonda) {
		unaRonda.irse(this);
	}

	public boolean responderRetruco(Ronda unaRonda){
		return (this.jugadores.get(0).responderRetruco(unaRonda));
	}

	public boolean responderValeCuatro(Ronda unaRonda){
		return (this.jugadores.get(0).responderValeCuatro(unaRonda));
	}

	public boolean responderEnvido(Ronda unaRonda){
		return (this.jugadores.get(0).responderEnvido(unaRonda));
	}

	public void sumarPuntosTanto(Ronda ronda) {
		int puntajeSumar = 0;
		if(ronda.obtenerTantoActual()==null){
			puntajeSumar = 1;
		}else{
			switch(ronda.obtenerTantoActual()){
			case ENVIDO: puntajeSumar = 2;
						break;
			case ENVIDOENVIDO: puntajeSumar = 4;
						break;
			case REALENVIDO: puntajeSumar = 3;
						break;
			case FALTAENVIDO: puntajeSumar = this.calculoFaltaenvido(ronda.obtenerEquipoRival(this));
						break;
			case ENVIDOENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaenvido(ronda.obtenerEquipoRival(this));
						break;
			case ENVIDOENVIDOREALENVIDO: puntajeSumar = 7;
						break;
			case ENVIDOENVIDOREALENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaenvido(ronda.obtenerEquipoRival(this));
						break;
			case ENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaenvido(ronda.obtenerEquipoRival(this));
						break;
			case ENVIDOREALENVIDO: puntajeSumar = 5;
						break;
			case ENVIDOREALENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaenvido(ronda.obtenerEquipoRival(this));
						break;
			case REALENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaenvido(ronda.obtenerEquipoRival(this));
						break;
			}
		}
		this.sumarPuntos(puntajeSumar);
	}

	private int calculoFaltaenvido(Equipo equipoRival) {
		int faltaEnvido = 0;
		if(equipoRival.obtenerPuntaje()<15){//ESTA EN LAS MALAS
			faltaEnvido = 15 - equipoRival.obtenerPuntaje();
		}else{
			faltaEnvido = 30 - equipoRival.obtenerPuntaje();
		}
		return faltaEnvido;
	}

}

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

}

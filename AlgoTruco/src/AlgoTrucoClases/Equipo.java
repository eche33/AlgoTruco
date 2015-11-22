package AlgoTrucoClases;

import java.util.ArrayList;

public class Equipo{

	private ArrayList<Jugador> jugadores;
	public int puntajeDeEquipo;

	public Equipo( ArrayList<Jugador> jugadoresDeEquipo ){

		this.jugadores = jugadoresDeEquipo;
		this.puntajeDeEquipo = 0;

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
}

package AlgoTrucoClases;

import java.util.ArrayList;

public class Equipo{

	private ArrayList<Player> jugadores;
	public int puntajeDeEquipo;

	public Equipo( ArrayList<Player> jugadoresDeEquipo ){

		this.jugadores = jugadoresDeEquipo;
		this.puntajeDeEquipo = 0;

	}

	public int obtenerCantidadDeJugadores() {
		return (this.jugadores.size());
	}

	public int obtenerPuntaje() {
		return (this.puntajeDeEquipo);
	}
}

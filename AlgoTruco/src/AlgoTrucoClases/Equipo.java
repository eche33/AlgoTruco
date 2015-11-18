package AlgoTrucoClases;

import java.util.ArrayList;

public class Equipo{
	
	private ArrayList<Player> jugadores;
	int puntajeDeEquipo;
	
	public Equipo( ArrayList<Player> jugadoresDeEquipo ){
		
		this.jugadores = jugadoresDeEquipo;
		this.puntajeDeEquipo = 0;
		
	}
}

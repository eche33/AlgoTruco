package AlgoTrucoTantos;

import java.util.ArrayList;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;

public class Tanto {

	private int puntosQueOtorga;

public Tanto(){
}

	public Equipo obtenerEquipoGanador(Ronda ronda){
		int envidoGanador = 0;
		Equipo equipoGanador = null;
		for(int i=0; i<ronda.obtenerJugadoresOrdenados().size(); i++){
			Jugador jugadorActual = ronda.obtenerJugadoresOrdenados().get(i);
			if(jugadorActual.obtenerEnvido()>envidoGanador){
				envidoGanador = jugadorActual.obtenerEnvido();
				equipoGanador = jugadorActual.obtenerEquipo();
			}else{
				if(jugadorActual.obtenerEnvido()==envidoGanador){
					equipoGanador = ronda.obtenerEquipoMano();
				}
			}
		}
		return (equipoGanador);
	}
}


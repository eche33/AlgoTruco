package AlgoTrucoClases;

import java.util.ArrayList;

public abstract class Tanto {

	protected int puntosQueOtorga;

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

	public int obtenerPuntos(){
		return (this.puntosQueOtorga);
	}
}


package AlgoTrucoClases;

import java.util.ArrayList;

public abstract class Tanto {

	protected int puntosQueOtorga;
	protected int puntosNoQuerido;
	public boolean seQuiere;
	protected Equipo equipoGanador;

public Tanto(){
	this.seQuiere = true;
	this.equipoGanador = null;
}

	public Equipo obtenerEquipoGanador(Ronda ronda){
		Equipo equipoGanador = null;
		if(this.seQuiere){
			int envidoGanador = 0;
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
		}else{
			equipoGanador = this.equipoGanador;
		}
		return equipoGanador;
		}

	public int obtenerPuntos(){
		if(this.seQuiere){
			return (this.puntosQueOtorga);
		}else{
			return (this.puntosNoQuerido);
		}
	}

	public int obtenerPuntosNoQuerido(){
		return (this.puntosNoQuerido);
	}

	public void noSeQuiere(Equipo equipo1){
		this.seQuiere = false;
		this.equipoGanador = equipo1;
	}
}


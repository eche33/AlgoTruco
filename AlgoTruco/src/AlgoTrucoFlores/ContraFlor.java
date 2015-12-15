package AlgoTrucoFlores;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Flores;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;

public class ContraFlor extends Flores{

	public ContraFlor(){
		this.puntosQueOtorga = 6;
	}

	@Override
	public Equipo obtenerEquipoGanador(Ronda ronda) {
		int florGanadora = 0;
		this.equipoGanador = null;
		for(int i=0; i<ronda.obtenerJugadoresOrdenados().size(); i++){
			Jugador jugadorActual = ronda.obtenerJugadoresOrdenados().get(i);
			if(jugadorActual.obtenerFlor()>florGanadora){
				florGanadora = jugadorActual.obtenerEnvido();
				this.equipoGanador = jugadorActual.obtenerEquipo();
			}else{
				if(jugadorActual.obtenerFlor()==florGanadora){
					this.equipoGanador = ronda.obtenerEquipoMano();
				}
			}
		}
		return (this.equipoGanador);
	}




}

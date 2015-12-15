package AlgoTrucoFlores;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Flores;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;

public class ContraFlorAlResto extends Flores {

	public ContraFlorAlResto(int puntaje){
		this.puntosQueOtorga = puntaje;
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

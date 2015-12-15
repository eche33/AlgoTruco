package AlgoTrucoFlores;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Flores;
import AlgoTrucoClases.Ronda;

public class Flor extends Flores {

	public Flor(Equipo equipo){
		this.puntosQueOtorga = 3;
		this.equipoGanador = equipo;
	}

	@Override
	public Equipo obtenerEquipoGanador(Ronda ronda) {
		return (this.equipoGanador);
	}

}

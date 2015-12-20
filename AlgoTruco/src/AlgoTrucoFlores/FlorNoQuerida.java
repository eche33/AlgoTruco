package AlgoTrucoFlores;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Flores;
import AlgoTrucoClases.Ronda;

public class FlorNoQuerida extends Flores {

	public FlorNoQuerida(Equipo equipo){
		this.puntosQueOtorga = 4;
		this.equipoGanador = equipo;
	}

	@Override
	public Equipo obtenerEquipoGanador(Ronda ronda) {
		return (this.equipoGanador);
	}

}

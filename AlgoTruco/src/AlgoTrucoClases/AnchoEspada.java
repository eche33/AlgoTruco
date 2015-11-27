package AlgoTrucoTestsUnitarios;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;

public class AnchoEspada extends Carta {

	private int prioridad;
	
	public AnchoEspada() {
		super(valor, paloActual);
	}

	public boolean esMayorQue(Carta carta1) {
		return true;
	}

}

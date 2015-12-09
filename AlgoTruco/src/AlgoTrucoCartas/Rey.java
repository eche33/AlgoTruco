package AlgoTrucoCartas;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;

public class Rey extends Carta {
	
	public Rey(Palos palo){
		this.palo = palo;
		this.numero = 12;
		this.prioridad = 8;
	}
}

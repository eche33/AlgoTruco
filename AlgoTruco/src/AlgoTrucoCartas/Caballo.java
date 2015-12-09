package AlgoTrucoCartas;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;

public class Caballo extends Carta {
	
	public Caballo(Palos palo){
		this.palo = palo;
		this.numero = 11;
		this.prioridad = 9;
	}
}

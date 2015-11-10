package AlgoTrucoClases;

import java.util.ArrayList;

public class Mano {

	private ArrayList<Carta> cartas;

	public Mano(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public int cantidadDeCartas() {
		return (this.cartas.size());
	}

}

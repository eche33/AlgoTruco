package AlgoTrucoClases;

import java.util.ArrayList;

public class Mesa {

	private ArrayList<Carta> cartasTiradas;

	public Mesa() {
		this.cartasTiradas = new ArrayList<Carta>();
	}

	public void tirarCarta(Carta carta) {
		cartasTiradas.add(carta);

	}

}

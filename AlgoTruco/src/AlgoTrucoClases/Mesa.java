package AlgoTrucoClases;

import java.util.ArrayList;

public class Mesa {

	private ArrayList<Carta> cartasTiradas;
	private ArrayList<Jugador> jugadores;

	public Mesa(){
		this.cartasTiradas = new ArrayList<Carta>();
	}

	public void tirarCarta(Carta carta, Jugador jugador){
		this.cartasTiradas.add(carta);
		this.jugadores.add(jugador);
	}

	public ArrayList<Carta> obtenerCartasEnMesa(){
		return (this.cartasTiradas);
	}

	public Jugador obtenerJugadorQueTiroCartaMasAlta(){
		int indicefinal;

		for (Carta carta1 : cartasTiradas){
			for (Carta carta2 : cartasTiradas){
				if (carta1.jugarContra(carta2) > 0){
					indicefinal = cartasTiradas.indexOf(carta1);
				}
				else indicefinal
			}
		}

		return jugadores.get(indicefinal);
	}


}

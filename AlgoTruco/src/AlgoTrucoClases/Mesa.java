package AlgoTrucoClases;

import java.util.ArrayList;

public class Mesa {

	private ArrayList<Carta> cartasTiradas;
	private ArrayList<Jugador> jugadores;

	public Mesa(){
		this.cartasTiradas = new ArrayList<Carta>();
		this.jugadores = new ArrayList<Jugador>();
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
		boolean parda = true;
		Carta cartaAlta = cartasTiradas.get(0);

		/*for (Carta carta1 : cartasTiradas){
		if (carta1.jugarContra(cartaAlta) > 0){
			cartaAlta = carta1;
			parda = false;
		}
		if (carta1.jugarContra(cartaAlta) == 0){
			parda = true;
		}
	}
	if (parda){
		return null;
	}*/
		int posicion = 0;
		for (int i=0; i<this.cartasTiradas.size(); i++){
			Carta cartaActual = cartasTiradas.get(i);
			if(cartaActual.jugarContra(cartaAlta)>0){
				cartaAlta = cartaActual;
				parda = false;
				posicion = i;
			}else{
				if(cartaActual.jugarContra(cartaAlta)==0){
					parda = true;
				}
			}
		}

		return jugadores.get(posicion);
	}


}

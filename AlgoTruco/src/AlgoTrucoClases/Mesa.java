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
		boolean parda = true;
		Jugador jugador = null;
		
		if ( !this.cartasTiradas.isEmpty() ){
			
			Carta cartaAlta = this.cartasTiradas.get(0);
			int posicion = 0;
			for (int i=0; i<this.cartasTiradas.size(); i++){
				Carta cartaActual = this.cartasTiradas.get(i);
				if(cartaActual.jugarContra(cartaAlta)>0){
					cartaAlta = cartaActual;
					parda = false;
					posicion = i;
				}else{
					if(cartaActual.jugarContra(cartaAlta)==0)
						parda = true;
				}
			}
			jugador = jugadores.get(posicion);
			if (parda)
				jugador = null;
		}	
		return jugador;
	}


}

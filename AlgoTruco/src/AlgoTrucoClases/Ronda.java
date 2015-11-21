package AlgoTrucoClases;

import java.util.ArrayList;

public class Ronda {

	private int numeroVuelta; // por si alguno quiere cantar el envido debe estar en la primera vuelta
	private Equipo equipo1;
	private Equipo equipo2;
	private Mazo mazo;
	private ArrayList<Jugador> jugadoresOrdenados;//ordenados de acuerdo a quien comienza la vuelta 1
	private Mesa mesa;
	private Cantos cantoActual;
	private Tantos tantoActual;

	public Ronda(Equipo equipo1, Equipo equipo2, ArrayList<Jugador> jugadoresOrdenados) {
		this.numeroVuelta = 1;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.jugadoresOrdenados = jugadoresOrdenados;
		this.mesa = new Mesa();
	}

	private void repartirCartas() {
		ArrayList<Mano> manosARepartir = mazo.repartirXCantidadDeManos(jugadoresOrdenados.size());

		for(int i=0 ; i<jugadoresOrdenados.size(); i++){
			jugadoresOrdenados.get(i).asignarMano(manosARepartir.get(i));
		}
	}

	private void ordenarTurnos(Jugador jugadorQueTiroCartaMasAlta) {
		ArrayList<Jugador> nuevoOrden = new ArrayList<Jugador>();
		int posicion = 100;

		for(int i = 0; i< this.jugadoresOrdenados.size(); i++){
			Jugador jugadorActual = (this.jugadoresOrdenados.get(i));

			if (jugadorActual.obtenerNombre() == jugadorQueTiroCartaMasAlta.obtenerNombre()){
				nuevoOrden.add(jugadorActual);
				posicion = i;
			}
			
			else {										// SIN EL ELSE AGREGARÍA DOS VECES AL QUE GANÓ LA RONDA.
				if(posicion != 100){
					nuevoOrden.add(jugadorActual);
				}
			}
		}
		for(int i=0 ; i<posicion ; i++){
			nuevoOrden.add(jugadoresOrdenados.get(i));
		}
		this.jugadoresOrdenados = nuevoOrden;
   }

	public void iniciar() {
		this.repartirCartas();
		
		for(int i = 0; i<3 ; i++){
			if(! this.rondaFinalizada()){ //puede terminarse en cualquier momento de una vuelta
				Vuelta vuelta = new Vuelta(this);
				this.numeroVuelta += 1;
				this.ordenarTurnos(vuelta.obtenerJugadorQueTiroCartaMasALta());
			}
		}
	}

	private boolean rondaFinalizada() {
		if (this.numeroVuelta > 3){ 		// ANTES ERA numeroVuelta == 3, POR LO QUE JUGARÍA 2 MANOS SOLAS.	
			return true;
		}
		if (( this.equipo1.ganoPartida()) || (this.equipo2.ganoPartida())){
			return true;
		}
		//contemplar que se ganó antes de la 3era vuelta o alguno se fue al mazo.
		return false;
	}

	public ArrayList<Jugador> obtenerJugadoresOrdenados() {
		return (this.jugadoresOrdenados);
	}

	public Mesa obtenerMesa() {
		return (this.mesa);
	}

	public void irse(Equipo equipo) {
		// DEBERÍA CORTAR LA PARTIDA (PODRÍA HABER UNA VARIABLE QUE rondaFinalizada CHEQUEE POR TRUE).
		// TAMBIÉN PODRÍA LLAMAR A UN MÉTODO DE SUMAR PUNTOS POR EQUIPO, EN BASE AL ATRIBUTO cantoActual.
		
	}

}
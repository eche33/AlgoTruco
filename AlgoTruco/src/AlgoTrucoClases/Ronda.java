package AlgoTrucoClases;

import java.util.ArrayList;

public class Ronda {

	int numeroVuelta; // por si alguno quiere cantar el envido debe estar en la primera vuelta
	Equipo equipo1;
	Equipo equipo2;
	Mazo mazo;
	private ArrayList<Jugador> jugadoresOrdenados;//ordenados de acuerdo a quien comienza la vuelta 1

	public Ronda(Equipo equipo1, Equipo equipo2, ArrayList<Jugador> jugadoresOrdenados) {


		this.numeroVuelta = 1;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.jugadoresOrdenados = jugadoresOrdenados;

	}



	private void repartirCartas() {
		  Mazo mazo = new Mazo();

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

		   if(posicion != 100){
		    nuevoOrden.add(jugadorActual);
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

		     Vuelta vuelta = new Vuelta(this.numeroVuelta,this.equipo1, this.equipo2);
		     this.numeroVuelta += 1;
		    }

		   }

	}


	private boolean rondaFinalizada() {
		if (this.vuelta == 3){
			return true;
		}
		if (( this.equipo1.gano()) || (this.equipo2.gano())){
			return true;
		}
		//contemplar que se ganó antes de la 3era vuelta o alguno se fue al mazo.


		return false;
	}

}
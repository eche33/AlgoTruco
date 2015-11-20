package AlgoTrucoClases;

import java.util.ArrayList;

public class Ronda {

	int numeroVuelta; // por si alguno quiere cantar el envido debe estar en la primera vuelta
	Equipo equipo1;
	Equipo equipo2;
	Mazo mazo;
	private ArrayList<Jugador> jugadoresOrdenados;

	public Ronda(Equipo equipo1, Equipo equipo2, ArrayList<Jugador> jugadoresOrdenados) {


		this.numeroVuelta = 1;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.jugadoresOrdenados = jugadoresOrdenados;
		this.repartirCartas(equipo1, equipo2);

	}



	private void repartirCartas(Equipo equipo12, Equipo equipo2) {
		// TODO Auto-generated method stub

	}



	private ArrayList<Jugador> ordenarTurnos(Equipo equipo1, Equipo equipo2) {
		//mergear
		return null;
	}

	public void iniciar() {

		while(! this.rondaFinalizada()){

			for(int i=0; i< jugadoresOrdenadosPorTurno.size(); i++){
				this.jugadoresOrdenadosPorTurno = this.ordenarTurnos(equipo1,equipo2);
				if(! this.rondaFinalizada()){ //puede terminarse en cualquier momento de una vuelta
					Vuelta vuelta = new Vuelta(this.numeroVuelta,this.equipo1, this.equipo2);

					jugadoresOrdenadosPorTurno.get(i).jugar(this);
				}

			}
			vuelta += 1;

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
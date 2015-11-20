package AlgoTrucoClases;

import java.util.ArrayList;

public class Vuelta {

	private ArrayList<Jugador> jugadoresOrdenados;
	int numeroVuelta; // por si alguno quiere cantar el envido debe estar en la primera vuelta
	Equipo equipo1;
	Equipo equipo2;


	public void iniciar(){

		this.ordenarJugadores();
		for(int i = 1; i<this.jugadoresOrdenados.size(); i++){
			jugadoresOrdenados.get(i).jugar(this);
		}
	}

}

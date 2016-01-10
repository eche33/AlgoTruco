package AlgoTrucoClases;

import java.util.ArrayList;

public class Partida {

	private static Partida partida = null;
	protected Equipo equipo1;
	protected Equipo equipo2;
	private Ronda rondaActual;

	
	public Partida(Equipo equipo1, Equipo equipo2){
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	
	public void iniciarPartida(){
		while( ! this.hayGanador()){
			this.rondaActual = new Ronda(this.equipo1,this.equipo2);
			rondaActual.iniciar();
			this.cambiarMano();
		}
	}

	private void cambiarMano(){
	// Quiz�s convenga pasar como par�metro la lista de turnos, para facilitar el cambio de turnos. El problema es que eso
	// tornar�a horrible los c�digos de las pruebas por no usar la partida y tener que hacer las listas de turnos. De esta
	// manera, si arma los turnos Ronda, con pasarle s�lo los 2 equipos ya est�.
	/* EL C�DIGO AC� ABAJO FUNCIONA, PERO PUEDEN DARSE CUENTA DE QUE ES HORRIBLE. */
		ArrayList<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
		for (int i = 0; i < this.equipo1.obtenerCantidadDeJugadores(); i++){
			jugadoresOrdenados.add(this.equipo1.obtenerJugador(i));
			jugadoresOrdenados.add(this.equipo2.obtenerJugador(i));
		}
		for (int i = 0; i < (this.equipo1.obtenerCantidadDeJugadores()*2); i++){
			if (jugadoresOrdenados.get(i).esMano()){
				jugadoresOrdenados.get(i).setearNoEsMano();
				if (i == 5){
					jugadoresOrdenados.get(0).setearEsMano();
				} else jugadoresOrdenados.get(i + 1).setearEsMano();
			}
		}
	}

	public boolean hayGanador(){
		return((this.equipo1.ganoPartida())||(this.equipo2.ganoPartida()));
	}


	public Equipo obtenerEquipo(int i) {
		if (i == 1){
			return this.equipo1;
		}
		return this.equipo2;
		
	}


	public Jugador obtenerJugadorActual() {
		return this.rondaActual.obtenerJugadorActual();
	}




	public Equipo obtenerEquipoJugando() {
		
		return this.rondaActual.obtenerEquipoJugando();
	}

}
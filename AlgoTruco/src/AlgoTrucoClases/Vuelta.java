package AlgoTrucoClases;

import java.util.Iterator;

public class Vuelta {

	private boolean vueltaEnCurso;
	private Ronda ronda;
	private Mesa mesa;
	private Jugador jugadorActual;

	public Vuelta(Ronda ronda){
		this.ronda = ronda;
		this.vueltaEnCurso = true;
		this.mesa = new Mesa();
	}


	public Mesa obtenerMesa(){
		return (this.mesa);
	}

	/*public void iniciar(){

		for(int i = 1; i<this.ronda.obtenerJugadoresOrdenados().size(); i++){
			if(vueltaEnCurso){
				this.ronda.obtenerJugadoresOrdenados().get(i).jugar(this);
			}
		}
	}*/

	public Jugador obtenerJugadorQueTiroCartaMasALta(){
		return (this.mesa.obtenerJugadorQueTiroCartaMasAlta());
	}

	public boolean estaEnCurso(){ //Chequear que no se haya ganado la ronda.
		return (this.vueltaEnCurso);
	}

	public int jugar(){

		Iterator<Jugador> iteradorDeJugadores = this.ronda.obtenerJugadoresOrdenados().iterator();
		while ((iteradorDeJugadores.hasNext())&&(this.estaEnCurso())){
			this.jugadorActual = iteradorDeJugadores.next();
			this.jugadorActual.jugar(this);
		}
		if (this.obtenerJugadorQueTiroCartaMasALta().obtenerEquipo().equals(this.ronda.obtenerEquipo1())){
			return 1;
		}
		if (this.obtenerJugadorQueTiroCartaMasALta().obtenerEquipo().equals(this.ronda.obtenerEquipo2())){
			return -1;
		}
		return 0;
	}

	public Ronda obtenerRonda(){
		return this.ronda;
	}

	public Equipo obtenerEquipoRival(Equipo equipo){
		return this.ronda.obtenerEquipoRival(equipo);
	}


	public Jugador obtenerJugadorActual() {
		return this.jugadorActual;
	}


	public Equipo obtenerEquipoJugando() {
		
		return this.jugadorActual.obtenerEquipo();
	}


}
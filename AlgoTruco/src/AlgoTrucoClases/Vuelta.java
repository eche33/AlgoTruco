package AlgoTrucoClases;

import java.util.Iterator;

public class Vuelta {

	private Jugador jugadorQueTiroLaCartaMasAlta;
	private boolean vueltaEnCurso;
	private Ronda ronda;


	public Vuelta(Ronda ronda){
		this.ronda = ronda;
		this.jugadorQueTiroLaCartaMasAlta = null;
		this.vueltaEnCurso = true;
	}

	public void iniciar(){

		for(int i = 1; i<this.ronda.obtenerJugadoresOrdenados().size(); i++){
			if(vueltaEnCurso){
				this.ronda.obtenerJugadoresOrdenados().get(i).jugar(this);
			}
		}
	}

	public Jugador obtenerJugadorQueTiroCartaMasALta(){
		return (this.jugadorQueTiroLaCartaMasAlta);
	}

	public Mesa obtenerMesa(){
		return (this.ronda.obtenerMesa());
	}

	public boolean estaEnCurso(){ //Chequear que no se haya ganado la ronda.
		return (this.vueltaEnCurso);
	}

	public int jugar(){

		Iterator<Jugador> iteradorDeJugadores = this.ronda.obtenerJugadoresOrdenados().iterator();
		while ((iteradorDeJugadores.hasNext())&&(this.estaEnCurso())){
			iteradorDeJugadores.next().jugar(this);
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


}



package AlgoTrucoClases;

import java.util.ArrayList;

public class Vuelta {

	private Jugador jugadorQueTiroLaCartaMasAlta;
	private boolean vueltaEnCurso;
	private Ronda ronda;
	//private Tantos tantoActual;


	public Vuelta(Ronda ronda) {
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

	public void envidoCantado() {
		this.cantoEnvidoPendiente = true;
	}

	public Jugador obtenerJugadorQueTiroCartaMasALta() {
		return (this.jugadorQueTiroLaCartaMasAlta);
	}

	public Mesa obtenerMesa() {
		return (this.ronda.obtenerMesa());
	}

}

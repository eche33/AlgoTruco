package AlgoTrucoClases;

import java.util.ArrayList;

public class Equipo{

	private ArrayList<Jugador> jugadores;
	public int puntajeDeEquipo;
	public boolean quiero;

	
	public Equipo(){
			this.jugadores = new ArrayList<Jugador>();
			this.puntajeDeEquipo = 0;
			this.quiero = true;
		}
	
	public void agregarJugadorAEquipo(Jugador jugadorNuevo){
		this.jugadores.add(jugadorNuevo);
		jugadorNuevo.asignarEquipo(this);
	}
	

	public Equipo(Jugador jugador1){
	// Constructor de equipo de sólo un jugador.
		jugador1.asignarEquipo(this);
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(jugador1);
		this.puntajeDeEquipo = 0;
		this.quiero = true;
	}

	public Equipo(Jugador jugador1, Jugador jugador2){
	// Constructor de equipo de dos jugadores.
		jugador1.asignarEquipo(this);
		jugador2.asignarEquipo(this);
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(jugador1);
		this.jugadores.add(jugador2);
		this.puntajeDeEquipo = 0;
		this.quiero = true;
	}

	public Equipo(Jugador jugador1, Jugador jugador2, Jugador jugador3){
	// Constructor de equipo de tres jugadores.
		jugador1.asignarEquipo(this);
		jugador2.asignarEquipo(this);
		jugador3.asignarEquipo(this);
		this.jugadores = new ArrayList<Jugador>();
		this.jugadores.add(jugador1);
		this.jugadores.add(jugador2);
		this.jugadores.add(jugador3);
		this.puntajeDeEquipo = 0;
		this.quiero = true;
	}


	public int obtenerPuntaje(){
		return (this.puntajeDeEquipo);
	}

	public Jugador obtenerJugador(int indice){
		return (this.jugadores.get(indice));
	}

	public boolean ganoPartida(){
		return (this.obtenerPuntaje() >= 30);
	}

	public void sumarPuntos(int nuevosPuntos){
		(this.puntajeDeEquipo) += nuevosPuntos;
	}

	public boolean devolverQuiero(){
		return this.quiero;
	}

	public void tieneQuiero(){
		this.quiero = true;
	}

	public void noTieneQuiero(){
		this.quiero = false;
	}

	public void irse(Ronda unaRonda){
		unaRonda.irse(this);
	}

	public boolean responderTruco(Vuelta vuelta){
		return (this.jugadores.get(0).responderTruco(vuelta));
	}

	public boolean responderRetruco(Vuelta vuelta){
		return (this.jugadores.get(0).responderRetruco(vuelta));
	}

	public boolean responderValeCuatro(Vuelta vuelta){
		return (this.jugadores.get(0).responderValeCuatro(vuelta));
	}

	public boolean responderEnvido(Vuelta vuelta){
		return (this.jugadores.get(0).responderEnvido(vuelta));
	}

	/*public void sumarPuntosTanto(Ronda ronda){
		int puntajeSumar = 0;

		if (ronda.obtenerTantoActual() == null){
			puntajeSumar = 1;
		}
		else {
				switch(ronda.obtenerTantoActual()){
				case ENVIDO: puntajeSumar = 2;
							 break;
				case ENVIDOENVIDO: puntajeSumar = 4;
								   break;
				case REALENVIDO: puntajeSumar = 3;
								 break;
				case FALTAENVIDO: puntajeSumar = this.calculoFaltaEnvido(ronda.obtenerEquipoRival(this));
								  break;
				case ENVIDOENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaEnvido(ronda.obtenerEquipoRival(this));
											  break;
				case ENVIDOENVIDOREALENVIDO: puntajeSumar = 7;
											 break;
				case ENVIDOENVIDOREALENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaEnvido(ronda.obtenerEquipoRival(this));
														break;
				case ENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaEnvido(ronda.obtenerEquipoRival(this));
										break;
				case ENVIDOREALENVIDO: puntajeSumar = 5;
									   break;
				case ENVIDOREALENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaEnvido(ronda.obtenerEquipoRival(this));
												  break;
				case REALENVIDOFALTAENVIDO: puntajeSumar = this.calculoFaltaEnvido(ronda.obtenerEquipoRival(this));
											break;
			}
		}
		this.sumarPuntos(puntajeSumar);
	}*/


	public int obtenerCantidadDeJugadores(){
		return (this.jugadores.size());
	}

	public boolean responderRealEnvido(Vuelta vuelta) {
		return (this.jugadores.get(0).responderRealEnvido(vuelta));
	}

	public boolean responderFaltaEnvido(Vuelta vuelta) {
		return (this.jugadores.get(0).responderFaltaEnvido(vuelta));
	}

	public boolean decidirFlor(Vuelta vuelta) {
		return (this.jugadores.get(0).decidirFlor(vuelta));
	}

	public boolean responderFlor(Vuelta vuelta) {
		return (this.jugadores.get(0).responderFlor(vuelta));
	}

	/*public void sumarPuntosFlor(Ronda unaRonda) {
		int puntajeSumar = 0;

		if (unaRonda.obtenerFlorActual() == null){
			puntajeSumar = 3;
		}
		else {
			switch(unaRonda.obtenerFlorActual()){
			case FLOR: puntajeSumar = 4;
					break;
			case CONTRAFLOR: puntajeSumar = 6;
					break;
			case CONTRAFLORALRESTO: puntajeSumar = this.calculoFaltaEnvido(unaRonda.obtenerEquipoRival(this));
					break;
			}
		}
		this.sumarPuntos(puntajeSumar);

	}*/

	public boolean responderContraFlorAlResto(Vuelta vuelta) {
		return(this.jugadores.get(0).responderContraFlorAlResto(vuelta));
	}

	public boolean responderEnvidoEnvido(Vuelta vuelta) {
		return(this.jugadores.get(0).responderEnvidoEnvido(vuelta));
	}

	public boolean responderEnvidoEnvidoRealEnvido(Vuelta vuelta) {
		return(this.jugadores.get(0).responderEnvidoEnvidoRealEnvido(vuelta));
	}

	public boolean responderEnvidoRealEnvido(Vuelta vuelta) {
		return(this.jugadores.get(0).responderEnvidoRealEnvido(vuelta));
	}


/** Igual que en otras clases, hay un método que sólo hicimos para probarse, como que no se usa en ninguna parte del
 *  código. Lo dejo comentado (tanto como su prueba), para tenerlo archivado.
 *
 *  public int obtenerCantidadDeJugadores(){
		return (this.jugadores.size());
	}
 *
 *
 *  Este otro método de acá abajo habíamos hablado de usarlo pero pensado en un principio para sumar todos los puntos al
 *  final de la ronda. Como ahora sumamos los puntos del envido ni bien lo jugamos y quedan sólo los del truco para
 *  después, creo que queda al pedo. Por las dudas lo dejo acá:
 *
 *  public void actualizarPuntos(){
		this.puntajeDeEquipo += this.puntosDeRonda;
		this.puntosDeRonda = 0;
	}
 *
 */

}

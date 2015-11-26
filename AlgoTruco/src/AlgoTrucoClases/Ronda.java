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
		this.equipo1.tieneQuiero();
		this.equipo2.tieneQuiero();
		this.jugadoresOrdenados = jugadoresOrdenados;
		this.mesa = new Mesa();
		this.cantoActual = null;
		this.tantoActual = null;
	}

	private void repartirCartas() {
		ArrayList<Mano> manosARepartir = mazo.repartirXCantidadDeManos(jugadoresOrdenados.size());

		for(int i=0 ; i<jugadoresOrdenados.size(); i++){
			jugadoresOrdenados.get(i).asignarMano(manosARepartir.get(i));
		}
	}

	public void ordenarTurnos(Jugador jugadorQueTiroCartaMasAlta) {
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
				vuelta.jugar();
				this.numeroVuelta += 1;
				this.ordenarTurnos(vuelta.obtenerJugadorQueTiroCartaMasALta());
			}
		}
		this.equipo1.actualizarPuntos();
		this.equipo2.actualizarPuntos();
	}

	private boolean rondaFinalizada() {
		if (this.numeroVuelta > 3){ 		// ANTES ERA numeroVuelta == 3, POR LO QUE JUGARÍA 2 MANOS SOLAS.
			return true;
		}
		if (( this.equipo1.ganoPartida()) || (this.equipo2.ganoPartida())){
			return true;
		}
		//contemplar que se ganó antes de la 3era vuelta o alguno se fue al mazo.
		if (this.equipo1==null || this.equipo2==null){
			return true;
		}
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

	public Equipo obtenerEquipo1() {
		return (this.equipo1);
	}

	public Equipo obtenerEquipo2() {
		return (this.equipo2);
	}

	public Equipo obtenerEquipoRival(Equipo equipo) {
		if (equipo.equals(equipo1)){
			return equipo2;
		}
		return equipo1;
	}

	public void setearTruco() {
		if (this.cantoActual == null){
			this.cantoActual = Cantos.TRUCO;
		}
	}

	public void setearRetruco() {
		if (this.cantoActual == Cantos.TRUCO){
			this.cantoActual = Cantos.RETRUCO;
		}
	}

	public void setearValeCuatro() {
		if (this.cantoActual == Cantos.RETRUCO){
			this.cantoActual = Cantos.VALECUATRO;
		}
	}

	public void setearEnvido() {
		if (this.tantoActual == null){
			this.tantoActual = Tantos.ENVIDO;
		}else{
			if(this.tantoActual == Tantos.ENVIDO){
				this.tantoActual = Tantos.ENVIDOENVIDO;
			}
		}

	}

	public boolean cantadoEnvidoEnvido() {
		if (this.tantoActual == Tantos.ENVIDOENVIDO){
			return true;
		}
		return false;
	}

	public Tantos obtenerTantoActual() {
		return (this.tantoActual);
	}

	public void setearRealEnvido() {
		if (this.tantoActual==null){
			this.tantoActual = Tantos.REALENVIDO;
		}else{
			if(this.tantoActual==Tantos.ENVIDO){
				this.tantoActual = Tantos.ENVIDOREALENVIDO;
			}else{
				if(this.tantoActual==Tantos.ENVIDOENVIDO){
					this.tantoActual = Tantos.ENVIDOENVIDOREALENVIDO;
				}
			}
		}

	}

	public void setearFaltaEnvido() {
		if (!(this.tantoActual == Tantos.FALTAENVIDO)){
			this.tantoActual = Tantos.FALTAENVIDO;
		}

	}

	public int obtenerNumeroDeVuelta() {
		return (this.numeroVuelta);
	}

	public void jugarTantos() {
		int envidoGanador = 0;
		Equipo equipoGanador = null;
		for(int i=0; i<this.jugadoresOrdenados.size(); i++){
			Jugador jugadorActual = this.jugadoresOrdenados.get(i);
			if(jugadorActual.obtenerEnvido()>envidoGanador){
				envidoGanador = jugadorActual.obtenerEnvido();
				equipoGanador = jugadorActual.obtenerEquipo();
			}else{
				if(jugadorActual.obtenerEnvido()==envidoGanador){
					equipoGanador = this.obtenerEquipoMano();
				}
			}
		}
		equipoGanador.sumarPuntosTanto(this);
	}

	private Equipo obtenerEquipoMano() {
		Equipo equipoMano = null;
		for(int i=0; i<this.jugadoresOrdenados.size(); i++){
			Jugador jugadorActual = this.jugadoresOrdenados.get(i);
			if(jugadorActual.esMano()){
				return jugadorActual.obtenerEquipo();
			}
		}
		return equipoMano;
	}

}
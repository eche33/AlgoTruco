package AlgoTrucoClases;

import java.util.ArrayList;

import AlgoTrucoTantos.Envido;
import AlgoTrucoTantos.EnvidoEnvido;
import AlgoTrucoTantos.EnvidoEnvidoRealEnvido;
import AlgoTrucoTantos.EnvidoRealEnvido;
import AlgoTrucoTantos.FaltaEnvido;
import AlgoTrucoTantos.RealEnvido;

public class Ronda {

	private int numeroVuelta; // Porque si alguno quiere cantar el envido debe estar en la primera vuelta.
	private Equipo equipo1;
	private Equipo equipo2;
	private Mazo mazo;
	private ArrayList<Jugador> jugadoresOrdenados; // Ordenados de acuerdo a quien comienza la primera vuelta.
	private Cantos cantoActual;
	private Tanto tantoActual;
	private Flor florActual;
	private int ganadores;


	public Ronda(Equipo equipo1, Equipo equipo2){
		this.numeroVuelta = 1;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.equipo1.tieneQuiero();
		this.equipo2.tieneQuiero();
		this.ordenarPrimeraRonda(equipo1, equipo2);
		this.cantoActual = null;
		this.tantoActual = null;
		this.florActual = null;
		this.ganadores = 0;
	}


	private void ordenarPrimeraRonda(Equipo equipo1, Equipo equipo2){
	// Con este m�todo no hay que pasarle los jugadores ordenados, los ordena solos.
		jugadoresOrdenados = new ArrayList<Jugador>();
		for (int i = 0; i < equipo1.obtenerCantidadDeJugadores(); i++){
			this.jugadoresOrdenados.add(equipo1.obtenerJugador(i));
			this.jugadoresOrdenados.add(equipo2.obtenerJugador(i));
		}
		this.jugadoresOrdenados.get(0).setearEsMano();
	}

	private void repartirCartas(){
		ArrayList<Mano> manosARepartir = this.mazo.repartirVariasManos(jugadoresOrdenados.size());

		for(int i=0 ; i<jugadoresOrdenados.size(); i++){
			jugadoresOrdenados.get(i).asignarMano(manosARepartir.get(i));
		}
	}

	public void ordenarTurnos(Jugador jugadorQueTiroCartaMasAlta){
		ArrayList<Jugador> nuevoOrden = new ArrayList<Jugador>();
		int posicion = 100;

		for(int i = 0; i< this.jugadoresOrdenados.size(); i++){
			Jugador jugadorActual = (this.jugadoresOrdenados.get(i));

			if (jugadorActual.obtenerNombre() == jugadorQueTiroCartaMasAlta.obtenerNombre()){
				nuevoOrden.add(jugadorActual);
				posicion = i;
			}

			else {
				if(posicion != 100){
					nuevoOrden.add(jugadorActual);
				}
			}
		}
		for(int i=0 ; i<posicion ; i++){
			nuevoOrden.add(this.jugadoresOrdenados.get(i));
		}
		this.jugadoresOrdenados = nuevoOrden;
   }

	public void iniciar(){
		this.repartirCartas();

		for(int i = 0; i<3 ; i++){
			if(! this.rondaFinalizada()){ // Puede terminarse en cualquier momento de una vuelta.
				Vuelta vuelta = this.crearNuevaVuelta(this);
				ganadores += vuelta.jugar();
				this.numeroVuelta += 1;
				this.ordenarTurnos(vuelta.obtenerJugadorQueTiroCartaMasALta());
			}
		}
		this.sumarPuntos(equipo1);
		this.sumarPuntos(equipo2);
	}

	public Vuelta crearNuevaVuelta(Ronda ronda) {
		Vuelta nueva = new Vuelta(ronda);
		return nueva;
	}


	public boolean rondaFinalizada(){
		if (this.numeroVuelta > 3){
			return true;
		}
		if ((this.equipo1.ganoPartida()) || (this.equipo2.ganoPartida())){
			return true;
		}
		if (numeroVuelta > 2 && ganadores != 0){
			return true;
		}
		if ((this.equipo1==null) || (this.equipo2==null)){
			return true;
		}
		return false;
	}

	public ArrayList<Jugador> obtenerJugadoresOrdenados(){
		return (this.jugadoresOrdenados);
	}

	public void irse(Equipo equipo){
		if(equipo.equals(this.equipo1)){
			this.equipo1 = null;
		}
		else{
			this.equipo2 = null;
		}
	}

	public Equipo obtenerEquipo1(){
		return (this.equipo1);
	}

	public Equipo obtenerEquipo2(){
		return (this.equipo2);
	}

	public Equipo obtenerEquipoRival(Equipo equipo){
		if (equipo.equals(this.equipo1)){
			return this.equipo2;
		}
		return this.equipo1;
	}

	public void setearTruco(){
		if (this.cantoActual == null){
			this.cantoActual = Cantos.TRUCO;
		}
	}

	public void setearRetruco(){
		if (this.cantoActual == Cantos.TRUCO){
			this.cantoActual = Cantos.RETRUCO;
		}
	}

	public void setearValeCuatro(){
		if (this.cantoActual == Cantos.RETRUCO){
			this.cantoActual = Cantos.VALECUATRO;
		}
	}

	public void setearEnvido(){
		if (this.tantoActual == null){
			this.tantoActual = new Envido();
		}
	}

	public boolean cantadoEnvidoEnvido(){
		if (this.tantoActual.getClass().getSimpleName() == "EnvidoEnvido" ){
			return true;
		}
		return false;
	}

	public Tanto obtenerTantoActual(){
		return (this.tantoActual);
	}

	public void setearRealEnvido(){
		this.tantoActual = new RealEnvido();
	}

	public void setearFaltaEnvido(){
		this.tantoActual = new FaltaEnvido(this.obtenerFaltaEnvido());
	}

	public int obtenerNumeroDeVuelta(){
		return (this.numeroVuelta);
	}

/*	public void jugarTantos(){
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
	}*/

	public Equipo obtenerEquipoMano(){
		Equipo equipoMano = null;
		for(int i=0; i<this.jugadoresOrdenados.size(); i++){
			Jugador jugadorActual = this.jugadoresOrdenados.get(i);
			if(jugadorActual.esMano()){
				return jugadorActual.obtenerEquipo();
			}
		}
		return equipoMano;
	}


	public void setearFlor() {
		if (this.florActual == null){
			florActual = Flor.FLOR;
		}

	}


	public void setearContraFlor() {
		if(this.florActual == Flor.FLOR){
			florActual = Flor.CONTRAFLOR;
		}

	}


	/*public void jugarFlor() {
		int florGanadora = 0;
		Equipo equipoGanador = null;
		for(int i=0; i<this.jugadoresOrdenados.size(); i++){
			Jugador jugadorActual = this.jugadoresOrdenados.get(i);
			if(jugadorActual.obtenerFlor()>florGanadora){
				florGanadora = jugadorActual.obtenerEnvido();
				equipoGanador = jugadorActual.obtenerEquipo();
			}else{
				if(jugadorActual.obtenerFlor()==florGanadora){
					equipoGanador = this.obtenerEquipoMano();
				}
			}
		}
		equipoGanador.sumarPuntosFlor(this);

	}*/


	public Flor obtenerFlorActual() {
		return (this.florActual);
	}


	public void setearContraFlorAlResto() {
		if(this.florActual == Flor.FLOR || this.florActual == Flor.CONTRAFLOR){
			this.florActual = Flor.CONTRAFLORALRESTO;
		}
	}


	public Equipo obtenerEquipoQueVaGanando() {
		Equipo equipoGanador = null;
		if(this.equipo1.obtenerPuntaje() > this.equipo2.obtenerPuntaje()){
			equipoGanador = this.equipo1;
		}else{
			equipoGanador = this.equipo2;
		}
		return (equipoGanador);
	}


	public int obtenerFaltaEnvido() {
		int faltaEnvido = 0;
		if (this.obtenerEquipoQueVaGanando().obtenerPuntaje()<15){ // Esta en las malas.
			faltaEnvido = 15 - this.obtenerEquipoQueVaGanando().obtenerPuntaje();
		}
		else {
			faltaEnvido = 30 - this.obtenerEquipoQueVaGanando().obtenerPuntaje();
		}
		return faltaEnvido;
	}


	public void setearEnvidoEnvido() {
		this.tantoActual = new EnvidoEnvido();

	}


	public void setearEnvidoRealEnvido() {
		this.tantoActual = new EnvidoRealEnvido();

	}


	public void setearEnvidoEnvidoRealEnvido() {
		this.tantoActual = new EnvidoEnvidoRealEnvido();

	}


	public void sumarPuntos(Equipo equipoAiluRodri) {
			if(this.tantoActual.obtenerEquipoGanador(this).equals(equipoAiluRodri)){
				equipoAiluRodri.sumarPuntos(this.tantoActual.obtenerPuntos());
			}
		}
		//Hay que hacer lo mismo con el envido y la flor
		/*La idea seria que este metodo sume al final de la ronda todo lo que se gano el equipo que
		 * le llega como parametro
		 */
	}


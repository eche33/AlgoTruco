package AlgoTrucoClases;

public class Jugador {

	private String nombre;
	private boolean esMano;
	private Mano mano;
	private Equipo equipo;
	private boolean noTiroCarta;

	public Jugador(String nombreDeJugador){

		this.nombre = nombreDeJugador;
		this.esMano = false;
		this.mano = null;
		this.noTiroCarta = true;

	}

	public boolean esMano() {
		return (this.esMano);
	}

	public String obtenerNombre(){
		return (this.nombre);
	}

	public Mano obtenerMano() {
		return (this.mano);
	}

	public void asignarMano(Mano mano) {
		this.mano = mano;

	}

	public int obtenerEnvido() {
		return (this.obtenerMano().obtenerEnvido());
	}

	public int obtenerFlor() {
		return (this.obtenerMano().obtenerFlor());
	}

	public boolean puedoCantarEnvido(int numeroDeVuelta){
		return (numeroDeVuelta == 1);
	}

	public void cantarEnvido(Vuelta vuelta){
		vuelta.envidoCantado();
	}



	public void tirarCarta(Carta carta, Ronda ronda){
		ronda.obtenerMesa().tirarCarta(carta);
		this.mano.borrarCarta(carta);
		this.noTiroCarta = false;

	}

	public void jugar(Ronda ronda) {
		int eleccion;

		while (this.noTiroCarta){

			switch(eleccion){
			case 1: this.cantarEnvido(ronda);
					break;
			case 2: this.cantarTruco(ronda);
					break;
			case 3: this.irse(ronda);
					break;
			case 4: this.tirarCarta(mano.obtenerCarta(0), ronda);
					break;
			case 5: this.tirarCarta(mano.obtenerCarta(1), ronda);
					break;
			case 6: this.tirarCarta(mano.obtenerCarta(2), ronda);
					break;
			case 7: this.cantarFlor(ronda);
					break;
			}
		}
	}


	private void cantarEnvido(Ronda unaRonda){

		if (unaRonda.obtenerEquipoRival(this.equipo).responderEnvido(unaRonda)){
			unaRonda.setearEnvido();
			unaRonda.jugarTantos();
		}
		else {
			equipo.sumarPuntosTanto(unaRonda);
		}
	}

	public boolean responderEnvido(Ronda unaRonda){
		int eleccion=0;

		if (!unaRonda.cantadoEnvidoEnvido()){/**DESACTIVAR BOTON ENVIDO**/}

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		case 2: unaRonda.setearEnvido();
				this.cantarEnvido(unaRonda);
				return true;
		case 3: unaRonda.setearEnvido();
				this.cantarRealEnvido(unaRonda);
				return true;
		case 4: unaRonda.setearEnvido();
				this.cantarFaltaEnvido(unaRonda);
				return true;
		}
		return false;
	}

	private void cantarTruco(Ronda unaRonda){

		if (unaRonda.obtenerEquipoRival(this.equipo).responderTruco(unaRonda)){
			this.equipo.noTieneQuiero();
			unaRonda.setearTruco();
		}
		else {
			unaRonda.obtenerEquipoRival(this.equipo).irse(unaRonda);
		}
	}

	private void cantarRetruco(Ronda unaRonda){

		// CHEQUEAR EL QUIERO, EL ESTADO DEL CANTO Y MANEJAR CON EXCEPCIONES.
		if (unaRonda.obtenerEquipoRival(this.equipo).responderRetruco(unaRonda)){
			this.equipo.noTieneQuiero();
			unaRonda.setearRetruco();
		}
		else {
			unaRonda.obtenerEquipoRival(this.equipo).irse(unaRonda);
		}
	}

	private void cantarValeCuatro(Ronda unaRonda){

		// CHEQUEAR EL QUIERO, EL ESTADO DEL CANTO Y MANEJAR CON EXCEPCIONES.
		if (unaRonda.obtenerEquipoRival(this.equipo).responderValeCuatro(unaRonda)){
			this.equipo.noTieneQuiero();
			unaRonda.setearValeCuatro();
		}
		else {
			unaRonda.obtenerEquipoRival(this.equipo).irse(unaRonda);
		}
	}

/**	private void cantarTruco(Ronda unaRonda){

		switch (unaRonda.obtenerEquipoRival(this.equipo).responderTruco()){
		case QUIERO: this.equipo.noTieneQuiero();
					 unaRonda.setearTruco();
			 		 break;
		  case NOQUIERO: unaRonda.obtenerEquipoRival(this.equipo).irse(unaRonda);
			     	     break;
		  case RETRUCO: equipo.responderRetruco();
					  break;
		}
	}
**/

//	private void cantarFlor(Ronda ronda) {
//		if (ronda.obtenerEquipoRival(this.equipo).aceptarFlor()){
//
//		}
//	}

	public void irse(Ronda unaRonda){
		this.equipo.irse(unaRonda);
	}

	public void asignarEquipo (Equipo equipo){
		this.equipo = equipo;
	}

	public boolean responderTruco(Ronda unaRonda) {
		int eleccion=0;

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		case 2: unaRonda.setearTruco();
				this.cantarRetruco(unaRonda);
				return true;
		}
		return false;
	}

	public boolean responderRetruco(Ronda unaRonda) {
		int eleccion=0;

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		case 2: unaRonda.setearRetruco();
				this.cantarValeCuatro(unaRonda);
				return true;
		}
		return false;
	}

	public boolean responderValeCuatro(Ronda unaRonda) {
		int eleccion=0;

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		}
		return false;
	}
}

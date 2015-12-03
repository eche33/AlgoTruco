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


	public boolean esMano(){
		return (this.esMano);
	}

	public String obtenerNombre(){
		return (this.nombre);
	}

	public Mano obtenerMano(){
		return (this.mano);
	}

	public void asignarMano(Mano mano){
		this.mano = mano;
	}

	public int obtenerEnvido(){
		return (this.obtenerMano().obtenerEnvido());
	}

	public int obtenerFlor(){
		return (this.obtenerMano().obtenerFlor());
	}

	public boolean puedoCantarEnvido(int numeroDeVuelta){
		return (numeroDeVuelta == 1);
	}

	public void tirarCarta(Carta carta, Ronda ronda){
		ronda.obtenerMesa().tirarCarta(carta);
		this.mano.borrarCarta(carta);
		this.noTiroCarta = false;
	}

	public void jugar(Ronda ronda){
		int eleccion=0;

		while (this.noTiroCarta){

			switch(eleccion){
			case 1: try{ //Hay que agregarle el funcionamiento del catch
						this.cantarEnvido(ronda);
						break;
					} catch(NoSePuedeCantarEnvidoError error){};

			case 2: this.cantarTruco(ronda);
					break;
			case 3: this.irse(ronda);
					break;
			case 4: this.tirarCarta(this.mano.obtenerCarta(0), ronda);
					break;
			case 5: this.tirarCarta(this.mano.obtenerCarta(1), ronda);
					break;
			case 6: this.tirarCarta(this.mano.obtenerCarta(2), ronda);
					break;
			case 7: try{
						this.cantarFlor(ronda);
						break;
					}catch(NoSePuedeCantarFlorError error){};
			case 8: try{
						this.cantarRealEnvido(ronda);
						break;
					}catch(NoSePuedeCantarRealEnvidoError error){}
			case 9:try{
						this.cantarFaltaEnvido(ronda);
						break;
					}catch(NoSePuedeCantarFaltaEnvidoError error){}
			}
			}
		}

	private void cantarFlor(Ronda unaRonda) throws NoSePuedeCantarFlorError{

		if(unaRonda.obtenerNumeroDeVuelta()!=1){
			throw new NoSePuedeCantarFlorError();
		}

		if (unaRonda.obtenerEquipoRival(this.equipo).decidirFlor(unaRonda)){
			if(unaRonda.obtenerFlorActual()==Flor.CONTRAFLORALRESTO){
				unaRonda.jugarFlor();
			}else{
				unaRonda.setearFlor();
				if(this.equipo.responderFlor(unaRonda)){
				unaRonda.jugarFlor();
				}else{
					this.equipo.sumarPuntosFlor(unaRonda);

				}
			}
		}else {
			this.equipo.sumarPuntosFlor(unaRonda);
		}
	}

	private void cantarEnvido(Ronda unaRonda) throws NoSePuedeCantarEnvidoError{

		if(unaRonda.obtenerNumeroDeVuelta()!=1){
			throw new NoSePuedeCantarEnvidoError();
		}

		if (unaRonda.obtenerEquipoRival(this.equipo).responderEnvido(unaRonda)){
			unaRonda.setearEnvido();
			unaRonda.jugarTantos();
		}
		else {
			this.equipo.sumarPuntosTanto(unaRonda);
		}
	}

	private void cantarFaltaEnvido(Ronda unaRonda) throws NoSePuedeCantarFaltaEnvidoError{
		if(unaRonda.obtenerNumeroDeVuelta()!=1){
			throw new NoSePuedeCantarFaltaEnvidoError();
		}

		if (unaRonda.obtenerEquipoRival(this.equipo).responderFaltaEnvido(unaRonda)){
			unaRonda.setearFaltaEnvido();
			unaRonda.jugarTantos();
		}
		else {
			this.equipo.sumarPuntosTanto(unaRonda);
		}
	}

	private void cantarRealEnvido(Ronda unaRonda) throws NoSePuedeCantarRealEnvidoError{
		if(unaRonda.obtenerNumeroDeVuelta()!=1){
			throw new NoSePuedeCantarRealEnvidoError();
		}

		if (unaRonda.obtenerEquipoRival(this.equipo).responderRealEnvido(unaRonda)){
			unaRonda.setearRealEnvido();
			unaRonda.jugarTantos();
		}
		else {
			this.equipo.sumarPuntosTanto(unaRonda);
		}
	}


	public boolean responderEnvido(Ronda unaRonda){
		int eleccion=0;

		if (!unaRonda.cantadoEnvidoEnvido()){/**DESACTIVAR BOTON ENVIDO**/}

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		case 2: try{ //Codear el catch
					unaRonda.setearEnvido();
					this.cantarEnvido(unaRonda);
					return true;
				} catch (NoSePuedeCantarEnvidoError error){}
		case 3: try{
					unaRonda.setearEnvido();
					this.cantarRealEnvido(unaRonda);
					return true;
				}catch (NoSePuedeCantarRealEnvidoError error){}
		case 4: try{
				unaRonda.setearEnvido();
				this.cantarFaltaEnvido(unaRonda);
				return true;
				}catch (NoSePuedeCantarFaltaEnvidoError error){}
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
		// Chequear el quiero, el estado del canto y manejar con excepciones.
		if (unaRonda.obtenerEquipoRival(this.equipo).responderRetruco(unaRonda)){
			this.equipo.noTieneQuiero();
			unaRonda.setearRetruco();
		}
		else {
			unaRonda.obtenerEquipoRival(this.equipo).irse(unaRonda);
		}
	}

	private void cantarValeCuatro(Ronda unaRonda){

		// Chequear el quiero, el estado del canto y manejar con excepciones.
		if (unaRonda.obtenerEquipoRival(this.equipo).responderValeCuatro(unaRonda)){
			this.equipo.noTieneQuiero();
			unaRonda.setearValeCuatro();
		}
		else {
			unaRonda.obtenerEquipoRival(this.equipo).irse(unaRonda);
		}
	}

	public void irse(Ronda unaRonda){
		this.equipo.irse(unaRonda);
	}

	public void asignarEquipo (Equipo equipo){
		this.equipo = equipo;
	}

	public boolean responderTruco(Ronda unaRonda){
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

	public boolean responderRetruco(Ronda unaRonda){
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

	public boolean responderValeCuatro(Ronda unaRonda){
		int eleccion=0;

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		}
		return false;
	}

	public Equipo obtenerEquipo(){
		return (this.equipo);
	}

	public void setearEsMano(){
		this.esMano = true;
	}

	public void setearNoEsMano(){
		this.esMano = false;
	}


	public boolean responderRealEnvido(Ronda unaRonda) {
		int eleccion=0;

		switch (eleccion){
		case 0: return true;//Quiero
		case 1: return false;//No quiero
		case 2: try{				//Falta envido
				unaRonda.setearRealEnvido();
				this.cantarFaltaEnvido(unaRonda);
				return true;
				}catch (NoSePuedeCantarFaltaEnvidoError error){}
		}
		return false;
	}


	public boolean responderFaltaEnvido(Ronda unaRonda) {
		int eleccion=0;

		switch (eleccion){
		case 0: return true;//Quiero
		case 1: return false;//No quiero
		}
		return false;
	}


	public boolean decidirFlor(Ronda unaRonda) {
		int eleccion = 0;

		switch(eleccion){
		case 0: return false;//No tiene flor
		case 1: return true;//ContraFlor
		case 2: this.cantarContraFlorAlResto(unaRonda);
				return true;
		}
		return false;
	}


	private void cantarContraFlorAlResto(Ronda unaRonda) {
		if (unaRonda.obtenerEquipoRival(this.equipo).responderContraFlorAlResto(unaRonda)){
			unaRonda.setearContraFlorAlResto();
		}

	}


	public boolean responderFlor(Ronda unaRonda) {
		int eleccion = 0;

		switch(eleccion){
		case 0: unaRonda.setearContraFlor();
				return true; //Quiero
		case 1: return false; //No quiero
		case 2: this.cantarContraFlorAlResto(unaRonda);
				return true;
		}
		return false;
	}


	public boolean responderContraFlorAlResto(Ronda unaRonda) {
		int eleccion = 0;

		switch(eleccion){
		case 1: return true;//Quiero
		case 2: return false;//No quiero
		}
		return false;
	}
	}



package AlgoTrucoClases;

import AlgoTrucoErrores.NoSePuedeCantarEnvidoError;
import AlgoTrucoErrores.NoSePuedeCantarFaltaEnvidoError;
import AlgoTrucoErrores.NoSePuedeCantarFlorError;
import AlgoTrucoErrores.NoSePuedeCantarRealEnvidoError;
import Vista.MainApp;

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

	private void tirarCarta(Carta carta, Vuelta vuelta){
		vuelta.obtenerMesa().tirarCarta(carta, this);
		this.mano.borrarCarta(carta);
		this.noTiroCarta = false;
	}

	public void jugar(Vuelta vuelta){
		
		MainApp.jugando = (this);
		MainApp.vuelta = vuelta;
		
		int eleccion = 0;

		while (this.noTiroCarta){

			switch(eleccion){
			
			case 1: try{ //Hay que agregarle el funcionamiento del catch
						this.cantarEnvido(vuelta);
						break;
					} catch(NoSePuedeCantarEnvidoError error){};

			case 2: this.cantarJuego(vuelta);
					break;
			case 3: this.irse(vuelta);
					break;
			case 4: this.tirarPrimerCarta(vuelta);
					break;
			case 5: this.tirarSegundaCarta(vuelta);
					break;
			case 6: this.tirarTercerCarta(vuelta);
					break;
			case 7: try{
						this.cantarFlor(vuelta);
						break;
					}catch(NoSePuedeCantarFlorError error){};
			case 8: try{
						this.cantarRealEnvido(vuelta);
						break;
					}catch(NoSePuedeCantarRealEnvidoError error){}
			case 9:try{
						this.cantarFaltaEnvido(vuelta);
						break;
					}catch(NoSePuedeCantarFaltaEnvidoError error){}
			}
		}
	}

	private void cantarJuego(Vuelta vuelta){
		if (!vuelta.obtenerEquipoRival(this.equipo).responderSubirJuego(vuelta)){
			vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).irse(vuelta.obtenerRonda());
		}
	}

	public boolean responderSubirJuego(Vuelta vuelta){
		int eleccion = 0;

		switch (eleccion){
		case 0: vuelta.obtenerRonda().subirCanto();//Quiero
				this.equipo.tieneQuiero();
				vuelta.obtenerEquipoRival(this.equipo).noTieneQuiero();
				return true;
		case 1: return false;//No quiero
		case 2: vuelta.obtenerRonda().subirCanto();//Subir canto
				this.cantarJuego(vuelta);
				return true;
		}
		return false;
	}

	public void tirarTercerCarta(Vuelta vuelta) {
		this.tirarCarta(this.mano.obtenerCarta(2), vuelta);
	}

	public void tirarSegundaCarta(Vuelta vuelta) {
		this.tirarCarta(this.mano.obtenerCarta(1), vuelta);
	}

	public void tirarPrimerCarta(Vuelta vuelta) {
		this.tirarCarta(this.mano.obtenerCarta(0), vuelta);
	}

	public void cantarFlor(Vuelta vuelta) throws NoSePuedeCantarFlorError{

		if((vuelta.obtenerRonda().obtenerNumeroDeVuelta()!=1) || (!this.noTiroCarta)){
			throw new NoSePuedeCantarFlorError();
		}

		if (!vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).decidirFlor(vuelta)){
			vuelta.obtenerRonda().setearFlor(this.obtenerEquipo());
		}
	}

	public void cantarEnvido(Vuelta vuelta) throws NoSePuedeCantarEnvidoError{

		if((vuelta.obtenerRonda().obtenerNumeroDeVuelta()!=1) || (!this.noTiroCarta)){
			throw new NoSePuedeCantarEnvidoError();
		}

		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderEnvido(vuelta)){
			vuelta.obtenerRonda().setearEnvido();
		}else{
			vuelta.obtenerRonda().setearEnvido();
			vuelta.obtenerRonda().obtenerTantoActual().noSeQuiere(this.obtenerEquipo());
		}
	}

	private void cantarFaltaEnvido(Vuelta vuelta) throws NoSePuedeCantarFaltaEnvidoError{
		if((vuelta.obtenerRonda().obtenerNumeroDeVuelta()!=1) || (!this.noTiroCarta)){
			throw new NoSePuedeCantarFaltaEnvidoError();
		}

		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderFaltaEnvido(vuelta)){
			vuelta.obtenerRonda().setearFaltaEnvido();
		}else{
				vuelta.obtenerRonda().setearFaltaEnvido();
				vuelta.obtenerRonda().obtenerTantoActual().noSeQuiere(this.obtenerEquipo());
			}
	}

	private void cantarRealEnvido(Vuelta vuelta) throws NoSePuedeCantarRealEnvidoError{
		if((vuelta.obtenerRonda().obtenerNumeroDeVuelta()!=1) || (!this.noTiroCarta)){
			throw new NoSePuedeCantarRealEnvidoError();
		}

		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderRealEnvido(vuelta)){
			vuelta.obtenerRonda().setearRealEnvido();
		}else{
			vuelta.obtenerRonda().setearRealEnvido();
			vuelta.obtenerRonda().obtenerTantoActual().noSeQuiere(this.obtenerEquipo());
		}
	}


	public boolean responderEnvido(Vuelta vuelta){
		//int eleccion = this.obtenerDecisionEnvido();
		int eleccion = 0;

		if (!vuelta.obtenerRonda().cantadoEnvidoEnvido()){/**DESACTIVAR BOTON ENVIDO**/}

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		case 2: this.cantarEnvidoEnvido(vuelta);
				return true;
		case 3: this.cantarEnvidoRealEnvido(vuelta);
				return true;
		case 4: try{
				this.cantarFaltaEnvido(vuelta);
				return true;
				}catch (NoSePuedeCantarFaltaEnvidoError error){}
		}
		return false;
	}

	private void cantarEnvidoRealEnvido(Vuelta vuelta) {
		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderEnvidoRealEnvido(vuelta)){
			vuelta.obtenerRonda().setearEnvidoRealEnvido();
		}else{
			vuelta.obtenerRonda().setearEnvidoRealEnvido();
			vuelta.obtenerRonda().obtenerTantoActual().noSeQuiere(this.obtenerEquipo());
		}

	}


	private void cantarEnvidoEnvido(Vuelta vuelta) {
		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderEnvidoEnvido(vuelta)){
			vuelta.obtenerRonda().setearEnvidoEnvido();
		}else{
			vuelta.obtenerRonda().setearEnvidoEnvido();
			vuelta.obtenerRonda().obtenerTantoActual().noSeQuiere(this.obtenerEquipo());
		}

	}

	public void irse(Vuelta vuelta){
		this.equipo.irse(vuelta.obtenerRonda());
	}

	public void asignarEquipo (Equipo equipo){
		this.equipo = equipo;
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

	public boolean responderRealEnvido(Vuelta vuelta) {
		int eleccion=0;

		switch (eleccion){
		case 0: this.quieroEnvido();//Quiero
		case 1: return false;//No quiero
		case 2: try{				//Falta envido
				vuelta.obtenerRonda().setearRealEnvido();
				this.cantarFaltaEnvido(vuelta);
				return true;
				}catch (NoSePuedeCantarFaltaEnvidoError error){}
		}
		return false;
	}

	private void quieroEnvido() {
		// TODO Auto-generated method stub
		
	}


	public boolean responderFaltaEnvido(Vuelta vuelta) {
		int eleccion=0;

		switch (eleccion){
		case 0: return true;//Quiero
		case 1: return false;//No quiero
		}
		return false;
	}

	public boolean decidirFlor(Vuelta vuelta) {
		int eleccion = 0;

		switch(eleccion){
		case 0: return false;//No tiene flor
		case 1: this.cantarContraFlor(vuelta);
				return true;
		case 2: this.cantarContraFlorAlResto(vuelta);
				return true;
		}
		return false;
	}

	public void cantarContraFlor(Vuelta vuelta) {
		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderContraFlor(vuelta)){
			vuelta.obtenerRonda().setearContraFlor();
		}else{
			vuelta.obtenerRonda().setearFlorNoquerida(this.obtenerEquipo());
		}

	}


	private void cantarContraFlorAlResto(Vuelta vuelta) {
		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderContraFlorAlResto(vuelta)){
			vuelta.obtenerRonda().setearContraFlorAlResto();
		}else{
			vuelta.obtenerRonda().setearFlorNoquerida(this.obtenerEquipo());
		}
	}

	/*public boolean responderFlor(Vuelta vuelta) {
		int eleccion = 0;

		switch(eleccion){
		case 0: vuelta.obtenerRonda().setearContraFlor();
				return true; //Quiero
		case 1: return false; //No quiero
		case 2: this.cantarContraFlorAlResto(vuelta);
				return true;
		}
		return false;
	}*/

	public boolean responderContraFlorAlResto(Vuelta vuelta) {
		int eleccion = 0;

		switch(eleccion){
		case 1: return true;//Quiero
		case 2: return false;//No quiero
		}
		return false;
	}

	public boolean responderEnvidoEnvido(Vuelta vuelta) {
		int eleccion = 0;
		switch(eleccion){
		case 0: return true;//Quiero
		case 1: return false;//No quiero
		case 2: this.cantarEnvidoEnvidoRealEnvido(vuelta);//Envido envido real envido
		case 3: try{
			this.cantarFaltaEnvido(vuelta);
			return true;
			}catch (NoSePuedeCantarFaltaEnvidoError error){}
		}
		return false;
	}

	private void cantarEnvidoEnvidoRealEnvido(Vuelta vuelta) {
		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderEnvidoEnvidoRealEnvido(vuelta)){
			vuelta.obtenerRonda().setearEnvidoEnvidoRealEnvido();
		}else{
			vuelta.obtenerRonda().setearEnvidoEnvidoRealEnvido();
			vuelta.obtenerRonda().obtenerTantoActual().noSeQuiere(this.obtenerEquipo());
		}

	}

	public boolean responderEnvidoEnvidoRealEnvido(Vuelta vuelta) {
		int eleccion = 0;
		switch(eleccion){
		case 0: return true;//Quiero
		case 1: return false;//No quiero
		case 2: try{
			this.cantarFaltaEnvido(vuelta);
			return true;
			}catch (NoSePuedeCantarFaltaEnvidoError error){}
		}
		return false;
	}

	public boolean responderEnvidoRealEnvido(Vuelta vuelta) {
		int eleccion = 0;
		switch(eleccion){
		case 0: return true;//Quiero
		case 1: return false;//No quiero
		case 2: try{
			this.cantarFaltaEnvido(vuelta);
			return true;
			}catch (NoSePuedeCantarFaltaEnvidoError error){}
		}
		return false;
	}


	public boolean responderContraFlor(Vuelta vuelta) {
		int eleccion = 0;
		switch (eleccion){
		case 0: return true;//Quiero
		case 1: return false;//NoQuiero
		case 2: this.cantarContraFlorAlResto(vuelta);
				return true;
		}
		return false;
	}


//<<<<<<< HEAD
/** M�todos no usados:
=======
	public boolean quieroEnvido() {
		return true;

	}


	public boolean noQuiero() {
		return false;

	}


/** M�todos no usados:
>>>>>>> origin/master
 *
 * 	private void cantarTruco(Vuelta vuelta){

		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderTruco(vuelta)){
			this.equipo.noTieneQuiero();
			vuelta.obtenerRonda().setearTruco();
		}
		else {
			vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).irse(vuelta.obtenerRonda());
		}
	}
 *
 *
 *	private void cantarRetruco(Vuelta vuelta){
		// Chequear el quiero, el estado del canto y manejar con excepciones.
		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderRetruco(vuelta)){
			this.equipo.noTieneQuiero();
			vuelta.obtenerRonda().setearRetruco();
		}
		else {
			vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).irse(vuelta.obtenerRonda());
		}
	}
 *
 *
 *	private void cantarValeCuatro(Vuelta vuelta){

		// Chequear el quiero, el estado del canto y manejar con excepciones.
		if (vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).responderValeCuatro(vuelta)){
			this.equipo.noTieneQuiero();
			vuelta.obtenerRonda().setearValeCuatro();
		}
		else {
			vuelta.obtenerRonda().obtenerEquipoRival(this.equipo).irse(vuelta.obtenerRonda());
		}
	}
 *
 *
 * 	public boolean responderTruco(Vuelta vuelta){
		int eleccion=0;

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		case 2: vuelta.obtenerRonda().setearTruco();
				this.cantarRetruco(vuelta);
				return true;
		}
		return false;
	}
 *
 *
 *	public boolean responderRetruco(Vuelta vuelta){
		int eleccion=0;

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		case 2: vuelta.obtenerRonda().setearRetruco();
				this.cantarValeCuatro(vuelta);
				return true;
		}
		return false;
	}
 *
 *
 *	public boolean responderValeCuatro(Vuelta vuelta){
		int eleccion=0;

		switch (eleccion){
		case 0: return true;
		case 1: return false;
		}
		return false;
	}
 *
 */
}



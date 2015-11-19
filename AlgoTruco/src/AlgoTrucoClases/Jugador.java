package AlgoTrucoClases;

public class Jugador {

	private String nombre;
	private boolean esMano;
	private Mano mano;

	public Jugador(String nombreDeJugador){

		this.nombre = nombreDeJugador;
		this.esMano = false;
		this.mano = null;

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

}

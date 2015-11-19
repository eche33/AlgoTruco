package AlgoTrucoClases;

public class Partida {

	private static Partida partida = null;
	protected Equipo equipo1;
	protected Equipo equipo2;

	public Partida(Equipo equipo1, Equipo equipo2){
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}



	public static Partida obtenerPartida(int modo, int vsCPU){
		if (partida == null) crearPartida(modo, vsCPU);
		return partida;
	}

	public void iniciarPartida(){

		while(! this.hayGanador()){

			Ronda rondaActual = new Ronda(equipo1,equipo2);

			rondaActual.iniciar();

		}
	}







	protected boolean hayGanador() {

		return false;
	}

}

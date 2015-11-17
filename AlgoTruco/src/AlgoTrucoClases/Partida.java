package AlgoTrucoClases;

public abstract class Partida {

	//private boolean enBuenas; va en RONDA
	//private static Partida partida = null;
	
	private Equipo equipo1;
	private Equipo equipo2;
	//private boolean hayGanador;
	

	// Constructor privado del Singleton, que de todas formas no se usa.
	// Lo pongo porque me dijeron que a Fontela le gusta que esté el constructor always o.o
	private Partida(Equipo equipoUno, Equipo equipoDos){
		
		this.equipo1 = equipoUno;
		this.equipo2 = equipoDos;
		//this.hayGanador() = false;
	}

	public boolean hayGanador(){
		return false; //IMPLEMENTAR
	}
	
	public void iniciarPartida(){
		
	}
	
	// Creador sincronizado que salvaguarda los posibles problemas debido al multi-thread.
 	private synchronized static void crearPartida(int modo, int vsCPU){
		switch (modo){
			case 1: partida = Partida1vs1.crearPartida(vsCPU);
			   		break;
			case 2: partida = Partida2vs2.crearPartida();
			   		break;
			case 3: partida = Partida3vs3.crearPartida();
			   		break;
		}
	}



	// Las variables modo y vsCPU se van a usar en el creador para definir el modo y si se jueva vs CPU (qué loco, ¿no?).
	public static Partida obtenerPartida(int modo, int vsCPU){
		if (partida == null) crearPartida(modo, vsCPU);
		return partida;
	}

}

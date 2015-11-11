package AlgoTrucoClases;

public abstract class Partida1vs1 extends Partida {

	// Constructor privado.
	private Partida1vs1();
	
	public static void crearPartida(int vsCPU){
		if (vsCPU == 1) 
			PartidaHumanoVsPC.crearPartida();
		else
			PartidaHumanoVsHumano.crearPartida();
	}
	
}

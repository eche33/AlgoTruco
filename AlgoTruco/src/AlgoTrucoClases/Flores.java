package AlgoTrucoClases;

public abstract class Flores {

	protected int puntosQueOtorga;
	protected Equipo equipoGanador;

	public int obtenerPuntos(){
		return (this.puntosQueOtorga);
	}

	public abstract Equipo obtenerEquipoGanador(Ronda ronda);

}

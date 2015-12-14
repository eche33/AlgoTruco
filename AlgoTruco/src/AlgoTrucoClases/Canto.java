package AlgoTrucoClases;

public abstract class Canto {

	protected int puntosQueOtorga;

	public Canto(){}

	public int obtenerPuntos(){
		return (this.puntosQueOtorga);
	}
	
	public abstract Canto subir();
	
}
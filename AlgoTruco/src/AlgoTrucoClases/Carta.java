package AlgoTrucoClases;

public abstract class Carta{

	protected Palos palo;
	protected int numero;
	protected int prioridad;


	public String obtenerPalo(){
		return (this.palo.name());
	}

	public int obtenerNumero(){
		return (this.numero);
	}

	public boolean esUnaFigura(){
		boolean esFigura = false;
		if((this.obtenerNumero() == 10) || (this.obtenerNumero() == 11) || (this.obtenerNumero() == 12)){
			esFigura = true;
		}
		return esFigura;
	}

	public int obtenerPrioridad(){
		return (this.prioridad);
	}

	public int jugarContra(Carta unaCarta){
	// M�todo para jugar contra otras cartas. Devuelve 1 si gana, -1 si pierde y 0 si parda.
	// ACLARACI�N: La mejor prioridad es 1 (ancho de espada), la peor es 14 (todos los cuatro).
		if (this.prioridad < unaCarta.obtenerPrioridad()){
			return 1;
		}
		else if (this.prioridad > unaCarta.obtenerPrioridad()){
			return -1;
		}
		else return 0;
	}

	public String nombre() {
		return this.obtenerNumero() + " " + this.obtenerPalo();
	}

/** ESTE M�TODO NO SE USA EN NING�N LADO, POR ESO LO APARTE.
 *
 * 	public boolean esPalo(String palo){
		return (this.obtenerPalo() == palo);
	}
 *
 */

}

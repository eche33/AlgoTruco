package AlgoTrucoClases;

public class Carta {

	private Palos palo;
	private int valor;
	private int prioridad; //Falta la asignación y los test

	public Carta(int valor, Palos paloActual) {
		this.palo = paloActual;
		this.valor = valor;
	}

	public Boolean EsPalo(String palo) {
		return ( (this.palo).name() == palo);
	}
	
	public String obtenerPalo() {
		return ( (this.palo).name() );
	}
	
	public int obtenerValor() {
		return (this.valor);
	}
	
	public int obtenerPrioridad(){
		return (this.prioridad);
	}
	
	public void asignarPrioridad(int importancia){
		this.prioridad = importancia;
	}

}

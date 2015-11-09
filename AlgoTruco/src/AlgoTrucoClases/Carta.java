package AlgoTrucoClases;

public class Carta {

	private String palo;
	private int valor;

	public Carta(int valor, String palo) {
		this.palo = palo;
		this.valor = valor;
	}

	public Boolean EsPalo(String palo) {
		return (this.palo == palo);
	}

}

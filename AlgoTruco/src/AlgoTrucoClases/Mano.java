package AlgoTrucoClases;

import java.util.ArrayList;

public class Mano {

	private ArrayList<Carta> cartas;

	public Mano(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}

	public int cantidadDeCartas() {
		return (this.cartas.size());
	}

	public boolean tieneEnvido() {
		boolean tieneEnvido = false;

		Carta primerCarta = this.cartas.get(0);
		Carta segundaCarta = this.cartas.get(1);
		Carta tercerCarta = this.cartas.get(2);

		if(primerCarta.obtenerPalo()==segundaCarta.obtenerPalo()){
			tieneEnvido = true;
		}else{
			if(primerCarta.obtenerPalo()==tercerCarta.obtenerPalo()){
				tieneEnvido = true;
			}else{
				if(segundaCarta.obtenerPalo()==tercerCarta.obtenerPalo()){
					tieneEnvido = true;
				}
			}
		}

		return tieneEnvido;
		}
	}



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

	public int obtenerEnvido() {
		int envido = 0;

		Carta primerCarta = this.cartas.get(0);
		Carta segundaCarta = this.cartas.get(1);
		Carta tercerCarta = this.cartas.get(2);

		if(this.sonTodasDeDistintoPalo()){
			envido = this.obtenerValorCartaMasAlta();
		}

		return envido;
	}

	public boolean sonTodasDeDistintoPalo() {
		boolean sonDeDistintoPalo = false;

		Carta primerCarta = this.cartas.get(0);
		Carta segundaCarta = this.cartas.get(1);
		Carta tercerCarta = this.cartas.get(2);

		if((primerCarta.obtenerPalo()!=segundaCarta.obtenerPalo()) && (primerCarta.obtenerPalo()!=tercerCarta.obtenerPalo())){
			if(segundaCarta.obtenerPalo()!=tercerCarta.obtenerPalo()){
				sonDeDistintoPalo = true;
			}
		}

		return sonDeDistintoPalo;
	}

	public int obtenerValorCartaMasAlta() {
		int cartaMasAlta = 0;

		Carta primerCarta = this.cartas.get(0);
		Carta segundaCarta = this.cartas.get(1);
		Carta tercerCarta = this.cartas.get(2);

		if(!primerCarta.esUnaFigura()){
			cartaMasAlta = primerCarta.obtenerValor();
		}
		if((segundaCarta.obtenerValor()>cartaMasAlta)&&(!segundaCarta.esUnaFigura())){
			cartaMasAlta = segundaCarta.obtenerValor();
		}
		if((tercerCarta.obtenerValor()>cartaMasAlta)&&(!tercerCarta.esUnaFigura())){
			cartaMasAlta = tercerCarta.obtenerValor();
		}

		return cartaMasAlta;
	}
	}



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

	/*public int obtenerValorCartaMasAlta() {
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
	}*/

	public int calcularEnvidoEntre(int posicion1, int posicion2) {
		int envido = 0;
		posicion1 = posicion1 - 1;
		posicion2 = posicion2 - 1;
		Carta primerCarta = this.cartas.get(posicion1);
		Carta segundaCarta = this.cartas.get(posicion2);

		if(primerCarta.obtenerPalo()==segundaCarta.obtenerPalo()){
			envido = 20;
			if(!primerCarta.esUnaFigura()){
				envido = envido + primerCarta.obtenerValor();
			}
			if(!segundaCarta.esUnaFigura()){
				envido = envido + segundaCarta.obtenerValor();
			}
		}else{
			envido = this.obtenerValorCartaMasAltaEntre(posicion1,posicion2);
		}

		return envido;
		}


	private int obtenerValorCartaMasAltaEntre(int posicion1, int posicion2) {
		int valor = 0;

		Carta primerCarta = this.cartas.get(posicion1);
		Carta segundaCarta = this.cartas.get(posicion2);

		if(!primerCarta.esUnaFigura()){
			valor = primerCarta.obtenerValor();
		}
		if((segundaCarta.obtenerValor()>valor)&&(!segundaCarta.esUnaFigura())){
			valor = segundaCarta.obtenerValor();
		}
		return valor;
	}

	public int obtenerEnvido() {
		int envido = 0;

		int envido12 = this.calcularEnvidoEntre(1, 2);
		int envido13 = this.calcularEnvidoEntre(1, 3);
		int envido23 = this.calcularEnvidoEntre(2, 3);

		if(envido12>envido13){
			if(envido12>envido23){
				envido = envido12;
			}else{
				envido = envido23;
			}
		}else{
			if(envido13>envido23){
				envido = envido13;
			}else{
				envido = envido23;
			}
		}

		return envido;
	}

	public boolean tieneFlor() {
		boolean tieneFlor = false;

		Carta primerCarta = this.cartas.get(0);
		Carta segundaCarta = this.cartas.get(1);
		Carta tercerCarta = this.cartas.get(2);

		if(primerCarta.obtenerPalo()==segundaCarta.obtenerPalo() && primerCarta.obtenerPalo()==tercerCarta.obtenerPalo() && segundaCarta.obtenerPalo()==tercerCarta.obtenerPalo()){
			tieneFlor =true;
		}

		return tieneFlor;
		}
	}



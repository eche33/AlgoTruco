package AlgoTrucoClases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;

public class Mazo {
	private List<Carta> mazoDeCartas;

	public Mazo(){
		
		this.mazoDeCartas = generarMazo();
		asignarImportanciaDeCartas();
	}

	private List<Carta> generarMazo() {
		ArrayList<Carta> nuevoMazo = new ArrayList<Carta>();
		for (Palos paloActual : Palos.values()) {
			for (int valor = 1; valor <= 12; valor++){
				if (valor != 8 && valor != 9)
					nuevoMazo.add( new Carta(valor, paloActual) );
			}
		}
		return nuevoMazo;
	}

	private void asignarImportanciaDeCartas(){
		
		buscarCarta(1,"ESPADA").asignarPrioridad(1);
		buscarCarta(1,"BASTO").asignarPrioridad(2);
		buscarCarta(7,"ESPADA").asignarPrioridad(3);
		buscarCarta(7,"ORO").asignarPrioridad(4);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(3,paloActual.name()).asignarPrioridad(5);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(2,paloActual.name()).asignarPrioridad(6);
		
		buscarCarta(1,"ORO").asignarPrioridad(7);
		buscarCarta(1,"COPA").asignarPrioridad(7);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(12,paloActual.name()).asignarPrioridad(8);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(11,paloActual.name()).asignarPrioridad(9);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(10,paloActual.name()).asignarPrioridad(10);
		
		buscarCarta(7,"BASTO").asignarPrioridad(11);
		buscarCarta(7,"COPA").asignarPrioridad(11);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(6,paloActual.name()).asignarPrioridad(12);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(5,paloActual.name()).asignarPrioridad(13);
		
		for (Palos paloActual : Palos.values())
			buscarCarta(4,paloActual.name()).asignarPrioridad(14);



	}

	private Carta buscarCarta(int numero, String palo) {
		Carta cartaBuscada = null;
		boolean encontrada = false;
		Iterator<Carta> recorrerMazo = this.mazoDeCartas.iterator();
		while ( recorrerMazo.hasNext() && !encontrada ){
			Carta cartaActual = recorrerMazo.next();
			if (cartaActual.obtenerPalo() == palo && cartaActual.obtenerValor()== numero ){
				cartaBuscada = cartaActual;
				encontrada = true;
			}
		}
		return cartaBuscada;
	}

	public void mezclarMazo(){
		
		Collections.shuffle(this.mazoDeCartas);
	}
		
	
	public ArrayList< ArrayList< Carta > > repartirXCantidadDeManos( int manosDeseadas ){
		ArrayList< ArrayList< Carta > > manosPedidas = new ArrayList< ArrayList< Carta > >();
		int indiceCartaActual = 0;
		int manosRepartidas = 0;
		while ( manosRepartidas < manosDeseadas){
			ArrayList< Carta > manoActual = new ArrayList< Carta >();
			for (int i = 1 ; i<=3 ; i++) {
				manoActual.add( this.devolverMazo().get( indiceCartaActual ) );
				indiceCartaActual++;
			}
			manosPedidas.add( manoActual );
			manosRepartidas++;
		}
		return manosPedidas;	
	}
	
	
	
	
	public boolean existeCarta(int numero, String palo){
		Iterator<Carta> recorrerMazo = this.mazoDeCartas.iterator();
		while (recorrerMazo.hasNext()){
			Carta cartaActual = recorrerMazo.next();
			if (cartaActual.obtenerPalo() == palo && cartaActual.obtenerValor()== numero )
				return true;
		}
		return false;
	}

	public List<Carta> devolverMazo(){
		return ( this.mazoDeCartas );
	}
	
}

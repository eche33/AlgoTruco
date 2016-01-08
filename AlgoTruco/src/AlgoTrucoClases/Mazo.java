package AlgoTrucoClases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import AlgoTrucoCartas.AnchoBasto;
import AlgoTrucoCartas.AnchoEspada;
import AlgoTrucoCartas.AnchoFalso;
import AlgoTrucoCartas.Caballo;
import AlgoTrucoCartas.Cinco;
import AlgoTrucoCartas.Cuatro;
import AlgoTrucoCartas.Dos;
import AlgoTrucoCartas.Rey;
import AlgoTrucoCartas.Seis;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoCartas.SieteFalso;
import AlgoTrucoCartas.SieteOro;
import AlgoTrucoCartas.Sota;
import AlgoTrucoCartas.Tres;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;

public class Mazo {
	private List<Carta> mazo;

	public Mazo(){
		this.mazo = generarMazo();
	}

	private List<Carta> generarMazo(){
		ArrayList<Carta> nuevoMazo = new ArrayList<Carta>();
		nuevoMazo.add(new AnchoEspada());
		nuevoMazo.add(new AnchoBasto());
		nuevoMazo.add(new SieteEspada());
		nuevoMazo.add(new SieteOro());
		nuevoMazo.add(new AnchoFalso(Palos.COPA));
		nuevoMazo.add(new AnchoFalso(Palos.ORO));
		nuevoMazo.add(new SieteFalso(Palos.BASTO));
		nuevoMazo.add(new SieteFalso(Palos.COPA));
		
		for (Palos palo : Palos.values()){
			nuevoMazo.add(new Tres(palo));
			nuevoMazo.add(new Dos(palo));
			nuevoMazo.add(new Rey(palo));
			nuevoMazo.add(new Caballo(palo));
			nuevoMazo.add(new Sota(palo));
			nuevoMazo.add(new Seis(palo));
			nuevoMazo.add(new Cinco(palo));
			nuevoMazo.add(new Cuatro(palo));
		}
		return nuevoMazo;
	}

	public void mezclarMazo(){
		Collections.shuffle(this.mazo);
	}
	
	public int cantidadDeCartas(){
		return this.mazo.size();
	}
		
	public Carta sacarCarta(){
		int maximo = this.cantidadDeCartas();
		int index = (int) Math.floor(Math.random()*(maximo - 1)); //devuelve un valor random entre 0 y la cantidad de cartas que quedan en el mazo
		Carta carta = this.mazo.get(index);
		this.mazo.remove(index); 
		return carta;
	}
	
	public ArrayList<Mano> repartirVariasManos(int manosDeseadas){
		ArrayList<Mano> manosPedidas = new ArrayList<Mano>();
		for (int i=0; i<manosDeseadas; i++){
			
			manosPedidas.add(new Mano(this.sacarCarta(),this.sacarCarta(),this.sacarCarta()));
			
		}
		return manosPedidas;	
	}
	
}

package AlgoTrucoClases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		
	public ArrayList<Mano> repartirVariasManos(int manosDeseadas){
		ArrayList<Mano> manosPedidas = new ArrayList<Mano>();
		int indice = 0;
		int manosRepartidas = 0;
		
		while (manosRepartidas < manosDeseadas){
			manosPedidas.add(new Mano(this.mazo.get(indice),this.mazo.get(indice+1),this.mazo.get(indice+2)));
			indice += 3;
			manosRepartidas++;
		}
		return manosPedidas;	
	}
		
/** Perdón gente, me tomé el atrevimiento de comentar estos métodos porque no se usaban en ningún lado y no sé para que
 *  sirven, así de paso para cuando llegue la hora de la entrega si no los usamos es más fácil limpiarlos.
 * 
 * 	private Carta buscarCarta(int numero, String palo){
		Carta cartaBuscada = null;
		boolean encontrada = false;
		Iterator<Carta> recorrerMazo = this.mazoDeCartas.iterator();
		while ( recorrerMazo.hasNext() && !encontrada ){
			Carta cartaActual = recorrerMazo.next();
			if (cartaActual.obtenerPalo() == palo && cartaActual.obtenerNumero()== numero ){
				cartaBuscada = cartaActual;
				encontrada = true;
			}
		}
		return cartaBuscada;
	}
 * 	
 * 
 * 	public boolean existeCarta(int numero, String palo){
		Iterator<Carta> recorrerMazo = this.mazoDeCartas.iterator();
		while (recorrerMazo.hasNext()){
			Carta cartaActual = recorrerMazo.next();
			if (cartaActual.obtenerPalo() == palo && cartaActual.obtenerValor()== numero )
				return true;
		}
		return false;
	}
 * 
**/
}

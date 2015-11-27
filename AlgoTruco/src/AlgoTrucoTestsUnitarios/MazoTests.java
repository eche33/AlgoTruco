package AlgoTrucoTestsUnitarios;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Mazo;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Mano;

public class MazoTests {

	private Mazo nuevoMazo;
	private ArrayList<Mano> manos1;
	private ArrayList<Mano> manos2;
	private ArrayList<Mano> manos3;

	
	@Before
	public void setup() {
		this.nuevoMazo = new Mazo();
		this.manos1 = this.nuevoMazo.repartirVariasManos(2);
		this.manos2 = this.nuevoMazo.repartirVariasManos(3);
		this.manos3 = this.nuevoMazo.repartirVariasManos(6);
	}

	
	@Test
	public void testDevuelveVariasManos(){
		Assert.assertTrue(this.manos1.size() == 2);
		Assert.assertTrue(this.manos2.size() == 3);
		Assert.assertTrue(this.manos3.size() == 6);
	}
	
	@Test
	public void testDevuelveManosDeTresCartas(){
		
		for(int i = 0 ; i < 2; i++){
			Assert.assertTrue(this.manos1.get(i).cantidadDeCartas() == 3);
		}
		
		for(int i = 0 ; i < 3; i++){
			Assert.assertTrue(this.manos2.get(i).cantidadDeCartas() == 3);
		}
		
		for(int i = 0 ; i < 5; i++){
			Assert.assertTrue(this.manos3.get(i).cantidadDeCartas() == 3);
		}
	}
	
	@Test
	public void todasLasCartasRepartidasSonDistintas(){
		
		for (int i = 0; i < 2; i++){
			for (int j = 0; j < 3; j++){
				Carta cartaPivote = this.manos1.get(i).obtenerCarta(j);
				for (int k = 0; k < 2; k++){
					for (int l = 0; l < 3; l++){
						if ((i != k) && (j != l)){
							Assert.assertFalse(cartaPivote.equals(this.manos1.get(k).obtenerCarta(l)));
						}
					}
				}
			}
		}
	}
	
	
/** Pruebas con métodos que están comentados (sólo se usaban para pasar las pruebas, no en el modelo):
 * 
 * 
 * 	@Test
	public void testSeCreaMazoDe40Cartas() {
		Assert.assertEquals(this.nuevoMazo.devolverMazo().size() , 40 );
	}
 *	
 *
  	@Test
	public void testEncuentraCartasExistentes(){
		Assert.assertTrue(this.nuevoMazo.existeCarta(1 , "BASTO"));
		Assert.assertTrue(this.nuevoMazo.existeCarta(1 , "ESPADA"));
		Assert.assertTrue(this.nuevoMazo.existeCarta(2 , "ORO"));
		Assert.assertTrue(this.nuevoMazo.existeCarta(12 , "COPA"));
	}
 *
 *
	@Test
	public void testNoEncuentraCartasNoExistentes(){
		Assert.assertFalse(this.nuevoMazo.existeCarta(8 , "ORO"));
		Assert.assertFalse(this.nuevoMazo.existeCarta(9 , "BASTO"));
		Assert.assertFalse(this.nuevoMazo.existeCarta(14 , "COPA"));
		Assert.assertFalse(this.nuevoMazo.existeCarta(2 , "DIAMANTE"));
	}
 *
 *
 *  Este test que chequea que se mezcle el mazo agarrando cartas puede tener problemas, no recomiendan usar tests que
 *  tengan un factor azaroso. Puede ser que justo dos veces la primer carta sea la misma, y fallaría el test no porque
 *  se estuviese mezclando mal
 *  
 *  @Test
	public void testMezclaElMazo(){
		
		Carta primerCarta = this.nuevoMazo.devolverMazo().get(0);
		Carta primerCarta2 = this.nuevoMazo.devolverMazo().get(39);
		
		this.nuevoMazo.mezclarMazo();
		
		Carta segundaCarta = this.nuevoMazo.devolverMazo().get(0);
		Carta segundaCarta2 = this.nuevoMazo.devolverMazo().get(39);
		
		Assert.assertNotEquals(primerCarta2, segundaCarta2);
		Assert.assertNotEquals(primerCarta, segundaCarta);

		Carta primerCarta3 = this.nuevoMazo.devolverMazo().get(31);
		
		this.nuevoMazo.mezclarMazo();
		
		Carta segundaCarta3 = this.nuevoMazo.devolverMazo().get(31);
		
		Assert.assertNotEquals(primerCarta3, segundaCarta3);
	}
 *
 */

	
}


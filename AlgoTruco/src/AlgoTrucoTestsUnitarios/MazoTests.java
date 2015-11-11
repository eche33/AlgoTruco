package AlgoTrucoTestsUnitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modelo.Carta;
import modelo.Mazo;

public class MazoTest {

	private Mazo nuevoMazo;
	
	@Before
	public void setup() {
		nuevoMazo = new Mazo();
	}

	@Test
	public void testSeCreaMazoDe40Cartas() {
		Assert.assertEquals(nuevoMazo.devolverMazo().size(),40);
	}

	@Test
	public void testEncuentraCartasExistentes(){
		Assert.assertTrue(nuevoMazo.existeCarta(1, "BASTO"));
		Assert.assertTrue(nuevoMazo.existeCarta(1, "ESPADA"));
		Assert.assertTrue(nuevoMazo.existeCarta(2, "ORO"));
		Assert.assertTrue(nuevoMazo.existeCarta(12, "COPA"));
	}
	
	@Test
	public void testNoEncuentraCartasNoExistentes(){
		Assert.assertFalse(nuevoMazo.existeCarta(8, "ORO"));
		Assert.assertFalse(nuevoMazo.existeCarta(9, "BASTO"));
		Assert.assertFalse(nuevoMazo.existeCarta(14, "COPA"));
		Assert.assertFalse(nuevoMazo.existeCarta(2, "DIAMANTE"));
	}
	
	@Test
	public void testMezclaElMazo(){
		Carta primerCarta = nuevoMazo.devolverMazo().get(0);
		Carta primerCarta2 = nuevoMazo.devolverMazo().get(39);
		nuevoMazo.mezclarMazo();
		Carta segundaCarta = nuevoMazo.devolverMazo().get(0);
		Carta segundaCarta2 = nuevoMazo.devolverMazo().get(39);
		Assert.assertNotEquals(primerCarta2, segundaCarta2);
		Assert.assertNotEquals(primerCarta, segundaCarta);

		Carta primerCarta3 = nuevoMazo.devolverMazo().get(31);
		nuevoMazo.mezclarMazo();
		Carta segundaCarta3 = nuevoMazo.devolverMazo().get(31);
		Assert.assertNotEquals(primerCarta3, segundaCarta3);
	}
}


package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;


public class CartaTests {

	private Carta carta1 = (new Carta(6,Palos.COPA));

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreaUnaCartaYGuardaValorCorrecto() {
		Assert.assertEquals(carta1.obtenerValor(),6);
	}

	@Test
	public void testCreaUnaCartaYGuardaPaloCorrecto() {
		Assert.assertEquals(( new Carta(6,Palos.COPA )).obtenerPalo(),"COPA");
	}

	@Test
	public void testChequeaElPaloDeUnaCarta() {
		Assert.assertTrue((new Carta(1,Palos.ESPADA)).esPalo("ESPADA"));
	}

	@Test
	public void testUnaCartaEsUnaFigura(){
		Carta carta = new Carta(10, Palos.BASTO);
		assertTrue(carta.esUnaFigura());
	}

	@Test
	public void testUnaCartaNoEsUnaFigura(){
		Carta carta = new Carta(1, Palos.BASTO);
		assertFalse(carta.esUnaFigura());
	}


	public static void main(String[] args) {

	}

}



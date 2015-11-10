package AlgoTrucoTestsUnitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;


public class CartaTests {


	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreaUnaCartaYGuardaValorCorrecto() {
		Assert.assertEquals((new Carta(6,Palos.COPA)).obtenerValor(),6);
	}

	@Test
	public void testCreaUnaCartaYGuardaPaloCorrecto() {
		Assert.assertEquals((new Carta(6,Palos.COPA)).obtenerPalo(),"COPA");
	}

	@Test
	public void testChequeaElPaloDeUnaCarta() {
		Assert.assertTrue((new Carta(1,Palos.ESPADA)).EsPalo("ESPADA"));
	}

	public static void main(String[] args) {

	}

}



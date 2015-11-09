package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;

public class CartaTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreaUnaCartaYChequeaElPalo() {
		Carta carta = new Carta(1,"Espada");
		Boolean result = carta.EsPalo("Espada");
	      
		Assert.assertTrue(result);
	}

	public static void main(String[] args) {
	
	}

}

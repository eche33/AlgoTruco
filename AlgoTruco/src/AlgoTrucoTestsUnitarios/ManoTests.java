package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Mano;

public class ManoTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreaUnaManoYChequeaCuantasCartasTiene() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,"Espada"));
		cartas.add( new Carta(1,"Basto"));
		cartas.add(new Carta(7,"Espada"));
	
		Mano mano = new Mano(cartas);
		
		Boolean result = (mano.cantidadDeCartas() == 3);
	      
		Assert.assertTrue(result);
			
	}

}

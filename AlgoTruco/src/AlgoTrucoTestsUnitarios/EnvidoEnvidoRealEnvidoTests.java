package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoTantos.EnvidoEnvidoRealEnvido;
import AlgoTrucoTantos.EnvidoRealEnvido;

public class EnvidoEnvidoRealEnvidoTests {
	private EnvidoEnvidoRealEnvido envidoEnvidoRealEnvido;

	@Before
	public void setUp() throws Exception{
		this.envidoEnvidoRealEnvido = new EnvidoEnvidoRealEnvido();
	}

		@Test
		public void realEnvidoSeCreaCorrectamente(){
			assertEquals(this.envidoEnvidoRealEnvido.obtenerPuntos(),7);
			assertEquals(this.envidoEnvidoRealEnvido.obtenerPuntosNoQuerido(),4);
			assertTrue(this.envidoEnvidoRealEnvido.seQuiere);
		}

}

package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoTantos.EnvidoEnvidoRealEnvido;
import AlgoTrucoTantos.FaltaEnvido;

public class FaltaEnvidoTests {
	private FaltaEnvido faltaEnvido;

	@Before
	public void setUp() throws Exception{
		this.faltaEnvido = new FaltaEnvido(15);
	}

		@Test
		public void faltaEnvidoSeCreaCorrectamente(){
			assertEquals(this.faltaEnvido.obtenerPuntos(),15);
			assertEquals(this.faltaEnvido.obtenerPuntosNoQuerido(),1);
		}


}

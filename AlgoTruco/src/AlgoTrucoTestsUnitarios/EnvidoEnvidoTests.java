package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoTantos.EnvidoEnvido;

public class EnvidoEnvidoTests {
	private EnvidoEnvido envidoEnvido;

	@Before
	public void setUp() throws Exception{
		this.envidoEnvido = new EnvidoEnvido();
	}

		@Test
		public void envidoEnvidoSeCreaCorrectamente(){
			assertEquals(this.envidoEnvido.obtenerPuntos(),4);
			assertEquals(this.envidoEnvido.obtenerPuntosNoQuerido(),2);
		}

}

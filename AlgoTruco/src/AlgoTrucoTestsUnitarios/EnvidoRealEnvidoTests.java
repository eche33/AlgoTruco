package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoTantos.EnvidoRealEnvido;

public class EnvidoRealEnvidoTests {
	private EnvidoRealEnvido envidoRealEnvido;

	@Before
	public void setUp() throws Exception{
		this.envidoRealEnvido = new EnvidoRealEnvido();
	}

		@Test
		public void envidoRealEnvidoSeCreaCorrectamente(){
			assertEquals(this.envidoRealEnvido.obtenerPuntos(),5);
			assertEquals(this.envidoRealEnvido.obtenerPuntosNoQuerido(),2);
		}


}

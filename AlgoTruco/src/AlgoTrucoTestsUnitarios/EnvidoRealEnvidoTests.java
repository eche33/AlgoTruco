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
		public void realEnvidoSeCreaCorrectamente(){
			assertEquals(this.envidoRealEnvido.obtenerPuntos(),5);
		}


}

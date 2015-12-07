package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoTantos.RealEnvido;

public class RealEnvidoTests {

private RealEnvido realEnvido;

@Before
public void setUp() throws Exception{
	this.realEnvido = new RealEnvido();
}

	@Test
	public void realEnvidoSeCreaCorrectamente(){
		assertEquals(this.realEnvido.obtenerPuntos(),3);
	}
}

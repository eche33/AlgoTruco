package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoFlores.ContraFlorAlResto;

public class ContraFlorAlRestoTests {
	private ContraFlorAlResto contraFlorAlResto;

	@Before
	public void setUp() throws Exception {
		this.contraFlorAlResto = new ContraFlorAlResto(15);
	}

	@Test
	public void contraFlorAlRestoSeCreaCorrectamente() {
		assertEquals(this.contraFlorAlResto.obtenerPuntos(),15);
	}

}

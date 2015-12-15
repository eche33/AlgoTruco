package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoFlores.ContraFlor;

public class ContraFlorTests {

	private ContraFlor contraFlor;

	@Before
	public void setUp() throws Exception {
		this.contraFlor = new ContraFlor();
	}

	@Test
	public void contraFlorSeCreaCorrectamente() {
		assertEquals(this.contraFlor.obtenerPuntos(),6);
	}

}

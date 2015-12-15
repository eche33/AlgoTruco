package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoFlores.Flor;

public class FlorTests {

	private Flor flor;
	private Equipo equipo;

	@Before
	public void setUp() throws Exception {
		this.equipo = new Equipo();
		this.flor = new Flor(this.equipo);
	}

	@Test
	public void florSeCreaCorrectamente() {
		assertEquals(this.flor.obtenerPuntos(),3);
	}

}

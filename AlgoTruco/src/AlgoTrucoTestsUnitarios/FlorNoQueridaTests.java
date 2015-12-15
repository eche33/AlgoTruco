package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoFlores.FlorNoQuerida;

public class FlorNoQueridaTests {
	private FlorNoQuerida florNoQuerida;
	private Equipo equipo;

	@Before
	public void setUp() throws Exception {
		this.equipo = new Equipo();
		this.florNoQuerida = new FlorNoQuerida(this.equipo);
	}

	@Test
	public void florNoQueridaSeCreaCorrectamente() {
		assertEquals(this.florNoQuerida.obtenerPuntos(), 4);

	}

}

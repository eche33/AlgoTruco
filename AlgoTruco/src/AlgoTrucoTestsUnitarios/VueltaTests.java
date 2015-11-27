package AlgoTrucoTestsUnitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;
import AlgoTrucoClases.Vuelta;

public class VueltaTests {

	private Equipo equipo1;
	private Equipo equipo2;
	private Ronda ronda;
	private Vuelta vuelta;

	@Before
	public void setUp() throws Exception {
		this.equipo1 = new Equipo(new Jugador("Rodri"), new Jugador("Ailu"));
		this.equipo2 = new Equipo(new Jugador("Cris"), new Jugador("Flor"));
		this.ronda = new Ronda(this.equipo1, this.equipo2);
		this.vuelta = new Vuelta(this.ronda);
	}

	@Test
	public void testVueltaSeCreaCorrectamente() {

		Assert.assertEquals(this.vuelta.obtenerJugadorQueTiroCartaMasALta(),null);
		Assert.assertTrue(this.vuelta.estaEnCurso());
	}

}

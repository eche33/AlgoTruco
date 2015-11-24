package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;
import AlgoTrucoClases.Vuelta;

public class VueltaTests {

	private Ronda ronda;
	private Vuelta vuelta;

	@Before
	public void setUp() throws Exception {
		Jugador rodri = new Jugador("Rodri");
		Jugador ailu = new Jugador("Ailu");
		Jugador flor = new Jugador("Flor");
		Jugador cris = new Jugador("Cris");
		ArrayList<Jugador> lista1 = new ArrayList<Jugador>();
		ArrayList<Jugador> lista2 = new ArrayList<Jugador>();
		lista1.add(ailu);
		lista1.add(rodri);
		lista2.add(flor);
		lista2.add(cris);
		Equipo equipo1 = new Equipo(lista1);
		Equipo equipo2 = new Equipo(lista2);
		ArrayList<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
		jugadoresOrdenados.add(ailu);
		jugadoresOrdenados.add(flor);
		jugadoresOrdenados.add(rodri);
		jugadoresOrdenados.add(cris);
		ronda = new Ronda(equipo1, equipo2, jugadoresOrdenados);
		this.vuelta = new Vuelta(ronda);
	}

	@Test
	public void testVueltaSeCreaCorrectamente() {

		assertEquals(this.vuelta.obtenerJugadorQueTiroCartaMasALta(),null);
		assertTrue(this.vuelta.estaEnCurso());
	}

}

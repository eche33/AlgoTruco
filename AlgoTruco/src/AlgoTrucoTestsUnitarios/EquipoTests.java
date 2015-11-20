package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;

public class EquipoTests {

	@Test
	public void testEquipoSeCreaCorrectamente(){
		Jugador jugador1 = new Jugador("Rodrigo");
		Jugador jugador2 = new Jugador("Flor");
		ArrayList<Jugador> lista = new ArrayList<Jugador>();
		lista.add(jugador1);
		lista.add(jugador2);
		Equipo equipo = new Equipo(lista);

		assertEquals(equipo.obtenerCantidadDeJugadores(),2);
		assertEquals(equipo.obtenerPuntaje(),0);

	}
}

package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Player;

public class EquipoTests {

	@Test
	public void testEquipoSeCreaCorrectamente(){
		Player jugador1 = new Player("Rodrigo");
		Player jugador2 = new Player("Flor");
		ArrayList<Player> lista = new ArrayList<Player>();
		lista.add(jugador1);
		lista.add(jugador2);
		Equipo equipo = new Equipo(lista);

		assertEquals(equipo.obtenerCantidadDeJugadores(),2);
		assertEquals(equipo.obtenerPuntaje(),0);

	}
}

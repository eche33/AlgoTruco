package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;
import AlgoTrucoClases.Jugador;

public class JugadorTests {

	private Jugador jugador;

	@Before
	public void setUp() throws Exception {
		jugador = new Jugador("Rodrigo");
	}

	@Test
	public void testPlayerSeCreaCorrectamente() {
		assertFalse(jugador.esMano());
		assertEquals(jugador.obtenerNombre(),"Rodrigo");
		assertEquals(jugador.obtenerMano(), null);
	}

	@Test
	public void testAsignarManoAPlayer(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.ESPADA));
		cartas.add( new Carta(1,Palos.BASTO));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		this.jugador.asignarMano(mano);

		assertEquals(this.jugador.obtenerMano().cantidadDeCartas(),3);
	}

	@Test
	public void testObtenerEnvidoCorrectoDeJugador(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.ESPADA));
		cartas.add( new Carta(1,Palos.BASTO));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		this.jugador.asignarMano(mano);

		assertEquals(this.jugador.obtenerEnvido(),28);
	}


	@Test
	public void testObtenerFlorCorrectaDeJugador(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.ESPADA));
		cartas.add( new Carta(1,Palos.BASTO));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		this.jugador.asignarMano(mano);

		assertEquals(this.jugador.obtenerFlor(),0);
	}

}

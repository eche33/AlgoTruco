package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoBasto;
import AlgoTrucoCartas.AnchoEspada;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Ronda;
import AlgoTrucoClases.Jugador;

public class JugadorTests {

	private Jugador jugador;
	private Mano mano;
	private Ronda ronda;


	@Before
	public void setUp() throws Exception {
		jugador = new Jugador("Rodrigo");
		this.mano = new Mano(new AnchoEspada(), new AnchoBasto(), new SieteEspada());

		Equipo equipo1 = new Equipo(new Jugador("Ailu"), new Jugador("Rodri"));
		Equipo equipo2 = new Equipo(new Jugador("Flor"), new Jugador("Cris"));
		this.ronda = new Ronda(equipo1, equipo2);
	}


	@Test
	public void testJugadorSeCreaCorrectamente() {
		assertFalse(jugador.esMano());
		assertEquals(jugador.obtenerNombre(),"Rodrigo");
		assertEquals(jugador.obtenerMano(), null);
	}

	@Test
	public void testAsignarManoAJugador(){
		this.jugador.asignarMano(this.mano);
		assertEquals(3,this.jugador.obtenerMano().cantidadDeCartas());
		assertEquals(this.jugador.obtenerMano(),this.mano);
	}

	@Test
	public void testObtenerEnvidoCorrectoDeJugador(){
		this.jugador.asignarMano(this.mano);
		assertEquals(this.jugador.obtenerEnvido(),28);
	}

	@Test
	public void testObtenerFlorCorrectaDeJugador(){
		this.jugador.asignarMano(this.mano);
		assertEquals(this.jugador.obtenerFlor(),0);
	}

	@Test
	public void tirarPrimerCarta(){

	}

}

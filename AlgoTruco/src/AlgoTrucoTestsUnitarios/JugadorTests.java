package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;
import AlgoTrucoClases.Ronda;
import AlgoTrucoClases.Jugador;

public class JugadorTests {

	private Jugador jugador;
	private ArrayList<Carta> cartas;
	private Mano mano;
	private Ronda ronda;

	@Before
	public void setUp() throws Exception {
		jugador = new Jugador("Rodrigo");

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
		this.ronda = new Ronda(equipo1, equipo2, jugadoresOrdenados);
	
		this.cartas = new ArrayList<Carta>();
		this.cartas.add(new Carta(1,Palos.ESPADA));
		this.cartas.add( new Carta(1,Palos.BASTO));
		this.cartas.add(new Carta(7,Palos.ESPADA));
	
		this.mano = new Mano(this.cartas);
		
	}

	@Test
	public void testPlayerSeCreaCorrectamente() {
		assertFalse(jugador.esMano());
		assertEquals(jugador.obtenerNombre(),"Rodrigo");
		assertEquals(jugador.obtenerMano(), null);
	}

	@Test
	public void testAsignarManoAPlayer(){
		this.jugador.asignarMano(this.mano);
		assertEquals(this.jugador.obtenerMano().cantidadDeCartas(),3);
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
	public void testJugar(){

	}

}

package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;

public class RondaTests {

	private Ronda ronda;

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
		this.ronda = new Ronda(equipo1, equipo2, jugadoresOrdenados);

	}

	@Test
	public void testRondaSeCreaCorrectamente(){

		assertEquals(ronda.obtenerEquipo1().obtenerCantidadDeJugadores(),2);
		assertEquals(ronda.obtenerEquipo2().obtenerCantidadDeJugadores(),2);
		assertEquals(ronda.obtenerJugadoresOrdenados().size(),4);
		assertEquals(ronda.obtenerMesa().obtenerCartasEnMesa().size(),0);
	}

	@Test
	public void testRondaReordenaLosTurnosCorrectamente(){
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
		Ronda ronda = new Ronda(equipo1, equipo2, jugadoresOrdenados);

		assertEquals(ronda.obtenerJugadoresOrdenados().get(0).obtenerNombre(),"Ailu");
		assertEquals(ronda.obtenerJugadoresOrdenados().get(1).obtenerNombre(),"Flor");
		assertEquals(ronda.obtenerJugadoresOrdenados().get(2).obtenerNombre(),"Rodri");
		assertEquals(ronda.obtenerJugadoresOrdenados().get(3).obtenerNombre(),"Cris");

		ronda.ordenarTurnos(rodri);

		assertEquals(ronda.obtenerJugadoresOrdenados().get(0).obtenerNombre(),"Rodri");
		assertEquals(ronda.obtenerJugadoresOrdenados().get(1).obtenerNombre(),"Cris");
		assertEquals(ronda.obtenerJugadoresOrdenados().get(2).obtenerNombre(),"Ailu");
		assertEquals(ronda.obtenerJugadoresOrdenados().get(3).obtenerNombre(),"Flor");

	}



}

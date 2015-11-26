package AlgoTrucoTestsIntegradores;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;

public class SumaPuntosTests {

	private Ronda ronda;
	Equipo equipo1 ;
	Equipo equipo2 ;

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
		this.equipo1 = new Equipo(lista1);
		this.equipo2 = new Equipo(lista2);
		ArrayList<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
		jugadoresOrdenados.add(ailu);
		jugadoresOrdenados.add(flor);
		jugadoresOrdenados.add(rodri);
		jugadoresOrdenados.add(cris);
		this.ronda = new Ronda(equipo1, equipo2, jugadoresOrdenados);
	}

	@Test
	public void testSumarEnvidoNoQuerido() {
		this.equipo1.sumarPuntosTanto(this.ronda);

		assertEquals(this.equipo1.puntajeDeEquipo, 1);
	}

	@Test
	public void testSumarEnvido() {
		this.ronda.setearEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);

		assertEquals(this.equipo1.puntajeDeEquipo, 2);
	}

	@Test
	public void testSumarRealEnvido() {
		this.ronda.setearRealEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);

		assertEquals(this.equipo1.puntajeDeEquipo, 3);
	}

	@Test
	public void testSumarFaltaEnvido() {
		this.ronda.setearFaltaEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);

		assertEquals(this.equipo1.puntajeDeEquipo, 15);
	}

}

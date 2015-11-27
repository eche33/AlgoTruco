package AlgoTrucoTestsIntegradores;

import org.junit.Assert;
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
		this.equipo1 = new Equipo(new Jugador("Ailu"), new Jugador("Rodri"));
		this.equipo2 = new Equipo(new Jugador("Flor"), new Jugador("Cris"));
		this.ronda = new Ronda(equipo1, equipo2);
	}

	@Test
	public void testSumarEnvidoNoQuerido() {
		this.equipo1.sumarPuntosTanto(this.ronda);
		Assert.assertEquals(this.equipo1.puntajeDeEquipo, 1);
	}

	@Test
	public void testSumarEnvido() {
		this.ronda.setearEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);
		Assert.assertEquals(this.equipo1.puntajeDeEquipo, 2);
	}

	@Test
	public void testSumarRealEnvido() {
		this.ronda.setearRealEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);
		Assert.assertEquals(this.equipo1.puntajeDeEquipo, 3);
	}

	@Test
	public void testSumarFaltaEnvido() {
		this.ronda.setearFaltaEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);
		Assert.assertEquals(this.equipo1.puntajeDeEquipo, 15);
	}

	@Test
	public void testSumarEnvidoEnvido() {
		this.ronda.setearEnvido();
		this.ronda.setearEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);
		Assert.assertEquals(this.equipo1.puntajeDeEquipo, 4);
	}

	@Test
	public void testSumarEnvidoRealEnvido() {
		this.ronda.setearEnvido();
		this.ronda.setearRealEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);
		Assert.assertEquals(this.equipo1.puntajeDeEquipo, 5);
	}

	@Test
	public void testSumarEnvidoEnvidoRealEnvido() {
		this.ronda.setearEnvido();
		this.ronda.setearEnvido();
		this.ronda.setearRealEnvido();
		this.equipo1.sumarPuntosTanto(this.ronda);
		Assert.assertEquals(this.equipo1.puntajeDeEquipo, 7);
	}

}

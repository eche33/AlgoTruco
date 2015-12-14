package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;

public class RondaTests {

	private Ronda ronda;
	private Equipo equipo1;
	private Equipo equipo2;
	private Jugador ailu;
	private Jugador rodri;
	private Jugador flor;
	private Jugador cris;


	@Before
	public void setUp() throws Exception {
		this.equipo1 = new Equipo (this.ailu = new Jugador("Ailu"), this.rodri = new Jugador("Rodri"));
		this.equipo2 = new Equipo (this.flor = new Jugador("Flor"), this.cris = new Jugador("Cris"));
		this.ronda = new Ronda(this.equipo1, this.equipo2);
	}


	@Test
	public void testRondaSeCreaCorrectamente(){
		Assert.assertTrue(this.ailu.esMano());
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().size(),4);
	}

	@Test
	public void testRondaReordenaLosTurnosCorrectamente(){
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(0), this.ailu);
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(1), this.flor);
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(2), this.rodri);
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(3), this.cris);

		this.ronda.ordenarTurnos(this.rodri);

		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(0), this.rodri);
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(1), this.cris);
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(2), this.ailu);
		Assert.assertEquals(this.ronda.obtenerJugadoresOrdenados().get(3), this.flor);
	}

	@Test
	public void setearEnvidoFuncionaCorrectamente(){
		this.ronda.setearEnvido();
		assertEquals(this.ronda.obtenerTantoActual().getClass().getSimpleName(),"Envido");
	}

	@Test
	public void setearFaltaEnvidoFuncionaCorrectamente(){
		this.ronda.setearFaltaEnvido();
		assertEquals(this.ronda.obtenerTantoActual().getClass().getSimpleName(),"FaltaEnvido");
	}

	@Test
	public void setearEnvidoEnvidoFuncionaCorrectamente(){
		this.ronda.setearEnvidoEnvido();
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntos(),4);
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntosNoQuerido(),2);
	}

	@Test
	public void setearRealEnvidoFuncionaCorrectamente(){
		this.ronda.setearRealEnvido();
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntos(),3);
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntosNoQuerido(),1);
	}

	@Test
	public void setearEnvidoRealEnvidoFuncionaCorrectamente(){
		this.ronda.setearEnvidoRealEnvido();
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntos(),5);
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntosNoQuerido(),2);
	}

	@Test
	public void setearEnvidoEnvidoRealEnvidoFuncionaCorrectamente(){
		this.ronda.setearEnvidoEnvidoRealEnvido();
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntos(),7);
		assertEquals(this.ronda.obtenerTantoActual().obtenerPuntosNoQuerido(),4);
	}


	@Test
	public void equipoSeVaAlMazoEntoncesRondaFinaliza(){
		this.ronda.irse(equipo1);
		//assertEquals(this.ronda.obtenerEquipo1(),null);
		assertTrue(this.ronda.rondaFinalizada());
	}

	@Test
	public void obtenerEquipoQueVaGanando(){
		this.equipo1.sumarPuntos(5);
		assertEquals(this.ronda.obtenerEquipoQueVaGanando(),equipo1);
	}

	@Test
	public void obtenerPuntajeDeFaltaEnvido(){
		this.equipo1.sumarPuntos(5);
		assertEquals(this.ronda.obtenerFaltaEnvido(),10);
	}

	@Test
	public void setearEnvidoNoSeteaPorqueHayTantoAnterior(){
		this.ronda.setearEnvidoEnvido();
		this.ronda.setearEnvido();

		assertEquals(this.ronda.obtenerTantoActual().getClass().getSimpleName(), "EnvidoEnvido");
	}

	@Test
	public void setearRealEnvidoNoSeteaPorqueHayTantoAnterior(){
		this.ronda.setearEnvidoEnvido();
		this.ronda.setearRealEnvido();

		assertEquals(this.ronda.obtenerTantoActual().getClass().getSimpleName(), "EnvidoEnvido");
	}

	@Test
	public void stearEnvidoConFaltaNoQuerido(){
		this.ronda.setearFaltaEnvido();
		this.ronda.obtenerTantoActual().noSeQuiere(equipo1);
		this.ronda.setearEnvido();

		assertEquals(this.ronda.obtenerTantoActual().getClass().getSimpleName(), "Envido");
		assertEquals(this.ronda.obtenerTantoActual().obtenerEquipoGanador(ronda), this.equipo1);
	}

	@Test
	public void faltaEnvidoCantadoFuncionaCorrectamente(){
		this.ronda.setearFaltaEnvido();
		assertTrue(this.ronda.faltaEnvidoCantado());
	}




}

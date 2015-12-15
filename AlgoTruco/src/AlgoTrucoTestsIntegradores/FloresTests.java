package AlgoTrucoTestsIntegradores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoBasto;
import AlgoTrucoCartas.Cuatro;
import AlgoTrucoCartas.Rey;
import AlgoTrucoCartas.Seis;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoCartas.SieteFalso;
import AlgoTrucoCartas.SieteOro;
import AlgoTrucoCartas.Sota;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;
import AlgoTrucoClases.Ronda;

public class FloresTests {

	private Equipo equipoAilu;
	private Equipo equipoRodri;
	private Equipo equipoAiluRodri;
	private Equipo equipoFlorCris;
	private Jugador flor;
	private Jugador cris;
	private Jugador ailu;
	private Jugador rodri;
	private Ronda ronda;
	private Ronda rondaEquiposDeADos;


	@Before
	public void setUp() throws Exception{
		this.equipoAilu = new Equipo();
		this.equipoAilu.agregarJugadorAEquipo(ailu = new Jugador("Ailu"));
		this.equipoRodri = new Equipo();
		this.equipoRodri.agregarJugadorAEquipo(rodri = new Jugador("Rodri"));

		this.ronda = new Ronda(equipoAilu, equipoRodri);

		this.equipoAiluRodri = new Equipo();
		this.equipoAiluRodri.agregarJugadorAEquipo(ailu = new Jugador("Ailu"));
		this.equipoAiluRodri.agregarJugadorAEquipo(rodri = new Jugador("Rodri"));

		this.equipoFlorCris = new Equipo();
		this.equipoFlorCris.agregarJugadorAEquipo(flor = new Jugador("Flor"));
		this.equipoFlorCris.agregarJugadorAEquipo(cris = new Jugador("Cris"));

		this.rondaEquiposDeADos = new Ronda(equipoAiluRodri,equipoFlorCris);

		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.ESPADA), new Rey(Palos.COPA));
		this.ailu.asignarMano(manoAilu);

		Mano manoFlor = new Mano(new Cuatro(Palos.BASTO), new Seis(Palos.COPA), new Sota(Palos.ORO));
		this.flor.asignarMano(manoFlor);

		Mano manoCris = new Mano(new AnchoBasto(), new SieteOro(), new SieteFalso(Palos.BASTO));
		this.cris.asignarMano(manoCris);
	}

	@Test
	public void equipoSumaFlorCorrectamente() {
		this.ronda.setearFlor(equipoAiluRodri);
		this.ronda.sumarPuntos(equipoAiluRodri);
		this.ronda.sumarPuntos(equipoFlorCris);
		assertEquals(this.equipoAiluRodri.obtenerPuntaje(),3);
		assertEquals(this.equipoFlorCris.obtenerPuntaje(),0);
	}

	@Test
	public void equipoSumaFlorNoQueridaCorrectamente() {
		this.ronda.setearFlorNoquerida(equipoAiluRodri);
		this.ronda.sumarPuntos(equipoAiluRodri);
		this.ronda.sumarPuntos(equipoFlorCris);
		assertEquals(this.equipoAiluRodri.obtenerPuntaje(),4);
		assertEquals(this.equipoFlorCris.obtenerPuntaje(),0);
	}

	@Test
	public void equipoSumaContraFlorCorrectamente() {
		//this.ronda.setearFlor(equipoRodri);
		this.ronda.setearContraFlor();
		this.ronda.sumarPuntos(equipoRodri);
		this.ronda.sumarPuntos(equipoAilu);
		assertEquals(this.equipoRodri.obtenerPuntaje(),6);
		assertEquals(this.equipoAilu.obtenerPuntaje(),0);
	}

	@Test
	public void equipoSumaContraFlorAlRestoCorrectamente() {
		this.ronda.setearFlor(equipoRodri);
		this.ronda.setearContraFlorAlResto();
		this.ronda.sumarPuntos(equipoRodri);
		this.ronda.sumarPuntos(equipoAilu);
		assertEquals(this.equipoRodri.obtenerPuntaje(),15);
		assertEquals(this.equipoAilu.obtenerPuntaje(),0);
	}



}

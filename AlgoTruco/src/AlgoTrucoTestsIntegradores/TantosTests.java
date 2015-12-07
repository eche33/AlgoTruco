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
import AlgoTrucoTantos.Envido;
import AlgoTrucoTantos.EnvidoEnvido;
import AlgoTrucoTantos.EnvidoEnvidoRealEnvido;
import AlgoTrucoTantos.EnvidoRealEnvido;
import AlgoTrucoTantos.FaltaEnvido;
import AlgoTrucoTantos.RealEnvido;

public class TantosTests {
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
		this.equipoAilu = new Equipo(ailu = new Jugador("Ailu"));
		this.equipoRodri = new Equipo(rodri = new Jugador("Rodri"));
		this.ronda = new Ronda(equipoAilu, equipoRodri);

		this.equipoAiluRodri = new Equipo(ailu = new Jugador("Ailu"), rodri = new Jugador("Rodri"));
		this.equipoFlorCris = new Equipo(flor = new Jugador("Flor"), cris = new Jugador("Cris"));
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
	public void tantosDevuelveElJugadorGanadorCorrecto(){
		Envido envido = new Envido();
		RealEnvido realEnvido = new RealEnvido();
		EnvidoEnvido Envidoenvido = new EnvidoEnvido();
		EnvidoRealEnvido envidoRealEnvido = new EnvidoRealEnvido();
		EnvidoEnvidoRealEnvido envidoEnvidoRealEnvido = new EnvidoEnvidoRealEnvido();
		FaltaEnvido faltaEnvido = new FaltaEnvido(this.rondaEquiposDeADos.obtenerFaltaEnvido());

		assertEquals(envido.obtenerEquipoGanador(rondaEquiposDeADos),equipoAiluRodri);
		assertEquals(realEnvido.obtenerEquipoGanador(rondaEquiposDeADos),equipoAiluRodri);
		assertEquals(Envidoenvido.obtenerEquipoGanador(rondaEquiposDeADos),equipoAiluRodri);
		assertEquals(envidoRealEnvido.obtenerEquipoGanador(rondaEquiposDeADos),equipoAiluRodri);
		assertEquals(envidoEnvidoRealEnvido.obtenerEquipoGanador(rondaEquiposDeADos),equipoAiluRodri);
		assertEquals(faltaEnvido.obtenerEquipoGanador(rondaEquiposDeADos),equipoAiluRodri);

	}





}

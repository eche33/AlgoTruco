package AlgoTrucoTestsIntegradores;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoBasto;
import AlgoTrucoCartas.AnchoEspada;
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

public class EnvidoTests {

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
	}


	@Test
	public void testObtenerEnvidoConCartasTodasDeDistintoPalo() {
		Mano mano = new Mano(new AnchoEspada(), new Rey(Palos.BASTO), new SieteFalso(Palos.COPA));
		Assert.assertEquals(mano.obtenerEnvido(),7);
	}

	@Test
	public void testObtenerEnvidoConDosCartasDelMismoPalo() {
		Mano mano = new Mano(new AnchoEspada(), new Rey(Palos.ESPADA), new SieteFalso(Palos.COPA));
		Assert.assertEquals(mano.obtenerEnvido(),21);
	}

	@Test
	public void testObtenerEnvidoConTodasDelMismoPalo() {
		Mano mano = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		Assert.assertEquals(mano.obtenerEnvido(),33);
	}

	@Test
	public void testObtenerEnvidoConTodasFigurasDistintas() {
		Mano mano = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.BASTO), new Rey(Palos.COPA));
		Assert.assertEquals(mano.obtenerEnvido(),0);
	}

	@Test
	public void testObtenerEnvidoConTodasFiguras() {
		Mano mano = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.ESPADA), new Rey(Palos.COPA));
		Assert.assertEquals(mano.obtenerEnvido(),20);
	}

	/*@Test
	public void testJugarTantos(){
		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.ESPADA), new Rey(Palos.COPA));
		this.ailu.asignarMano(manoAilu);

		this.ronda.setearEnvido();
		this.ronda.jugarTantos();

		Assert.assertEquals(0,equipoAilu.puntajeDeEquipo);
		Assert.assertEquals(2,equipoRodri.puntajeDeEquipo);
	}*/

	/*@Test
	public void testJugarTantosConEnvidosIguales(){
		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Seis(Palos.COPA), new Rey(Palos.ESPADA), new SieteFalso(Palos.COPA));
		this.ailu.asignarMano(manoAilu);

		this.ronda.setearEnvido();
		this.ronda.jugarTantos();

		Assert.assertEquals(2,equipoAilu.puntajeDeEquipo);
		Assert.assertEquals(0,equipoRodri.puntajeDeEquipo);


	}*/

	/*@Test
	public void testJugarTantosCon4Jugadores(){
		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.ESPADA), new Rey(Palos.COPA));
		this.ailu.asignarMano(manoAilu);

		Mano manoFlor = new Mano(new Cuatro(Palos.BASTO), new Seis(Palos.COPA), new Sota(Palos.ORO));
		this.flor.asignarMano(manoFlor);

		Mano manoCris = new Mano(new AnchoBasto(), new SieteOro(), new SieteFalso(Palos.BASTO));
		this.cris.asignarMano(manoCris);

		this.rondaEquiposDeADos.setearEnvido();
		this.rondaEquiposDeADos.jugarTantos();

		Assert.assertEquals(0,equipoFlorCris.puntajeDeEquipo);
		Assert.assertEquals(2,equipoAiluRodri.puntajeDeEquipo);
	}*/

	/*@Test
	public void testJugarTantosCon4JugadoresTeniendoEnvidosIguales(){
		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.ESPADA), new Rey(Palos.COPA));
		this.ailu.asignarMano(manoAilu);

		Mano manoFlor = new Mano(new Cuatro(Palos.BASTO), new Seis(Palos.COPA), new SieteFalso(Palos.COPA));
		this.flor.asignarMano(manoFlor);

		Mano manoCris = new Mano(new AnchoBasto(), new SieteOro(), new SieteFalso(Palos.BASTO));
		this.cris.asignarMano(manoCris);

		this.rondaEquiposDeADos.setearEnvido();
		this.rondaEquiposDeADos.jugarTantos();

		Assert.assertEquals(0,equipoFlorCris.puntajeDeEquipo);
		Assert.assertEquals(2,equipoAiluRodri.puntajeDeEquipo);
	}*/


}

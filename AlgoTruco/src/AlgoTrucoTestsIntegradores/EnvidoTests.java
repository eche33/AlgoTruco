package AlgoTrucoTestsIntegradores;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoEspada;
import AlgoTrucoCartas.Rey;
import AlgoTrucoCartas.Seis;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoCartas.SieteFalso;
import AlgoTrucoCartas.Sota;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;
import AlgoTrucoClases.Ronda;

public class EnvidoTests {

	private Equipo equipo1;
	private Equipo equipo2;
	private Jugador ailu;
	private Jugador rodri;
	private Ronda ronda;
	
	
	@Before
	public void setUp() throws Exception{
		this.equipo1 = new Equipo(ailu = new Jugador("Ailu"));
		this.equipo2 = new Equipo(rodri = new Jugador("Rodri"));
		this.ronda = new Ronda(equipo1, equipo2);
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

	@Test
	public void testJugarTantos(){
		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.ESPADA), new Rey(Palos.COPA));
		this.ailu.asignarMano(manoAilu);

		this.ronda.setearEnvido();
		this.ronda.jugarTantos();

		Assert.assertEquals(0,equipo1.puntajeDeEquipo);
		Assert.assertEquals(2,equipo2.puntajeDeEquipo);
	}

	@Test
	public void testJugarTantosConEnvidosIguales(){
		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Seis(Palos.COPA), new Rey(Palos.ESPADA), new SieteFalso(Palos.COPA));
		this.ailu.asignarMano(manoAilu);

		this.ronda.setearEnvido();
		this.ronda.jugarTantos();

		Assert.assertEquals(2,equipo1.puntajeDeEquipo);
		Assert.assertEquals(0,equipo2.puntajeDeEquipo);


	}


}

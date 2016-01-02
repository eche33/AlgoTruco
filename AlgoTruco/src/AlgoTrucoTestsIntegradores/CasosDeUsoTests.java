package AlgoTrucoTestsIntegradores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.Rey;
import AlgoTrucoCartas.Seis;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoCartas.Sota;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;
import AlgoTrucoClases.Ronda;
import AlgoTrucoClases.Vuelta;
import AlgoTrucoErrores.NoSePuedeCantarEnvidoError;

public class CasosDeUsoTests {
	private Equipo equipoAilu;
	private Equipo equipoRodri;
	private Jugador ailu;
	private Jugador rodri;
	private Ronda ronda;
	private Vuelta vuelta;


	@Before
	public void setUp() throws Exception {
		this.equipoAilu = new Equipo();
		this.equipoAilu.agregarJugadorAEquipo(ailu = new Jugador("Ailu"));
		this.equipoRodri = new Equipo();
		this.equipoRodri.agregarJugadorAEquipo(rodri = new Jugador("Rodri"));

		this.ronda = new Ronda(equipoAilu, equipoRodri);
		this.vuelta = new Vuelta(this.ronda);


		Mano manoRodri = new Mano(new Seis(Palos.ESPADA), new Rey(Palos.ESPADA), new SieteEspada());
		this.rodri.asignarMano(manoRodri);

		Mano manoAilu = new Mano(new Sota(Palos.ESPADA), new Rey(Palos.ESPADA), new Rey(Palos.COPA));
		this.ailu.asignarMano(manoAilu);
	}

	@Test
	public void jugadoresJueganVueltaYLaGanaElQueTiraLaCartaMasAlta(){
		this.ailu.tirarPrimerCarta(vuelta);
		this.rodri.tirarTercerCarta(vuelta);
		assertEquals(this.vuelta.obtenerJugadorQueTiroCartaMasALta(),this.rodri);
	}

	@Test
	public void jugadoresJueganVueltaYPardan(){
		this.ailu.tirarTercerCarta(vuelta);;
		this.rodri.tirarSegundaCarta(vuelta);;
		assertEquals(this.vuelta.obtenerJugadorQueTiroCartaMasALta(),null);
	}

	@Test
	public void jugadoresJueganEnvidoYGanaRodri(){
		this.ronda.setearEnvido();
		this.ronda.sumarPuntos(equipoAilu);
		this.ronda.sumarPuntos(equipoRodri);
		assertEquals(this.equipoAilu.obtenerPuntaje(),0);
		assertEquals(this.equipoRodri.obtenerPuntaje(),2);
	}

	@Test
	public void jugadorNoPuedeCantarEnvidoPorqueYaTiroCarta() {
		this.rodri.tirarPrimerCarta(vuelta);
		String error  = "";
		try {
			this.rodri.cantarEnvido(vuelta);
		} catch (NoSePuedeCantarEnvidoError e) {
			error = "No podes cantar envido";
		}
		assertEquals(error,"No podes cantar envido");
	}

	@Test
	public void ailuGanaTruco(){

	}



}

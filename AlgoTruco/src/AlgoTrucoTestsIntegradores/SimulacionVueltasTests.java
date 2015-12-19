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

public class SimulacionVueltasTests {
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
	public void jugarVueltaTirandoCartasSolamente() {
		this.ailu.tirarSegundaCarta(this.vuelta);;
		this.rodri.tirarTercerCarta(vuelta);
		//assertEquals(this.vuelta.obtenerMesa().obtenerCartasEnMesa().size(),2);
		assertEquals(this.vuelta.obtenerJugadorQueTiroCartaMasALta().obtenerNombre(),"Rodri");
	}



}

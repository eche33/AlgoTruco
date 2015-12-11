package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoBasto;
import AlgoTrucoCartas.AnchoEspada;
import AlgoTrucoCartas.Cinco;
import AlgoTrucoCartas.Cuatro;
import AlgoTrucoCartas.Rey;
import AlgoTrucoCartas.Seis;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoCartas.SieteFalso;
import AlgoTrucoCartas.SieteOro;
import AlgoTrucoCartas.Sota;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Mesa;
import AlgoTrucoClases.Palos;
import AlgoTrucoClases.Ronda;
import AlgoTrucoClases.Vuelta;

public class MesaTest {

	private Mesa mesaPrueba1;
	private Mesa mesaPrueba2;
	private Mesa mesaPrueba3;
	private Carta carta1;
	private Carta carta2;
	private Jugador jugador;


	@Before
	public void setup(){
		this.mesaPrueba1 = new Mesa();
		this.mesaPrueba2 = new Mesa();
		this.mesaPrueba3 = new Mesa();

		this.jugador = new Jugador("Cris");

		this.carta1 = new Seis(Palos.COPA);
		this.carta2 = new AnchoEspada();

		this.mesaPrueba2.tirarCarta(carta1,this.jugador);
		this.mesaPrueba3.tirarCarta(carta1,this.jugador);
		this.mesaPrueba3.tirarCarta(carta2,this.jugador);
	}


	@Test
	public void testCreaMesaSinCartas() {
		Assert.assertTrue(this.mesaPrueba1.obtenerCartasEnMesa().isEmpty());
	}

	@Test
	public void testAgregaUnaCarta() {
		Assert.assertEquals(this.mesaPrueba2.obtenerCartasEnMesa().size(), 1);
		Assert.assertEquals(this.carta1, this.mesaPrueba2.obtenerCartasEnMesa().get(0));
	}

	@Test
	public void testAgregaDosCartas() {
		Assert.assertEquals(this.mesaPrueba3.obtenerCartasEnMesa().size(), 2);
		Assert.assertEquals(this.carta1, this.mesaPrueba3.obtenerCartasEnMesa().get(0));
		Assert.assertEquals(this.carta2, this.mesaPrueba3.obtenerCartasEnMesa().get(1));
	}

	@Test
	public void tirarCarta(){
		Jugador rodri = new Jugador("Rodri");
		this.mesaPrueba1.tirarCarta(carta1, rodri);

		assertEquals(this.mesaPrueba1.obtenerCartasEnMesa().get(0).obtenerNumero(),6);
	}

	@Test
	public void obtenerJugadorQueTiroLaCartaMasAltaDevuelveElJugadorCorrecto(){
		Jugador rodri = new Jugador("Rodri");
		Jugador ailu= new Jugador("Ailu");
		Jugador cris= new Jugador("Cris");
		Jugador flor= new Jugador("Flor");

		Mesa mesa = new Mesa();

		Carta seis= new Seis(Palos.ESPADA);
		Carta sota = new Sota(Palos.ESPADA);
		Carta cuatro = new Cuatro(Palos.BASTO);
		Carta ancho = new AnchoBasto();

		mesa.tirarCarta(cuatro, flor);
		mesa.tirarCarta(sota, ailu);
		mesa.tirarCarta(ancho, cris);
		mesa.tirarCarta(seis, rodri);


		assertEquals(mesa.obtenerJugadorQueTiroCartaMasAlta().obtenerNombre(),"Cris");

	}

	@Test
	public void obtenerJugadorQueTiroLaCartaMasAltaDevuelveElJugadorCorrecto2(){
		Jugador rodri = new Jugador("Rodri");
		Jugador ailu= new Jugador("Ailu");
		Jugador cris= new Jugador("Cris");
		Jugador flor= new Jugador("Flor");

		Mesa mesa = new Mesa();

		Carta seis= new Seis(Palos.ESPADA);
		Carta sota = new Sota(Palos.ESPADA);
		Carta cuatro = new Cuatro(Palos.BASTO);
		Carta ancho = new AnchoBasto();

		mesa.tirarCarta(cuatro, flor);
		mesa.tirarCarta(ancho, ailu);
		mesa.tirarCarta(sota, cris);
		mesa.tirarCarta(seis, rodri);


		assertEquals(mesa.obtenerJugadorQueTiroCartaMasAlta().obtenerNombre(),"Ailu");
	}

	@Test
	public void obtenerJugadorQueTiroLaCartaMasAltaDevuelveNullPorPardas(){
		Jugador rodri = new Jugador("Rodri");
		Jugador ailu= new Jugador("Ailu");
		Jugador cris= new Jugador("Cris");
		Jugador flor= new Jugador("Flor");

		Mesa mesa = new Mesa();

		Carta seis= new Seis(Palos.ESPADA);
		Carta cinco = new Cinco(Palos.ESPADA);
		Carta cuatro = new Cuatro(Palos.BASTO);
		Carta seis2 = new Seis(Palos.BASTO);

		mesa.tirarCarta(cuatro, flor);
		mesa.tirarCarta(seis2, ailu);
		mesa.tirarCarta(cinco, cris);
		mesa.tirarCarta(seis, rodri);


		assertEquals(mesa.obtenerJugadorQueTiroCartaMasAlta(),null);
	}


}

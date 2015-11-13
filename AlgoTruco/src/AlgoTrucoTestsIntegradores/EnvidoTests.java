package AlgoTrucoTestsIntegradores;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;

public class EnvidoTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testObtenerEnvidoConCartasTodasDeDistintoPalo() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.ESPADA));
		cartas.add( new Carta(12,Palos.BASTO));
		cartas.add(new Carta(7,Palos.COPA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerEnvido(),7);
	}

	@Test
	public void testObtenerEnvidoConDosCartasDelMismoPalo() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.ESPADA));
		cartas.add( new Carta(12,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.COPA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerEnvido(),21);
	}

	@Test
	public void testObtenerEnvidoConTodasDelMismoPalo() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(6,Palos.ESPADA));
		cartas.add( new Carta(12,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerEnvido(),33);
	}

	@Test
	public void testObtenerEnvidoConTodasFigurasDistintas() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(10,Palos.ESPADA));
		cartas.add( new Carta(12,Palos.BASTO));
		cartas.add(new Carta(12,Palos.COPA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerEnvido(),0);
	}

	@Test
	public void testObtenerEnvidoConTodasFiguras() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(10,Palos.ESPADA));
		cartas.add( new Carta(12,Palos.ESPADA));
		cartas.add(new Carta(12,Palos.COPA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerEnvido(),20);
	}

}

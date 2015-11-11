package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;

public class ManoTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreaUnaManoYChequeaCuantasCartasTiene() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.ESPADA));
		cartas.add( new Carta(1,Palos.BASTO));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		Boolean result = (mano.cantidadDeCartas() == 3);

		Assert.assertTrue(result);

	}


	@Test
	public void testManoTieneEnvido() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.ESPADA));
		cartas.add( new Carta(1,Palos.BASTO));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertTrue(mano.tieneEnvido());
	}


	@Test
	public void testManoNoTieneEnvido() {
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.COPA));
		cartas.add( new Carta(1,Palos.BASTO));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertFalse(mano.tieneEnvido());
	}

	@Test
	public void testSonTodasDeDistintoPalo(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.COPA));
		cartas.add( new Carta(1,Palos.BASTO));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertTrue(mano.sonTodasDeDistintoPalo());
	}


	@Test
	public void testNoSonTodasDeDistintoPalo(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.COPA));
		cartas.add( new Carta(1,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertFalse(mano.sonTodasDeDistintoPalo());
	}

	/*@Test
	public void testObtenerValorCartaMasAlta(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.COPA));
		cartas.add( new Carta(1,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerValorCartaMasAlta(),7);

	}*/

	/*@Test
	public void testObtenerValorCartaMasAltaConUnaFiguraEnLaMano(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.COPA));
		cartas.add( new Carta(10,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerValorCartaMasAlta(),7);

	}*/

	/*@Test
	public void testObtenerValorCartaMasAltaConTodasFiguras(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(11,Palos.ESPADA));
		cartas.add( new Carta(10,Palos.ESPADA));
		cartas.add(new Carta(12,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerValorCartaMasAlta(),0);

	}*/

	@Test
	public void calcularEnvidoEntreDosCartas(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(11,Palos.ESPADA));
		cartas.add( new Carta(10,Palos.ESPADA));
		cartas.add(new Carta(12,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.calcularEnvidoEntre(1,2),20);
	}

	@Test
	public void calcularEnvidoEntreDosCartas2(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(6,Palos.ESPADA));
		cartas.add( new Carta(7,Palos.ESPADA));
		cartas.add(new Carta(12,Palos.BASTO));

		Mano mano = new Mano(cartas);

		assertEquals(mano.calcularEnvidoEntre(1,3),6);
	}

	@Test
	public void calcularEnvidoEntreDosCartas3(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(6,Palos.ESPADA));
		cartas.add( new Carta(7,Palos.ESPADA));
		cartas.add(new Carta(12,Palos.BASTO));

		Mano mano = new Mano(cartas);

		assertEquals(mano.calcularEnvidoEntre(1,2),33);
	}

	@Test
	public void testManoTieneFlor(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(6,Palos.ESPADA));
		cartas.add( new Carta(7,Palos.ESPADA));
		cartas.add(new Carta(12,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertTrue(mano.tieneFlor());
	}


	@Test
	public void testManoNoTieneFlor(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(6,Palos.ESPADA));
		cartas.add( new Carta(7,Palos.BASTO));
		cartas.add(new Carta(12,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertFalse(mano.tieneFlor());
	}


	}








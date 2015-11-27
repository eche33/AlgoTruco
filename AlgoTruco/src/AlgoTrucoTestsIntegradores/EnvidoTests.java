package AlgoTrucoTestsIntegradores;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;
import AlgoTrucoClases.Ronda;

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

	@Test
	public void testJugarTantos(){
		Jugador rodri = new Jugador("Rodri");
		Jugador ailu = new Jugador("Ailu");
		ArrayList<Jugador> lista1 = new ArrayList<Jugador>();
		ArrayList<Jugador> lista2 = new ArrayList<Jugador>();
		lista1.add(ailu);
		lista2.add(rodri);
		Equipo equipo1 = new Equipo(lista1);
		Equipo equipo2 = new Equipo(lista2);
		ailu.asignarEquipo(equipo1);
		rodri.asignarEquipo(equipo2);
		ArrayList<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
		jugadoresOrdenados.add(ailu);
		jugadoresOrdenados.add(rodri);
		Ronda ronda = new Ronda(equipo1, equipo2, jugadoresOrdenados);

		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(6,Palos.ESPADA));
		cartas.add( new Carta(12,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano1 = new Mano(cartas);
		rodri.asignarMano(mano1);

		ArrayList<Carta> cartas2 = new ArrayList<Carta>();
		cartas2.add(new Carta(10,Palos.ESPADA));
		cartas2.add( new Carta(12,Palos.ESPADA));
		cartas2.add(new Carta(12,Palos.COPA));

		Mano mano2 = new Mano(cartas2);
		ailu.asignarMano(mano2);

		ronda.setearEnvido();
		ronda.jugarTantos();

		assertEquals(equipo1.puntajeDeEquipo,0);
		assertEquals(equipo2.puntajeDeEquipo,2);


	}

	@Test
	public void testJugarTantosConEnvidosIguales(){
		Jugador rodri = new Jugador("Rodri");
		Jugador ailu = new Jugador("Ailu");
		ArrayList<Jugador> lista1 = new ArrayList<Jugador>();
		ArrayList<Jugador> lista2 = new ArrayList<Jugador>();
		lista1.add(ailu);
		lista2.add(rodri);
		Equipo equipo1 = new Equipo(lista1);
		Equipo equipo2 = new Equipo(lista2);
		ailu.asignarEquipo(equipo1);
		rodri.asignarEquipo(equipo2);
		ArrayList<Jugador> jugadoresOrdenados = new ArrayList<Jugador>();
		jugadoresOrdenados.add(ailu);
		jugadoresOrdenados.add(rodri);
		Ronda ronda = new Ronda(equipo1, equipo2, jugadoresOrdenados);

		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(6,Palos.ESPADA));
		cartas.add( new Carta(12,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano1 = new Mano(cartas);
		rodri.asignarMano(mano1);

		ArrayList<Carta> cartas2 = new ArrayList<Carta>();
		cartas2.add(new Carta(6,Palos.COPA));
		cartas2.add( new Carta(12,Palos.ESPADA));
		cartas2.add(new Carta(7,Palos.COPA));

		Mano mano2 = new Mano(cartas2);
		ailu.asignarMano(mano2);

		ailu.setearEsMano();
		ronda.setearEnvido();
		ronda.jugarTantos();

		assertEquals(equipo1.puntajeDeEquipo,2);
		assertEquals(equipo2.puntajeDeEquipo,0);


	}


}

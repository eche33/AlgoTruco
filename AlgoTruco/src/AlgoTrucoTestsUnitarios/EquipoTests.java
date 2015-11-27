package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Palos;

public class EquipoTests {
	
	private ArrayList<Jugador> lista;
	private Equipo equipo;
	@Before
	public void setUp() throws Exception {
		Jugador jugador1 = new Jugador("Rodrigo");
		Jugador jugador2 = new Jugador("Flor");
		lista = new ArrayList<Jugador>();
		lista.add(jugador1);
		lista.add(jugador2);
		equipo = new Equipo(lista);
	}


	@Test
	public void testEquipoSeCreaConPuntajeNulo(){

		Assert.assertEquals(equipo.obtenerPuntaje(),0);

	}
	
	@Test
	public void testEquipoSeCreaConQuiero(){

		Assert.assertTrue( equipo.devolverQuiero() );

	}
	
	@Test
	public void testEquipoModificaQuiero(){
		equipo.tieneQuiero();
		Assert.assertTrue( equipo.devolverQuiero() );		
		equipo.noTieneQuiero();
		Assert.assertFalse( equipo.devolverQuiero() );
		

	}
	@Test
	
	public void testEquipoSeCreaConCantidadCorrectaDeJugadores(){
		
		assertEquals(equipo.obtenerCantidadDeJugadores(),2);
	}

	@Test
	public void testEquipoSumaPuntosCorrectamente(){
	equipo.sumarPuntos(10);
	assertEquals(equipo.obtenerPuntaje(),10);
}


}

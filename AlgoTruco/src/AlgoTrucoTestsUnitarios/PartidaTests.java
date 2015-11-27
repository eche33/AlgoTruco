package AlgoTrucoTestsUnitarios;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import AlgoTrucoClases.Partida;
import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;

public class PartidaTests {

	private Partida partidaDePrueba1;
	private Partida partidaDePrueba2;
	private Equipo equipoPrueba2; 
	private Equipo equipoPrueba1; 
	private Equipo equipoPrueba3; 
	
	@Before
	public void setup(){
		ArrayList< Jugador > equipo1 = new ArrayList< Jugador >();
		equipo1.add( new Jugador( "Jugador1" ) );
		ArrayList< Jugador > equipo2 = new ArrayList< Jugador >();
		equipo2.add( new Jugador( "Jugador2" ) );
		ArrayList< Jugador > equipo3 = new ArrayList< Jugador >();
		equipo2.add( new Jugador( "Jugador3" ) );
		
		equipoPrueba1 = new Equipo( equipo1 );
		equipoPrueba2 = new Equipo( equipo2 );
		equipoPrueba3 = new Equipo( equipo3 );
		
		partidaDePrueba1 = new Partida( equipoPrueba1 , equipoPrueba2 );
		partidaDePrueba2 = new Partida( equipoPrueba1 , equipoPrueba3 );
		
	}
	
	@Test
	public void testNoEncuentraGanadorPorPuntajesNulos() {
		Assert.assertFalse( partidaDePrueba1.hayGanador() );
		Assert.assertFalse( partidaDePrueba2.hayGanador() );
	}
	
	@Test
	public void testNoEncuentraGanadorPorPuntajesMenoresA30() {
		this.equipoPrueba1.sumarPuntos(27);
		Assert.assertFalse( partidaDePrueba1.hayGanador() );
		Assert.assertFalse( partidaDePrueba2.hayGanador() );
	}
	
	@Test
	public void testEncuentraGanador() {
		this.equipoPrueba3.sumarPuntos(30);
		Assert.assertFalse( partidaDePrueba1.hayGanador() );
	}

}

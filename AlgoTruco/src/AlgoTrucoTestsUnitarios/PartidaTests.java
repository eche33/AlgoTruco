package AlgoTrucoTestsUnitarios;

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
		this.equipoPrueba1 = new Equipo();
		this.equipoPrueba1.agregarJugadorAEquipo(new Jugador("Jugador 1"));
		this.equipoPrueba2 = new Equipo();
		this.equipoPrueba2.agregarJugadorAEquipo(new Jugador("Jugador 2"));
		this.equipoPrueba3 = new Equipo();
		this.equipoPrueba3.agregarJugadorAEquipo(new Jugador("Jugador 3"));
		
		this.partidaDePrueba1 = new Partida(this.equipoPrueba1, this.equipoPrueba2);
		this.partidaDePrueba2 = new Partida(this.equipoPrueba1, this.equipoPrueba3);
	}
	
	
	@Test
	public void testNoEncuentraGanadorPorPuntajesNulos(){
		Assert.assertFalse(this.partidaDePrueba1.hayGanador());
		Assert.assertFalse(this.partidaDePrueba2.hayGanador());
	}
	
	@Test
	public void testNoEncuentraGanadorPorPuntajesMenoresA30(){
		this.equipoPrueba1.sumarPuntos(27);
		Assert.assertFalse(this.partidaDePrueba1.hayGanador());
		Assert.assertFalse(this.partidaDePrueba2.hayGanador());
	}
	
	@Test
	public void testEncuentraGanador(){
		this.equipoPrueba3.sumarPuntos(30);
		Assert.assertFalse(this.partidaDePrueba1.hayGanador());
	}

}

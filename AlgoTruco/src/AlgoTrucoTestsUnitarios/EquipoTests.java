package AlgoTrucoTestsUnitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;

public class EquipoTests {
	
	private Equipo equipo;
	
	
	@Before
	public void setUp() throws Exception {
		this.equipo = new Equipo(new Jugador("Rodri"), new Jugador("Flor"));
	}

	
	@Test
	public void testEquipoSeCreaConPuntajeNulo(){
		Assert.assertEquals(0, this.equipo.obtenerPuntaje());
	}
	
	@Test
	public void testEquipoSeCreaConElQuiero(){
		Assert.assertTrue(this.equipo.devolverQuiero());
	}
	
	@Test
	public void testEquipoModificaQuiero(){
		this.equipo.tieneQuiero();
		Assert.assertTrue(this.equipo.devolverQuiero());
		
		this.equipo.noTieneQuiero();
		Assert.assertFalse(this.equipo.devolverQuiero());
	}
	
	@Test
	public void testEquipoSumaPuntosCorrectamente(){
		this.equipo.sumarPuntos(10);
		Assert.assertEquals(this.equipo.obtenerPuntaje(),10);
	}
	
	@Test
	public void testEquipoGanaCon30Puntos(){
		this.equipo.sumarPuntos(30);
		Assert.assertTrue(this.equipo.ganoPartida());
	}
	
	
/** Prueba comentada porque el método esta comentado.
 * 
 * @Test
	public void testEquipoSeCreaConCantidadCorrectaDeJugadores(){
		Assert.assertEquals(this.equipo.obtenerCantidadDeJugadores(),2);
	}
 *	
 */
	
}

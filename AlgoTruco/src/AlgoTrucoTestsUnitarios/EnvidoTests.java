package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Ronda;
import AlgoTrucoTantos.Envido;


public class EnvidoTests {
	private Envido envido;

	@Before
	public void setUp() throws Exception{
		this.envido = new Envido();
	}

	@Test
	public void envidoSeCreaCorrectamente(){
		assertEquals(this.envido.obtenerPuntos(),2);
		assertEquals(this.envido.obtenerPuntosNoQuerido(),1);
	}
}

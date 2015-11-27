package AlgoTrucoTestsUnitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoEspada;
import AlgoTrucoCartas.Seis;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Mesa;
import AlgoTrucoClases.Palos;

public class MesaTest {

	private Mesa mesaPrueba1;
	private Mesa mesaPrueba2;
	private Mesa mesaPrueba3;
	private Carta carta1;
	private Carta carta2;
	
	
	@Before
	public void setup(){
		this.mesaPrueba1 = new Mesa();
		this.mesaPrueba2 = new Mesa();
		this.mesaPrueba3 = new Mesa();
		
		this.carta1 = new Seis(Palos.COPA);
		this.carta2 = new AnchoEspada();
		
		this.mesaPrueba2.tirarCarta(carta1);
		this.mesaPrueba3.tirarCarta(carta1);
		this.mesaPrueba3.tirarCarta(carta2);
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

}

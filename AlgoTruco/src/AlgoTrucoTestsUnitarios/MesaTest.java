package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
		mesaPrueba1 = new Mesa();
		mesaPrueba2 = new Mesa();
		mesaPrueba3 = new Mesa();
		
		carta1 = new Carta( 6 , Palos.COPA );
		carta2 = new Carta( 1 , Palos.ESPADA );
		

		mesaPrueba2.tirarCarta(carta1);
		mesaPrueba3.tirarCarta(carta1);
		mesaPrueba3.tirarCarta(carta2);
	}
	
	@Test
	public void testCreaMesaSinCartas() {
		Assert.assertTrue( mesaPrueba1.obtenerCartasEnMesa().isEmpty() );
	}
	
	@Test
	public void testAgregaPrimerCarta() {
		Assert.assertEquals( mesaPrueba2.obtenerCartasEnMesa().size() , 1 );
	}
	
	@Test
	public void testAgregaDosCartas() {		
		Assert.assertEquals( mesaPrueba3.obtenerCartasEnMesa().size() , 2 );
	}

}

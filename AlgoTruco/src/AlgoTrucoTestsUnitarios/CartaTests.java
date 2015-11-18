package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;


public class CartaTests {

	private Carta carta1;
	private Carta carta2;
	private Carta carta3;
	private Carta carta4;

	@Before
	public void setUp() throws Exception {
		
		 carta1 = new Carta( 6 , Palos.COPA );
		 carta2 = new Carta( 1 , Palos.ESPADA );
		 carta3 = new Carta( 10 , Palos.BASTO ); 
		 carta4 = new Carta( 1 , Palos.BASTO );
	}

	@Test
	public void testCreaUnaCartaYGuardaValorCorrecto() {
		Assert.assertEquals( carta1.obtenerValor() , 6 );
	}

	@Test
	public void testCreaUnaCartaYGuardaPaloCorrecto() {
		Assert.assertEquals( carta1.obtenerPalo() , "COPA" );
	}

	@Test
	public void testChequeaElPaloDeUnaCarta() {
		Assert.assertTrue( carta2.esPalo( "ESPADA" ) );
	}

	@Test
	public void testUnaCartaEsUnaFigura(){
		assertTrue( carta3.esUnaFigura() );
	}

	@Test
	public void testUnaCartaNoEsUnaFigura(){
		assertFalse( carta4.esUnaFigura() );
	}


	public static void main(String[] args) {

	}

}



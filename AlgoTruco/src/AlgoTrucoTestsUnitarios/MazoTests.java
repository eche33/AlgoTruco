package AlgoTrucoTestsUnitarios;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Mazo;

public class MazoTests {

	private Mazo nuevoMazo;
	private ArrayList<ArrayList<Carta>> mano1;
	private ArrayList<ArrayList<Carta>> mano2;
	private ArrayList<ArrayList<Carta>> mano3;

	@Before
	public void setup() {
		nuevoMazo = new Mazo();
		
		mano1 = this.nuevoMazo.repartirXCantidadDeManos(2);
		mano2 = this.nuevoMazo.repartirXCantidadDeManos(3);
		mano3 = this.nuevoMazo.repartirXCantidadDeManos(6);
	}

	@Test
	public void testSeCreaMazoDe40Cartas() {
		
		Assert.assertEquals( this.nuevoMazo.devolverMazo().size() , 40 );
	}

	@Test
	public void testEncuentraCartasExistentes(){
		Assert.assertTrue( this.nuevoMazo.existeCarta( 1 , "BASTO" ) );
		Assert.assertTrue( this.nuevoMazo.existeCarta( 1 , "ESPADA" ) );
		Assert.assertTrue( this.nuevoMazo.existeCarta( 2 , "ORO" ) );
		Assert.assertTrue( this.nuevoMazo.existeCarta( 12 , "COPA" ) );
	}

	@Test
	public void testNoEncuentraCartasNoExistentes(){
		Assert.assertFalse( this.nuevoMazo.existeCarta( 8 , "ORO" ) );
		Assert.assertFalse( this.nuevoMazo.existeCarta( 9 , "BASTO" ) );
		Assert.assertFalse( this.nuevoMazo.existeCarta( 14 , "COPA" ) );
		Assert.assertFalse( this.nuevoMazo.existeCarta( 2 , "DIAMANTE" ) );
	}

	@Test
	public void testMezclaElMazo(){
		
		Carta primerCarta = this.nuevoMazo.devolverMazo().get( 0 );
		Carta primerCarta2 = this.nuevoMazo.devolverMazo().get( 39 );
		
		this.nuevoMazo.mezclarMazo();
		
		Carta segundaCarta = this.nuevoMazo.devolverMazo().get( 0 );
		Carta segundaCarta2 = this.nuevoMazo.devolverMazo().get( 39 );
		
		Assert.assertNotEquals( primerCarta2 , segundaCarta2 );
		Assert.assertNotEquals( primerCarta , segundaCarta );

		Carta primerCarta3 = this.nuevoMazo.devolverMazo().get( 31 );
		
		this.nuevoMazo.mezclarMazo();
		
		Carta segundaCarta3 = this.nuevoMazo.devolverMazo().get( 31 );
		
		Assert.assertNotEquals( primerCarta3 , segundaCarta3 );
	}

	@Test
	public void devuelveXManos(){

		Assert.assertTrue( mano1.size() == 2 );
		Assert.assertTrue( mano2.size() == 3 );
		Assert.assertTrue( mano3.size() == 6 );
	}
	
	@Test
	public void devuelveManosDeTresCartas(){
		
		Assert.assertTrue( mano1.get( 0 ).size() == 3 );
		Assert.assertTrue( mano1.get( 1 ).size() == 3 );
	}

	@Test
	public void devuelveManosDeTresCartasDistintas(){
		
		Assert.assertTrue( mano1.get( 0 ).get( 0 ) != mano1.get( 0 ).get( 1 ) );
		Assert.assertTrue( mano1.get( 0 ).get( 1 ) != mano1.get( 0 ).get( 2 ) );
		Assert.assertTrue( mano1.get( 0 ).get( 0 ) != mano1.get( 0 ).get( 2 ) );
		
		
		Assert.assertTrue( mano1.get( 0 ).get( 0 ) != mano1.get( 1 ).get( 1 ) );
		Assert.assertTrue( mano1.get( 1 ).get( 2 ) != mano1.get( 0 ).get( 2 ) );
		Assert.assertTrue( mano1.get( 1 ).get( 0 ) != mano1.get( 0 ).get( 2 ) );
	}
}


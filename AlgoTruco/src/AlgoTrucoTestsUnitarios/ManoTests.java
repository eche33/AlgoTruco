package AlgoTrucoTestsUnitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoBasto;
import AlgoTrucoCartas.AnchoEspada;
import AlgoTrucoCartas.AnchoFalso;
import AlgoTrucoCartas.Caballo;
import AlgoTrucoCartas.Cinco;
import AlgoTrucoCartas.Dos;
import AlgoTrucoCartas.Rey;
import AlgoTrucoCartas.Seis;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoCartas.SieteFalso;
import AlgoTrucoCartas.SieteOro;
import AlgoTrucoCartas.Sota;
import AlgoTrucoCartas.Tres;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Palos;

public class ManoTests {

	private Mano manoTruco;
	private Mano manoFlor;
	private Mano manoEnvido;
	private Mano manoEnvidoFigura;
	
	
	@Before
	public void setUp() throws Exception {
		this.manoTruco = new Mano(new AnchoEspada(), new AnchoBasto(), new SieteOro());
		this.manoFlor = new Mano(new Sota(Palos.COPA), new Seis(Palos.COPA), new AnchoFalso(Palos.COPA));
		this.manoEnvido = new Mano(new Tres(Palos.ORO), new Dos(Palos.BASTO), new SieteFalso(Palos.BASTO));
		this.manoEnvidoFigura = new Mano(new Rey(Palos.ESPADA), new SieteEspada(), new AnchoFalso(Palos.ORO));
	}

	
	@Test
	public void testCreaUnaManoYChequeaCuantasCartasTiene() {
		Assert.assertEquals(3,this.manoTruco.cantidadDeCartas());
	}

	@Test
	public void testManoTieneEnvido() {
		Assert.assertTrue(this.manoEnvido.tieneEnvido());
		Assert.assertTrue(this.manoFlor.tieneEnvido());
	}

	@Test
	public void testManoNoTieneEnvido() {
		Assert.assertFalse(this.manoTruco.tieneEnvido());
	}

	@Test
	public void obtenerEnvidoEntreFiguras(){
		Mano mano = new Mano(new Caballo(Palos.ESPADA), new Sota(Palos.ESPADA), new Rey(Palos.ESPADA));
		Assert.assertEquals(20, mano.obtenerEnvido());
	}

	@Test
	public void obtenerEnvidoEntreNumeros(){
		Assert.assertEquals(29, this.manoEnvido.obtenerEnvido());
	}

	@Test
	public void obtenerEnvidoConFiguraNumero(){
		Assert.assertEquals(27, this.manoEnvidoFigura.obtenerEnvido());
	}

	@Test
	public void obtenerEnvidoEntreTodasDistintas(){
		Assert.assertEquals(7, this.manoTruco.obtenerEnvido());
	}
	
	@Test
	public void obtenerEnvidoMayorManoConFlor(){
		Assert.assertEquals(27, this.manoFlor.obtenerEnvido());
	}
	
	@Test
	public void testManoTieneFlor(){
		Assert.assertTrue(this.manoFlor.tieneFlor());
	}

	@Test
	public void testManoNoTieneFlor(){
		Assert.assertFalse(this.manoTruco.tieneFlor());
		Assert.assertFalse(this.manoEnvido.tieneFlor());
	}

	@Test
	public void testCalcularFlorCorrectamente(){
		Assert.assertEquals(this.manoFlor.obtenerFlor(),27);
	}

	@Test
	public void testCalcularFlorCorrectamenteConTodasFiguras(){
		Mano mano = new Mano(new Rey(Palos.ESPADA), new Caballo(Palos.ESPADA), new Sota(Palos.ESPADA));
		Assert.assertEquals(mano.obtenerFlor(),20);
	}

	@Test
	public void testCalcularFlorMasAltaCorrectamente(){
		Mano mano = new Mano(new SieteFalso(Palos.COPA), new Seis(Palos.COPA), new Cinco(Palos.COPA));
		Assert.assertEquals(mano.obtenerFlor(),38);
	}

	
/** Tests que prueba cosas que no se usan en el modelo:
 * 
 * 
 * 	@Test
	public void testSonTodasDeDistintoPalo(){
		Assert.assertTrue(this.manoTruco.sonTodasDeDistintoPalo());
	}
 *
	@Test
	public void testNoSonTodasDeDistintoPalo(){
		Assert.assertFalse(this.manoTruco.sonTodasDeDistintoPalo());
	}
 * 	
 * 
 * 
 *  Estas otras pruebas eran sobre calcularEnvidoEntreDosNumeros(), pero creo que convendría hacer ese método privado,
 *  por lo que no podrían hacerse estos tests:
 *  
 *  
 *  @Test
	public void calcularEnvidoEntreDosFiguras(){
		Mano mano = new Mano(new Caballo(Palos.ESPADA), new Sota(Palos.ESPADA), new Rey(Palos.ESPADA));
		assertEquals(20, mano.calcularEnvidoEntre(1,2));
		assertEquals(20, mano.calcularEnvidoEntre(1,3));
		assertEquals(20, mano.calcularEnvidoEntre(2,3));
	}
 *
 *
	@Test
	public void calcularEnvidoEntreDosNumeros(){
		Mano mano = new Mano(new SieteEspada(), new Seis(Palos.ESPADA), new Cinco(Palos.ESPADA));
		assertEquals(33, mano.calcularEnvidoEntre(1,2));
		assertEquals(32, mano.calcularEnvidoEntre(1,3));
		assertEquals(31, mano.calcularEnvidoEntre(2,3));
	}
 *
 *
	@Test
	public void calcularEnvidoConFiguraNumero(){
		Mano mano = new Mano(new SieteOro(), new Rey(Palos.ORO), new Caballo(Palos.ORO));
		assertEquals(27,mano.calcularEnvidoEntre(1,2));
		assertEquals(27,mano.calcularEnvidoEntre(1,3));
	}
 *
 *	
	@Test
	public void calcularEnvidoEntreDosDistintas(){
		Assert.assertEquals(1, manoTruco.calcularEnvidoEntre(1,2));
		Assert.assertEquals(7, manoTruco.calcularEnvidoEntre(1,3));
		Assert.assertEquals(7, manoTruco.calcularEnvidoEntre(2,3));
	}
 * 
 * 
 * 
 *  Estos que van acá abajo son viejos y ni tienen métodos que los pasen. Quizás ni sirvan.
 *  
 *  
 *  @Test
	public void testObtenerValorCartaMasAlta(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.COPA));
		cartas.add( new Carta(1,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerValorCartaMasAlta(),7);
	}
 *
 *
	@Test
	public void testObtenerValorCartaMasAltaConUnaFiguraEnLaMano(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(1,Palos.COPA));
		cartas.add( new Carta(10,Palos.ESPADA));
		cartas.add(new Carta(7,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerValorCartaMasAlta(),7);
	}
 *
 *
	@Test
	public void testObtenerValorCartaMasAltaConTodasFiguras(){
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		cartas.add(new Carta(11,Palos.ESPADA));
		cartas.add( new Carta(10,Palos.ESPADA));
		cartas.add(new Carta(12,Palos.ESPADA));

		Mano mano = new Mano(cartas);

		assertEquals(mano.obtenerValorCartaMasAlta(),0);
	}
 *  
 */
}








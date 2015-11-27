package AlgoTrucoTestsUnitarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import AlgoTrucoCartas.AnchoEspada;
import AlgoTrucoCartas.Cuatro;
import AlgoTrucoCartas.SieteEspada;
import AlgoTrucoCartas.SieteOro;
import AlgoTrucoCartas.Sota;
import AlgoTrucoCartas.Tres;
import AlgoTrucoClases.Carta;
import AlgoTrucoClases.Palos;

public class CartaTests {

	private Carta copa4;
	private Carta espada7;
	private Carta oro10;
	private Carta basto3;

	
	@Before
	public void setUp() throws Exception {
		this.copa4 = new Cuatro(Palos.COPA);
		this.espada7 = new SieteEspada();
		this.oro10 = new Sota(Palos.ORO);
		this.basto3 = new Tres(Palos.BASTO);
	}

	
	@Test
	public void testAnchoDeEspadasGanaCuatroDeCopas(){
		Carta ancho = new AnchoEspada();
		Assert.assertEquals(1, ancho.jugarContra(this.copa4));
	}
	
	@Test
	public void testSieteDeEspadasGanaSieteDeOro(){
		Carta oro7 = new SieteOro();
		Assert.assertEquals(1, this.espada7.jugarContra(oro7));
	}
	
	@Test
	public void testCuatroDeCopasPierdeSotaDeOro(){
		Assert.assertEquals(-1, this.copa4.jugarContra(this.oro10));
	}
	
	@Test
	public void testTresDeBastosPardaTresDeEspada(){
		Carta espada3 = new Tres(Palos.ESPADA);
		Assert.assertEquals(0, this.basto3.jugarContra(espada3));
	}
	
	@Test
	public void testCreaCartaConNumeroCorrecto() {
		Assert.assertEquals(7, this.espada7.obtenerNumero());
	}

	@Test
	public void testCreaCartaConPaloCorrecto() {
		Assert.assertEquals("COPA", this.copa4.obtenerPalo());
	}

	@Test
	public void testUnaCartaEsUnaFigura(){
		Assert.assertTrue(this.oro10.esUnaFigura());
	}

	@Test
	public void testUnaCartaNoEsUnaFigura(){
		Assert.assertFalse(this.espada7.esUnaFigura());
	}

}



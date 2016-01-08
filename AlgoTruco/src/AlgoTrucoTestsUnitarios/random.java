package AlgoTrucoTestsUnitarios;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class random {

	@Test
	public void test() {
		int valor = (int) Math.floor(Math.random()*(39));
		Assert.assertTrue(valor < 40);	
	}

}

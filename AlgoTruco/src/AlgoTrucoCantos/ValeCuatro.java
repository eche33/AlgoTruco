package AlgoTrucoCantos;

import AlgoTrucoClases.Canto;

public class ValeCuatro extends Canto {

	@Override
	public Canto subir(){
		throw new NoSePuedeSubirValeCuatroError();
	}

}
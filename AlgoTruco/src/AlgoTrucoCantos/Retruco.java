package AlgoTrucoCantos;

import AlgoTrucoClases.Canto;

public class Retruco extends Canto {

	@Override
	public Canto subir() {
		return (new ValeCuatro());
	}

}
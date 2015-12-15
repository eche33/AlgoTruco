package AlgoTrucoCantos;

import AlgoTrucoClases.Canto;

public class Truco extends Canto {

	@Override
	public Canto subir() {
		return (new Retruco());
	}

}
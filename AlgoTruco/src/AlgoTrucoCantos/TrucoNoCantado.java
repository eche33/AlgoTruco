package AlgoTrucoCantos;

import AlgoTrucoClases.Canto;

public class TrucoNoCantado extends Canto {

	@Override
	public Canto subir() {
		return (new Truco());
	}

}
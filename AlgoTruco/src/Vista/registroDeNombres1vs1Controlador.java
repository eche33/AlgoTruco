package Vista;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Partida;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registroDeNombres1vs1Controlador {
	
	private Stage dialogStage;

	
	private String nombreJ1;
	
	private String nombreJ2;
	@FXML
	TextField nombreJugador1;
	@FXML
	TextField nombreJugador2;


	private Equipo equipo1;
	private Equipo equipo2;





    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	@FXML
	private void registrarNombres() {
		nombreJ1 = nombreJugador1.getText();
		nombreJ2 = nombreJugador2.getText();
		System.out.println(nombreJ1);
		System.out.println(nombreJ2);
		dialogStage.close();
	}
	


	public void crearEquipos(){
//		crearJugador(nombreJ1);
//		.
//		.
//		.
		
//		crearEquipos();
		
		
	}


	public void crearPartida1vs1() {
		crearEquipos();
	
		MainApp.partida = new Partida(equipo1, equipo2);
		
	}


}
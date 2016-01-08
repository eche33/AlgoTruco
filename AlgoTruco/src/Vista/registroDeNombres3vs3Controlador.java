package Vista;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Partida;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registroDeNombres3vs3Controlador {
	
	private Stage dialogStage;

	
	private String nombreJ1;
	
	private String nombreJ2;
	
	private String nombreJ3;

	private String nombreJ4;
	
	private String nombreJ5;

	private String nombreJ6;

	@FXML
	TextField nombreJugador1E1;
	@FXML
	TextField nombreJugador2E1;
	@FXML
	TextField nombreJugador3E1;
	@FXML
	TextField nombreJugador1E2;
	@FXML
	TextField nombreJugador2E2;
	@FXML
	TextField nombreJugador3E2;


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
		nombreJ1 = nombreJugador1E1.getText();
		nombreJ2 = nombreJugador2E1.getText();
		nombreJ3 = nombreJugador3E1.getText();
		nombreJ4 = nombreJugador1E2.getText();
		nombreJ5 = nombreJugador2E2.getText();
		nombreJ6 = nombreJugador3E2.getText();
		
		
		dialogStage.close();
	}
	public void crearEquipos(){
//		crearJugador(nombreJ1);
//		.
//		.
//		.
		
//		crearEquipos();
		
		
	}


	public void crearPartida3vs3() {
		crearEquipos();
	
//		MainApp.partida = new Partida(equipo1, equipo2);
		
	}
    


}
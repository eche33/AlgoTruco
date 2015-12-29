package Vista;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Partida;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class registroDeNombre1vsPCControlador {
	
	private Stage dialogStage;

	
	private String nombreJ;
	
	@FXML
	TextField nombreJugador;


	private Equipo equipo1;
	private Equipo equipo2;

	

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	@FXML
	private void registrarNombre() {
		nombreJ = nombreJugador.getText();
		System.out.println(nombreJ);
		dialogStage.close();
	}
	
	public void crearEquipos(){
//		crearJugador(nombreJ1);
//		.
//		.
//		.
		
//		crearEquipos();
		
		
	}


	public void crearPartida1vsPC() {
		crearEquipos();
		MainApp.juego = new Partida(equipo1, equipo2);
		
	}

    

}
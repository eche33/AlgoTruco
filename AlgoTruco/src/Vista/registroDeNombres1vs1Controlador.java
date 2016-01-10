package Vista;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Juego;
import AlgoTrucoClases.Jugador;
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
		
		dialogStage.close();
	}
	


	
	public void crearEquipos(){
		Jugador jugador1 = new Jugador(nombreJ1);
		Jugador jugador2 = new Jugador(nombreJ2);
		
		equipo1 = new Equipo(1);
		equipo2 = new Equipo(2);
		
		equipo1.agregarJugadorAEquipo(jugador1);
		equipo2.agregarJugadorAEquipo(jugador2);		
		
	}


	public void crearPartida1vs1() {
		crearEquipos();
		MainApp.juego = new Juego();
		this.crearEquipos();
		MainApp.juego.crearPartida(equipo1, equipo2);
		
	}


}
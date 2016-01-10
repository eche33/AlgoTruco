package Vista;

import java.net.URL;
import java.util.ResourceBundle;

import AlgoTrucoClases.Equipo;
import AlgoTrucoClases.Jugador;
import AlgoTrucoClases.Mano;
import AlgoTrucoClases.Partida;
import AlgoTrucoErrores.NoSePuedeCantarEnvidoError;
import AlgoTrucoErrores.NoSePuedeCantarFlorError;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class Pantalla1vs1Controller implements  ControlledScreen {

    ScreensController myController;

    private Jugador jugador1,jugador2;
    
    private Equipo equipo1, equipo2;
    
    private Mano manoJ1, manoJ2;
    
    @FXML
    Label nombreJ1,nombreJ2;
    
    @FXML
    Button carta0J1,carta1J1,carta2J1,carta0J2, carta1J2,carta2J2;
    
    @FXML
    Label cartaJ1,cartaJ2;
    

    @FXML
    Button botonTruco,botonVale4,botonRetruco;
    
    @FXML
    Button botonFlor, botonContraFlor,botonContraFlorAlResto;
    
    @FXML
    Button botonEnvido,botonRealEnvido,botonEnvidoEnvido;
    

    @FXML
    Button botonIrse;
    
    @FXML
    public void initialize() {
      
    	
    	
    	if (! MainApp.conFlor){
    		botonFlor.setVisible(false);
    	}
    	
    	cartaJ1.setText(" ");
    	cartaJ2.setText(" ");
    	
    	
    	this.equipo1 = MainApp.juego.obtenerEquipo(1);
    	this.equipo2 = MainApp.juego.obtenerEquipo(2);
    	
    	this.jugador1 = equipo1.obtenerJugador(0);
    	this.jugador2 = equipo2.obtenerJugador(0);
    	
    	this.nombreJ1.setText(this.jugador1.obtenerNombre());
    	this.nombreJ2.setText(this.jugador2.obtenerNombre());
    	
    	this.manoJ1 = jugador1.obtenerMano();
    	this.manoJ2 = jugador2.obtenerMano();
    	
    	
    	carta0J1.setText(manoJ1.obtenerCarta(0).nombre());
    	carta1J1.setText(manoJ1.obtenerCarta(1).nombre());
    	carta2J1.setText(manoJ1.obtenerCarta(2).nombre());
    	carta0J1.setText(manoJ2.obtenerCarta(0).nombre());
    	carta1J1.setText(manoJ2.obtenerCarta(1).nombre());
    	carta2J1.setText(manoJ2.obtenerCarta(2).nombre());
    	
    }
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    private void jugador1TiraPrimerCarta(){
    	if (MainApp.jugando.esEquipo(1)){
    		cartaJ1.setText(carta0J1.getText());
        	carta0J1.setText(" ");    	
        	jugador1.tirarPrimerCarta(MainApp.vuelta);
        	this.actualizarEquipoJugando();
    	}
    }
    
    private void actualizarEquipoJugando() {
		MainApp.jugando = MainApp.juego.obtenerEquipoJugando();
		
	}

	@FXML
    private void jugador1TiraSegundaCarta(){
    	if (MainApp.jugando.esEquipo(1)){
    		cartaJ1.setText(carta1J1.getText());
        	carta1J1.setText(" ");    	
        	jugador1.tirarSegundaCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void jugador1TiraTercerCarta(){
    	if (MainApp.jugando.esEquipo(1)){
    		cartaJ1.setText(carta2J1.getText());
        	carta2J1.setText(" ");    	
        	jugador1.tirarTercerCarta(MainApp.vuelta);
    	}
    }
   
    @FXML
    private void jugador2TiraPrimerCarta(){
    	if (MainApp.jugando.esEquipo(2)){
    		cartaJ2.setText(carta0J2.getText());
        	carta0J2.setText(" ");    	
        	jugador2.tirarPrimerCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void jugador2TiraSegundaCarta(){
    	if (MainApp.jugando.esEquipo(2)){
    		cartaJ2.setText(carta1J2.getText());
        	carta1J2.setText(" ");    	
        	jugador2.tirarSegundaCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void jugador2TiraTercerCarta(){
    	if (MainApp.jugando.esEquipo(2)){
    		cartaJ2.setText(carta2J2.getText());
        	carta2J2.setText(" ");    	
        	jugador2.tirarTercerCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void cantarEnvido(){
    	try {
			MainApp.jugando.cantarEnvido(MainApp.vuelta);
			this.botonEnvido.setVisible(false);
			this.botonEnvidoEnvido.setVisible(true);
//			MainApp.respuestaJugadorContrario();
			
		} catch (NoSePuedeCantarEnvidoError e) {
			MainApp.cartelAlerta("NO SE PUEDE CANTAR ENVIDO");
		}
    }
    
    @FXML
    private void cantarFlor(){
		try {
			MainApp.jugando.cantarFlor(MainApp.vuelta);
			this.botonFlor.setVisible(false);
			this.botonContraFlor.setVisible(true);
			this.botonContraFlorAlResto.setVisible(true);
		} catch (NoSePuedeCantarFlorError e) {
			MainApp.cartelAlerta("NO SE PUEDE CANTAR FLOR");
		}

    }
    
    @FXML
    private void cantarContraFlor(){
			MainApp.jugando.cantarContraFlor(MainApp.vuelta);			
			this.botonContraFlor.setVisible(false);
			this.botonContraFlorAlResto.setVisible(false);		
    }
    
    @FXML
    private void volverAPantallaInicial(ActionEvent event){
    	
       myController.setScreen(MainApp.pantallaInicial);
    }
    
    
    
   
    
    
}

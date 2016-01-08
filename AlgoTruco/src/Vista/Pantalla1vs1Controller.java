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




public class Pantalla1vs1Controller implements Initializable , ControlledScreen {

    ScreensController myController;

    private Jugador jugador1;
    private Jugador jugador2;
    
    private Equipo equipo1;
    private Equipo equipo2;
    
    private Mano manoJ1;
    private Mano manoJ2;
    
    @FXML
    Button carta0J1;
    
    @FXML
    Button carta1J1;
    
    @FXML
    Button carta2J1;
    
    @FXML
    Button carta0J2;
    
    @FXML
    Button carta1J2;
    
    @FXML
    Button carta2J2;
    
    @FXML
    Label cartaJ1;
    
    @FXML
    Label cartaJ2;
    

    @FXML
    Button botonTruco;
    
    @FXML
    Button botonVale4;
    
    @FXML
    Button botonRetruco;
    
    @FXML
    Button botonFlor;
    
    @FXML
    Button botonContraFlor;
    
    @FXML
    Button botonContraFlorAlResto;
    
    @FXML
    Button botonEnvido;
   

    @FXML
    Button botonRealEnvido;
    

    @FXML
    Button botonEnvidoEnvido;
    

    @FXML
    Button botonIrse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    	if (! MainApp.conFlor){
    		botonFlor.setVisible(false);
    	}
    	
    	cartaJ1.setText(" ");
    	cartaJ2.setText(" ");
    	
    	
    	equipo1 = MainApp.juego.obtenerEquipo(1);
    	equipo2 = MainApp.juego.obtenerEquipo(2);
    	
    	jugador1 = equipo1.obtenerJugador(0);
    	jugador2 = equipo2.obtenerJugador(0);
    	
    	manoJ1 = jugador1.obtenerMano();
    	manoJ2 = jugador2.obtenerMano();
    	
    	
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
    	if (MainApp.jugando.obtenerNombre() ==  jugador1.obtenerNombre()){
    		cartaJ1.setText(carta0J1.getText());
        	carta0J1.setText(" ");    	
        	jugador1.tirarPrimerCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void jugador1TiraSegundaCarta(){
    	if (MainApp.jugando.obtenerNombre() ==  jugador1.obtenerNombre()){
    		cartaJ1.setText(carta1J1.getText());
        	carta1J1.setText(" ");    	
        	jugador1.tirarSegundaCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void jugador1TiraTercerCarta(){
    	if (MainApp.jugando.obtenerNombre() ==  jugador1.obtenerNombre()){
    		cartaJ1.setText(carta2J1.getText());
        	carta2J1.setText(" ");    	
        	jugador1.tirarTercerCarta(MainApp.vuelta);
    	}
    }
   
    @FXML
    private void jugador2TiraPrimerCarta(){
    	if (MainApp.jugando.obtenerNombre() ==  jugador2.obtenerNombre()){
    		cartaJ2.setText(carta0J2.getText());
        	carta0J2.setText(" ");    	
        	jugador2.tirarPrimerCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void jugador2TiraSegundaCarta(){
    	if (MainApp.jugando.obtenerNombre() ==  jugador2.obtenerNombre()){
    		cartaJ2.setText(carta1J2.getText());
        	carta1J2.setText(" ");    	
        	jugador2.tirarSegundaCarta(MainApp.vuelta);
    	}
    }
    
    @FXML
    private void jugador2TiraTercerCarta(){
    	if (MainApp.jugando.obtenerNombre() ==  jugador2.obtenerNombre()){
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
